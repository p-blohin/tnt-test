package com.tnt.testing.selenide;

import com.codeborne.selenide.ElementsCollection;
import static org.testng.Assert.*;

import org.testng.annotations.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TNTechSearchObjectsTest {

    public List<String> getWebObjects(String className) {
        ElementsCollection elementsList = $$(By.className(className));
        return elementsList.texts();
    }

    @BeforeClass(groups = {"oneObjTest", "multiObjTest"})
    public void openContactsOnTNTechSite() {
        open("https://tt.transneft.ru");
        $(By.linkText("Контакты")).click();
    }

    @Test(groups = {"oneObjTest"})
    @Parameters({"textToSearch", "className"})
    public void searchTextOneObj(String textToSearch, String className) {
        boolean containCheck = getWebObjects(className).contains(textToSearch);
        assertTrue(containCheck);
    }

    @Test(groups = {"multiObjTest"})
    @Parameters({"textToSearch_1", "textToSearch_2", "className"})
    public void searchTextMultiObj(String textToSearch_1, String textToSearch_2, String className) {
        List<String> elemToSearch = new ArrayList<>(List.of(textToSearch_1, textToSearch_2));
        boolean containCheck = getWebObjects(className).containsAll(elemToSearch);
        assertTrue(containCheck);
    }

}
