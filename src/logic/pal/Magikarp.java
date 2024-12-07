package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Magikarp extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Magikarp(int level) {
		super("Magikarp",Type.WATER,level);
		initializeStats();
		initializeMoves();
	}
	
	@Override
	public boolean isEvolvable() {
		// TODO Auto-generated method stub
		return this.level >= evolutionLevel;
	}
	
	@Override
	public BasePal evolve() {
		// TODO Auto-generated method stub
		return new Gyarados(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 20;
		this.baseAtk = 10;
		this.baseDef = 55;
		this.baseSpAtk = 15;
		this.baseSpDef = 20;
		this.baseSpd = 80;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Struggle", Type.NORMAL, MoveType.PHYSICAL, 50, 100));
	}
}
