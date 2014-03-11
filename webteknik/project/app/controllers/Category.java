
package controllers;

import play.*;



import views.html.*;
import play.mvc.Controller;
import play.mvc.Result;

public class Category extends Controller {

	public static Result category(){
		return ok(category.render("Category"));
	}
	
}
