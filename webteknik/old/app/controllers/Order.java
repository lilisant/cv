package controllers;


import play.*;


import play.mvc.Controller;
import play.mvc.Result;


import views.html.*;

public class Order extends Controller  {
 
	public static Result order(){
	 return ok(order.render("Order"));
		
	}
}
