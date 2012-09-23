package models;

import java.net.URL;
import java.util.Date;
import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.DateTime;
import siena.Generator;
import siena.Id;
import siena.Text;
import siena.embed.Embedded;

/**
 * Book with ISBN
 */
public class Book extends EnhancedModel
{
	/**
	 * primary key
	 */
    @Id(Generator.AUTO_INCREMENT)
    public Long id;
    
    public String isbn10;
    public String isbn13;

    public String title;
    @Text
    public String description;
    
    public String image;

    @Embedded
	public List<String> authors;

    @DateTime
	public Date publishedDate;

	public int pageCount;

	public String language;

	public String infoLink;
    
    /**
     * @param isbn can be isbn10 or isbn13
     * @return
     */
    public static Book FindByISBN(String isbn)
    {
    	if (isbn.length() == 10)
    		return Book.all().filter("isbn10", isbn).get();
    	if (isbn.length() == 13)
    		return Book.all().filter("isbn13", isbn).get();
    	return null;
    }
}
