package com.robert.myschool.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/21
 */
public class DateUtil {

  private final static String YYYYMMDD1 = "yyyy-MM-dd";
  private final static String YYYYMMDD2 = "yyyy年MM月dd日";
  private final static String YYYYMMDDHHMMSS1 = "yyyy-MM-dd HH:mm:ss";

  public static String formatYYYYMMDD(LocalDateTime localDateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDD1);
    String formattedDateTime = localDateTime.format(formatter);
    return formattedDateTime;
  }

  public static LocalDateTime parseYYYYMMDD(String dateStr) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS1);
    return LocalDateTime.parse(dateStr, formatter);
  }

}
