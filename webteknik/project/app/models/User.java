package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int userid;
    private String firstname;
    private String surname;
    private String street_adress;
    private String town;
    private String postcode;
    private String mobile;
    private String email;
    private String password;
    
    
    @OneToMany(mappedBy = "user")
	private List<Cart> carts;
    
    public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public User() {
 
    }
    public User(String firstname, String surname, String street_adress, String town, String postcode, String mobile, String email, String password) {

    	this.firstname = firstname;
        this.surname = surname;
        this.street_adress = street_adress;
        this.town = town;
        this.postcode = postcode;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
 
    }
    public User(int userid, String firstname, String surname, String street_adress, String town, String postcode, String mobile, String email, String password) {
        this.userid = userid;
    	this.firstname = firstname;
        this.surname = surname;
        this.street_adress = street_adress;
        this.town = town;
        this.postcode = postcode;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
 
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getSurname() {
        return surname;
    }
 
    public void setSurname(String surname) {
        this.surname = surname;
    }
 
    public String getStreet_adress() {
        return street_adress;
    }
 
    public void setStreet_adress(String street_adress) {
        this.street_adress = street_adress;
    }
 
    public String getTown() {
        return town;
    }
 
    public void setTown(String town) {
        this.town = town;
    }
 
    public String getPostcode() {
        return postcode;
    }
 
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
 
    public String getMobile() {
        return mobile;
    }
 
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
