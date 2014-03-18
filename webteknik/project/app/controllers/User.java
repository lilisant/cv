package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import views.html.*;

public class User extends Controller {

    public static Result user() {
    	/////// new ...
    	
    	//List<User> users = Ebean.find(User.class).findList();
    	
        return ok(user.render());
    }
	
	public static Result createSomeUsers(){
		models.User user = new models.User(1, "tati", "Sant", "address" , "town", "postcode", "mobile", "email", "password");
		
		Ebean.save(user);

		return ok("Users created");
	}
	
	public static Result showUser(int id){
		models.User user = Ebean.find(models.User.class, id);
    	
		return ok(showUser.render(user));
    }
	public static Result listAllUsers(){
//		List<models.User> users = askDatabaseForAllUsers();
//
//		return ok(listalluser.render(users));
		List<models.User> users = Ebean.find(models.User.class).findList();
    	
        return ok(listalluser.render(users));
	}

}
