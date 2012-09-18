package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Api extends Controller {

    public static void getBookByISBN(String isbn) {
    	Book book = Book.findById(isbn);
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

    public static void getUserBooksRead(String username) {
    	User user = User.findByUsername(username);
    	if (user == null)
    		notFound();
        renderJSON(user.books_read);
    }

    public static void getUserWishlist(String username) {
    	User user = User.findByUsername(username);
    	if (user == null)
    		notFound();
        renderJSON(user.books_wished);
    }

}