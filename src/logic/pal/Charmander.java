package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Charmander extends BasePal implements Evolvable {
	
	private final int evolutionLevel = 16 ;
	
	public Charmander(int level) {
		super("Charmander",Type.FIRE,level);
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
		return new Charmeleon(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 39;
		this.baseAtk = 52;
		this.baseDef = 43;
		this.baseSpAtk = 60;
		this.baseSpDef = 50;
		this.baseSpd = 65;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Ember", Type.FIRE, MoveType.SPECIAL, 40, 100));
	}
}
