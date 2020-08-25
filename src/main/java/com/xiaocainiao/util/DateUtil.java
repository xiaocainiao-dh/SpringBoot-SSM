package com.xiaocainiao.util;

import org.apache.commons.lang.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYY = "yyyy";
    public static final String YYYY_MM = "yyyyMM";

    private final static SimpleDateFormat dateformater = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
    private final static SimpleDateFormat dateformater1 = new SimpleDateFormat(YYYY_MM_DD);
    private final static SimpleDateFormat dateformater2 = new SimpleDateFormat(YYYY_MMDD);
    private final static SimpleDateFormat dateformater3 = new SimpleDateFormat(YYYYMMDDHHMMSS);
    private final static SimpleDateFormat dateformater4 = new SimpleDateFormat(YYYY_MM);
    private final static SimpleDateFormat dateformater5 = new SimpleDateFormat(YYYY);
    public static boolean defaultTimeFlag = true;

    public final static String startTimePoint = " 00:00:00";
    public final static String endTimePoint = " 23:59:59";


    /**
     * Format(yyyy_MM_dd HH:mm:ss)
     * @return java.util.Date
     */
    public static Date getNowDate() {
        Date date = null;
        try {
            date = parseUtilDate(dateformater.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 精确到时分秒
     * @return
     * @throws ParseException
     */
    public static java.lang.String formatSecondDate(Date d) throws ParseException {
        return dateformater3.format(d);
    }
    public static String getFormatNowDay() {
        return dateformater1.format(new Date());
    }

    public static String getSNowDay() {
        return dateformater.format(new Date());
    }
    public static String getFormatDay(Date d) {
        return dateformater2.format(d);
    }

    public static String getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar
                .getActualMinimum(Calendar.DAY_OF_MONTH));

        return dateformater1.format(calendar.getTime());
    }

    public static String getMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateformater1.format(calendar.getTime());
    }


    private final static long DAY_IN_MILLISECOND = 1000 * 3600 * 24;

    public final static long DAY_IN_SECOND = 3600 * 24;


    private DateUtil() {
    }

    public static java.util.Date getDate(java.util.Date startDate, int days) {
        java.util.Date returnDay = dateDayAdd(startDate, days);
        return returnDay;
    }

    public static java.util.Date getMonthDate(java.util.Date startDate,
                                              int months) {
        java.util.Date returnDay = dateMonthAdd(startDate, months);
        return returnDay;
    }

    public static String getCurMonth() {
        return new SimpleDateFormat("yyyy-MM").format(new java.util.Date());
    }

    public static java.util.Date getMonthBegin(java.util.Date month) {
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(month);
        int year = ca.get(GregorianCalendar.YEAR);
        int mon = ca.get(GregorianCalendar.MONTH);
        GregorianCalendar gCal = new GregorianCalendar(year, mon, 1);
        return gCal.getTime();
    }

    public static java.util.Date getMonthBegin(int year, int month) {
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month must from 1 to 12");
        GregorianCalendar gCal = new GregorianCalendar(year, month - 1, 1);
        return gCal.getTime();
    }
    public static java.util.Date getMonthEnd(java.util.Date month) {
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(month);
        int year = ca.get(GregorianCalendar.YEAR);
        int mon = ca.get(GregorianCalendar.MONTH);
        int lastDay = ca.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        GregorianCalendar gCal = new GregorianCalendar(year, mon, lastDay);
        return gCal.getTime();
    }

    public static java.util.Date getMonthEnd(int year, int month) {
        java.util.Date start = getMonthBegin(year, month);
        return getMonthEnd(start);
    }

    public static java.util.Date getWeekBegin(java.util.Date date) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(date);
        int startDay = gCal.getActualMinimum(GregorianCalendar.DAY_OF_WEEK);
        gCal.set(GregorianCalendar.DAY_OF_WEEK, startDay);
        return gCal.getTime();
    }

    public static java.util.Date getWeekEnd(java.util.Date date) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(date);
        int lastDay = gCal.getActualMaximum(GregorianCalendar.DAY_OF_WEEK);
        gCal.set(GregorianCalendar.DAY_OF_WEEK, lastDay);
        return gCal.getTime();
    }

    public static int getDays(java.sql.Timestamp beginTime,
                              java.sql.Timestamp endTime) {
        int days = (int) ((endTime.getTime() - beginTime.getTime()) / DAY_IN_MILLISECOND);
        return days;
    }

    public static java.sql.Date parseSqlDate(String strDate) {
        return java.sql.Date.valueOf(strDate);
    }

    /**
     * 精确到时分秒
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static java.util.Date parseUtilDate(String strDate) throws ParseException {
        return dateformater.parse(strDate);
    }

    /**
     * 精确到日
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static java.util.Date parseDayDate(String strDate) throws ParseException {
        return dateformater1.parse(strDate);
    }

    /**
     * 精确到日
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static java.util.Date parseDay2Date(String strDate) throws ParseException {
        return dateformater2.parse(strDate);
    }
    /**
     * 格式化时间
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static java.util.Date parse2Date(String strDate) throws ParseException {
        java.util.Date d = null;
        try {
            d =dateformater2.parse(strDate);
        } catch (Exception e) {
            try {
                d = dateformater4.parse(strDate);
            } catch (Exception e1) {
                d = dateformater5.parse(strDate);
            }
        }
        return d;
    }
    /**
     * 格式化时间
     * @return
     * @throws ParseException
     */
    public static java.lang.String format2Date(Date date) throws ParseException {
        java.lang.String d = null;
        try {
            d =dateformater2.format(date);
        } catch (Exception e) {
            try {
                d = dateformater4.format(date);
            } catch (Exception e1) {
                d = dateformater5.format(date);
            }
        }
        return d;
    }

    /**
     * 精确到日
     * @return
     * @throws ParseException
     */
    public static java.lang.String formatDayDate(Date d) throws ParseException {
        return dateformater1.format(d);
    }

    /**
     * 精确到日
     * @return
     * @throws ParseException
     */
    public static java.lang.String formatDate(Date d) throws ParseException {
        return dateformater2.format(d);
    }

    public static java.util.Date parseLastMonthDate() {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(new Date());
        gCal.add(GregorianCalendar.MONTH, -1);
        return gCal.getTime();
    }
    public static java.sql.Timestamp parseLastMonthTimestamp() {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(new Date());
        gCal.add(GregorianCalendar.MONTH, -1);
        return new java.sql.Timestamp(gCal.getTime().getTime());
    }

    public static java.sql.Timestamp getNextTimestamp(Timestamp e, int i) {
        if(e==null) return new java.sql.Timestamp(new Date().getTime());
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(new Date(e.getTime()+i*1000*60*60*24));
        return new java.sql.Timestamp(gCal.getTime().getTime());
    }

    private static java.util.Date dateDayAdd(java.util.Date date, int days) {
        long now = date.getTime() + days * DAY_IN_MILLISECOND;
        return (new java.util.Date(now));
    }

    @SuppressWarnings("unused")
    private static java.sql.Timestamp dateDateTimeAdd(
            java.sql.Timestamp timestamp, int minutes) {
        long now = timestamp.getTime() + minutes * 1000 * 60;
        return (new java.sql.Timestamp(now));
    }

    public static long getDiffMinu(Timestamp startDate, Timestamp endDate) {
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        System.out.println(startTime);
        System.out.println(endTime);

        long minu = (long) ((endTime - startTime) / (1000 * 60));
        return minu;
    }

    private static java.util.Date dateMonthAdd(java.util.Date date, int months) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        int m = cal.get(GregorianCalendar.MONTH) + months;
        if (m < 0)
            m += -12;
        cal.roll(GregorianCalendar.YEAR, m / 12);
        cal.roll(GregorianCalendar.MONTH, months);
        return cal.getTime();
    }

    @SuppressWarnings("unused")
    private static String getDateTimeStr(String str) {
        if (str.indexOf(" ") == -1)
            str += "  00:00:00";
        else if (str.lastIndexOf(":") == 13)
            str += ":00";
        return str;
    }

    public static int GetDaysOfMonth(int iYear, int Month) {
        int days = 0;
        switch (Month) {
            case 1:
                days = 31;
                break;
            case 2:
                if (IsRuYear(iYear)) {
                    days = 29;
                } else {
                    days = 28;
                }

                break;
            case 3:
                days = 31;
                break;
            case 4:
                days = 30;
                break;
            case 5:
                days = 31;
                break;
            case 6:
                days = 30;
                break;
            case 7:
                days = 31;
                break;
            case 8:
                days = 31;
                break;
            case 9:
                days = 30;
                break;
            case 10:
                days = 31;
                break;
            case 11:
                days = 30;
                break;
            case 12:
                days = 31;
                break;
        }

        return days;


    }

    private static boolean IsRuYear(int year) {

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();

        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) w = 0;
        return weekDays[w];

    }

    public static String convertDateFormat(Date date, String format) {
        String time = "";
        try {
            time = (new SimpleDateFormat(format)).format(date);
        } catch (RuntimeException e) {

        }
        return time;
    }



    public static Date getDateFromSeconds(long seconds) {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(seconds * 1000);
        return ca.getTime();
    }

    public static long getSecondsFromDurTime(String duration) {
        long seconds = 0;
        String[] dur = duration.split(":");
        seconds = new Long(dur[0]).longValue() * 3600 + new Long(dur[1]).longValue() * 60 + new Long(dur[2]).longValue();
        return seconds;
    }

    public static String formatDurTime(long durLong, String formatStr) {
        String durTime = "";
        if (formatStr == null || "".equals(formatStr))
            formatStr = "hh:mm:ss";
        String[] fmtArray = formatStr.split(":");
        for (int i = 0; i < fmtArray.length; i++) {
            if (fmtArray[i].equals("hh") || fmtArray[i].endsWith("小时")) {
                long hl = durLong / 3600;
                if (hl == 0)
                    continue;
                durLong = durLong % 3600;
                if (fmtArray[i].endsWith("小时"))
                    durTime += hl + fmtArray[i];
                else
                    durTime += hl + ":";
            } else if (fmtArray[i].equals("mm") || fmtArray[i].startsWith("分")) {
                long ml = durLong / 60;
                durLong = durLong % 60;
                if (fmtArray[i].startsWith("分"))
                    durTime += ml + fmtArray[i];
                else
                    durTime += ml + ":";
            } else if (fmtArray[i].equals("ss") || fmtArray[i].equals("秒")) {
                long sl = durLong;
                if (fmtArray[i].equals("秒"))
                    durTime += sl + "秒";
                else
                    durTime += sl;
            }
        }


        return durTime;
    }

    public static Date getFinallyDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        String fm = format.format(date);
        fm += " 23:59:59";
        try {
            return DateUtils.parseDate(fm, new String[] { "yyyyMMdd HH:mm:ss" });
        }
        catch (ParseException e1) {
            return null;
        }
    }

    public static Date getStartDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        String fm = format.format(date);
        fm += " 00:00:00";
        try {
            return DateUtils.parseDate(fm, new String[] { "yyyyMMdd HH:mm:ss" });
        }
        catch (ParseException e1) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getDate(getNowDate(),3));
    }
    /**
     *
     * @param date ForExample:"20121221"
     * @param pattern ForExample:"yyyyMMdd"
     * @return
     */
    public static Date dateStringToDate(String date, String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = null;
        try {
            today = df.parse(date);
        }catch (NullPointerException e){
            today = null;
        } catch (ParseException e) {
            today = null;
        }
        return today;
    }
    /**
     * 给指定的日期加上天数 如：2008-2-27;加上10天则返回：2008-3-8
     *
     * @param dDate
     * @param iNbDay
     * @return
     */
    public static Date addDay(Date dDate, long iNbDay) {
        return addHour(dDate, iNbDay * 24);
    }
    /**
     * 给指定的日期加上hour个小时.
     *
     * @param dDate
     *            指定的日期
     * @param hour
     *            几个小时
     * @return 返回加完小时之后 的日期
     */
    public static Date addHour(Date dDate, long hour) {
        return addSecond(dDate, hour * 60L * 60L);
    }

    /**
     * 给指定的日期加上second秒
     *
     * @param dDate
     * @param second
     * @return
     */
    public static Date addSecond(Date dDate, long second) {

        long datems = dDate.getTime();
        long secondms = second * 1000L;
        long newDateMs = datems + secondms;
        Date result = new Date(newDateMs);
        return result;

    }
}

