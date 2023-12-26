package org.example.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class GetVideoInfo {
    private static final String cid_Api;
    private static final String video_Api;

    static {
        cid_Api = "https://api.bilibili.com/x/player/pagelist?bvid=%s&jsonp=jsonp";
//        Vl_Api = "https://api.bilibili.com/x/web-interface/view?cid=%d&bvid=%s";
        video_Api = "https://api.bilibili.com/x/player/wbi/playurl?cid=%d&bvid=%s&qn=32";
    }

    public static int getCid(String avid) throws IOException {
        String url = String.format(cid_Api,avid);
        String res = HttpRequestUtil.getContentInString(url);
        JsonObject jsonObject = JsonParser.parseString(res).getAsJsonObject();
        return jsonObject
                .getAsJsonArray("data")
                .get(0)
                .getAsJsonObject()
                .get("cid")
                .getAsInt();
    }

    public static String getVideoLink(String avid,int cid) throws IOException {
        String url = String.format(video_Api,cid,avid);
        String res = HttpRequestUtil.getContentInString(url);
        return null ; // remember to delete
    }

}
