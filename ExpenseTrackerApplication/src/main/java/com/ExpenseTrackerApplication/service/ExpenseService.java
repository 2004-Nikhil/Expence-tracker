package com.ExpenseTrackerApplication.service;

import java.util.List;

import com.ExpenseTrackerApplication.dto.ExpenseDto;

public interface ExpenseService {

	abstract ExpenseDto createExpense(ExpenseDto Expense);
	abstract ExpenseDto getExpenseById(Long id);
	abstract ExpenseDto updateItemName(Long id,String itemName);
	abstract ExpenseDto updateItemDesc(Long id,String itemDesc);
	abstract ExpenseDto updateBalance(Long id,double amount);
	abstract List<ExpenseDto> getAllExpenses();
	abstract void deleteExpense(Long id);
}
