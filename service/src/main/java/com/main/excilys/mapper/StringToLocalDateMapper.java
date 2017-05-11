package com.main.excilys.mapper;

import com.main.excilys.util.ComputerDbException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToLocalDateMapper {
  private static final DateTimeFormatter formatter = DateTimeFormatter
      .ofPattern("[dd-MM-yyyy]" + "[yyyy-MM-dd]");

  /**
   * convert a string to a local date.
   *
   * @param strDate
   *          the string to convert. Must match [dd-MM-yyyy] or [yyyy-MM-dd]
   * @return the converted string to localdate
   */
  public static LocalDate strToLocalDateMapper(String strDate) {
    try {
      return strDate != null && !strDate.isEmpty() ? LocalDate.parse(strDate, formatter) : null;
    } catch (DateTimeParseException e) {
      throw new ComputerDbException("The date : " + strDate + " is invalid");
    }
  }

  /**
   * Convert a date to a string.
   *
   * @param date
   *          the date to convert
   * @return the date converted on string or null
   */
  public static String localDateToStringMapper(LocalDate date) {
    return date != null ? date.toString() : null;
  }

}
