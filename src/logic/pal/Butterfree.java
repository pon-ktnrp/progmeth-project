package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Butterfree extends BasePal {

	public Butterfree(int level) {
		super("Butterfree", Type.GRASS, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 60;
		this.baseAtk = 45;
		this.baseDef = 50;
		this.baseSpAtk = 90;
		this.baseSpDef = 80;
		this.baseSpd = 70;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Bug Bite", Type.GRASS, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Bug Buzz", Type.GRASS, MoveType.SPECIAL, 90, 100));
	}
}
