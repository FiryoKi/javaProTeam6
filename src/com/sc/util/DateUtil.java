package com.sc.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author 6组
 */
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

}
