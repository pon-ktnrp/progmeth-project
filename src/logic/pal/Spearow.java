package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Spearow extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Spearow(int level) {
		super("Spearow", Type.NORMAL, level);
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
		return new Fearow(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 40;
		this.baseAtk = 60;
		this.baseDef = 30;
		this.baseSpAtk = 31;
		this.baseSpDef = 31;
		this.baseSpd = 70;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Peck", Type.NORMAL, MoveType.PHYSICAL, 35, 100));
	}
}
