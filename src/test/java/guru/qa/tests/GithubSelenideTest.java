package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSelenideTest {
    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void wikiSoftAssertionsTest() {
        // - Откройте страницу Selenide в Github
        open("/selenide/selenide");
        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").$("ul").$$("li")
                .shouldHave(itemWithText("Soft assertions"));
    }

    @Test
    void jUnitExampleTest() {
        // - Откройте страницу SoftAssertions //$(".markdown-body").$("ul").$$("li").findBy(text("Soft assertions")).$("a").click();
        open("/selenide/selenide/wiki/SoftAssertions");
        // проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").$$("h4").filter(text("JUnit5"))
                .shouldHave(sizeGreaterThan(0));
        $("#user-content-3-using-junit5-extend-test-class").sibling(0)
                .shouldHave(exactText("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}