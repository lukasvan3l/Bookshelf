package models;

import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;
import siena.embed.Embedded;

/**
 * Owner of a bookshelf
 */
public class User extends EnhancedModel
{
    @Id(Generator.NONE)
    public String id;

    public String username;
    
    public String email;
    
    @Embedded
    public List<String> books_owned;
    @Embedded
    public List<String> books_read;
    @Embedded
    public List<String> books_wished;
    
    public static User findByUsername(String username)
    {
    	return User.all().filter("username", username).get();
    }

	public void addToBookshelf(String isbn) {
		books_owned.add(isbn);
		save();
	}
}
