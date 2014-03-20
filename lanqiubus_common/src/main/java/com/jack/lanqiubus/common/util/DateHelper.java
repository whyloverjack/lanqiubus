/**----------------------------------------------------------------
 // Copyright (C) 2012 北京品众互动网络营销技术有限公司
 // 版权所有。
 //
 // 工程名：PZoom_Common
 // 所属包：package com.pzoom.common;
 //
 // 文件名：DateHelper.java
 //
 // 创建时间：2012-8-15
 //----------------------------------------------------------------*/

package com.jack.lanqiubus.common.util;

import jodd.datetime.JDateTime;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作类
 *
 * @author zhangyunjie
 *         <p/>
 *         修改标识： 修改描述：
 * @version [PZoom-V2.0]
 */
public class DateHelper {
    private static Logger log = Logger.getLogger(DateHelper.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat();
    private static String FORMAT = "yyyy-MM-dd";

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        date = c.getTime();
        return date;
    }

    /**
     * 给根据日期添加小时数
     *
     * @param date 日期
     * @param hour 要添加的小时
     * @return
     */
    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hour);
        date = c.getTime();
        return date;
    }

    /**
     * 获取需要时间格式
     *
     * @param str
     * @param format
     * @return
     */
    public static String getStrDate(long str, String format) {
        sdf.applyPattern(format);
        Date dt = new Date(str);
        String date = sdf.format(dt);
        return date;
    }

    /*
     * 获取需要时间 格式为"yyyy-MM-dd
     */
    public static String getNeedDate(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt = new Date(Long.parseLong(str));
        String date = sdf.format(dt);
        return date;
    }

    /**
     * 获取当前时间，格式为：yyyy-MM-dd
     *
     * @return
     */
    public static String getNowDate() {
        Date date = new Date();
        sdf.applyPattern("yyyy-MM-dd");
        String time = sdf.format(date);
        return time;
    }


    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.DATE, -1);
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        return dayAfter;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getDayAfterUseField(String specifiedDay, int limit) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + limit);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        return dayAfter;
    }

    /**
     * @param specifiedDay
     * @param i
     * @return
     * @Description: 把日期减去i天
     */
    public static String getNeedDate(String specifiedDay, int i) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.DATE, -i);
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;

    }

    /**
     * @param cntDate
     * @return
     * @Description: 获取当前日期减去i天之后的日期<br>
     * date[0] startDate<br>
     * date[1] endDate<br>
     */
    public static String[] getCntDate(long perDate, int cntDate) {
        String[] date = new String[2];
        String endDate = getStrDate(perDate, FORMAT);
        String startDate = getNeedDate(endDate, cntDate);
        date[0] = startDate;
        date[1] = endDate;
        return date;

    }

    /**
     * 在给定日期上添加给定的月数
     *
     * @param date  日期
     * @param month 要加的月数
     * @return
     */
    public static Date addMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        date = c.getTime();
        return date;
    }

    /**
     * @param date
     * @param date2
     * @return
     */
    public static int before(Date date, Date date2) {
        return date.compareTo(date2);
    }

    public static String format(Date date, String format) {
        sdf.applyPattern(format);
        return sdf.format(date);
    }

    public static String format(Date date) {
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date parse(String dateStr, String pattern) {
        try {
            sdf.applyPattern(pattern);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parse(String dateStr) throws ParseException {
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(dateStr);
    }

    public static boolean sameDay(Date d1, Date d2) {
        String s1 = DateHelper.format(d1, "yyyy-MM-dd");
        String s2 = DateHelper.format(d2, "yyyy-MM-dd");
        return s1.equals(s2);
    }

    public static Date getCurrentMonthStart() {
        String d = format(new Date(), "yyyy-MM");
        Date date = parse(d + "-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        return date;
    }

    public static Date getCurrentWeekStart() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    public static Date getTodayStart() {
        String d = format(new Date(), "yyyy-MM-dd");
        Date date = parse(d + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
        return date;
    }

    public static long ConvertDateToLong(Date date) {
        long time = 0l;

        date.getTime();

        return time;
    }

    private static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @param time
     * @param i
     * @return
     * @throws java.text.ParseException
     * @Description: 日期向后推i天
     */
    public static String addoneDay(String time, int i) {
        Calendar c = Calendar.getInstance();
        Date date = null;

        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        c.setTime(date);
        c.add(Calendar.DATE, i);
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /**
     * @param cntDate
     * @return
     * @Description: 获得日期减去i天之后时间范围短内的所有日期
     */
    public static String[] getAllCntDate(String endDate, int cntDate) {
        String[] allDate = new String[cntDate];
        String startDate = null;
        for (int i = 0; i < cntDate; i++) {
            startDate = getNeedDate(endDate, i);
            allDate[i] = startDate;
        }
        return allDate;
    }

    public static long getTwoDaysDifference(String dateBef, String dateAfter) {
        String[] split1 = dateBef.split("-");
        String[] split2 = dateAfter.split("-");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]), Integer.parseInt(split1[2]));
        calendar2.set(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), Integer.parseInt(split2[2]));

        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffDays = diff / (24 * 60 * 60 * 1000);

//        log.info("[DateHelper twoDaysDifference] 两个日期相差  " + diffDays + "天！！！");
        return diffDays;
    }

    /**
     * 获取给定增量下的时间值
     *
     * @param date      特操作日期
     * @param increment 增量
     * @return
     */
    public static String getTargetDate(String date, int increment) {
        JDateTime jdt = new JDateTime(date);
        jdt.addDay(increment);
        return jdt.toString("YYYY-MM-DD");
    }

    /**
     * 两个时间之间相差距离多少天
     *
     * @param str1 时间参数 1：
     * @param str2 时间参数 2：
     * @return 相差天数
     */
    public static long getDistanceDays(String str1, String str2) {
        Date one = null;
        Date two = null;
        long days = 0;
        sdf.applyPattern(FORMAT);
        try {
            one = sdf.parse(str1);
            two = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = one.getTime();
        long time2 = two.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        days = diff / (1000 * 60 * 60 * 24);

        return days;
    }

}
