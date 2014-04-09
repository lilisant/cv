package controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

public class Order extends Controller  {
 	
	@Transactional
	@Security.Authenticated
	public static Result showOrderForm(){
		models.User userActiv = MyAuthentication.getActivUser().get(0);		
		List<models.Cart> carts = userActiv.getCarts();		
		if(carts.size() == 0){
			return redirect(routes.Application.index());
		}	
		models.Cart cart = carts.get(0);		
		return ok(neworder.render(cart.getProductQuantities()));
	}
	
	@Transactional
	@Security.Authenticated
	public static Result newOrder(){
				
		models.User activeUser = MyAuthentication.getActivUser().get(0);		
		models.Cart cart = activeUser.getCarts().get(0);
	
		models.Order order = new models.Order();
		order.setUser(activeUser);		  
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateString = sdf.format(new Date()); 		
		try {
			Date date = sdf.parse(dateString);
			order.setDateOrder(date);
		} catch (ParseException e) {			
			e.printStackTrace();
		}

    	JPA.em().persist(order);

    	List<models.ProductQuantity> productQuantityCarts = cart.getProductQuantities();
		for(models.ProductQuantity list : productQuantityCarts)
		{
	    	models.ProductsInOrder productsInOrder = new models.ProductsInOrder();	    		
	    	productsInOrder.setOrder(order);
	    	productsInOrder.setProduct(list.getProduct());
	    	productsInOrder.setQty(list.getQty()); 	    	
	    	JPA.em().persist(productsInOrder);		
	     }
		JPA.em().remove(cart);	
		return redirect(routes.Cart.showCardForm());

	}

	@Transactional
	@Security.Authenticated
	public static Result listAllOrders(){
		models.User activeUser = MyAuthentication.getActivUser().get(0);
		TypedQuery<models.Order> query = JPA.em().createQuery( "SELECT c FROM Order c WHERE c.user = :minParam1", models.Order.class);
		List<models.Order> orders = query.setParameter("minParam1", activeUser).getResultList();
		
		return ok(listallorders.render(orders)); 	
	}
	
	@Transactional
	public static Result showOrder(int id){
		models.Order order = JPA.em().find(models.Order.class, id);
		return ok(showorder.render(order));
    	
    }
}
