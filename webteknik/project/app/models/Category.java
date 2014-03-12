package models;

public class Category {
	private int id;
    private String name;
    
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
}
