package controllers;

import java.util.ArrayList;
import java.util.List;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

//    public static Result index() {
//        return ok(index.render("Your new application is ready."));
//    }
	
	public static Result index(){
//		flash().put("username-login", "no");
		List<String> list = new ArrayList<String>();
		list.add("categories");
		list.add("products");	
		list.add("users");
		list.add("cart");
		list.add("orders");

		return ok(first.render(list));
	}
	
}
