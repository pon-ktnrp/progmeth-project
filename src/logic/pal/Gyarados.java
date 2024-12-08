package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Gyarados extends BasePal {

	public Gyarados(int level) {
		super("Gyarados", Type.WATER, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 95;
		this.baseAtk = 125;
		this.baseDef = 79;
		this.baseSpAtk = 60;
		this.baseSpDef = 110;
		this.baseSpd = 81;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Waterfall", Type.WATER, MoveType.PHYSICAL, 80, 100));
		this.moves.add(new Move("Hydro Pump", Type.WATER, MoveType.SPECIAL, 110, 80));
		this.moves.add(new Move("Hyper Beam", Type.NORMAL, MoveType.SPECIAL, 150, 90));
	}
}
