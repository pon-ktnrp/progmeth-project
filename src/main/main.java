package main;

import logic.pal.*;
import logic.item.*;

public class main {
	public static void main(String[] args) {
		//System.out.print(new Bulbasaur(10).getType());
		BasePal slave = new Venusaur(32);
		BasePal master = new Charmander(16);
		
		System.out.println(slave.getHp());
		
		master.useMove(1, slave);
		
		System.out.println(slave.getHp());
		
		BaseConsumption potion = new Potion(1);
		
		potion.use(slave);
		
		System.out.print(slave.getHp());
	}
}
