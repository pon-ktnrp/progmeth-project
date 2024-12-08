package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Bulbasaur extends BasePal implements Evolvable {
	private final int evolutionLevel = 16 ;
	
	public Bulbasaur(int level) {
		super("Bulbasaur",Type.GRASS,level);
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
		return new Ivysaur(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 45;
		this.baseAtk = 49;
		this.baseDef = 49;
		this.baseSpAtk = 65;
		this.baseSpDef = 65;
		this.baseSpd = 45;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Vine Whip", Type.GRASS, MoveType.PHYSICAL, 45, 100));
	}
}
