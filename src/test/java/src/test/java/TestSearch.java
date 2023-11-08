package src.test.java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestSearch {

    @BeforeAll
    static void settings() {
        Configuration.browserSize ="1920x1080";
        Configuration.holdBrowserOpen =true;
        SelenideLogger.addListener("allure", new AllureSelenide());


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
