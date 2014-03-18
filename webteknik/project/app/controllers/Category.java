
package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import views.html.*;
import play.mvc.Controller;
import play.mvc.Result;

public class Category extends Controller {

	public static Result category(){
		
		return ok(category.render());
	}
	
	public static Result createSomeCategory(){
		models.Category category = new models.Category(3, "MAN");		
		Ebean.save(category);
		return ok("Category created");
	}
	
	public static Result showCategory(int id){
		models.Category category = Ebean.find(models.Category.class, id);
    	
		return ok(showcategory.render(category));
    }
	public static Result listAllCategory(){
		List<models.Category> categories = Ebean.find(models.Category.class).findList();
		return ok(listallcategories.render(categories));

	}

}


