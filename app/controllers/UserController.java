package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class UserController extends Controller {

    public static void bookshelf(String username) {
    	User user = User.findByUsername(username);
    	if (user == null)
    		Marketing.index();
        render(user.books_owned, user);
    }

    public static void wishlist(String username) {
    	User user = User.findByUsername(username);
    	if (user == null)
    		Marketing.index();
        render(user.books_wished, user);
    }

}