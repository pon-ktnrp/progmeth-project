package logic.item;

import logic.pal.BasePal;

public class Potion extends BaseConsumption {

	public Potion(int quantity) {
		super("Potion", "Heal Pal a bit.", quantity, 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BasePal target) {
		// TODO Auto-generated method stub
		target.heal(target.getMaxHp() * getEffectValue()/100);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
