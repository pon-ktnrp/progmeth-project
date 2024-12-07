package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Rattata extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Rattata(int level) {
		super("Rattata", Type.NORMAL, level);
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
		return new Raticate(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 30;
		this.baseAtk = 56;
		this.baseDef = 35;
		this.baseSpAtk = 25;
		this.baseSpDef = 35;
		this.baseSpd = 72;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Quick Attack", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
	}
}
