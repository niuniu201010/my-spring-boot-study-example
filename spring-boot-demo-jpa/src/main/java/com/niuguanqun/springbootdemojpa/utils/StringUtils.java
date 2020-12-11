package com.niuguanqun.springbootdemojpa.utils;

public class StringUtils {
    public static boolean isNullOrEmpty(String obj) {
        if (obj == null) {
            return true;
        }
        if ("".equals(obj)) {
            return true;
        }
        return false;
    }
}
