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
		System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
		System.out.println("|                    Choose your starter Pal                    |");
		System.out.println("|---------------------------------------------------------------|");
		System.out.println("|       <1> Bulbasaur     <2> Charmander     <3> Squirtle       |");
		System.out.println("|_______________________________________________________________|");
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
		instance.setSelectPal(0);
		startGameFlow();
	}
	
	public static void startGameFlow() {
		while(!instance.isGameover()) {
			instance.nextWave();
			System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
			System.out.println("|                        Wave " + instance.getWave() + " Start!");
			System.out.println("|_______________________________________________________________|\n");
			BasePal enemy = new Bulbasaur(5);
			while(true) {
				System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
				System.out.println("|    My's " + instance.getSelectPal().getName() + " HP:" + instance.getSelectPal().getHp() + "/" +  instance.getSelectPal().getMaxHp() + " Vs. Enemy's " + enemy.getName() + " HP:" + enemy.getHp() + "/" +  instance.getSelectPal().getMaxHp());
				System.out.println("|---------------------------------------------------------------|");
				System.out.println("|              <1> Battle     <2> Pals     <3> Bag              |");
				System.out.println("|_______________________________________________________________|\n");
				int action = inputCheck(1,3);
				switch(action) {
				case 1:
					System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
					System.out.println("| " + instance.getSelectPal().getName() + "'s Move");
					for(int i = 0 ; i < instance.getSelectPal().getMoves().size() ; i++) {
						System.out.println("| <" + (i+1) + "> " + instance.getSelectPal().getMoves().get(i).toString() );
					}
					System.out.println("|_______________________________________________________________|\n");
					int move = inputCheck(1,instance.getSelectPal().getMoves().size());
					int enemyMove = new Random().nextInt(enemy.getMoves().size());
					
					int selectedPalSpeed = instance.getSelectPal().getSpd();
					if(selectedPalSpeed >= enemy.getSpd()) {
						instance.getSelectPal().useMove(move-1, enemy);
						enemy.useMove(enemyMove, instance.getPal(0));
					}
					else if(selectedPalSpeed < enemy.getSpd()) {
						enemy.useMove(enemyMove, instance.getPal(0));
						instance.getSelectPal().useMove(move-1, enemy);
					}
						
					break;
				case 2:
					if(instance.getPals().size() <= 1) {
						System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
						System.out.println("|            *** Don't have enough Pal to switch ***            |");
						System.out.println("|_______________________________________________________________|\n");
						break;
					}
					System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
					System.out.println("| Switch " + instance.getSelectPal().getName() + " to " );
					for(int i = 0 ; i < instance.getPals().size() ; i++) {
						if(!instance.getPal(i).equals(instance.getSelectPal())) {
							System.out.println("| <" + (i+1) + "> " + instance.getPal(i).getName() );
						}
					}
					System.out.println("|_______________________________________________________________|\n");
					int switchToPal = inputCheck(1,instance.getPals().size());
					instance.setSelectPal(switchToPal-1);
					System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
					System.out.println("|                  Already switch to " + instance.getSelectPal().getName());
					System.out.println("|_______________________________________________________________|\n");
					break;
				}
				if(enemy.isFainted()) {
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
