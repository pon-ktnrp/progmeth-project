package main;

import java.util.ArrayList;

import logic.item.*;
import logic.pal.*;

public class GameController {
	private static GameController instance = new GameController();
	private ArrayList<BasePal> pals;
	private ArrayList<BaseItem> items;
	private BasePal selectPal;
	private int wave;
	
	public GameController() {
		pals = new ArrayList<BasePal>() ;
		items = new  ArrayList<BaseItem>() ;
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
			if(!pal.isFainted() & wave <= 50) return false;
		}
		return true;
	}
	
	public boolean isTeamfull() {
		return pals.size() == 4;
	}
	
	public ArrayList<BasePal> getPals(){
		return this.pals;
	}
	
	public BasePal getPal(int index) {
		return pals.get(index);
	}
	
	public void addPal(BasePal newpals) {
		if(!isTeamfull()) {
			pals.add(newpals);
			System.out.println("|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
			System.out.println("|               " + newpals.getName() + " already join your team!");
			System.out.println("|_______________________________________________________________|\n");
		}
	}
	
	public BasePal getSelectPal() {
		return this.selectPal;
	}
	
	public void setSelectPal(int index) {
		this.selectPal = pals.get(index);
	}
	
	public ArrayList<BaseItem> getItems(){
		return items;
	}
	
	public BaseItem getItem(int index){
		return items.get(index);
	}
	
	public void addItem(BaseItem newItem) {
		boolean found = false;
		for(int i = 0 ; i < items.size() ; i++) {
			if(items.get(i).getName().equals(newItem.getName())) {
				items.get(i).addQuantity(newItem.getQuantity());
				found = true;
			}
		}
		if(!found) {
			items.add(newItem);
		}
	}
}
