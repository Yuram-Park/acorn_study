package model;

import java.util.ArrayList;

public class BookBean {
	
	
	public String[] getBookCart(String book) {
		String[] books = book.split(" / ");
		System.out.println(book);
		return books;
	}
}
