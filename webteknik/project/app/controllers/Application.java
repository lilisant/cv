package controllers;

import java.util.ArrayList;
import java.util.List;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

//    public static Result index() {
//        return ok(index.render("Your new application is ready."));
//    }
	
	public static Result index(){
		
		List<String> list = new ArrayList<String>();
		list.add("category");
		list.add("product");	

		return ok(first.render(list));
	}
}
