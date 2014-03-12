
package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import play.*;
import views.html.*;
import play.mvc.Controller;
import play.mvc.Result;

public class Category extends Controller {

	public static Result category(){
		
		return ok(category.render());
	}
	
	public static Result listAllCategory(){
		List<models.Category> categorys = askDatabaseForAllCategorys();

		return ok(listallcategory.render(categorys));
	}
	
	private static List<models.Category> askDatabaseForAllCategorys(){
		return Arrays.asList(new models.Category[]{
			new models.Category(1, "Book"),
			new models.Category(2, "Clothes")
		});
	}
	
	public static Result showOneCategory(int id){
		models.Category category = askDatabaseForOneCategory(id);

		if(category == null){
			return notFound("Category not found");
		}

		return ok(showonecategory.render(category));
	}
	private static models.Category askDatabaseForOneCategory(int id) {
		if(id == 1){
			return new models.Category(1, "Book");
		}
		if(id == 2){
			return new models.Category(2, "Clothes");
		}

		return null;
	}	

}


