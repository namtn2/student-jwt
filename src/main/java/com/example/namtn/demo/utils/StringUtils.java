package com.example.namtn.demo.utils;

public class StringUtils {

    public static boolean isStringNullOrEmpty(String s) {
        return s == null || "".equals(s);
    }

    public static boolean isLongNullOrZero(Long l) {
        return l == null || 0L == l;
    }
}
