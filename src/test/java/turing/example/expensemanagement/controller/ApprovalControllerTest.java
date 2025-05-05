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
import turing.example.expensemanagement.dto.ApprovalDTO;
import turing.example.expensemanagement.service.ApprovalService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ApprovalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ApprovalService approvalService;

    @InjectMocks
    private ApprovalController approvalController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(approvalController).build();
    }

    @Test
    void testGetAllApprovals_Success() throws Exception {
        // ✅ Fix: Use correct field names from ApprovalDTO
        ApprovalDTO approval1 = new ApprovalDTO(1L, "APPROVED", "John Doe");
        ApprovalDTO approval2 = new ApprovalDTO(2L, "REJECTED", "Jane Doe");
        List<ApprovalDTO> approvals = Arrays.asList(approval1, approval2);

        when(approvalService.getAllApprovals()).thenReturn(approvals);

        // ✅ Ensure correct field names and proper assertions
        mockMvc.perform(get("/approvals")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].approverName").value("APPROVED"));

        verify(approvalService, times(1)).getAllApprovals();
    }

    @Test
    void testGetAllApprovals_EmptyList() throws Exception {
        when(approvalService.getAllApprovals()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/approvals")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(approvalService, times(1)).getAllApprovals();
    }

}
