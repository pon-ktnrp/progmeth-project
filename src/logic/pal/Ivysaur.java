package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Ivysaur extends BasePal implements Evolvable {
	private final int evolutionLevel = 32 ;

	public Ivysaur(int level) {
		super("Ivysaur",Type.GRASS,level);
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
		return new Venusaur(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 60;
		this.baseAtk = 62;
		this.baseDef = 63;
		this.baseSpAtk = 80;
		this.baseSpDef = 80;
		this.baseSpd = 60;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Vine Whip", Type.GRASS, MoveType.PHYSICAL, 45, 100));
		this.moves.add(new Move("Razor Leaf", Type.GRASS, MoveType.PHYSICAL, 55, 95));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
	}
}
