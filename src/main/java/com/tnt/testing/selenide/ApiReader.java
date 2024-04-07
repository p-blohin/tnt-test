package com.tnt.testing.selenide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ApiReader {

    public static String getJSONFromURL(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
    }

    public static HashMap<String, String> getData(String url) {
        String jsonString = getJSONFromURL(url);

        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        HashMap<String, String> dataMap = new HashMap<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject personData = jsonArray.getJSONObject(i);

            String email = personData.getString("email");
            String firstName = personData.getString("first_name");

            dataMap.put(firstName, email);
        }

        return dataMap;
    }
}
