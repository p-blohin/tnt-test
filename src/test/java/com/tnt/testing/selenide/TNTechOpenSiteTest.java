package com.tnt.testing.selenide;

import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TNTechOpenSiteTest {

    @Test(groups = {"searchInGoogleTest"})
    public void searchTNTechSiteInGoogle() {
        open("http://google.com");

        $(By.name("q")).setValue("транснефть технологии").pressEnter();

        ElementsCollection resultLinks = $$(By.className("q0vns"));
        resultLinks.first().shouldHave(text("https://tt.transneft.ru"));
    }

    @Test(groups = "openContactsTest")
    public void openContactsOnTNTechSite() {
        open("https://tt.transneft.ru");
        $(By.linkText("Контакты")).click();
    }
}