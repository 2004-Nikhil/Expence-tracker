package com.ExpenseTrackerApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTrackerApplication.dto.ExpenseDto;
import com.ExpenseTrackerApplication.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
	
	private ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}

	// add expense api
	@PostMapping
	public ResponseEntity<ExpenseDto> addExpense(@RequestBody ExpenseDto expenseDto)
	{
		return new ResponseEntity<>(expenseService.createExpense(expenseDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id)
	{
		ExpenseDto expenseDto = expenseService.getExpenseById(id);
		return ResponseEntity.ok(expenseDto);
	}
	
	@GetMapping
	public ResponseEntity<List<ExpenseDto>> getAllExpenses()
	{
		List<ExpenseDto> expenseDto = expenseService.getAllExpenses();
		return ResponseEntity.ok(expenseDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable Long id)
	{
		expenseService.deleteExpense(id);
		return ResponseEntity.ok("Expense Deleted Successfully");
	}
	
	@PutMapping("/update/{id}/amount")
	public ResponseEntity<ExpenseDto> updateBalance(@PathVariable Long id,@RequestBody Map<String, Double> request)
	{
		Double amount = request.get("amount");
		ExpenseDto expenseDto = expenseService.updateBalance(id, amount);
		return ResponseEntity.ok(expenseDto);
	}
	
	@PutMapping("/update/{id}/name")
	public ResponseEntity<ExpenseDto> updateItemName(@PathVariable Long id,@RequestBody Map<String, String> request)
	{
		String item_name = request.get("itemName");
		ExpenseDto expenseDto = expenseService.updateItemName(id, item_name);
		return ResponseEntity.ok(expenseDto);
	}
	
	@PutMapping("/update/{id}/desc")
	public ResponseEntity<ExpenseDto> updateItemDesc(@PathVariable Long id,@RequestBody Map<String, String> request)
	{
		String item_desc = request.get("itemDesc");
		ExpenseDto expenseDto = expenseService.updateItemDesc(id, item_desc);
		return ResponseEntity.ok(expenseDto);
	}
}
