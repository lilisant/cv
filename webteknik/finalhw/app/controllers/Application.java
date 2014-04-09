package controllers;

import play.*;

import play.mvc.*;

import views.html.*;
import java.util.List;

import com.avaje.ebean.Ebean;

import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import models.Student;


public class Application extends Controller {

    public static Result index() {
        	return ok(index.render(Ebean.find(Student.class).findList()));
    }
    
    public static Result create() {
    
		    Form<Student> form  = Form.form(Student.class).bindFromRequest();
		        
		    if(form.hasErrors()){	    	
		    	flash().put("error", "yes");  //esto lo pongo cuando en el view use el if en vez de @flash.get("error")   	
		  	 	    	
		    	for(String propertyName: form.errors().keySet()){
		    		List<ValidationError> errorsForThisField = form.errors().get(propertyName);    		
		    		ValidationError firstErrorForThisField = errorsForThisField.get(0);
		    		String errorMessage = firstErrorForThisField.message();		    		 		
		    		flash().put(propertyName, errorMessage);		    		
		    	}
		    }else{
		    	Student student = form.get();
		    	Ebean.save(student);
		    }
		    return redirect(routes.Application.index());
	}		
}
