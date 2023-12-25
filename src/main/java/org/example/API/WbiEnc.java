package org.example.API;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.util.HttpRequestUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WbiEnc {
    static int[] MixinArray = new int[]{46, 47, 18, 2, 53, 8, 23, 32, 15, 50, 10, 31, 58, 3, 45, 35, 27, 43, 5, 49, 33, 9, 42, 19, 29, 28, 14, 39, 12, 38, 41, 13, 37, 48, 7, 16, 24, 55, 40, 61, 26, 17, 0, 1, 60, 51, 30, 4, 22, 25, 54, 21, 56, 59, 6, 63, 57, 62, 11, 36, 20, 34, 44, 52};
    public static String getWts(String url) {
        long ts = System.currentTimeMillis() / 1000L;
        String wts = String.format("wts=%d",ts);
        return url.isEmpty()? "?" + wts : "&" + wts;
    }

    public static String getWrid(String url) throws UnsupportedEncodingException {
        //1.1 get full uri
        String url1 = getWts(url);
        System.out.println("拼接后url为:"+ url1);

        //1.2 get param string array
        int urlEnd_idx = url1.lastIndexOf("/");
        int paramIdx = url1.indexOf("?") + 1;
        String paramStr = url1.substring(paramIdx);
        String[] params = paramStr.split("&");
        // array -> arraylist
        List<String> paramList = new ArrayList<>(Arrays.asList(params));

        //1.3 sort list
        Collections.sort(paramList);

        //1.4 encoding key & value by iterate;
        //    get new String
        String ans;
        for(String s : paramList) {
            String[] arr1 = s.split("=",2);
            arr1[0] = URLEncoder.encode(arr1[0],"UTF-8");
            arr1[1] = URLEncoder.encode(arr1[1],"UTF-8");
            s = arr1[0] + "=" + arr1[1];
        }
        return String.join("&",paramList);
    }
    public String getKeys() throws IOException {
        String key = HttpRequestUtil.getContentInString();
        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(key).getAsJsonObject();
        JsonObject jsonObject1 = jsonObject.getAsJsonObject("data").getAsJsonObject("wbi_img");
//        String url = jsonObject1.get("img_url").toString().matches(".*?$(.png)");
        Pattern pattern = Pattern.compile(".*/(\\w+)\\.png$");
        Matcher matcher = pattern.matcher(jsonObject1.get("img_url").getAsString());
        Matcher matcher1 = pattern.matcher(jsonObject1.get("sub_url").getAsString());
        if(matcher.find() && matcher1.find()) {
            return  matcher.group(1) + matcher1.group(1);
        }
        return null;
    }

    public String getMixinKeys(String keys) {
        StringBuilder builder = new StringBuilder();
        for(int i =0; i<keys.length();i++){
            builder.append(keys.charAt(MixinArray[i]));
        }
        return builder.toString();
    }

}
