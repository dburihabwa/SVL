package test;


import org.junit.Assert;
import org.junit.Test;

import domain.Book;
import domain.Order;

public class TestOrder {
	@Test
	public void addBook(){
		Order o = new Order();
		o.addBook(Book.LIVRE_1);
		Assert.assertEquals(Book.PRICE, o.getPrice(),0.01);
	}
}
