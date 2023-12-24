package org.example.API;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WbiEnc {
    public static String getWts(String url) {
        long ts = System.currentTimeMillis() / 1000L;
        String wts = String.format("wts=",ts);
        return url =  url == ""? "?" + wts : "&" + wts;
    }

    public static String getWrid(String url) throws UnsupportedEncodingException {
        //1.1 get full uri
        url = getWts(url);
        System.out.println("拼接后url为:"+url);

        //1.2 get param string array
        int urlEnd_idx = url.lastIndexOf("/");
        int paramIdx = url.indexOf("?") + 1;
        String paramStr = url.substring(paramIdx);
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
       url = String.join("&",paramList);
        return url;
    }
}
