package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	public int id;
	@Required
	@MinLength(2)
	@MaxLength(10)
	public String name;
	@Required
	@MaxLength(10)
	public String surname;
	public boolean wearsGlasses;
	@Email
	@MaxLength(5)
	public String email;

}
