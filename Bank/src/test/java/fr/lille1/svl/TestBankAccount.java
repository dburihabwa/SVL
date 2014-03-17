package test.java.fr.lille1.svl;

import static org.junit.Assert.*;
import junit.framework.Assert;

import main.java.fr.lille1.svl.BankAccount;
import main.java.fr.lille1.svl.InsufficientFundsException;
import main.java.fr.lille1.svl.NegativeAmountException;
import main.java.fr.lille1.svl.NoOperationException;

import org.junit.Test;

public class TestBankAccount {

	@Test
	public void testBankAccount() {
		BankAccount account = new BankAccount();
		Assert.assertEquals(0, (int) account.getBalance());
	}

	@Test(expected = NegativeAmountException.class)
	public void testCreditNegativeAmount() throws NegativeAmountException {
		BankAccount account = new BankAccount();
		Integer negativeAmount = new Integer(-13);
		account.credit(negativeAmount);
		fail("An exception should have prevented the test case from reaching this line!");
	}

	@Test
	public void testCredit() {
		BankAccount account = new BankAccount();
		Integer expextedBalance = account.getBalance();
		Integer amount = new Integer(100);
		expextedBalance += amount;
		try {
			account.credit(amount);
			assertEquals(expextedBalance, account.getBalance());
			assertEquals(amount, account.getLastOperation());
		} catch (NegativeAmountException | NoOperationException e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected = NegativeAmountException.class)
	public void testDebitNegativeAmount() throws NegativeAmountException {
		BankAccount account = new BankAccount();
		Integer negativeAmount = new Integer(-13);
		try {
			account.debit(negativeAmount);
		} catch (InsufficientFundsException e) {
			fail(e.getMessage());
		}
		fail("An exception should have prevented the test case from reaching this line!");
	}
	
	@Test(expected = InsufficientFundsException.class)
	public void testDebitInsufficientFunds() throws InsufficientFundsException {
		BankAccount account = new BankAccount();
		Integer amount = new Integer(100);
		try {
			account.credit(amount);
			account.debit(amount + 1);
		} catch (NegativeAmountException e) {
			fail(e.getMessage());
		}
		fail("An exception should have prevented the test case from reaching this line!");
	}

	@Test
	public void testDebit() {
		BankAccount account = new BankAccount();
		try {
			account.credit(100);
		} catch (NegativeAmountException e1) {
			fail(e1.getMessage());
		}
		Integer expextedBalance = account.getBalance();
		Integer amount = new Integer(100);
		expextedBalance -= amount;
		Integer expectedOperation = 0 - amount;
		try {
			account.debit(amount);
			assertEquals(expextedBalance, account.getBalance());
			assertEquals(expectedOperation, account.getLastOperation());
		} catch (NegativeAmountException | NoOperationException
				| InsufficientFundsException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = NoOperationException.class)
	public void testGetLastOperationNoOperation() throws NoOperationException {
		BankAccount account = new BankAccount();
		account.getLastOperation();
	}

}
