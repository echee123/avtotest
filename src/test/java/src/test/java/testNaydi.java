package src.test.java;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testNaydi {
    @Test
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://test.core.brew4ru.net/CAWA/signin");
        $("[placeholder=Логин]").setValue("tsanw01");
        $("[placeholder=Пароль]").setValue("Tim!1234");
        $(".btn-wrap").click();
        $(".user-name").shouldHave(text("tsanw01"));
}

    @Test
    void pass() {
        Configuration.pageLoadStrategy = "eager";
        open("https://test.core.brew4ru.net/CAWA/signin");
        $("[placeholder=Логин]").setValue("tsanw01");
        $("[placeholder=Пароль]").setValue("qqqqqqqq");
        $(".btn-wrap").click();
        $(".title-wrap").shouldHave(text("Авторизация"));
    }
}
