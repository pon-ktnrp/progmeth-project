package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Raticate extends BasePal {

	public Raticate(int level) {
		super("Raticate", Type.NORMAL, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 55;
		this.baseAtk = 81;
		this.baseDef = 60;
		this.baseSpAtk = 50;
		this.baseSpDef = 70;
		this.baseSpd = 97;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Quick Attack", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Bite", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
	}
}
