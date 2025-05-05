package turing.example.expensemanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ApprovalDTO {
    private Long id;
    private String approverName;
    private String decision;

    public ApprovalDTO(Long id, String approverName, String decision) {
        this.id = id;
        this.approverName = approverName;
        this.decision = decision;
    }

    public ApprovalDTO() {

    }


    public String getStatus() {
        return this.decision; // ✅ Fix: Returning the decision field as status
    }
}
