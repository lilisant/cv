
package controllers;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import play.db.jpa.JPA;
import play.mvc.*;
import views.html.*;
import play.db.jpa.Transactional;

public class Product extends Controller{
	
	@Transactional
	@Security.Authenticated
	public static Result newProduct(){		
		Map<String, String[]> form = request().body().asFormUrlEncoded();		
		List<Category> categories = new ArrayList<Category>();

		Integer categoryId;
		
		for (int i = 0; i < form.get("category-id").length; i++ ){
			categoryId = Integer.parseInt(form.get("category-id")[i]);
			Category category = JPA.em().find(Category.class, categoryId);
			categories.add(category);
		}
		models.Product product = new models.Product();
		product.setName(form.get("name")[0]);
		product.setPrice(Double.parseDouble(form.get("price")[0]));
		product.setStock(Integer.parseInt(form.get("stock")[0]));
		product.setCategoriesProd(categories);
		
		JPA.em().persist(product);
		return redirect(routes.Product.listAllProducts());
	}
	
	@Transactional
	public static Result showProductForm(){				
		List<models.Product> products    = JPA.em().createQuery("SELECT a from Product AS a", models.Product.class).getResultList();
		List<models.Category> categories = JPA.em().createQuery("SELECT a from Category AS a", models.Category.class).getResultList();	
		return ok(newproduct.render(products, categories));
	}
	
	@Transactional
	public static Result showProduct(int id){
		models.Product product = JPA.em().find(models.Product.class, id);	
		return ok(showproduct.render(product));   	
    }
	
	@Transactional
	public static Result listAllProducts(){
		List<models.Product> products = JPA.em().createQuery("SELECT a FROM Product a", models.Product.class).getResultList();
		return ok(listallproduct.render(products));  	
	}
}

