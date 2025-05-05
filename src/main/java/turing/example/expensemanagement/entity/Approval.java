package turing.example.expensemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String approverName;
    private String decision;
    private String comments;

    public Approval(Long id, String approverName, String decision) {
        this.id = id;
        this.approverName = approverName;
        this.decision = decision;
    }
}
