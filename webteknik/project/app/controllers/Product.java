
package controllers;
import java.util.Arrays;
import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.*;
import play.mvc.*;
import views.html.*;

public class Product extends Controller{
	static public Result product(){
		return ok(product.render());		
	}
	public static Result createSomeproduct(){
		models.Product product = new models.Product(5, "Panty", 10, "Woman");
		
		Ebean.save(product);

		return ok("Product created");
	}
	public static Result showProduct(int id){
		models.Product product = Ebean.find(models.Product.class, id);
    	return ok(showproduct.render(product));
    	//showproduct.render(product)
    }
	public static Result listAllProduct(){
		List<models.Product> products = Ebean.find(models.Product.class).findList();
    	return ok(listallproduct.render(products));
    	//listallproduct.render(products)
	}

}
