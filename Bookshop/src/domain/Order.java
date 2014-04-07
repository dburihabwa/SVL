package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Order {
	
	private Map<Book, Integer> books;

	public Order(){
		books = new HashMap<Book, Integer>();
	}
	
	public void addBook(Book b) {
		Integer nbr = books.get(b);
		if (nbr == null) {
			books.put(b, 1);
		} else {
			books.put(b, nbr + 1);
		}
	}

	public double getPrice() {
		double price = 0;
		for( Entry<Book,Integer> e : books.entrySet()){
			price += e.getValue() * Book.PRICE;
		}
		return price;
	}
}
