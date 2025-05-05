package turing.example.expensemanagement.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {

    public static boolean isValidAmount(Double amount) {
        return amount != null && amount > 0;
    }

    public static boolean isValidString(String value) {
        return StringUtils.isNotBlank(value);
    }

    public static void validateExpense(String description, Double amount) {
        if (!isValidString(description)) {
            throw new IllegalArgumentException("Expense description cannot be empty.");
        }
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Expense amount must be greater than zero.");
        }
    }

    public static void validateApprovalStatus(String status) {
        if (!isValidString(status)) {
            throw new IllegalArgumentException("Approval status cannot be empty.");
        }
        if (!status.equalsIgnoreCase("APPROVED") && !status.equalsIgnoreCase("REJECTED")) {
            throw new IllegalArgumentException("Invalid approval status. Must be APPROVED or REJECTED.");
        }
    }
}
