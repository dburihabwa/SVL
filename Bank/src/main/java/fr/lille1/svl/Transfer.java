package main.java.fr.lille1.svl;

public class Transfer {
	private IBankAccount sender;
	private IBankAccount receiver;

	public Transfer(IBankAccount sender, IBankAccount receiver) throws NoAccountException {
		if (sender == null) {
			throw new NoAccountException("Sender null");
		} else if (receiver == null) {
			throw new NoAccountException("Receiver null");
		}
		this.sender = sender;
		this.receiver = receiver;
	}

	public void transfer(int amount) throws NegativeAmountException,
			InsufficientFundsException {
		if (amount < 0)
			throw new NegativeAmountException();
		if (sender.getBalance() < amount) {
			throw new InsufficientFundsException();
		}
		
		this.sender.debit(amount);
		this.receiver.credit(amount);
	}

	public IBankAccount getSender() {
		return sender;
	}

	public IBankAccount getReceiver() {
		return receiver;
	}
}
