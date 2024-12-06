package Pal;

import java.util.ArrayList;

import Move.Move;

public abstract class BasePal {
	
	//Pal's fields
	private String name;
	private Type type;
	private int level;
	private int exp;
	private int maxHp;
	private int hp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int spd;
	private ArrayList<Move> moveSet;
	private int captureRate;
	
	//Pal's method
	public BasePal(String name, Type type, int level){
		this.name = name;
		this.type = type;
		this.level = level;
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
	
    private void levelUp() {
        this.level++;
    }
	
	public void useMove(int moveIndex, BasePal target) {
        if (moveIndex >= 0 && moveIndex < moveSet.size()) {
            Move move = this.moveSet.get(moveIndex);
            move.execute(this, target);
        } else {
            System.out.println("Invalid move!");
        }
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
