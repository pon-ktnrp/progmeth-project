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
	protected int baseHp;
	protected int maxHp;
	protected int hp;
	protected int baseAtk;
	protected int atk;
	protected int baseDef;
	protected int def;
	protected int baseSpAtk;
	protected int spAtk;
	protected int baseSpDef;
	protected int spDef;
	protected int baseSpd;
	protected int spd;
	protected ArrayList<Move> moves;
	//protected int captureRate;
	
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
        if(isFainted()) {
        	System.out.println(name + " is fainted.");
        }
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
		if (!isFainted()) {
	        if (moveIndex >= 0 && moveIndex < moves.size()) {
	            Move move = this.moves.get(moveIndex);
	            move.execute(this, target);
	        } else {
	            System.out.println("Invalid move!");
	        }
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getBaseHp() {
		return baseHp;
	}

	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getBaseAtk() {
		return baseAtk;
	}

	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getBaseDef() {
		return baseDef;
	}

	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getBaseSpAtk() {
		return baseSpAtk;
	}

	public void setBaseSpAtk(int baseSpAtk) {
		this.baseSpAtk = baseSpAtk;
	}

	public int getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	public int getBaseSpDef() {
		return baseSpDef;
	}

	public void setBaseSpDef(int baseSpDef) {
		this.baseSpDef = baseSpDef;
	}

	public int getSpDef() {
		return spDef;
	}

	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	public int getBaseSpd() {
		return baseSpd;
	}

	public void setBaseSpd(int baseSpd) {
		this.baseSpd = baseSpd;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}

	@Override
	public String toString() {
		return "BasePal [name=" + name + ", type=" + type + ", level=" + level + ", exp=" + exp + ", baseHp=" + baseHp
				+ ", maxHp=" + maxHp + ", hp=" + hp + ", baseAtk=" + baseAtk + ", atk=" + atk + ", baseDef=" + baseDef
				+ ", def=" + def + ", baseSpAtk=" + baseSpAtk + ", spAtk=" + spAtk + ", baseSpDef=" + baseSpDef
				+ ", spDef=" + spDef + ", baseSpd=" + baseSpd + ", spd=" + spd + ", moves=" + moves + "]";
	}
	
}
