package com.yjl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yujiale
 */
public class DateUtils {

    /**
     * 获取日期对象 格式化后的字符串
     * @return
     */
    public static String getDateFormat(){

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = sdf.format(date);

        return format;
    }
}
