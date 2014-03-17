package main.java.fr.lille1.svl;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	private Integer balance;
	private List<Integer> operations;

	public BankAccount() {
		this.balance = 0;
		this.operations = new ArrayList<Integer>();
	}

	public void credit(Integer amount) throws NegativeAmountException {
		if (amount < 0) {
			throw new NegativeAmountException();
		}
		this.balance += amount;
		this.operations.add(amount);
	}

	public void debit(Integer amount) throws NegativeAmountException,
			InsufficientFundsException {
		if (amount < 0)
			throw new NegativeAmountException();
		if (this.balance < amount)
			throw new InsufficientFundsException();
		this.balance -= amount;
		this.operations.add(0 - amount);
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	
	public List<Integer> operations() {
		return this.operations;
	}
	
	public Integer getLastOperation() throws NoOperationException {
		if (this.operations.isEmpty())
			throw new NoOperationException();
		return this.operations.get(operations.size() - 1);
	}
}
