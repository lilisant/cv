package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private User user;
	

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE)
	private List<ProductQuantity> productQuantities;

	
	public Cart(){

	}
	
	public Cart(User user){
		this.user = user;	
	}
		
	public int getId() {
		return id;
	}

	public void setUser(User user) {
		
		this.user = user;	
		
	}
	public User getUser() {
		
		return user;	
		
	}

	public List<ProductQuantity> getProductQuantities() {
		return productQuantities;
	}

	
}
