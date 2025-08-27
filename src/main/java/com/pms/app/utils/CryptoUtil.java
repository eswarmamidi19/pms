package com.pms.app.utils;

import java.util.Base64;

public class CryptoUtil {

    private static final String SECRET_KEY = "mysecret"; // keep it short and simple

    public static String encrypt(String data) {
        byte[] key = SECRET_KEY.getBytes();
        byte[] input = data.getBytes();
        byte[] result = new byte[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = (byte) (input[i] ^ key[i % key.length]); // XOR encryption
        }

        return Base64.getEncoder().encodeToString(result);
    }

    public static String decrypt(String encryptedData) {
        byte[] key = SECRET_KEY.getBytes();
        byte[] input = Base64.getDecoder().decode(encryptedData);
        byte[] result = new byte[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = (byte) (input[i] ^ key[i % key.length]); // XOR decryption
        }

        return new String(result);
    }
}