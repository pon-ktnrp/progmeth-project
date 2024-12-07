package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Charmeleon extends BasePal implements Evolvable {
	
	private final int evolutionLevel = 36 ;
	
	public Charmeleon(int level) {
		super("Charmeleon",Type.FIRE,level);
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
		return new Charizard(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 58;
		this.baseAtk = 64;
		this.baseDef = 58;
		this.baseSpAtk = 80;
		this.baseSpDef = 65;
		this.baseSpd = 80;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Fire Fang", Type.FIRE, MoveType.PHYSICAL, 65, 95));
		this.moves.add(new Move("Flamethrower", Type.FIRE, MoveType.SPECIAL, 90, 100));
	}
}
