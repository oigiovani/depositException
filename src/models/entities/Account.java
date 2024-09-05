package models.entities;

import models.exceptions.WithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw (Double amount) throws WithdrawException {
		if (balance<amount) {
			throw new WithdrawException("Not enough balance");
		}
		if(amount>withdrawLimit) {
			throw new WithdrawException("The amount exceeds withdraw limit");
		}
		
		this.balance -= amount;
	}
}
