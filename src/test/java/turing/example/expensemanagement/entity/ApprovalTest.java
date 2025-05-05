package turing.example.expensemanagement.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApprovalTest {

    @Test
    void testNoArgsConstructor() {
        Approval approval = new Approval();
        assertNotNull(approval);
    }

    @Test
    void testAllArgsConstructor() {
        Approval approval = new Approval(1L, "John Doe", "APPROVED");
        assertEquals(1L, approval.getId());
        assertEquals("John Doe", approval.getApproverName());
        assertEquals("APPROVED", approval.getDecision());
    }

    @Test
    void testSettersAndGetters() {
        Approval approval = new Approval();
        approval.setId(2L);
        approval.setApproverName("Jane Doe");
        approval.setDecision("REJECTED");
        approval.setComments("Insufficient justification");

        assertEquals(2L, approval.getId());
        assertEquals("Jane Doe", approval.getApproverName());
        assertEquals("REJECTED", approval.getDecision());
        assertEquals("Insufficient justification", approval.getComments());
    }
}
