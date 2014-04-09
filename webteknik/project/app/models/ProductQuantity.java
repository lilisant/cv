package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductQuantity {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Cart cart;
	@ManyToOne
	private Product product;
	private int qty;
	
	public ProductQuantity(){

	}
	
	public int getId() {
		return id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setProduct(Product product) {
		
		this.product = product;
	}
	
	public Product getProduct(){
		return product;
	}
	
	public Cart getCart(){
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
		
	}

	@Override
	public String toString() {
		return "ProductQuantity [id=" + id + ", cart=" + cart + ", product="
				+ product + ", qty=" + qty + "]";
	}
	
	
	
	

}
