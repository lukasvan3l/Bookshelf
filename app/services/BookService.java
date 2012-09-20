package services;

import utils.Utils;
import models.Book;

public class BookService {

	public static Book getBookInformation(String isbn)
	{
    	if (!Utils.isValidISBN(isbn))
    		return null;
		
		Book book = Book.findById(isbn);
		if (book != null)
			return book;
		
		// todo download info from bol, amazon
		
		return null;
	}
	
}