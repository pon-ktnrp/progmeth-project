package logic.item;

import logic.pal.BasePal;

public abstract class BaseConsumption extends BaseItem{
	private int effectValue;
	
	public BaseConsumption(String name, String description, int quantity, int effectValue) {
		super(name,description,quantity);
		setEffectValue(effectValue);
	}

	public int getEffectValue() {
		return effectValue;
	}

	public void setEffectValue(int effectValue) {
		this.effectValue = effectValue;
	}
	
}
