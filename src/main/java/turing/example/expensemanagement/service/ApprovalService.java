package turing.example.expensemanagement.service;

import org.springframework.stereotype.Service;
import turing.example.expensemanagement.dto.ApprovalDTO;
import turing.example.expensemanagement.entity.Approval;
import turing.example.expensemanagement.repository.ApprovalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;

    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    public List<ApprovalDTO> getAllApprovals() {
        List<Approval> approvals = approvalRepository.findAll();
        return approvals.stream()
                .map(approval -> new ApprovalDTO(approval.getId(), approval.getDecision(), approval.getApproverName()))
                .collect(Collectors.toList());
    }
}
