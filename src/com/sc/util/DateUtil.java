package com.sc.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {
    public static Date stringToDate(String date)  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(format.parse(date).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        return simpleDateFormat.format(date);
    }

}
