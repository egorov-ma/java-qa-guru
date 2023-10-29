package ru.vtb;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginVtbTest {
    @Test
    void successfulLoginTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://ift-ibrb1-sharing.vtb.ru/login");
        $("[data-test-id=choicelogintype_login_new]").click();
        $("[data-test-id=login_formfield_input]").setValue("20252888");
        $("[data-test-id=submit-credentials-button]").click();
        $("[data-test-id=otp_formfield_input]").setValue("000000");
        $("[data-test-id=password_field_input]").setValue("123123Qw!");
        $("[data-test-id=submit-password-button]").click();
        $(".bSBHxy").shouldBe(Condition.exist).click();
    }
}
