package logic.game;

import java.util.ArrayList;
import logic.pal.BasePal;

public class GameController {
	private int money; // Initial money value
	private int pocket; // Initial pocket value
	private int xHp;
	private int xAtt;
	private int xDef;
	private int xSpAtt;
	private int xSpDef;
	private int xSpeed;
	private static GameController instance;
	private ArrayList<BasePal> pals;

	private GameController() {
		this.pals = new ArrayList<>();
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
		this.xHp = this.xAtt = this.xDef = this.xSpAtt = this.xSpDef = this.xSpeed = 0; // Reset stats
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


	public ArrayList<BasePal> getPals() {
		return pals;
	}

	public void setPals(ArrayList<BasePal> pals) {
		this.pals = pals;
	}

	public boolean isGameOver() {
		for (BasePal entity : pals) {
			if (!entity.isFainted())
				return false;
		}
		return true;
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
}
