package controllers;

import play.*;
import play.modules.siena.SienaFixtures;
import play.mvc.*;

import java.util.*;

import models.*;

public class Database extends Controller {

    public static void create() {
    	SienaFixtures.deleteAllModels();
    	SienaFixtures.loadModels("data.yml");
    	
    	Marketing.index();
    }

}