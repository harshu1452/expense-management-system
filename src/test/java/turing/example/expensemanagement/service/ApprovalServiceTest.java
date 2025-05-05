package turing.example.expensemanagement.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import turing.example.expensemanagement.dto.ApprovalDTO;
import turing.example.expensemanagement.entity.Approval;
import turing.example.expensemanagement.repository.ApprovalRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApprovalServiceTest {

    @Mock
    private ApprovalRepository approvalRepository;

    @InjectMocks
    private ApprovalService approvalService;

    private Approval approval1;
    private Approval approval2;

    @BeforeEach
    void setUp() {
        approval1 = new Approval(1L, "John Doe", "APPROVED");
        approval2 = new Approval(2L, "Jane Smith", "REJECTED");
    }


    @Test
    void testGetAllApprovals_EmptyList() {
        // Arrange
        when(approvalRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<ApprovalDTO> approvals = approvalService.getAllApprovals();

        // Assert
        assertTrue(approvals.isEmpty());
        verify(approvalRepository, times(1)).findAll();
    }

    @Test
    void testGetAllApprovals_ExceptionHandling() {
        // Arrange: Simulate an exception
        when(approvalRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> approvalService.getAllApprovals());
        assertEquals("Database error", exception.getMessage());

        verify(approvalRepository, times(1)).findAll();
    }
}
