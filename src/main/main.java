package main;

import logic.pal.*;
import logic.item.*;

public class main {
	public static void main(String[] args) {
//		System.out.print(new Bulbasaur(10).getType());
		BasePal slave = new Mewtwo(50);
		BasePal master = new Charizard(45);
		
		System.out.println(slave.getHp());
		
		master.useMove(3, slave);
		
		System.out.println(slave.getHp());
		
		BaseConsumption potion = new SuperPotion(1);
		
		potion.use(slave);
		
		System.out.print(slave.getHp());
	}
}
