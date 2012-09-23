package models;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.joda.time.DateTime;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;

/**
 * Book downloaded in JSON from google books
 */
public class GoogleBookInfo
{
    public String title;
    public List<String> authors;
    public String publisher;
    public String publishedDate;
    public String description;
    public Integer pageCount;
    public String printType;
    public float averageRating;
    public String language;
    public String infoLink;
    public List<Identifier> industryIdentifiers;
    public ImageLinks imageLinks;
    
    public String getISBN10()
    {
    	for (Identifier i : industryIdentifiers)
    		if (i.type.equals("ISBN_10"))
    			return i.identifier;
    	return null;
    }
    public String getISBN13()
    {
    	for (Identifier i : industryIdentifiers)
    		if (i.type.equals("ISBN_13"))
    			return i.identifier;
    	return null;
    }
    
    public Book getBook() {
    	Book book = new Book();
    	book.isbn10 = getISBN10();
    	book.isbn13 = getISBN13();
    	book.title = title;
    	book.description = description;
    	book.image = imageLinks.thumbnail;
    	book.authors = authors;
    	book.publishedDate = DateTime.parse(publishedDate).toDate();
    	book.pageCount = pageCount;
    	book.language = language;
    	book.infoLink = infoLink;
    	return book;
	}
    
    public class Identifier
    {
    	public String type;
    	public String identifier;
    }
    
    public class ImageLinks
    {
    	public String thumbnail;
    	public String smallThumbnail;
    }
}