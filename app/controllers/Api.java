package controllers;

import play.*;
import play.mvc.*;
import services.BookService;
import utils.Utils;

import java.util.*;

import models.*;

public class Api extends Controller {

    public static void getBookByISBN(String isbn) {
    	Book book = BookService.getBookInformation(isbn);
    	if (book == null)
    		notFound();
        renderJSON(book);
    }

    public static void getUserBookshelf(String username) {
    	User user = User.findByUsername(username);
    	if (user == null)
    		notFound();
        renderJSON(user.books_owned);
    }

    public static void getUserWishlist(String username) {
    	User user = User.findByUsername(username);
    	if (user == null)
    		notFound();
        renderJSON(user.books_wished);
    }

    public static void addBookToShelf(String isbn, String username)
    {
    	if (!Utils.isValidISBN(isbn))
    		error("Invalid isbn number");
    	User user = User.findByUsername(username);
    	if (user == null)
    		notFound();
    	Book book = BookService.getBookInformation(isbn);
    	user.addToBookshelf(book);
    	renderJSON(book);
    }
    
    
}