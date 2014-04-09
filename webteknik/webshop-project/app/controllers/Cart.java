package controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.TypedQuery;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

public class Cart extends Controller{
	
	
	@Transactional
	@Security.Authenticated
	public static Result addProductToCart()
	{	
		Map<String, String[]> form = request().body().asFormUrlEncoded();

		models.User userActiv = MyAuthentication.getActivUser().get(0);
				
		TypedQuery<models.Cart> query = JPA.em().createQuery( "SELECT c FROM Cart c WHERE c.user = :minParam1", models.Cart.class);
		List<models.Cart> activCart = query.setParameter("minParam1", userActiv).getResultList();

		List<models.Product> products = new ArrayList<models.Product>();
		products.add(getProduct(form));

		if (activCart.size() == 1 && (form.get("qty")[0] !="")){
	    	models.ProductQuantity productQuantity = new models.ProductQuantity();
	    	productQuantity.setProduct(products.get(0));	
	    	productQuantity.setQty(getQty(form)); 
	    	productQuantity.setCart(activCart.get(0));
	    	JPA.em().persist(productQuantity);
		}else{
				if (form.get("qty")[0] !=""){
					models.Cart cart = new models.Cart();
			    	cart.setUser(MyAuthentication.getActivUser().get(0));
			    	
			    	JPA.em().persist(cart);
			    	
			    	models.ProductQuantity productQuantity = new models.ProductQuantity();
			    	productQuantity.setProduct(products.get(0));	
			    	productQuantity.setQty(getQty(form)); 
			    	productQuantity.setCart(cart);
			    	JPA.em().persist(productQuantity);	
				}
			
		}	
		return redirect(routes.Product.listAllProducts());
	}

	private static int getQty(Map<String, String[]> form) {
		return Integer.parseInt(form.get("qty")[0]);
	}

	public static models.Product getProduct(Map<String, String[]> form) {
		int  productId = Integer.parseInt(form.get("product-id")[0]);
		models.Product product = JPA.em().find(models.Product.class, productId);
		return product;
	}
	
	@Transactional
	@Security.Authenticated	
	public static Result showCardForm(){
			
			models.User userActiv = MyAuthentication.getActivUser().get(0);		
			List<models.Cart> carts = userActiv.getCarts();
			
			if(carts.size() == 0){
				//return notFound();
				flash().put("cart-empty", "yes");
				return redirect(routes.Application.index());
			}
			
			models.Cart cart = carts.get(0);		
			return ok(showcart.render(cart.getProductQuantities()));
	}
	
	@Transactional
	@Security.Authenticated
	public static Result changeCart(){

		Map<String, String[]> form = request().body().asFormUrlEncoded();		
		models.User activeUser = MyAuthentication.getActivUser().get(0);		
		models.Cart cart = activeUser.getCarts().get(0);
		
//		List<String> list = new ArrayList<String>();
//		for(String key: form.keySet()){
//			String value = form.get(key)[0];
//
//			list.add(key+ "  " +value);
//		}
//		return ok(verlista.render(list));


		
		if ((form.get("deletec")) != null){
			String deletec = form.get("deletec")[0];
			if (deletec.equals("yes")){
				JPA.em().remove(cart);
				return redirect(routes.Cart.showCardForm());
			}
	    	
		}
		
		for(String key: form.keySet()){
	
			if ("qty-".equals(key.substring(0,4)))
			{
				String value = form.get(key)[0];
				if (!value.equals(null) && (value !="")){
					int id = Integer.parseInt(key.substring(4));
					models.ProductQuantity p = JPA.em().find(models.ProductQuantity.class, id);
			            if (p != null){
			            	p.setQty(Integer.parseInt(value));
			            }	
				}		
			}else if (key.equals("delete")){		
				int id = Integer.parseInt(form.get("delete")[0]);
				models.ProductQuantity p = JPA.em().find(models.ProductQuantity.class, id);
				 if (p != null){
					 JPA.em().remove(p);
				 }	 
			}
		}
	
		return redirect(routes.Cart.showCardForm());
		
	}
	
	@Transactional
	public static Result listAllCart(){
		List<models.Cart> carts = JPA.em().createQuery("SELECT a FROM Cart a", models.Cart.class).getResultList();
		return ok(listallcart.render(carts));
   	
	}	
	

}