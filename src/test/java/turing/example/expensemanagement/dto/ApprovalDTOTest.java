package turing.example.expensemanagement.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApprovalDTOTest {

    @Test
    void testApprovalDTOBuilderAndGetters() {
        // Arrange
        ApprovalDTO approval = ApprovalDTO.builder()
                .id(1L)
                .approverName("John Doe")
                .decision("Approved")
                .build();

        // Act & Assert
        assertNotNull(approval);
        assertEquals(1L, approval.getId());
        assertEquals("John Doe", approval.getApproverName());
        assertEquals("Approved", approval.getDecision());
    }

    @Test
    void testApprovalDTOSetters() {
        // Arrange
        ApprovalDTO approval = new ApprovalDTO();

        // Act
        approval.setId(2L);
        approval.setApproverName("Jane Smith");
        approval.setDecision("Rejected");

        // Assert
        assertEquals(2L, approval.getId());
        assertEquals("Jane Smith", approval.getApproverName());
        assertEquals("Rejected", approval.getDecision());
    }

    @Test
    void testApprovalDTOEqualsAndHashCode() {
        // Arrange
        ApprovalDTO approval1 = ApprovalDTO.builder()
                .id(1L)
                .approverName("John Doe")
                .decision("Approved")
                .build();

        ApprovalDTO approval2 = ApprovalDTO.builder()
                .id(1L)
                .approverName("John Doe")
                .decision("Approved")
                .build();

        ApprovalDTO approval3 = ApprovalDTO.builder()
                .id(2L)
                .approverName("Jane Doe")
                .decision("Rejected")
                .build();

        // Act & Assert
        assertEquals(approval1, approval2); // Equals check
        assertNotEquals(approval1, approval3); // Ensure different objects are not equal
        assertEquals(approval1.hashCode(), approval2.hashCode()); // Hash code should match for equal objects
        assertNotEquals(approval1.hashCode(), approval3.hashCode()); // Hash code should be different for different objects
    }
}
