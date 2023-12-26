package org.example.API;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.util.HttpRequestUtil;
import org.example.util.MD5Dig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WbiEnc {
    static int[] MixinArray = new int[]{46, 47, 18, 2, 53, 8, 23, 32, 15, 50, 10, 31, 58, 3, 45, 35, 27, 43, 5, 49, 33, 9, 42, 19, 29, 28, 14, 39, 12, 38, 41, 13, 37, 48, 7, 16, 24, 55, 40, 61, 26, 17, 0, 1, 60, 51, 30, 4, 22, 25, 54, 21, 56, 59, 6, 63, 57, 62, 11, 36, 20, 34, 44, 52};
    static String NavUrl = "https://api.bilibili.com/x/web-interface/nav";

    /**
     * concat wts param
     * @param url
     * @return
     */
    public static String setWts(String url) {
        StringBuilder result = new StringBuilder(url);
        long ts = System.currentTimeMillis() / 1000L;
        String wts = String.format("wts=%d",ts);
        result.append(url.isEmpty()? "?" + wts : "&" + wts);
        return result.toString();
    }

    /**
     * generate and concat w_rid param
     * @param url
     * @return w_rid = ""
     * @throws UnsupportedEncodingException
     */
    public static String setWrid(String url) throws IOException {
        //1.1
        StringBuilder url_wrid = new StringBuilder();

        //1.2 get param string array
        int paramIdx = url.indexOf("?") + 1;
        String paramStr = url.substring(paramIdx);
        url_wrid.append(url.substring(0,paramIdx));
        String[] params = paramStr.split("&");

        // array -> arraylist : convert to use sort()
        List<String> paramList = new ArrayList<>(Arrays.asList(params));

        //1.3 sort list
        Collections.sort(paramList);

        //1.4 encoding key & value by iterate;
        //    get new String
        for(String s : paramList) {
            String[] arr1 = s.split("=",2);
            arr1[0] = URLEncoder.encode(arr1[0],"UTF-8");
            arr1[1] = URLEncoder.encode(arr1[1],"UTF-8");
            url_wrid
                    .append(arr1[0])
                    .append("=")
                    .append(arr1[1])
                    .append("&");
        }
        String mixinKeys = getMixinKeys();
        String md5Input = String.join("&",paramList) + mixinKeys;
        url_wrid
                .append("&")
                .append("w_rid")
                .append("=")
                .append(MD5Dig.md5Enc(md5Input));
        return url_wrid.toString();
    }

    /**
     * concat wbi img_url & sub_url
     * @return keys
     * @throws IOException
     */
    private static String getKeys() throws IOException {
        String key = HttpRequestUtil.getContentInString(NavUrl);
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

    /**
     * obtain the keys form getKeys() func
     * @return MixinKeys
     */
    private static String getMixinKeys() throws IOException {
        String keys = getKeys();
        StringBuilder MixinKeys = new StringBuilder();
        for(int i =0; i<keys.length();i++){
            MixinKeys.append(keys.charAt(MixinArray[i]));
        }
        return MixinKeys.substring(31);
    }
}
