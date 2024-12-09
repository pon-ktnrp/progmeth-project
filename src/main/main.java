package main;

import logic.pal.*;
import logic.item.*;

import java.util.Random;
import java.util.Scanner;

public class main {
	private static Scanner sc;
	private static GameController instance = GameController.getInstance(); 
	
	public static void main(String[] args) {
//		System.out.print(new Bulbasaur(10).getType());
//		BasePal slave = new Zygarde(50);
//		BasePal master = new Charizard(45);
//		BaseConsumption revive = new Revive(1);
//		
//		System.out.println(slave.getHp());
//		
//		master.useMove(3, slave);
//		System.out.println(slave.getHp());
//		//revive.use(slave);
//		slave.useMove(1, master);
//		System.out.println(master.getHp());
//		
//		master.useMove(3, slave);
//		System.out.println(slave.getHp());
//		//revive.use(slave);
//		
//		System.out.print(slave.getHp());
//		
//		BasePal test = new Mewtwo(50);
//		BaseCapture balls = new PalBall(1);
//		
//		test.takeDamage(200);
//		
//		balls.tryCapture(test);
		sc = new Scanner(System.in);
		System.out.println("|===============================================================|");
		System.out.println("|=                   Choose your starter Pal                   =|");
		System.out.println("|===============================================================|");
		System.out.println("|=      <1> Bulbasaur     <2> Charmander     <3> Squirtle      =|");
		System.out.println("|===============================================================|");
		int choice = inputCheck(1, 3);
		switch(choice) {
		case 1:
			instance.addPal(new Bulbasaur(5));
			break;
		case 2:
			instance.addPal(new Charmander(5));
			break;
		case 3:
			instance.addPal(new Squirtle(5));
			break;
		}
		startGameFlow();
	}
	
	public static void startGameFlow() {
		instance.nextWave();
		while(!instance.isGameover()) {
			System.out.println("+---------------------------------------------------------------+");
			System.out.println("                         Wave " + instance.getWave() + " Start!");
			System.out.println("+---------------------------------------------------------------+");
			BasePal enemy = new Bulbasaur(5);
			while(true) {
				//System.out.println("|===============================================================|");
				System.out.println("        My's " + instance.getPal(0).getName() + " HP:" + instance.getPal(0).getHp() + " Vs. Enemy's " + enemy.getName() + " HP:" + enemy.getHp());
				System.out.println("|_______________________________________________________________|");
				int move = inputCheck(0, instance.getPal(0).getMoves().size() - 1);
				int enemyMove = new Random().nextInt(enemy.getMoves().size());
				instance.getPal(0).useMove(move, enemy);
				enemy.useMove(enemyMove, instance.getPal(0));
				if (enemy.isFainted()) {
					instance.nextWave();
					break;
				}
			}
		}
	}
	
    public static int inputCheck(int lowestInput, int highestInput) {
        int choice = sc.nextInt();
        while (choice < lowestInput || choice > highestInput) {
            System.out.println("Invalid input");
            choice = sc.nextInt();
        }
        return choice;
    }
}
