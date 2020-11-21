package com.revoluteai.utils;

public class StringUtils {

    public static void isNotNullOrEmpty(String data,String message){

        if(data == null || data.trim().isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }
}
