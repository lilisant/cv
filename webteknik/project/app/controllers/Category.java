
package controllers;

import java.util.List;
import java.util.Map;
import views.html.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

public class Category extends Controller {

	
	@Transactional
	@Security.Authenticated
	public static Result newCategory(){		
		Map<String, String[]> form = request().body().asFormUrlEncoded();	
		models.Category category = new models.Category();
		category.setName(form.get("name")[0]);		
		JPA.em().persist(category);
		return redirect(routes.Category.listAllCategory());
	}
	
	@Transactional
	@Security.Authenticated
	public static Result showCategoryForm(){
		List<models.Category> categories = JPA.em().createQuery("SELECT a from Category AS a", models.Category.class).getResultList();
		return ok(newcategory.render(categories));
	}
	
	@Transactional
	public static Result showCategory(int id){
		models.Category category = JPA.em().find(models.Category.class, id);		
		return ok(showcategory.render(category));
    }
	@Transactional
	public static Result listAllCategory(){
		List<models.Category> categories = JPA.em().createQuery("SELECT a FROM Category a", models.Category.class).getResultList();
		return ok(listallcategories.render(categories));
	}
	

}


