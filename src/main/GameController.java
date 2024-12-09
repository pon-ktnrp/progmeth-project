package main;

import java.util.ArrayList;

import logic.pal.*;

public class GameController {
	private static GameController instance = new GameController();
	private ArrayList<BasePal> pals;
	private int wave;
	
	public GameController() {
		pals = new ArrayList<BasePal>() ;
	}
	
	public static GameController getInstance() {
		return instance;
	}
	
	public int getWave() {
		return wave;
	}
	
	public void nextWave() {
		wave++;
	}
	
	public boolean isGameover() {
		for (BasePal pal:pals) {
			if(!pal.isFainted() & wave < 50) return false;
		}
		return true;
	}
	
	public boolean isTeamfull() {
		return pals.size() == 4;
	}
	
	public BasePal getPal(int index) {
		return pals.get(index);
	}
	
	public void addPal(BasePal newpals) {
		if(!isTeamfull()) {
			pals.add(newpals);
			System.out.println("|===============================================================|");
			System.out.println("                " + newpals.getName() + " already join your team!");
			System.out.println("|===============================================================|");
		}
	}
}
