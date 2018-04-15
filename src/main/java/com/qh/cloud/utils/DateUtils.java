package com.qh.cloud.utils;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;



/**
 * @ClassName: DateUtils
 * @Description: 有关日期的常用操作
 * @author yangfei
 * @date 2016年7月14日 下午2:13:04
 *
 */
public class DateUtils {
	public static String format = "yyyy-MM-dd HH:mm:ss";

	public static String format_day = "yyyy-MM-dd";

	public static String format_ms = "yyyy-MM-dd HH:mm:ss.S";

	public static String format_cn_ms = "yyyy年MM月dd日 HH时mm分ss秒";

	public static String format_cn_mm = "yyyy年MM月dd日 HH时mm分";

	public static String format_mm = "yyyy-MM-dd HH:mm";

	public static String format_yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public static String format_yyyyMMdd = "yyyyMMdd";

	public static String format_MMdd = "MM. dd";

	public static String format_HH_mm = "HH:mm";

	public static String format_javascript = "yyyy/MM/dd,HH:mm:ss";
	private final static Format dateFormat = new SimpleDateFormat("MMddHHmmssS");

    private final static NumberFormat numberFormat = new DecimalFormat("0000");
    private static int seq = 0;
    
    private static final int MAX = 9999;
    public static long getDaySub(Date startDate,Date endDate){
    	long start = startDate.getTime();
    	long end = endDate.getTime();
    	long result = (end - start) / (1000*3600*24);
    	return result;
    }
	/**
	 * 获取当前时间（以毫秒为单位的）
	 * @return Date 当前的时间
	 */
	public static Date getCurrentTime() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 将String类型的值转换成Date类型,格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @return Date类型的数值
	 * @param date
	 *            一个时间格式的字符串
	 */
	public static Date parseDateFromString(String date) {
		return parseDateFromString(date, format);
	}

	/**
	 * 将String类型的值转换成format格式的Date类型(format为自己定义的格式)
	 * 
	 * @param date
	 *            一个时间格式的字符串
	 * @param format
	 *            所需要的格式
	 */
	public static Date parseDateFromString(String date, String format) {
		return parseDateFromString(date, format, java.util.Locale.US);
	}

	/**
	 * 将String类型的值根据国家地区语言将值转换成format格式的Date类型(format为自己定义的格式)
	 * 
	 * @param date
	 *            一个时间格式的字符串
	 * @param format
	 *            自己定义的格式
	 * @param locale
	 *            所需转换成的国家地区语言
	 * @return format格式locale国家的Date类型
	 */
	public static Date parseDateFromString(String date, String format, Locale locale) {
		SimpleDateFormat fm = new SimpleDateFormat(format, locale);
		ParsePosition pos = new ParsePosition(0);
		return fm.parse(date, pos);
	}

	/**
	 * 将Date类型的值转换成yyyy-MM-dd HH:mm:ss格式的String类型
	 * 
	 * @return yyyy-MM-dd HH:mm:ss格式的String类型
	 * @param date
	 *            需要做转换的Date类型的数值
	 */
	public static String parseStringFromDate(Date date) {
		return parseStringFromDate(date, format);
	}
	/**
	 * 将Date类型的值转换成yyyy-MM-dd HH:mm:ss格式的String类型
	 * @author yangjunjie 
	 * @date 2016年9月18日
	 * @return yyyy-MM-dd HH:mm:ss格式的String类型
	 * @param date
	 *            需要做转换的Date类型的数值
	 */
	public static String getParseStringFromDate() {
		Date date = new Date();
		return parseStringFromDate(date, format);
	}
	/**
	 * 将Date类型的值转换成一定格式的String类型
	 * 
	 * @return format格式的String类型
	 * @param date
	 *            需要做转换的Date类型
	 * @param format
	 *            自己定义的格式
	 */
	public static String parseStringFromDate(Date date, String format) {
		return parseStringFromDate(date, format, java.util.Locale.US);
	}

	/**
	 * 将Date类型的值转换成一定格式的String类型而且国家地理语言敏感
	 * 
	 * @return format格式locale国家的String类型
	 * @param date
	 *            需要做转换的Date类型
	 * @param format
	 *            自己定义的格式
	 * @param locale
	 *            所需转换成的国家地区语言
	 */
	public static String parseStringFromDate(Date date, String format, Locale locale) {
		return parseStringFromDate(date, format, locale, null);
	}

	/**
	 * 将Date类型的值转换成一定格式的String类型而且国家地理语言敏感，带有时区偏移量
	 * 
	 * @param date
	 *            需要做转换的Date类型
	 * @param format
	 *            自己定义的格式
	 * @param locale
	 *            所需转换成的国家地区语言
	 * @param tz
	 *            需要算入的时区偏移量
	 */
	public static String parseStringFromDate(Date date, String format, Locale locale, TimeZone tz) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat fm = new SimpleDateFormat(format, locale);
		if (tz != null) {
			fm.setTimeZone(tz);
		}
		return fm.format(date);
	}

	/**
	 * 将所传入的数据组装成所需要的Date类型的数据
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param dayOfMonth
	 *            日
	 * @param hour
	 *            时
	 * @param minute
	 *            分
	 * @param second
	 *            秒
	 * @return Date类型的组装数据
	 */
	public static Date getDate(int year, int month, int dayOfMonth, int hour, int minute, int second) {
		return specificDate(year, month, dayOfMonth, hour, minute, second, 0, null);
	}

	/**
	 * 将所传入的数据组装成所需要的Date类型的数据（时区偏移量敏感）
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param dayOfMonth
	 *            日
	 * @param hour
	 *            时
	 * @param minute
	 *            分
	 * @param second
	 *            秒
	 * @param milliSecond
	 *            毫秒
	 * @param zone
	 *            时区偏移量
	 * @return Date类型的组装数据
	 */
	public static Date specificDate(int year, int month, int dayOfMonth, int hour, int minute, int second,
			int milliSecond, TimeZone zone) {
		Calendar c = (zone == null) ? Calendar.getInstance() : Calendar.getInstance(zone);
		if (year >= 0)
			c.set(Calendar.YEAR, year);
		if (month >= 0)
			c.set(Calendar.MONTH, month);
		if (dayOfMonth >= 0)
			c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		if (hour >= 0)
			c.set(Calendar.HOUR_OF_DAY, hour);
		if (minute >= 0)
			c.set(Calendar.MINUTE, minute);
		if (second >= 0)
			c.set(Calendar.SECOND, second);
		if (milliSecond >= 0)
			c.set(Calendar.MILLISECOND, milliSecond);
		return c.getTime();
	}

	/**
	 * 通过date取星期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekFromDate(Date date) {
		if (date == null) {
			return null;
		}
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;

		return dayNames[dayOfWeek];
	}

	/**
	 * 全局默认日期格式
	 */
	public static final String Format_Date = "yyyy-MM-dd";

	/**
	 * 全局默认时间格式
	 */
	public static final String Format_Time = "HH:mm:ss";

	/**
	 * 全局默认日期时间格式
	 */
	public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 得到以yyyy-MM-dd格式表示的当前日期字符串
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat(Format_Date).format(new Date());
	}

	/**
	 * 得到以format格式表示的当前日期字符串
	 */
	public static String getCurrentDate(String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(new Date());
	}

	/**
	 * 得到以format格式表示的当前时间字符串
	 */
	public static String getCurrentTime(String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(new Date());
	}

	/**
	 * 得到以yyyy-MM-dd HH:mm:ss表示的当前时间字符串
	 */
	public static String getCurrentDateTime() {
		String format = format_day + " " + Format_Time;
		return getCurrentDateTime(format);
	}

	/**
	 * 今天是星期几
	 * 
	 * @return
	 */
	public static int getDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 指定日期是星期几
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 今天是本月的第几天
	 * 
	 * @return
	 */
	public static int getDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 指定日期是当月的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取某一个月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getMaxDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 以yyyy-MM-dd格式获取某月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat(Format_Date).format(cal.getTime());
	}

	/**
	 * 今天是本年的第几天
	 * 
	 * @return
	 */
	public static int getDayOfYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 指定日期是当年的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 以yyyy-MM-dd解析字符串date，并返回其表示的日期是周几
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 以yyyy-MM-dd解析字符串date，并返回其表示的日期是当月第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 以yyyy-MM-dd解析字符串date，并返回其表示的日期是当年第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 以指定的格式返回当前日期时间的字符串
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentDateTime(String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(new Date());
	}

	/**
	 * 以yyyy-MM-dd格式输出只带日期的字符串
	 */
	public static String toString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(Format_Date).format(date);
	}

	/**
	 * 以yyyy-MM-dd HH:mm:ss输出带有日期和时间的字符串
	 */
	public static String toDateTimeString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(Format_DateTime).format(date);
	}
	
	/**
	 * 以HH:mm:ss输出带有日期和时间的字符串
	 */
	public static String toDayTimeString(Date date) {
		if (date == null){
			return "";
		}
		return new SimpleDateFormat(Format_Time).format(date);
	}
	/**
	 * 按指定的format输出日期字符串
	 */
	public static String toString(Date date, String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(date);
	}

	/**
	 * 以HH:mm:ss输出只带时间的字符串
	 */
	public static String toTimeString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(Format_Time).format(date);
	}

	/**
	 * 以yyyy-MM-dd解析两个字符串，并比较得到的两个日期的大小
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare(String date1, String date2) {
		return compare(date1, date2, Format_Date);
	}

	/**
	 * 以HH:mm:ss解析两个字符串，并比较得到的两个时间的大小
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static int compareTime(String time1, String time2) {
		return compareTime(time1, time2, Format_Time);
	}

	/**
	 * 以指定格式解析两个字符串，并比较得到的两个日期的大小
	 * 
	 * @param date1
	 * @param date2
	 * @param format
	 * @return
	 */
	public static int compare(String date1, String date2, String format) {
		Date d1 = parse(date1, format);
		Date d2 = parse(date2, format);
		return d1.compareTo(d2);
	}

	/**
	 * 以指定解析两个字符串，并比较得到的两个时间的大小
	 * 
	 * @param time1
	 * @param time2
	 * @param format
	 * @return
	 */
	public static int compareTime(String time1, String time2, String format) {
		String[] arr1 = time1.split(":");
		String[] arr2 = time2.split(":");
		if (arr1.length < 2) {
			throw new RuntimeException("错误的时间值:" + time1);
		}
		if (arr2.length < 2) {
			throw new RuntimeException("错误的时间值:" + time2);
		}
		int h1 = Integer.parseInt(arr1[0]);
		int m1 = Integer.parseInt(arr1[1]);
		int h2 = Integer.parseInt(arr2[0]);
		int m2 = Integer.parseInt(arr2[1]);
		int s1 = 0, s2 = 0;
		if (arr1.length == 3) {
			s1 = Integer.parseInt(arr1[2]);
		}
		if (arr2.length == 3) {
			s2 = Integer.parseInt(arr2[2]);
		}
		if (h1 < 0 || h1 > 23 || m1 < 0 || m1 > 59 || s1 < 0 || s1 > 59) {
			throw new RuntimeException("错误的时间值:" + time1);
		}
		if (h2 < 0 || h2 > 23 || m2 < 0 || m2 > 59 || s2 < 0 || s2 > 59) {
			throw new RuntimeException("错误的时间值:" + time2);
		}
		if (h1 != h2) {
			return h1 > h2 ? 1 : -1;
		} else {
			if (m1 == m2) {
				if (s1 == s2) {
					return 0;
				} else {
					return s1 > s2 ? 1 : -1;
				}
			} else {
				return m1 > m2 ? 1 : -1;
			}
		}
	}

	/**
	 * 判断指定的字符串是否符合HH:mm:ss格式，并判断其数值是否在正常范围
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isTime(String time) {
		String[] arr = time.split(":");
		if (arr.length < 2) {
			return false;
		}
		try {
			int h = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			int s = 0;
			if (arr.length == 3) {
				s = Integer.parseInt(arr[2]);
			}
			if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 判断指定的字符串是否符合yyyy:MM:ss格式，但判断其数据值范围是否正常
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date) {
		String[] arr = date.split("-");
		if (arr.length < 3) {
			return false;
		}
		try {
			int y = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			int d = Integer.parseInt(arr[2]);
			if (y < 0 || m > 12 || m < 0 || d < 0 || d > 31) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否是日期或者带时间的日期，日期必须符合格式yy-MM-dd或yy-MM-dd HH:mm:ss
	 */
	public static boolean isDateTime(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		if (str.indexOf(" ") > 0) {
			String[] arr = str.split(" ");
			if (arr.length == 2) {
				return isDate(arr[0]) && isTime(arr[1]);
			} else {
				return false;
			}
		} else {
			return isDate(str);
		}
	}

	/**
	 * 判断指定日期是否是周末
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isWeekend(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int t = cal.get(Calendar.DAY_OF_WEEK);
		if (t == Calendar.SATURDAY || t == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}

	/**
	 * 以yyyy-MM-dd解析指定字符串，并判断相应的日期是否是周末
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isWeekend(String str) {
		return isWeekend(parse(str));
	}

	/**
	 * 以yyyy-MM-dd解析指定字符串，返回相应java.util.Date对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date parse(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			return new SimpleDateFormat(Format_Date).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 按指定格式解析字符串，并返回相应的java.util.Date对象
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date parse(String str, String format) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			SimpleDateFormat t = new SimpleDateFormat(format);
			return t.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 以yyyy-MM-dd HH:mm:ss格式解析字符串，并返回相应的java.util.Date对象
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseDateTime(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		if (str.length() <= 10) {
			return parse(str);
		}
		try {
			return new SimpleDateFormat(Format_DateTime).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 以指定格式解析字符串，并返回相应的java.util.Date对象
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date parseDateTime(String str, String format) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			SimpleDateFormat t = new SimpleDateFormat(format);
			return t.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 日期date上加count分钟，count为负表示减
	 */
	public static Date addMinute(Date date, int count) {
		return new Date(date.getTime() + 60000L * count);
	}

	/**
	 * 日期date上加count小时，count为负表示减
	 */
	public static Date addHour(Date date, int count) {
		return new Date(date.getTime() + 3600000L * count);
	}

	/**
	 * 日期date上加count天，count为负表示减
	 */
	public static Date addDay(Date date, int count) {
		return new Date(date.getTime() + 86400000L * count);
	}

	/**
	 * 日期date上加count星期，count为负表示减
	 */
	public static Date addWeek(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.WEEK_OF_YEAR, count);
		return c.getTime();
	}

	/**
	 * 日期date上加count月，count为负表示减
	 */
	public static Date addMonth(Date date, int count) {
		/* ${_ZVING_LICENSE_CODE_} */

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, count);
		return c.getTime();
	}

	/**
	 * 日期date上加count年，count为负表示减
	 */
	public static Date addYear(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, count);
		return c.getTime();
	}

	/**
	 * 人性化显示时间日期,date格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String toDisplayDateTime(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		try {
			if (isDate(date)) {
				return toDisplayDateTime(parse(date));
			} else {
				SimpleDateFormat t = new SimpleDateFormat(Format_DateTime);
				Date d = t.parse(date);
				return toDisplayDateTime(d);
			}

		} catch (ParseException e) {
			e.printStackTrace();
			return "不是标准格式时间!";
		}
	}

	/**
	 * 人性化显示时间日期
	 * 
	 * @param date
	 * @return
	 */
	public static String toDisplayDateTime(Date date) {
		long minite = (System.currentTimeMillis() - date.getTime()) / 60000L;
		if (minite < 60) {
			return toString(date, "MM-dd") + " " + minite + "分钟前";
		}
		if (minite < 60 * 24) {
			return toString(date, "MM-dd") + " " + minite / 60L + "小时前";
		} else {
			return toString(date, "MM-dd") + " " + minite / 1440L + "天前";
		}
	}

	static private String formatArr[] = { "second", "minute", "hour", "day" };

	static private long calculateArr[] = { 1000, 1000 * 60, 1000 * 60 * 60, 1000 * 60 * 60 * 24 };

	static public String dateFormatYYYYMMDD = "yyyy-MM-dd";

	static public String dateFormatYYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	static public String dateFormatHHMMSS = "HH:mm:ss";

	static public String dateFormatHHMMSS_CH = "HH时mm分ss秒";

	/**
	 * 2007-07-13 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 2007-07-13 日期相加(按毫秒)
	 * 
	 * @param date
	 *            日期
	 * @param millis
	 *            毫秒
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDate(java.util.Date date, long millis) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + millis);
		return c.getTime();
	}

	/**
	 * 2007-10-09 日期相加(按秒或分钟或小时或天)
	 * 
	 * @param date
	 *            日期
	 * @param oneInAthousand
	 *            值
	 * 
	 * @param format
	 *            转换格式 "second" "minute" "hour" "day"
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDate(java.util.Date date, long oneInAthousand, String format) {
		long result = oneInAthousand;
		if (format == null)
			format = "";

		for (int i = 0; i < formatArr.length; i++) {
			if (formatArr[i].equals(format)) {
				result = oneInAthousand * calculateArr[i];
			}
		}

		return addDate(date, result);
	}

	/**
	 * 2007-09-24 按月份日期相加
	 * 
	 * @param date
	 *            日期
	 * @param months
	 *            月份(正整数代表 当前日期之后的日期 负整数代表 当前日期之前的日期
	 * 
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDateByMonth(java.util.Date date, int months) {
		Date ret = null;
		try {
			GregorianCalendar grc = new GregorianCalendar();
			grc.setTime(date);
			grc.add(Calendar.MONTH, months);
			ret = grc.getTime();
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * 2007-07-13 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期按毫秒
	 */
	public static long diffDate(java.util.Date date, java.util.Date date1) {
		long ret = 0;
		long date_long = 0;
		long date1_long = 0;
		if (date != null) {
			date_long = getMillis(date);
		}
		if (date1 != null) {
			date1_long = getMillis(date1);
		}
		ret = date_long - date1_long;
		return ret;
	}

	/**
	 * 2007-07-13 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @param format
	 *            转换格式 "second" "minute" "hour" "day"
	 * @return 返回相减后的日期
	 */
	public static long diffDate(java.util.Date date, java.util.Date date1, String format) {
		long ret = 0;
		long diffDate_long = diffDate(date, date1);
		for (int i = 0; i < formatArr.length; i++) {
			if (formatArr[i].equals(format)) {
				ret = diffDate_long / calculateArr[i];
			}
		}
		return ret;

	}

	/**
	 * 2007-07-19 将千分秒转换成 秒 分钟 小时 天数 oneInAthousand千分秒
	 * 
	 * @param oneInAthousand
	 *            值
	 * 
	 * @param format
	 *            转换格式 "second" "minute" "hour" "day"
	 * @return 成功返回 转换后的值 失败返回 oneInAthousand的值
	 * 
	 */
	public static long oneInAthousandConvert(long oneInAthousand, String format) {
		long ret = oneInAthousand;
		if (format == null)
			format = "";
		String formatArr[] = { "second", "minute", "hour", "day" };
		long calculateArr[] = { 1000, 1000 * 60, 1000 * 60 * 60, 1000 * 60 * 60 * 24 };
		for (int i = 0; i < formatArr.length; i++) {
			if (formatArr[i].equals(format)) {
				ret = oneInAthousand / calculateArr[i];
			}
		}

		return ret;
	}

	/**
	 * 2007-07-13 日期格式化函数
	 * 
	 * @param date
	 *            日期
	 * @param format日期格式
	 * @return 成功返回格式化后的字符串 失败返回""
	 */
	public static String getDateTimeString(java.util.Date date, String format) {
		return format(date, format);
	}

	/**
	 * 2007-07-13 日期格式化函数
	 * 
	 * @param date
	 *            日期
	 * @param format日期格式
	 * @return 成功返回格式化后的字符串 失败返回""
	 */
	public static String format(java.util.Date date, String format) {
		return format(date, format, null);
	}

	/**
	 * 2007-07-13 日期格式化函数
	 * 
	 * @param date
	 *            日期
	 * @param format日期格式
	 * @param calendar
	 *            日历对象
	 * @return 成功返回格式化后的字符串 失败返回""
	 */
	public static String format(java.util.Date date, String format, Calendar calendar) {
		String result = "";
		try {
			if (date != null) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
				if (calendar != null) {
					sdf.setCalendar(calendar);
				}
				result = sdf.format(date);
			}
		} catch (Exception e) {
		}

		return result;
	}

	/**
	 * 2007-07-13 日期格式化函数
	 * 
	 * @param date_str
	 *            日期字符串
	 * 
	 * @param format日期格式
	 * @return 成功返回格式化后的字符串 失败返回""
	 */
	public static String format(String date_str, String format) {
		String ret = null;
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
			Date date = sdf.parse(date_str);
			ret = format(date, format);
		} catch (Exception e) {
		}
		return ret;
	}

	/**
	 * 2007-07-13 日期格式化函数
	 * 
	 * @param date_str
	 *            日期字符串
	 * 
	 * @param format日期格式
	 * @param calendar
	 *            日历对象
	 * @return 成功返回格式化后的字符串 失败返回""
	 */
	public static String format(String date_str, String format, Calendar calendar) {
		String ret = null;
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
			Date date = sdf.parse(date_str);
			ret = format(date, format, calendar);
		} catch (Exception e) {
		}
		return ret;

	}

	/**
	 * 2007-08-02 将字符串转换成日期
	 * 
	 * @dateformat 日期格式 如 'yyyy-MM-dd HH:mm:ss:SSSS'
	 * @datestr 日期字符串 如'2007-08-02 14:51:00'
	 */
	public static Date convertStrToDate(String dateformat, String datestr) {
		Date date = null;
		if (datestr == null || datestr.equals("")) {
			return date;
		}

		SimpleDateFormat myFmt = new SimpleDateFormat(dateformat);
		try {
			date = myFmt.parse(datestr);
		} catch (Exception e) {
			// e.printStackTrace();

		}
		return date;
	}

	/**
	 * 2007-08-02 将字符串转换成日期
	 * 
	 * @datestr 日期字符串 如'2007-08-02 14:51:00'
	 */
	public static Date convertStrToDate(String datestr) {
		Date date = null;

		date = convertStrToDate(dateFormatYYYYMMDDHHMMSS, datestr);
		if (date == null) {
			date = convertStrToDate(dateFormatYYYYMMDD, datestr);
		}
		return date;
	}

	/**
	 * 是否是日期类
	 * 
	 * @param classSinstance
	 *            类实例
	 */
	public static boolean isDateClass(Class classSinstance) {
		boolean ret = false;
		if (classSinstance != null) {
			if (classSinstance == java.sql.Timestamp.class)
				ret = true;
			else if (classSinstance == java.sql.Date.class)
				ret = true;
			else if (classSinstance == java.util.Date.class)
				ret = true;
		}
		return ret;
	}

	/**
	 * 判断值是否为日期或时间类型
	 * 
	 * @param dateValue
	 *            日期值可以是日期相关类型 或 字符串类型
	 * @param dateFormat
	 *            日期格式(当dateValue为字符串类型必须设置此值)
	 */
	public static boolean isDateOrTimeValue(Object dateValue, String dateFormat) {
		boolean ret = true;
		if (dateValue != null) {
			ret = false;
		} else if (isDateClass(dateValue.getClass())) {
			ret = true;
		} else if (dateValue.getClass() == String.class) {
			try {
				java.text.DateFormat f = new java.text.SimpleDateFormat(dateFormat);
				java.text.ParsePosition pp = new java.text.ParsePosition(0);

				f.setLenient(false);
				Date datevalue = f.parse(dateValue.toString(), pp);
				int endIndex = pp.getIndex();
				if (endIndex < ((String) dateValue).length())
					ret = false;
				if (datevalue == null)
					ret = false;

			} catch (Exception e) {

			}
		}
		return ret;
	}

	/**
	 * 判断值是否为日期时间类型
	 * 
	 * @param dateValue
	 *            日期值可以是日期相关类型 或 字符串类型
	 */
	public static boolean isDateTimeValue(Object dateValue) {
		return isDateOrTimeValue(dateValue, dateFormatYYYYMMDDHHMMSS);
	}

	/**
	 * 判断值是否为日期类型
	 * 
	 * @param dateValue
	 *            日期值可以是日期相关类型 或 字符串类型
	 */
	public static boolean isDateValue(Object dateValue) {
		return isDateOrTimeValue(dateValue, dateFormatYYYYMMDD);
	}

	/**
	 * 判断值是否为时间类型
	 * 
	 * @param dateValue
	 *            日期值可以是日期相关类型 或 字符串类型
	 */
	public static boolean isTimeValue(Object dateValue) {
		return isDateOrTimeValue(dateValue, dateFormatHHMMSS);
	}

	/**
	 * 时间相减
	 * 
	 * @param date1
	 *            被减数 日期格式字符串
	 * @param date2
	 *            减数 日期格式字符串
	 * @return xx天 xx小时xx分xx秒 eg. “2012-07-22 03:04:05” - "2012-07-21 01:01:01"
	 *         = “1天2小时3分钟4秒”
	 */
	public static String subtractDate(String date1, String date2) {
		Date _date1 = null;
		Date _date2 = null;
		StringBuffer sb = new StringBuffer();
		try {
			_date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1);
			_date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long milliseconds = _date1.getTime() - _date2.getTime();
		long day = milliseconds / (60 * 60 * 24 * 1000);
		long hour = milliseconds % (60 * 60 * 24 * 1000) / (60 * 60 * 1000);
		long minute = milliseconds % (60 * 60 * 24 * 1000) % (60 * 60 * 1000) / (60 * 1000);
		long second = milliseconds % (60 * 60 * 24 * 1000) % (60 * 60 * 1000) % (60 * 1000) / 1000;
		if (day > 0)
			sb.append(day).append("天");
		if (hour > 0)
			sb.append(hour).append("小时");
		if (minute > 0)
			sb.append(minute).append("分钟");
		if (second > 0)
			sb.append(second).append("秒");
		return sb.toString();
	}

	public static String lastDaoOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));// 设置为1号,当前日期既为本月第一天
		String lastDay = format.format(cale.getTime());
		return lastDay;
	}

	// 将时间戳转换成 Date类型
	public static Date getTime(String minter) {
		long min;
		min = Long.parseLong(minter);
		Date date = new Date(min);
		return date;
	}
	public static int getAge(Date dateOfBirth) {
    	int age = 0;
    	Calendar born = Calendar.getInstance();
    	Calendar now = Calendar.getInstance();
    	if (dateOfBirth != null) {
    	now.setTime(new Date());
    	born.setTime(dateOfBirth);
    	if (born.after(now)) {
    	throw new IllegalArgumentException(
    	"Can't be born in the future");
    	}
    	age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
    	if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
    	age -= 1;
    	}
    	}
    	return age;
    }
	private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
	 public static synchronized String generateSequenceNo(){
	    	Calendar now = Calendar.getInstance();
	    	StringBuffer sb = new StringBuffer();
	    	dateFormat.format(now.getTime(), sb, HELPER_POSITION);
	    	numberFormat.format(seq, sb, HELPER_POSITION);
	        if (seq == MAX) {
	            seq = 0;
	        } else {
	            seq++;
	        }
	        return sb.toString();
	    }
	 
	 public static Date getYearLast(int year){  
		 Calendar calendar = Calendar.getInstance();  
	        calendar.clear(); 
	        calendar.set(Calendar.YEAR, year);  
	        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
	        calendar.roll(Calendar.SECOND, -1);
	        calendar.roll(Calendar.MINUTE, -1);
	        calendar.roll(Calendar.HOUR_OF_DAY, -1);
	        Date currYearLast = calendar.getTime();  
	        return currYearLast;  
	    }  
	 public static Date getMonthLast(int year,int month){  
		 Calendar calendar = Calendar.getInstance();  
		 calendar.clear(); 
		 calendar.set(Calendar.YEAR, year);
		 calendar.set(Calendar.MONTH, month);
		 calendar.roll(Calendar.DAY_OF_MONTH, -1);
		 calendar.roll(Calendar.SECOND, -1);
		 calendar.roll(Calendar.MINUTE, -1);
		 calendar.roll(Calendar.HOUR_OF_DAY, -1);
		 Date currYearLast = calendar.getTime();  
		 return currYearLast;  
	 }  
	 public static Date getCurrYearLast()
	 {  
	        Calendar currCal=Calendar.getInstance();    
	        int currentYear = currCal.get(Calendar.YEAR);  
	        return getYearLast(currentYear);  
	 }

	 public static Date getCurrMonLast()
	 {  
		 Calendar currCal=Calendar.getInstance();    
		 int currentYear = currCal.get(Calendar.YEAR);  
		 int currentMonth = currCal.get(Calendar.MONTH); 
		 return getMonthLast(currentYear,currentMonth);  
	 }  
	/**
	 * 计算两个日期之间的相隔天数
	 * @param first
	 * @param second
	 * @return
	 */
	public static int longOfTwoDate(Date first, Date second) {
		Calendar cal = Calendar.getInstance();  
        cal.setTime(first);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(second);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
          
       return Integer.parseInt(String.valueOf(between_days));    
	}
	 
	 public static Date getCurrYearFirstDay(Date date)
	 {
		 Calendar calendar = Calendar.getInstance();  
		 calendar.clear(); 
		 calendar.setTime(date);
		 calendar.set(Calendar.MONTH, 0);
		 calendar.set(Calendar.DAY_OF_MONTH, 1);
		 return calendar.getTime();
	 }
	 
}
