package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Marketing extends Controller {

    public static void index() {
    	List<User> users = User.all().fetch();
        render(users);
    }

}