
package controllers;

import play.*;


import play.mvc.Controller;
import play.mvc.Result;


public class Product extends Controller{
	static public Result product(){
		return ok(views.html.product.render(""));		
	}

}
