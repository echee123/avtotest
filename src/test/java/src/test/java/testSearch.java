package src.test.java;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testSearch {
    @BeforeAll
    static void settings() {
        Configuration.browserSize ="1920x1080";
        Configuration.holdBrowserOpen =true;
    }
    @Test //авторизация
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://test.core.brew4ru.net/CAWA/signin");
        $("[placeholder=Логин]").setValue("tsanw01");
        $("[placeholder=Пароль]").setValue("Tim!1234");
        $(".btn-wrap").click();
        $(".user-name").shouldHave(text("tsanw01"));
}

    @Test //неправильный пароль
    void pass() {
        open("https://test.core.brew4ru.net/CAWA/signin");
        $("[placeholder=Логин]").setValue("tsanw01");
        $("[placeholder=Пароль]").setValue("qqqqqqqq");
        $(".btn-wrap").click();
        $(".title-wrap").shouldHave(text("Авторизация"));
    }
}
