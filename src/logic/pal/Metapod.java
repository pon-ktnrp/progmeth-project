package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Metapod extends BasePal implements Evolvable {
	private final int evolutionLevel = 10;
	
	public Metapod(int level) {
		super("Metapod",Type.GRASS,level);
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
		return new Butterfree(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 50;
		this.baseAtk = 20;
		this.baseDef = 55;
		this.baseSpAtk = 25;
		this.baseSpDef = 25;
		this.baseSpd = 30;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Struggle", Type.NORMAL, MoveType.PHYSICAL, 50, 100));
	}
}
