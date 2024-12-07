package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Moltres extends BasePal {

	public Moltres(int level) {
		super("Moltres", Type.FIRE, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 90;
		this.baseAtk = 100;
		this.baseDef = 90;
		this.baseSpAtk = 125;
		this.baseSpDef = 85;
		this.baseSpd = 90;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Overheat", Type.FIRE, MoveType.SPECIAL, 130, 90));
		this.moves.add(new Move("Sky Attack", Type.NORMAL, MoveType.PHYSICAL, 140, 90));
	}
}
