package turing.example.expensemanagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format: " + DATE_FORMAT);
        }
    }
}
