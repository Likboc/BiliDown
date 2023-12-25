package org.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestUtil {
    public static String url = "https://api.bilibili.com/x/web-interface/nav";
    public static String getContentInString() throws IOException {
        URL request = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) request.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String tmp;
        StringBuilder result = new StringBuilder();
        while((tmp = bufferedReader.readLine()) != null) {
            result.append(tmp);
        }
        return result.toString();

    }
}
