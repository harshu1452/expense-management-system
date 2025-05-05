package turing.example.expensemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import turing.example.expensemanagement.dto.ApprovalDTO;
import turing.example.expensemanagement.service.ApprovalService;

import java.util.List;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {
    private final ApprovalService approvalService;

    @GetMapping
    public ResponseEntity<List<ApprovalDTO>> getAllApprovals() {
        return ResponseEntity.ok(approvalService.getAllApprovals());
    }
}