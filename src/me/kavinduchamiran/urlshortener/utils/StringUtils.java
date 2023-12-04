package me.kavinduchamiran.urlshortener.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean notEmpty(String s) {
        return !isEmpty(s);
    }
}
