package com.kongpf.commonhelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static final SimpleDateFormat DATE_FROMAT_DEFAULT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate() {
        return formatDate(new Date());
    }

    public static String formatDate(long ms) {
        return formatDate(new Date(ms));
    }

    public static String formatDate(Date date) {
        return formatDate(DATE_FROMAT_DEFAULT, date);
    }

    public static String formatDate(String format, Date date) {
        return formatDate(new SimpleDateFormat(format), date);
    }

    public static String formatDate(SimpleDateFormat dateFormat, Date date) {
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
