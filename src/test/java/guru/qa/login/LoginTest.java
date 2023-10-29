package guru.qa.login;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    private String username;
    private String password;

    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void loadCredentials() {
        try {
            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("credentials.properties");
            if (input != null) {
                prop.load(input);
                username = prop.getProperty("username");
                password = prop.getProperty("password");
            } else {
                throw new IOException("credentials.properties not found in the classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading credentials", e);
        }
    }

    @Test
    void successfulLoginTest() {
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue(username);
        $("[name=password]").setValue(password).pressEnter();
        $(".main-header__login").click();
        $("#xdget642385_1").shouldHave(text("Здравствуйте, Maksim"));
    }
}
