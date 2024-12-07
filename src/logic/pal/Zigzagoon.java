package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Zigzagoon extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Zigzagoon(int level) {
		super("Zigzagoon", Type.NORMAL, level);
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
		return new Linoone(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 38;
		this.baseAtk = 30;
		this.baseDef = 41;
		this.baseSpAtk = 30;
		this.baseSpDef = 41;
		this.baseSpd = 60;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Pin Missile", Type.GRASS, MoveType.PHYSICAL, 40, 95));
	}
}
