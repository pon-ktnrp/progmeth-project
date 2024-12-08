package logic.item;

public abstract class BaseConsumption extends BaseItem{
	private int effectValue;
	
	public BaseConsumption(String name, String description, int quantity, int effectValue) {
		super(name,description,quantity);
		this.effectValue = effectValue;
	}
	
	public abstract void use();
}
