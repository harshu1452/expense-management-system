package turing.example.expensemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turing.example.expensemanagement.entity.Approval;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, Long> {
}
