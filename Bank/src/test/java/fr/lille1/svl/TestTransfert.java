package test.java.fr.lille1.svl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import main.java.fr.lille1.svl.IBankAccount;
import main.java.fr.lille1.svl.InsufficientFundsException;
import main.java.fr.lille1.svl.NegativeAmountException;
import main.java.fr.lille1.svl.NoAccountException;
import main.java.fr.lille1.svl.Transfer;

import org.junit.Test;

public class TestTransfert {

	@Test
	public void testTransferer() throws NoAccountException {
		IBankAccount envoyeur = mock(IBankAccount.class, "envoyeur");
		IBankAccount receveur = mock(IBankAccount.class, "receveur");
		Transfer transfert = new Transfer(envoyeur, receveur);
		assertEquals(envoyeur,transfert.getSender());
		assertEquals(receveur,transfert.getReceiver());

	}
	
	@Test(expected = NoAccountException.class)
	public void testTransfererCompteEnvoyeurNull() throws NoAccountException {
		IBankAccount receveur = mock(IBankAccount.class, "receveur");
		Transfer transfert = new Transfer(null, receveur);
		fail();
	}
	
	@Test(expected = NoAccountException.class)
	public void testTransfererCompteReceveurNull() throws NoAccountException {
		IBankAccount envoyeur = mock(IBankAccount.class, "envoyeur");
		Transfer transfert = new Transfer(envoyeur, null);
		fail();
	}
	
	@Test(expected = NoAccountException.class)
	public void testTransfererComptesNull() throws NoAccountException {
		Transfer transfert = new Transfer(null, null);
		fail();
	}
	
	@Test(expected = NegativeAmountException.class)
	public void testTransfereMontantNegatif() throws NoAccountException, NegativeAmountException, InsufficientFundsException {
		IBankAccount envoyeur = mock(IBankAccount.class, "envoyeur");
		IBankAccount receveur = mock(IBankAccount.class, "receveur");
		Transfer transfert = new Transfer(envoyeur, receveur);
		transfert.transfer(-100);
		fail();
	}
	
	@Test(expected = InsufficientFundsException.class)
	public void testTransfereMontantTropEleve() throws NoAccountException, NegativeAmountException, InsufficientFundsException {
		int amount = 100;
		IBankAccount envoyeur = mock(IBankAccount.class, "envoyeur");
		when(envoyeur.getBalance()).thenReturn(amount - 1);
		IBankAccount receveur = mock(IBankAccount.class, "receveur");
		when(receveur.getBalance()).thenReturn(0);
		Transfer transfert = new Transfer(envoyeur, receveur);
		transfert.transfer(amount);
		verify(envoyeur,never()).debit(anyInt());
		verify(receveur,never()).credit(anyInt());
		fail();

	}
	
	@Test
	public void testTransfereMontantExact() throws NoAccountException, NegativeAmountException, InsufficientFundsException {
		int amount = 100;
		IBankAccount envoyeur = mock(IBankAccount.class, "envoyeur");
		when(envoyeur.getBalance()).thenReturn(amount);
		IBankAccount receveur = mock(IBankAccount.class, "receveur");
		when(receveur.getBalance()).thenReturn(0);
		Transfer transfert = new Transfer(envoyeur, receveur);
		transfert.transfer(amount);
		verify(envoyeur,atLeastOnce()).debit(anyInt());
		verify(receveur,atLeastOnce()).credit(anyInt());
		assertTrue(true);
	}
}
