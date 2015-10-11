package com.tdb.tanbobo.base.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Description: (日期工具类)
 * @Author Tandingbo
 * @Date 2015/8/31 22:27
 */
public class DateUtils {

    public static String formatYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");//格式化对象
        return sdf.format(date);
    }

    public static long getAfterMonthDate() {
        Date date = new Date();//当前日期
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期
        calendar.add(Calendar.MONTH, +1);//月份加一
//        System.out.println(formatYMD(calendar.getTime()));//输出格式化的日期
        return calendar.getTimeInMillis();
    }

    public static long getBeforMonthDate() {
        Date date = new Date();//当前日期
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期
        calendar.add(Calendar.MONTH, -1);//月份减一
//        System.out.println(formatYMD(calendar.getTime()));//输出格式化的日期
        return calendar.getTimeInMillis();
    }

    public static void main(String[] args) {
        System.out.println(getAfterMonthDate());
    }
}
