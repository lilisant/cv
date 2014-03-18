package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Product {
	
	@Id
	private int id;
	private String name;
	private double price;
	private String catId;

	public Product(int id, String name, double price, String catId){
		this.id = id;
		this.name = name;
		this.price = price;
		this.setCatId(catId);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}
}