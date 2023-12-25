package org.example.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Dig {

    public static String md5Enc(String input) {
        String md5Str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] InputBytes = input.getBytes();
            byte[] md5Bytes = md.digest(InputBytes);
            md5Str = new BigInteger(1,md5Bytes).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Str;
    }

}
