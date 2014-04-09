package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	@ManyToOne
	private User user;
	private Date dateOrder;
	
	@OneToMany(mappedBy = "order")
	private List<ProductsInOrder> productsOrder;
	
	public Order(){

	}
	public Order(int orderId, User user, Date dateOrder){
		this.setOrderId(orderId);
		this.setUser(user);
		this.setDateOrder(dateOrder);
		
	}


	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void setOrdersProd(List<ProductsInOrder> productsOrder) 
	{
	        this.productsOrder = productsOrder;
	    }
	public List<ProductsInOrder> getOrdersProd() {
		return productsOrder;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
