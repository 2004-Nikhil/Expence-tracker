package com.ExpenseTrackerApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ExpenseTrackerApplication.dto.ExpenseDto;
import com.ExpenseTrackerApplication.entity.Expenses;
import com.ExpenseTrackerApplication.mapper.ExpenseMapper;
import com.ExpenseTrackerApplication.repository.ExpenseRepository;
import com.ExpenseTrackerApplication.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseRepository expenseRepository;
	
	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}

	@Override
	public ExpenseDto createExpense(ExpenseDto expenseDto) {

		Expenses expense = ExpenseMapper.mapToExpense(expenseDto);
		Expenses savedExpense = expenseRepository.save(expense);
		ExpenseDto returnExpense = ExpenseMapper.mapToExpenseDto(savedExpense);
		return returnExpense;
	}

	@Override
	public ExpenseDto getExpenseById(Long id) {
		
		Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
		ExpenseDto returnExpense = ExpenseMapper.mapToExpenseDto(expense);
		return returnExpense;
	}

	@Override
	public List<ExpenseDto> getAllExpenses() {

		return expenseRepository.findAll().stream().map( (expense)->ExpenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());		
	
	}

	@Override
	public void deleteExpense(Long id) {
		Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
		expenseRepository.delete(expense);
	}
	
	@Override
	public ExpenseDto updateBalance(Long id, double amount) {
		
		Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
		expense.setAmount(amount);
		Expenses savedExpense = expenseRepository.save(expense);
		ExpenseDto returnExpense = ExpenseMapper.mapToExpenseDto(savedExpense);
		return returnExpense;
	}

	@Override
	public ExpenseDto updateItemName(Long id, String itemName) {
		Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
		expense.setItemName(itemName);
		Expenses savedExpense = expenseRepository.save(expense);
		ExpenseDto returnExpense = ExpenseMapper.mapToExpenseDto(savedExpense);
		return returnExpense;
	}

	@Override
	public ExpenseDto updateItemDesc(Long id, String itemDesc) {
		Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
		expense.setItemDesc(itemDesc);
		Expenses savedExpense = expenseRepository.save(expense);
		ExpenseDto returnExpense = ExpenseMapper.mapToExpenseDto(savedExpense);
		return returnExpense;
	}
}
