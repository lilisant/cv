package models;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int id;
    private String name;
    
    @ManyToMany(mappedBy="categories")
    private List<Product> products;
    
    public Category(){
    	
    }
    public Category(String name){
    	this.name = name;
    }
    public Category(int id, String name){
    	this.id = id;
    	this.name = name;
    }
 
    public String getName() {
        return name;
    }
 

    public void setName(String name) {
        this.name = name;
    }
 
    public int getid() {
        return id;
    }
 
    public void setid(int id) {
        this.id = id;
    }
	public List<Product> getProductsCategory() {
        return products;
    }
 
    public void setProductsCategory(List<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
