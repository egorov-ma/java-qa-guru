package guru.qa.selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browserCommandExample() {
        open("https://google.com"); // абсолютный путь
        open("/customer/orders");   // можно задать относительный путь, настройке в build.gradle и впоследствии использовать в jobs Jenkins -> -Dselenide.baseUrl=://123.23.1
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password")); // используется когда надо авторизоваться на страничке с поп-ап

        Selenide.back();    // кнопочка назад в браузере
        Selenide.refresh(); // кнопочка обновить в браузере

        Selenide.clearBrowserCookies(); // почистить куки, после этой команды необходим refresh
        Selenide.clearBrowserLocalStorage();    // чистит LocalStorage, после этой команды необходим refresh
        executeJavaScript("sessionStorage.clear();");   // бывают случаи когда необходимо еще почистить сессию

        Selenide.confirm(); // нажать ОК в алерте
        Selenide.dismiss(); // закрыть алерт

        Selenide.closeWindow(); // закрыть активное окно
        Selenide.closeWebDriver(); // закрыть браузер

        Selenide.switchTo().frame("new");   // Бывает необходимо переходить по фреймам на странице. Можем использовать эту команду и переходить по имени/номеру
        Selenide.switchTo().defaultContent();   // возвращает в самое начало дом-дерева основного

        Selenide.switchTo().window("The Internet"); // перейти по имени или номеру окна
    }

    void selectorsExamples() {
        $("div").click();   // $ -- команда для поиска элементов на странице
        element("div").click();   // Element -- синоним $. Можно использовать если пишем на kotlin т.к. доллар уже занят

        $("div", 2).click();    // можно искать по индексу

        $x("//h1/div").click(); // селектор можно писать xPath
        $(byXpath("//h1/div")).click(); // то же самое что и пример выше

        $(byText("full text")).click(); // поиск элемента по полному тексту
        $(withText("ull tex")).click(); // поиск элемента по совпадению в тексте

        $(byTagAndText("div", "full text")).click(); // поиск элемента по полному тексту и тегу
        $(withTagAndText("div", "ull tex")).click(); // поиск элемента по совпадению в тексте и тегу

        $("").parent(); // поиск вверх по дом-дереву
        $("").sibling(1);   // брат вниз по дереву
        $("").preceding(1);   // брат вверх по дереву
        $("").closest("div");   // поиск предка по селектору
        $("").ancestor("div");   // поиск предка по селектору
        $("div:last-child");    // поиск последнего ребенка

        $("div").$("h1").find(byText("abc")).click();   // пример что селекторы можно соединять

        $(byAttribute("abc", "x")).click();  // Редкие, опционально. Есть синоним, см ниже
        $("[abc=x]").click();   //  поиск по цсс селектору. обычный атрибут -- []

        $(byId("mytext")).click(); // Редкие, опционально. Есть синоним, см ниже. Исключение если айди начинается с цифры
        $("#mytext").click();   //  поиск по цсс селектору. айди -- #

        $(byClassName("red")).click(); // Редкие, опционально. Есть синоним, см ниже
        $(".red").click();   //  поиск по цсс селектору. класс -- .
    }

    void actionsExample() {
        $("").click();  // клик по элементу
        $("").doubleClick();  // двойной клик по элементу
        $("").contextClick();   // клик правой клавиши мыши

        $("").hover();  // поднести мышку, но не нажимать

        $("").setValue("text"); // Записываем текст в поле для ввода. Если есть предзаполненный текст, то команда его сотрет
        $("").append("text");   // добавляет текст в конец уже написанного в поле
        $("").clear();  // очищает поле
        $("").setValue(""); // очищает поле

        $("div").sendKeys("c"); // эмуляция нажатия клавиш
        actions().sendKeys("c").perform();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform();    // комбинация клавиш
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));  // если не работает через actions, то можно попробовать посылать на коневой html комбинации

        $("").pressEnter(); // нажатие на энтер
        $("").pressEscape();    // нажатие на эскейп
        $("").pressTab();   // нажатие на таб

        // начать действие, передвинуть мышку к элементу, кликнуть и не отпускать, двигать не отпуская клавишу, отпустить, завершить действие
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        $("").selectOption("dropdown_options"); // Работа с dropdown. Не всегда работает с новыми dropdown. На новых используем клики
        $("").selectRadio("radio_options"); // Работа с чек боксами и radiobutton. Чаще всего проще использовать клик по тексту радом с чек боксом
    }

    void assertionsExample() {
        // очень рекомендуется в селениде в проверках использовать should… Команды работают одинаково, разное название нужно только чтобы по-английски корректно читалось
        $("").shouldBe(Condition.visible);
        $("").shouldNotBe(Condition.visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(Condition.appear);
        $("").shouldNot(Condition.appear);

        $("").shouldBe(Condition.visible, Duration.ofSeconds(30));  // если необходимо для конкретной проверки увеличить/уменьшить таймаут
    }

    void conditionExample() {
        $("").shouldBe(Condition.visible);    // проверка на видимость
        $("").shouldBe(Condition.hidden); // проверка на невидимость

        $("").shouldHave(text("abc"));    // проверка на вхождение текста
        $("").shouldHave(Condition.exactText("abc"));    // проверка на конкретный текста
        $("").shouldHave(Condition.textCaseSensitive("abc"));    // проверка на вхождение текста с учетом регистра
        $("").shouldHave(Condition.exactText("abc"));    // проверка на конкретный текст с учетом регистра
        $("").should(Condition.matchText("[0-9]abc$")); // проверка regex

        $("").shouldHave(Condition.cssClass("red"));    // проверяет, содержит ли элемент данный класс
        $("").shouldHave(Condition.cssValue("font-size", "12"));    // проверка элемента по css

        $("").shouldHave(Condition.value("25"));    // для проверок полей для ввода, если нет толя текста
        $("").shouldHave(Condition.exactValue("25"));   // то же самое, но для полной строки
        $("").shouldBe(Condition.empty);   // проверка, что поле пустое

        $("").shouldHave(Condition.attribute("disabled"));  // проверка атрибутов на существование
        $("").shouldHave(Condition.attribute("name", "example"));  // проверка атрибутов на значение
        $("").shouldHave(Condition.attributeMatching("name", "[0-9]abc$"));  // проверка атрибутов regex

        $("").shouldBe(Condition.checked); // проверка, что чекбокс включен

        $("").should(Condition.exist);  // Не путать с visible. А exist проверяет что элемент есть в дом дереве

        $("").shouldBe(Condition.disabled); // Проверка на недоступность нажатия кнопки. Не всегда работает, зависит от реализации
        $("").shouldBe(Condition.enabled);  // Проверка на доступность нажатия кнопки. Не всегда работает, зависит от реализации
    }

    void collectionExample() {
        $$("div");  // Собирает в коллекцию все элементы
        $$x("//div");   // То же самое для xPath

        $$("div").filter(text("123")).shouldHave(size(1));    // Коллекции можем фильтровать. Ищем те что содержит по тексту
        $$("div").excludeWith(text("123")).shouldHave(size(1));   // Те что не содержит текст

        $$("div").first().click();  // Клик по первому элементу
        elements("div").first().click();    // синоним

        $$("div").last().click();   // Клик по последнему элементу
        $$("div").get(1).click();   // Клик по номеру элемента
        $("div", 1).click();    //  синоним
        $$("div").findBy(text("123")).click();    // Фильтрует и берет первый

        // assertions
        $$("").shouldHave(size(0));  // проверка на размер
        $$("").shouldBe(empty);  // Проверка на пустоту

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));  // Проверка подстроки на количество элементов
        $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));  // Проверка полной строки на количество элементов

        $$("").shouldHave(textsInAnyOrder("Alfa", "Beta", "Gamma"));    // То же самое, но игнорирует порядок
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Alfa", "Beta", "Gamma"));    // То же самое, но для полной строки

        $$("").shouldHave(itemWithText("Gamma"));    // Проверяет что в коллекции есть хотя бы один элемент с текстом

        $$("").shouldHave(sizeGreaterThan(0));  // Проверяет что в коллекции больше нуля элементов
        $$("").shouldHave(sizeGreaterThanOrEqual(1));   // Проверяет что в коллекции больше или равно одному элементу
        $$("").shouldHave(sizeLessThan(2)); // Проверяет что в коллекции меньше нуля элементов
        $$("").shouldHave(sizeLessThanOrEqual(3));  // Проверяет что в коллекции меньше или равно одному элементу
    }

    void fileOperationExample() throws FileNotFoundException {
        File file1 = $("a.fileLink").download();    // Скачивание файла, но работает не всегда
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // Работает почти всегда

        //Загрузка файла
        File file = new File("src/test/resources/readme.txt");   // прописываем путь до файла
        $("#file-upload").uploadFile(file); // подгружаем файл
        $("#file-upload").uploadFromClasspath("readme.txt");    // если файли изначально в resources, то он сам подтянется
        // Не забываем после того как подложили файл нажать кнопку загрузки
        $("uploadButton").click();
    }

    void javascriptExample() {
        // Запуск можно любой JS и из любого места
        executeJavaScript("alert('selenide')"); // прямой вызов команды
        executeJavaScript("alert(argument[0]+argument[1])", "abc", 12); // вызов JS с использованием параметров
        long fortytwo = executeJavaScript("return argument[0]*argument[1];", 6, 7);    // получить значение в результате выполнения JS
    }
}
