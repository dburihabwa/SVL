package main.java.fr.lille1.svl;

import java.util.List;

public interface IBankAccount {
	void credit(Integer amount) throws NegativeAmountException;

	public void debit(Integer amount) throws NegativeAmountException,
			InsufficientFundsException;

	public Integer getBalance();

	public List<Integer> operations();

	public Integer getLastOperation() throws NoOperationException;

}
