package guru.qa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DropTest {

    @BeforeEach
    void setUp() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dropTest() {

        //2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
        // - Откройте https://the-internet.herokuapp.com/drag_and_drop
        // - Перенесите прямоугольник А на место В
        // - Проверьте, что прямоугольники действительно поменялись
        // - В Selenide есть команда $(element).dragAndDrop($(to-element)),
        // проверьте работает ли тест, если использовать её вместо actions()

        Point pointA = $("#column-a").getLocation();
        Point pointB = $("#column-b").getLocation();
        actions().dragAndDropBy($("#column-a"),
                pointB.getX() - pointA.getX(),
                pointB.getY() - pointA.getY()).perform();
        $("#column-a").shouldHave(text("B"));

    }
}
