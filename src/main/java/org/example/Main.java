package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {
        String raw = "{\"code\":0,\"message\":\"0\",\"ttl\":1,\"data\":[{\"cid\":1348330933,\"page\":1,\"from\":\"vupload\",\"part\":\"好纠结呀，到底要不要去做近视手术？\",\"duration\":229,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":3840,\"height\":2160,\"rotate\":0},\"first_frame\":\"http://i0.hdslb.com/bfs/storyff/n231129qn1j3geypcyq6p2rb13d01yk6_firsti.jpg\"}]}";
        JsonObject jsonObject = JsonParser.parseString(raw).getAsJsonObject();
        System.out.println(jsonObject.getAsJsonArray("data").get(0).getAsJsonObject().get("cid").getAsString());
    }
}