package logic.item;

import logic.pal.BasePal;

public class SuperPotion extends BaseConsumption {

	public SuperPotion(int quantity) {
		super("Super Potion", "Restores a significant amount of your Pal's health.", quantity, 50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BasePal target) {
		// TODO Auto-generated method stub
		if(target.isFainted()) {
			System.out.println("Can't heal fainted Pal.");
		}
		else {
			reduceQuantity(1);
			target.heal(target.getMaxHp() * getEffectValue()/100);
		}
	}

	@Override
	public String toString() {
		return "SuperPotion [name=" + name + ", description=" + description + ", quantity=" + quantity + "]";
	}

}
