package logic.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import logic.item.BaseItem;
import logic.item.PalBall;
import logic.pal.BasePal;
import logic.pal.Bulbasaur;
import logic.pal.Charmander;
import logic.pal.Squirtle;
import logic.state.StateRoute1;

public class GameController {
	private int money; // Initial money value
	private int pocket; // Initial pocket value
	private int xHp;
	private int xAtt;
	private int xDef;
	private int xSpAtt;
	private int xSpDef;
	private int xSpeed;
	private int wave;
	private static GameController instance;
	private ArrayList<BasePal> pals;
	private BasePal selectPal;
	private ArrayList<BasePal> enemy;
	private LinkedHashMap<String,Integer> items;

	private GameController() {
		this.pals = new ArrayList<>();
		this.enemy = new ArrayList<>();
		items = new  LinkedHashMap<>();
		items.put("PalBall", 0);
		items.put("PokeBall", 0);
		items.put("Potion", 0);
		items.put("SuperPotion", 0);
		items.put("Revive", 0);
		initGame();
	}

	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private void initGame() {
		this.money = 100; // Reset money
		this.pocket = 1000; // Reset pocket
		this.wave = this.xHp = this.xAtt = this.xDef = this.xSpAtt = this.xSpDef = this.xSpeed = 0; // Reset stats
		this.enemy.add(StateRoute1.generateRandomPal(5));
		this.enemy.add(StateRoute1.generateRandomPal(5));
		this.enemy.add(StateRoute1.generateRandomPal(5));
		this.enemy.add(StateRoute1.generateRandomPal(5));
		this.enemy.add(StateRoute1.generateRandomPal(5));
		this.enemy.add(StateRoute1.generateRandomPal(5));
//		this.enemy.add(new Charmander(3));
//		this.enemy.add(new Squirtle(3));
//		this.enemy.add(new Bulbasaur(3));
		
	}

	public void resetGame() {
		initGame();
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPocket() {
		return pocket;
	}

	public void setPocket(int pocket) {
		this.pocket = pocket;
	}

	public int getxHp() {
		return xHp;
	}

	public void setxHp(int xHp) {
		this.xHp = xHp;
	}

	public int getxAtt() {
		return xAtt;
	}

	public void setxAtt(int xAtt) {
		this.xAtt = xAtt;
	}

	public int getxDef() {
		return xDef;
	}

	public void setxDef(int xDef) {
		this.xDef = xDef;
	}

	public boolean isTeamfull() {
		return pals.size() == 6;
	}

	public ArrayList<BasePal> getPals() {
		return pals;
	}
	
	public BasePal getPal(int index) {
		return pals.get(index);
	}
	
	public BasePal getSelectPal() {
		return this.selectPal;
	}
	
	public void setSelectPal(int index) {
		this.selectPal = pals.get(index);
	}


	public void addPals(BasePal newpals) {
		int damage = newpals.getMaxHp()-newpals.getHp();
		newpals.setBaseHp((int)((1+xHp/5.0)*newpals.getBaseHp()));
		newpals.setBaseAtk((int)((1+xAtt/5.0)*newpals.getBaseAtk()));
		newpals.setBaseDef((int)((1+xDef/5.0)*newpals.getBaseDef()));
		newpals.setBaseSpAtk((int)((1+xSpAtt/5.0)*newpals.getSpAtk()));
		newpals.setBaseSpDef((int)((1+xSpDef/5.0)*newpals.getSpDef()));
		newpals.setBaseSpd((int)((1+xSpeed/5.0)*newpals.getSpd()));
		newpals.updateStat();
		newpals.setHp(newpals.getMaxHp()-damage);
		pals.add(newpals);
	}

	public boolean isGameOver() {
		for (BasePal entity : pals) {
			if (!entity.isFainted())
				return false;
		}
		return true;
	}

	public void nextWave() {
		wave++;
	}

	public int getxSpAtt() {
		return xSpAtt;
	}

	public void setxSpAtt(int xSpAtt) {
		this.xSpAtt = xSpAtt;
	}

	public int getxSpDef() {
		return xSpDef;
	}

	public void setxSpDef(int xSpDef) {
		this.xSpDef = xSpDef;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getWave() {
		return wave;
	}

	public void setWave(int wave) {
		this.wave = wave;
	}

	public ArrayList<BasePal> getEnemy() {
		return enemy;
	}

	public void setEnemy(ArrayList<BasePal> enemy) {
		this.enemy = enemy;
	}

	
	public void addItem(BaseItem newItem) {
		String nameItem = newItem.getName();
		items.put(nameItem, newItem.getQuantity()+items.get(nameItem));
	}

	public LinkedHashMap<String, Integer> getItems() {
		return items;
	}

	public void setItems(LinkedHashMap<String, Integer> items) {
		this.items = items;
	}


}
