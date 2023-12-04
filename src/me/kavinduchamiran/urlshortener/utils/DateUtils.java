package me.kavinduchamiran.urlshortener.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private DateUtils() {
    }

    public static Date getNow() {
        return new Date();
    }

    public static Date addMinutes(int numberOfMinutes) {
        return addMinutes(getNow(), numberOfMinutes);
    }

    public static Date addMinutes(Date date, int numberOfMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, numberOfMinutes);
        return cal.getTime();
    }
}
