package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import play.Logger;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import utils.Utils;
import models.Book;
import models.GoogleBook;
import models.GoogleBooks;

public class BookService {

	public static Book getBookInformation(String isbn)
	{
		Logger.debug("Get book information %s", isbn);
		
    	if (!Utils.isValidISBN(isbn))
    		return null;
		
    	// get it from our own database
		Book book = Book.FindByISBN(isbn);
		if (book != null)
			return book;
		
		// get it from google books, save to our own database
		GoogleBook gbook = getBookFromGoogle(isbn);
		if (gbook != null)
		{
			book = gbook.getBook();
			book.save();
			return book;
		}
		
		return null;
	}
	
	public static GoogleBook getBookFromGoogle(String isbn)
	{
		String url = String.format("https://www.googleapis.com/books/v1/volumes?q=%s", isbn);

		Logger.debug("Downloading %s", url);
		
		HttpResponse response = WS.url(url).get();
		Gson gson = new Gson();
		GoogleBooks books = gson.fromJson(response.getJson(), GoogleBooks.class);
		if (books != null && books.items.size() > 0)
		{
			Logger.info("%d book(s) found on Google Books for isbn %s", books.items.size(), isbn);
			return books.items.get(0);
		}
		Logger.info("No book found on Google Books for isbn %s", isbn);
		return null;
	}
	
}