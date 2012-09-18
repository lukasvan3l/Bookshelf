package models;

import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;

/**
 * Owner of a bookshelf
 */
public class User extends EnhancedModel
{
    @Id(Generator.NONE)
    public String id;

    public String username;
    
    public String email;
    
    public List<Book> books_owned;
    public List<Book> books_read;
    public List<Book> books_wished;
    
    public static User findByUsername(String username)
    {
    	return User.all().filter("username", username).get();
    }
}
