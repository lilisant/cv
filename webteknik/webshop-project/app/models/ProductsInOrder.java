package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductsInOrder {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne	
	private Product product;
	
	@ManyToOne
	private Order order;
	
	private int qty;
	
    public ProductsInOrder(){
    	
    }

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	public Product getProduct(){
		return product;
	}
	public void setProduct(Product product){
		this.product = product;
	}
	public void setOrder(Order order){
		this.order = order;
	}

}
