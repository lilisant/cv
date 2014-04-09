package controllers;

import java.util.List;
import java.util.Map;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class User extends Controller {
	
	    @Transactional
		public static Result newUser(){    	
		    	Map<String, String[]> form = request().body().asFormUrlEncoded();
				
				String email = form.get("email")[0];
				String passwd = form.get("password")[0];
				
				boolean usernameIsEmpty = "".equals(email);
				boolean passwordIsEmpty = "".equals(passwd);
				if(usernameIsEmpty || passwordIsEmpty){
						if(usernameIsEmpty){
								flash().put("email-empty", "yes");
						}
						if(passwordIsEmpty){
								flash().put("password-empty", "yes");
						}
			    		return redirect(routes.User.showUserForm());
				}	    	
				models.User user = new models.User();
				user.setFirstname(form.get("firstname")[0]);
				user.setSurname(form.get("surname")[0]);
				user.setEmail(email);
				user.setPassword(passwd);
				JPA.em().persist(user);
				return redirect(routes.User.listAllUsers());	    	
		}
	    
		@Transactional
		public static Result showUserForm(){
				List<models.User> users = JPA.em().createQuery("SELECT a from User AS a", models.User.class).getResultList();
				return ok(newuser.render(users));
		}
						
	    @Transactional
		public static Result showUser(int id){
				models.User user = JPA.em().find(models.User.class, id);	
				return ok(showUser.render(user));
	    }
	        
	    @Transactional
		public static Result listAllUsers(){
				List<models.User> users = JPA.em().createQuery("SELECT a FROM User a", models.User.class).getResultList();
				return ok(listalluser.render(users));
		}	
}
