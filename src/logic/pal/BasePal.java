package logic.pal;

import java.util.ArrayList;

import logic.move.Move;
import utils.Type;

public abstract class BasePal {
	
	//Pal's fields
	protected String name;
	protected Type type;
	protected int level;
	protected int exp;
	protected int maxHp;
	protected int hp;
	protected int atk;
	protected int def;
	protected int spAtk;
	protected int spDef;
	protected int spd;
	protected ArrayList<Move> moves;
	protected int captureRate;
	protected int baseHp;
	protected int baseAtk;
	protected int baseDef;
	protected int baseSpAtk;
	protected int baseSpDef;
	protected int baseSpd;
	
	//Pal's method
	public BasePal(String name, Type type, int level){
		this.name = name;
		this.type = type;
		this.level = level;
		this.moves = new ArrayList<Move>();
	}
	
	public abstract void initializeStats();
    public abstract void initializeMoves();
	
	public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }
	
	public void heal(int amount) {
        this.hp += amount;
        if (this.hp > maxHp) this.hp = maxHp;
    }
	
	public boolean isFainted() {
        return this.hp <= 0;
    }
	
	public void gainExp(int amount) {
        this.exp += amount;
        if (this.exp >= getExpThreshold()) {
            this.exp -= getExpThreshold();
        	levelUp();
        }
    }

	public int getExpThreshold() {
        return level * 100; // Example EXP threshold formula
    }
	
    public void levelUp() {
        this.level++;
        updateStat();
    }
	
	public void useMove(int moveIndex, BasePal target) {
        if (moveIndex >= 0 && moveIndex < moves.size()) {
            Move move = this.moves.get(moveIndex);
            move.execute(this, target);
        } else {
            System.out.println("Invalid move!");
        }
    }
	
	public void updateStat() {
		this.maxHp = (int) (0.02 * baseHp * level) + baseHp + 10;
        this.atk = (int) (0.02 * baseAtk * level) + 5;
        this.def = (int) (0.02 * baseDef * level) + 5;
        this.spAtk = (int) (0.02 * baseSpAtk * level) + 5;
        this.spDef = (int) (0.02 * baseSpDef * level) + 5;
        this.spd = (int) (0.02 * baseSpd * level) + 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	public int getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	public int getSpDef() {
		return spDef;
	}

	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
