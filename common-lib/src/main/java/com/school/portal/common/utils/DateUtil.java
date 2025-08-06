package com.school.portal.common.utils;

import jakarta.annotation.Nonnull;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtil {

  public static final String ZONE_ID = "UTC";

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private DateUtil() {}

  public static ZonedDateTime parseDateString(@Nonnull String dateString) {
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return ZonedDateTime.of(localDate.atStartOfDay(), ZoneId.of(ZONE_ID));
  }

  public static ZonedDateTime addDays(@Nonnull String dateString, long days) {
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return ZonedDateTime.of(localDate.atStartOfDay(), ZoneId.of(ZONE_ID)).plusDays(days);
  }

  public static String addDaysToday(long days) {
    return zoneDateString(addDays(days));
  }

  public static ZonedDateTime addDays(long days) {
    LocalDate localDate = LocalDate.now(ZoneId.of(ZONE_ID));
    return ZonedDateTime.of(localDate.atStartOfDay(), ZoneId.of(ZONE_ID)).plusDays(days);
  }

  public static String zoneDateString(@Nonnull ZonedDateTime zoneDateTime) {
    return formatter.format(zoneDateTime);
  }

  public static String zoneDateTimeString(@Nonnull ZonedDateTime zoneDateTime) {
    return zoneDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
  }

  public static String offsetDateTimeString(@Nonnull ZonedDateTime zoneDateTime) {
    return zoneDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  public static ZonedDateTime getUTCZonedDate() {
    LocalDate now = LocalDate.now(ZoneId.of(ZONE_ID));
    return ZonedDateTime.of(now.atStartOfDay(), ZoneId.of(ZONE_ID));
  }

  public static ZonedDateTime getUTCZonedEndDate() {
    return getSpecifiedZonedEndDate(ZONE_ID);
  }

  public static ZonedDateTime getSpecifiedZonedEndDate(String zoneId) {
    LocalDate now = LocalDate.now(ZoneId.of(zoneId));
    return ZonedDateTime.of(now, LocalTime.MAX, ZoneId.of(zoneId)).truncatedTo(ChronoUnit.MICROS);
  }

  public static ZonedDateTime getUTCZonedDateAddYears(int years) {
    LocalDate now = LocalDate.now();
    return ZonedDateTime.of(now.plusYears(years).atStartOfDay(), ZoneId.of(ZONE_ID));
  }

  public static ZonedDateTime getUTCZonedDateTime() {
    return ZonedDateTime.now(ZoneId.of(ZONE_ID));
  }

  public static boolean isEqualOrAfterToday(ZonedDateTime date) {

    if (null == date) {
      return false;
    }

    var utcZonedDateToday = getUTCZonedDate();
    return date.isEqual(utcZonedDateToday) || date.isAfter(utcZonedDateToday);
  }

  public static boolean isEqualOrBeforeToday(ZonedDateTime date) {

    if (null == date) {
      return false;
    }

    ZonedDateTime today = DateUtil.getUTCZonedDate();
    return !date.isAfter(today);
  }

  public static boolean isEqualOrAfter(ZonedDateTime expected, ZonedDateTime actual) {
    return actual.isEqual(expected) || actual.isAfter(expected);
  }

  public static ZonedDateTime removeTime(ZonedDateTime dateTime) {
    return dateTime.toLocalDate().atStartOfDay(ZoneId.of(dateTime.getZone().getId()));
  }

  public static ZonedDateTime getStartOfYearZonedDateTime(int year) {
    return ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, ZoneId.of(ZONE_ID));
  }

  public static ZonedDateTime getEndOfYearZonedDateTime(int year) {
    return ZonedDateTime.of(year, 12, 31, 23, 59, 59, 999_999_000, ZoneId.of(ZONE_ID));
  }

  public static ZonedDateTime withMaxTime(ZonedDateTime zonedDateTime) {
    return zonedDateTime.with(LocalTime.MAX).truncatedTo(ChronoUnit.MICROS);
  }

  public static ZonedDateTime instantToZonedDateTime(Instant instant) {
    return instant.atZone(ZoneId.of(ZONE_ID));
  }
}
