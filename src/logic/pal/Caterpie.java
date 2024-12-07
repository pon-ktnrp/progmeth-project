package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Caterpie extends BasePal implements Evolvable {
	private final int evolutionLevel = 7;
	
	public Caterpie(int level) {
		super("Caterpie",Type.GRASS,level);
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
		return new Metapod(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 45;
		this.baseAtk = 30;
		this.baseDef = 35;
		this.baseSpAtk = 20;
		this.baseSpDef = 20;
		this.baseSpd = 45;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Bug Bite", Type.GRASS, MoveType.PHYSICAL, 60, 100));
	}
}
