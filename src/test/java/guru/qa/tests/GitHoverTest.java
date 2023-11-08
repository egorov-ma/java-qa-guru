package guru.qa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHoverTest {
    @BeforeEach
    void setUp() {
        open("https://github.com");
    }

    @Test
    void hoverTest() {

        //1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."

        $("[aria-label=Global]").$("ul").$$("li").findBy(text("Solutions")).hover();
        $("ul").$("[aria-labelledby=solutions-for-heading]").$(withText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}