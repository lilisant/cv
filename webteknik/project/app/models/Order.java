package models;

import java.util.Date;

public class Order {
	private int orderId;
	private int userid;
	private Date dateOrder;
	
	public Order(int orderId, int userid, Date dateOrder){
		this.setOrderId(orderId);
		this.setUserid(userid);
		this.setDateOrder(dateOrder);
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
	
}
