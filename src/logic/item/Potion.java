package logic.item;

import logic.pal.BasePal;

public class Potion extends BaseConsumption {

	public Potion(int quantity) {
		super("Potion", "Restore some of your Pal's health", quantity, 25);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BasePal target) {
		// TODO Auto-generated method stub
		target.heal(target.getMaxHp() * getEffectValue()/100);
	}

	@Override
	public String toString() {
		return "Potion [name=" + name + ", description=" + description + ", quantity=" + quantity + "]";
	}

}
