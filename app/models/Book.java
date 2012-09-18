package models;

import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;

/**
 * Book with ISBN
 */
public class Book extends EnhancedModel
{
	/**
	 * primary key
	 */
    @Id(Generator.NONE)
    public String isbn;

    public String name;
    
    public static Book FindByISBN(String isbn)
    {
    	return findById(isbn);
    }
}
