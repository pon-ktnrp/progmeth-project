package logic.item;

import logic.pal.BasePal;

public abstract class BaseItem {
    protected String name;
    protected String description;
    protected int quantity;
    
    public BaseItem(String name, String description) {
    	setName(name);
    	setDescription(description);
    	setQuantity(1);
    }
    
    public BaseItem(String name, String description, int quantity) {
    	setName(name);
    	setDescription(description);
    	setQuantity(quantity);
    }
    
    public abstract void use(BasePal target);
    
	public String getName() {
		return name;
	}
 
    public void setName(String name) {
    	this.name = name;
    	if (name.isBlank()) {
            this.name = "Unnamed Item";
        }
    }
    

	public String getDescription() {
		return description;
	}
    
    public void setDescription(String description) {
    	this.description = description;
    	if (name.isBlank()) {
            this.name = "No Description Item";
        }
    }
    
    public void addQuantity(int amount) {
    	this.quantity += amount;
    }
    
    public int getQuantity() {
    	return quantity;
    }
    
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    	if(this.quantity < 0) {
    		this.quantity = 0;
    	}
    }
    
    public void reduceQuantity(int amount) {
    	setQuantity(getQuantity() - amount);
    }

	@Override
	public abstract String toString();
	
}

