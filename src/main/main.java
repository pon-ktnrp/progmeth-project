package main;

import logic.pal.*;
import logic.item.*;

public class main {
	public static void main(String[] args) {
//		System.out.print(new Bulbasaur(10).getType());
		BasePal slave = new Zygarde(50);
		BasePal master = new Charizard(45);
		BaseConsumption revive = new Revive(1);
		
		System.out.println(slave.getHp());
		
		master.useMove(3, slave);
		System.out.println(slave.getHp());
		//revive.use(slave);
		slave.useMove(1, master);
		System.out.println(master.getHp());
		
		master.useMove(3, slave);
		System.out.println(slave.getHp());
		//revive.use(slave);
		
		System.out.print(slave.getHp());
		
//		BasePal test = new Mewtwo(50);
//		BaseCapture balls = new PalBall(1);
//		
//		test.takeDamage(200);
//		
//		balls.tryCapture(test);
	}
}
