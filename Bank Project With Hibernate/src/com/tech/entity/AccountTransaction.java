package com.tech.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class AccountTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int account_Id;
	
	private Date date;
	
	private String description;
	
	private String debitorCredit;
	
	private double amount;
	
	private double balance;
	
	@ManyToOne
	private  Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDebitorCredit() {
		return debitorCredit;
	}

	public void setDebitorCredit(String debitorCredit) {
		this.debitorCredit = debitorCredit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccount_Id() {
		return account_Id;
	}

	public void setAccount_Id(int account_Id) {
		this.account_Id = account_Id;
	}

	
	
	
	

}
