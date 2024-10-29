package com.ExpenseTrackerApplication.mapper;

import com.ExpenseTrackerApplication.dto.ExpenseDto;
import com.ExpenseTrackerApplication.entity.Expenses;

public class ExpenseMapper {
	
	public static Expenses mapToExpense(ExpenseDto expenseDto)
	{
		Expenses expense = new Expenses(expenseDto.getId(),expenseDto.getItemName(),expenseDto.getItemDesc(),expenseDto.getAmount());
		return expense;
	}

	public static ExpenseDto mapToExpenseDto(Expenses expense)
	{
		ExpenseDto expenseDto = new ExpenseDto(expense.getId(),expense.getItemName(),expense.getItemDesc(),expense.getAmount());
		return expenseDto;
	}
}
