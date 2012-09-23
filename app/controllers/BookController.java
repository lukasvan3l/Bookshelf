package controllers;

import play.*;
import play.mvc.*;
import services.BookService;
import utils.Utils;

import java.util.*;

import models.*;

public class BookController extends Controller {

    public static void book(String isbn) {
    	if (!Utils.isValidISBN(isbn))
    		error("Invalid isbn number");

    	Book book = BookService.getBookInformation(isbn);
    	if (book == null)
    		notFound();
        render(book);
    }

}