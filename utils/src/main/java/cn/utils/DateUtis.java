package cn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtis {
    //日期字符串
    public static  String date2String(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }
    public static Date String2Date(String str,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        try {
            Date date = simpleDateFormat.parse(str);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException("日期转换异常");
        }
    }
}
