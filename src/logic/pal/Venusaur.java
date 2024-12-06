package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Venusaur extends BasePal {
	public Venusaur(String name, Type type, int level) {
		super("Venusaur",Type.GRASS,level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 80;
		this.baseAtk = 82;
		this.baseDef = 83;
		this.baseSpAtk = 100;
		this.baseSpDef = 100;
		this.baseSpd = 80;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Seed Bomb", Type.GRASS, MoveType.PHYSICAL, 80, 100));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
		this.moves.add(new Move("Power Whip", Type.GRASS, MoveType.PHYSICAL, 120, 85));
		this.moves.add(new Move("Solar Beam", Type.GRASS, MoveType.SPECIAL, 120, 100));
	}

}
