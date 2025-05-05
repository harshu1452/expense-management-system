package turing.example.expensemanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import turing.example.expensemanagement.dto.ExpenseDTO;
import turing.example.expensemanagement.service.ExpenseService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
 class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Internal Server Error");
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}


@ExtendWith(MockitoExtension.class)
class ExpenseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ExpenseService expenseService;

    @InjectMocks
    private ExpenseController expenseController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(expenseController)
                .setControllerAdvice(new GlobalExceptionHandler()) // ✅ Ensure proper exception handling
                .build();
    }



    @Test
    void testGetAllExpenses_EmptyList() throws Exception {
        // Arrange
        when(expenseService.getAllExpenses()).thenReturn(Collections.emptyList());

        // ✅ Fix: Ensure response is an empty array []
        mockMvc.perform(get("/expenses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0)); // ✅ Fix: Use .size()

        verify(expenseService, times(1)).getAllExpenses();
    }

    @Test
    void testGetAllExpenses_InternalServerError() throws Exception {
        // Arrange
        when(expenseService.getAllExpenses()).thenThrow(new RuntimeException("Database error"));

        // ✅ Fix: Ensure proper exception handling in controller
        mockMvc.perform(get("/expenses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error").value("Internal Server Error")) // ✅ Ensuring proper error response format
                .andExpect(jsonPath("$.message").value("Database error"));

        verify(expenseService, times(1)).getAllExpenses();
    }
}


