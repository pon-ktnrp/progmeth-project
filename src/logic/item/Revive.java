package logic.item;

import logic.pal.BasePal;

public class Revive extends BaseConsumption {

	public Revive(int quantity) {
		super("Revive", "Revive fainted Pal and restore some health", quantity, 50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(BasePal target) {
		// TODO Auto-generated method stub
		if(target.isFainted()) {
			reduceQuantity(1);
			target.heal(target.getMaxHp() * getEffectValue()/100);
			System.out.println(target.getName() + " was revive.");
		}
		else {
			System.out.println("Can't use revive.");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
