package com.ExpenseTrackerApplication.dto;

public class ExpenseDto {
	
	private Long id;
	private String itemName;
	private String itemDesc;
	private double amount;
	public ExpenseDto(Long id, String itemName, String itemDesc, double amount) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.amount = amount;
	}
	public ExpenseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
