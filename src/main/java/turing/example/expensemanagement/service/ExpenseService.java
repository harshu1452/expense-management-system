package turing.example.expensemanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turing.example.expensemanagement.dto.ExpenseDTO;
import turing.example.expensemanagement.entity.Expense;
import turing.example.expensemanagement.repository.ExpenseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .map(expense -> ExpenseDTO.builder()
                        .id(expense.getId())
                        .description(expense.getDescription())
                        .amount(expense.getAmount())
                        .date(expense.getDate())
                        .build())
                .collect(Collectors.toList());
    }
}
