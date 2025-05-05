package turing.example.expensemanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import turing.example.expensemanagement.dto.ExpenseDTO;
import turing.example.expensemanagement.entity.Expense;
import turing.example.expensemanagement.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class ExpenseServiceTest {

    @InjectMocks
    private ExpenseService expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    @org.junit.jupiter.api.Test
    void testGetAllExpenses() {
        // Arrange
        Expense expense1 = new Expense(1L, "Laptop", 1200.00, LocalDate.of(2024, 3, 10));
        Expense expense2 = new Expense(2L, "Office Supplies", 200.50, LocalDate.of(2024, 3, 11));

        when(expenseRepository.findAll()).thenReturn(Arrays.asList(expense1, expense2));

        // Act
        var result = expenseService.getAllExpenses();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Office Supplies", result.get(1).getDescription());
        assertEquals(1200.00, result.get(0).getAmount());

        verify(expenseRepository, times(1)).findAll();
    }
}
