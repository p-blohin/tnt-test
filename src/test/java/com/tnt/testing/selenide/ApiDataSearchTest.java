package com.tnt.testing.selenide;

import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Selenide.*;

public class ApiDataSearchTest {

    @Test
    @Parameters({"apiAddress"})
    public void findNameAndEmail(String apiAddress) {
        open("https://j17lt.csb.app/");
        ElementsCollection elements = $$("#root p");

        String name = elements.get(4).text();
        String email = elements.get(5).text();

        HashMap<String, String> firstNameEmailMap = ApiReader.getData(apiAddress);

        assertTrue(firstNameEmailMap.containsKey(name));
        assertTrue(firstNameEmailMap.containsValue(email));
    }
}
