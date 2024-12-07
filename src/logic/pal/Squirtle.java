package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Squirtle extends BasePal implements Evolvable {
	private final int evolutionLevel = 16 ;
	
	public Squirtle(int level) {
		super("Squirtle",Type.WATER,level);
		initializeStats();
		initializeMoves();
	}
	
	@Override
	public boolean isEvolvable() {
		// TODO Auto-generated method stub
		return this.level >= evolutionLevel;
	}
	
	@Override
	public void evolve() {
		// TODO Auto-generated method stub
		if(isEvolvable()) {
			
		}
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 44;
		this.baseAtk = 48;
		this.baseDef = 65;
		this.baseSpAtk = 50;
		this.baseSpDef = 64;
		this.baseSpd = 43;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Water Gun", Type.WATER, MoveType.PHYSICAL, 40, 100));
	}
}
