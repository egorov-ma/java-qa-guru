package guru.qa.selenide;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browserCommandExample() {
        open("https://google.com"); // абсолютный путь
        open("/customer/orders");   // можно задать относительный путь, настройке в билд гредл и впоследствии использовать в джобах дженкинса -> -Dselenide.baseUrl=://123.23.1
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password")); // используется когда надо авторизоваться на страникче с поп-ап

        Selenide.back();    // кнопочка назад в браузере
        Selenide.refresh(); // кнопочка обновить в браузере

        Selenide.clearBrowserCookies(); // почистить куки, после этой команды необходим рефреш
        Selenide.clearBrowserLocalStorage();    // чистит локалсторадж, после этой команды необходим рефреш
        executeJavaScript("sessionStorage.clear();");   // бывают случаи когда необходимо еще почистить сессию

        Selenide.confirm(); // нажать ОК в алерте
        Selenide.dismiss(); // закрыть алерт

        Selenide.closeWindow(); // закрыть активное окно
        Selenide.closeWebDriver(); // закрыть браузер

        Selenide.switchTo().frame("new");   // бывает необходимо переходить по фреймам на странице. можем использовать эту команду и переходить по имени/номеру
        Selenide.switchTo().defaultContent();   // возвращает в самое начало дом-дерева основного

        Selenide.switchTo().window("The Internet"); // перейти по имени или номеру окна
    }

    void selectorsExamples() {
        $("div").click();   // $ -- команда для поиска элементов на странице
        element("div").click();   // element -- синоним $. можно использовать если пишем на kotlin т.к. доллар уже занят

        $("div", 2).click();    // можно искать по индексу

        $x("//h1/div").click(); // селектор можно писать xPath
        $(byXpath("//h1/div")).click(); // то же самое что и пример выше

        $(byText("full text")).click(); // поиск элемента по полнуму тексту
        $(withText("ull tex")).click(); // поиск элемента по совпадению в тексте

        $(byTagAndText("div", "full text")).click(); // поиск элемента по полнуму тексту и тегу
        $(withTagAndText("div", "ull tex")).click(); // поиск элемента по совпадению в тексте и тегу

        $("").parent(); // поиск вверх по дом-дереву
        $("").sibling(1);   // брат вниз по дереву
        $("").preceding(1);   // брат вверх по дереву
        $("").closest("div");   // поиск предка по селектору
        $("").ancestor("div");   // поиск предка по селектору
        $("div:last-child");    // поиск последнего ребенка

        $("div").$("h1").find(byText("abc")).click();   // пример что селекторы можно соединять

        $(byAttribute("abc", "x")).click();  //редкие, опционально. есть синоним, см ниже
        $("[abc=x]").click();   //  поиск по цсс селектуру. обычный атрибут -- []

        $(byId("mytext")).click(); //редкие, опционально. есть синоним, см ниже. исключение если айди начинается с цифры
        $("#mytext").click();   //  поиск по цсс селектуру. айди -- #

        $(byClassName("red")).click(); //редкие, опционально. есть синоним, см ниже
        $(".red").click();   //  поиск по цсс селектуру. класс -- .
    }

    void actionsExample() {
        $("").click();  // клик по элементу
        $("").doubleClick();  // двойной клик по элементу
        $("").contextClick();   // клик правой клавиши мыши

        $("").hover();  // поднести мышку но не нажимать

        $("").setValue("text"); // записываем текст в поле для ввода. если есть предзаполненный текст то команда его сотрет
        $("").append("text");   // добавляет текст в конец уже написанного в поле
        $("").clear();  // очищает поле
        $("").setValue(""); // очищает поле

        $("div").sendKeys("c"); // имуляция нажатия клавишь
        actions().sendKeys("c").perform();
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform();    // комбинация клавиш
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));  // если не работает через actions то можно попробовать посылать на коневой html комбинации

        $("").pressEnter(); // нажатие на энтер
        $("").pressEscape();    // нажатие на эскейп
        $("").pressTab();   // нажатие на таб

        // начать действие, передвинуть мышку к элементу, кликнуть и не отпускать, двигать не отпуская клавишу, отпустить, завершить действие
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        $("").selectOption("dropdown_options"); // работа с дропдаунами. не всегда работывает с новыми дропдаунами. на новых используем клики
        $("").selectRadio("radio_options"); // работа с чекбоксами и радиобаттоми. чаще всего проще использовать клик по тексту радом с чекбоксом
    }

    void assertionsExample() {
        // чень рекомендуется в селениде в проверках использовать should.. команды работают одиноково, разное название нужно только чтобы по английски корректно читалось
        $("").shouldBe(Condition.visible);
        $("").shouldNotBe(Condition.visible);
        $("").shouldHave(Condition.text("abc"));
        $("").shouldNotHave(Condition.text("abc"));
        $("").should(Condition.appear);
        $("").shouldNot(Condition.appear);

        $("").shouldBe(Condition.visible, Duration.ofSeconds(30));  // если необходимо для конкретной проверки увеличить/уменьшить таймаут
    }
}
