package models;

import java.util.ArrayList;
import java.util.List;

import play.modules.siena.EnhancedModel;

import services.BookService;
import siena.Generator;
import siena.Id;
import siena.embed.Embedded;

/**
 * Owner of a bookshelf
 */
public class User extends EnhancedModel
{
    @Id(Generator.AUTO_INCREMENT)
    public Long id;

    public String username;
    
    public String email;
    
    @Embedded
    public List<Long> books_owned;
    @Embedded
    public List<Long> books_read;
    @Embedded
    public List<Long> books_wished;
    
    public static User findByUsername(String username)
    {
    	return User.all().filter("username", username).get();
    }

	public void addToBookshelf(Book book) {
		books_owned.add(book.id);
		save();
	}

	public List<Book> getBooksOwned() {
		List<Book> books = new ArrayList<Book>();
		for (Long b : books_owned)
		{
			Book book = Book.findById(b);
			if (book != null)
				books.add(book);
		}
		return books;
	}
}
