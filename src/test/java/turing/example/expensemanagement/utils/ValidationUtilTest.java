package turing.example.expensemanagement.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void testIsValidString_ValidInput() {
        assertTrue(ValidationUtil.isValidString("Valid Input"));
    }

    @Test
    void testIsValidString_NullInput() {
        assertFalse(ValidationUtil.isValidString(null));
    }

    @Test
    void testIsValidString_EmptyString() {
        assertFalse(ValidationUtil.isValidString(""));
    }

    @Test
    void testIsValidString_SpacesOnly() {
        assertFalse(ValidationUtil.isValidString("   "));
    }

    @Test
    void testIsValidAmount_ValidAmount() {
        assertTrue(ValidationUtil.isValidAmount(100.50));
    }

    @Test
    void testIsValidAmount_Zero() {
        assertFalse(ValidationUtil.isValidAmount(0.0));
    }

    @Test
    void testIsValidAmount_NegativeValue() {
        assertFalse(ValidationUtil.isValidAmount(-10.0));
    }

    @Test
    void testIsValidAmount_Null() {
        assertFalse(ValidationUtil.isValidAmount(null));
    }

    @Test
    void testValidateExpense_ValidInput() {
        assertDoesNotThrow(() -> ValidationUtil.validateExpense("Lunch", 50.0));
    }

    @Test
    void testValidateExpense_InvalidAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                ValidationUtil.validateExpense("Valid Description", -5.0));
        assertEquals("Expense amount must be greater than zero.", exception.getMessage());
    }

    @Test
    void testValidateExpense_InvalidDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidationUtil.validateExpense("", 10.0));
        assertEquals("Expense description cannot be empty.", exception.getMessage());
    }

    @Test
    void testValidateExpense_NullDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidationUtil.validateExpense(null, 10.0));
        assertEquals("Expense description cannot be empty.", exception.getMessage());
    }

    @Test
    void testValidateExpense_NullAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidationUtil.validateExpense("Valid Description", null));
        assertEquals("Expense amount must be greater than zero.", exception.getMessage());
    }
}
