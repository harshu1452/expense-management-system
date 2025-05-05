package turing.example.expensemanagement.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDTOTest {

    @Test
    void testExpenseDTOBuilderAndGetters() {
        // Arrange
        LocalDate date = LocalDate.of(2025, 3, 14);
        ExpenseDTO expense = ExpenseDTO.builder()
                .id(1L)
                .description("Laptop Purchase")
                .amount(1500.00)
                .date(date)
                .build();

        // Act & Assert
        assertNotNull(expense);
        assertEquals(1L, expense.getId());
        assertEquals("Laptop Purchase", expense.getDescription());
        assertEquals(1500.00, expense.getAmount());
        assertEquals(date, expense.getDate());
    }

    @Test
    void testExpenseDTOSetters() {
        // Arrange
        ExpenseDTO expense = new ExpenseDTO();
        LocalDate date = LocalDate.of(2025, 3, 14);

        // Act
        expense.setId(2L);
        expense.setDescription("Flight Ticket");
        expense.setAmount(500.00);
        expense.setDate(date);

        // Assert
        assertEquals(2L, expense.getId());
        assertEquals("Flight Ticket", expense.getDescription());
        assertEquals(500.00, expense.getAmount());
        assertEquals(date, expense.getDate());
    }

    @Test
    void testExpenseDTOEqualsAndHashCode() {
        // Arrange
        LocalDate date = LocalDate.of(2025, 3, 14);
        ExpenseDTO expense1 = ExpenseDTO.builder().id(1L).description("Laptop").amount(1500.00).date(date).build();
        ExpenseDTO expense2 = ExpenseDTO.builder().id(1L).description("Laptop").amount(1500.00).date(date).build();

        // Act & Assert
        assertEquals(expense1, expense2);
        assertEquals(expense1.hashCode(), expense2.hashCode());
    }

    @Test
    void testExpenseDTONotEquals() {
        // Arrange
        ExpenseDTO expense1 = ExpenseDTO.builder().id(1L).description("Laptop").amount(1500.00).date(LocalDate.of(2025, 3, 14)).build();
        ExpenseDTO expense2 = ExpenseDTO.builder().id(2L).description("Flight Ticket").amount(500.00).date(LocalDate.of(2025, 3, 15)).build();

        // Act & Assert
        assertNotEquals(expense1, expense2);
    }

    @Test
    void testExpenseDTOToString() {
        // Arrange
        LocalDate date = LocalDate.of(2025, 3, 14);
        ExpenseDTO expense = ExpenseDTO.builder()
                .id(1L)
                .description("Laptop")
                .amount(1500.00)
                .date(date)
                .build();

        // Act
        String toStringOutput = expense.toString();

        // Assert
        assertNotNull(toStringOutput);
        assertTrue(toStringOutput.contains("id=1"));
        assertTrue(toStringOutput.contains("description=Laptop"));
        assertTrue(toStringOutput.contains("amount=1500.0")); // Ensure correct formatting
        assertTrue(toStringOutput.contains("date=2025-03-14"));
    }
}