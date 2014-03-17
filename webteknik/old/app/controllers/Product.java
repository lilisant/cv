
package controllers;
import java.util.Arrays;
import java.util.List;
import play.*;

import play.*;
import play.mvc.*;
import views.html.*;

public class Product extends Controller{
	static public Result product(){
		return ok(product.render());		
	}
	
	public static Result listAllProducts(){
		List<models.Product> products = askDatabaseForAllProducts();

		return ok(listallproducts.render(products));
	}

	public static Result showOneProduct(int id){
		models.Product product = askDatabaseForOneProduct(id);

		if(product == null){
			return notFound("Product not found");
		}

		return ok(showoneproduct.render(product));
	}

	private static List<models.Product> askDatabaseForAllProducts(){
		return Arrays.asList(new models.Product[]{
			new models.Product(1, "Hitchhikers' Guide", 200.50),
			new models.Product(2, "Bamse i Trollskogen", 18.30),
			new models.Product(3, "Short White", 200.10),
			new models.Product(4, "Blouse", 80.00)

		});
	}

	private static models.Product askDatabaseForOneProduct(int id) {
		if(id == 1){
			return new models.Product(1, "Hitchhikers' Guide", 200.50);
		}
		if(id == 2){
			return new models.Product(2, "Bamse i Trollskogen", 180.50);
		}
		if(id == 3){
			return new models.Product(3, "Short White", 200.10);
		}
		if(id == 4){
			return new models.Product(4, "Blouse", 80.00);
		}

		return null;
	}	

}
