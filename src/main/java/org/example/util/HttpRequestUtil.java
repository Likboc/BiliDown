package org.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestUtil {
    /**
     * convet response to String
     * @param url
     * @return
     * @throws IOException
     */
    public static String getContentInString(String url) throws IOException {
        URL request = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) request.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Referer", "https://www.bilibili.com");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        connection.setRequestProperty("Host", "api.bilibili.com");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String tmp;
        StringBuilder result = new StringBuilder();
        while((tmp = bufferedReader.readLine()) != null) {
            result.append(tmp);
        }
        return result.toString();
    }

    public static String getStatus(String url) throws IOException {
        URL request = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) request.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Referer", "https://www.bilibili.com");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        connection.setRequestProperty("Host", "api.bilibili.com");
        return String.valueOf(connection.getResponseCode());
    }
}
