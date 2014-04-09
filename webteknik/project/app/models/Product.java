package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity

public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private int stock;
	@ManyToMany
	private List<Category> categories;
	public Product(){

	}
	public Product(String name, double price, List<Category> categoriesProd){
		this.name = name;
		this.price = price;
		this.categories = categoriesProd;
	}

	public Product(int id, String name, double price, List<Category> categoriesProd){
		this.id = id;
		this.name = name;
		this.price = price;
		this.categories = categoriesProd;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
	    this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
	     this.price = price;
	}
	
	public List<Category> getCategoriesProd() {
        return categories;
    }
 
    public void setCategoriesProd(List<Category> categories) {
        this.categories = categories;
    }
    @Override
    public String toString(){
        return name;
    }
	@Override
	public int hashCode()
	{
		int result = 1;
		result += 37 * this.name.hashCode();
		result += 37 * this.getClass().hashCode();

		return result;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}