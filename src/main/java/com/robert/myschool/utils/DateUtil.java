package com.robert.myschool.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

  public static LocalDate parseYYYYMMDD2(String dateStr) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDD1);
    return LocalDate.parse(dateStr, formatter);
  }

  public static String formatYYYYMMDD2(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDD1);
    LocalDate localDate =  LocalDate.parse("2020-06-01", formatter);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.parse("00:00:00"));
    return localDateTime.format(dtf);
  }

  public static void main(String[] args) {
    System.out.println(formatYYYYMMDD2());
  }

}
