package turing.example.expensemanagement.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {

    @Test
    void testNoArgsConstructorAndSetters() {
        // Create an instance using the no-args constructor
        Expense expense = new Expense();

        // Set properties via setters
        expense.setId(1L);
        expense.setDescription("Office Laptop");
        expense.setAmount(1500.00);
        expense.setDate(LocalDate.of(2024, 3, 10));

        // Verify that getters return the expected values
        assertEquals(1L, expense.getId());
        assertEquals("Office Laptop", expense.getDescription());
        assertEquals(1500.00, expense.getAmount());
        assertEquals(LocalDate.of(2024, 3, 10), expense.getDate());

        // Call toString() to cover that method (inherited from Object)
        assertNotNull(expense.toString());
    }

    @Test
    void testAllArgsConstructor() {
        // Create an instance using the all-args constructor
        Expense expense = new Expense(2L, "Flight Ticket", 500.00, LocalDate.of(2024, 3, 12));

        // Verify that the values passed to the constructor are returned
        assertEquals(2L, expense.getId());
        assertEquals("Flight Ticket", expense.getDescription());
        assertEquals(500.00, expense.getAmount());
        assertEquals(LocalDate.of(2024, 3, 12), expense.getDate());
    }
}
