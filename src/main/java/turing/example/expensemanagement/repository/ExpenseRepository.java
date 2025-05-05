package turing.example.expensemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turing.example.expensemanagement.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
