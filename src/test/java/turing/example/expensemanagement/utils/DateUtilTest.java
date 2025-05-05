package turing.example.expensemanagement.utils;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void testFormatDate_ValidDate_ReturnsFormattedString() {
        LocalDate date = LocalDate.of(2025, 3, 14);
        String expected = "2025-03-14";
        String actual = DateUtil.formatDate(date);
        assert actual != null;
        assertEquals(expected, actual);
    }

    @Test
    void testFormatDate_NullInput() {
        assertNull(DateUtil.formatDate(null));
    }

    @Test
    void testParseDate_ValidFormat() {
        String dateString = "2025-03-14";
        LocalDate expected = LocalDate.of(2025, 3, 14);
        LocalDate actual = DateUtil.parseDate(dateString);
        assertEquals(expected, actual);
    }

    @Test
    void testParseDate_InvalidFormat() {
        String invalidDate = "14-03-2025"; // Wrong format

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateUtil.parseDate(invalidDate);
        });

        String expectedMessage = "Invalid date format. Expected format: yyyy-MM-dd";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
