package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Linoone extends BasePal {
	
	public Linoone(int level) {
		super("Linoone", Type.NORMAL, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 78;
		this.baseAtk = 70;
		this.baseDef = 61;
		this.baseSpAtk = 50;
		this.baseSpDef = 61;
		this.baseSpd = 100;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Pin Missile", Type.GRASS, MoveType.PHYSICAL, 40, 95));
		this.moves.add(new Move("Headbutt", Type.NORMAL, MoveType.PHYSICAL, 70, 100));
		this.moves.add(new Move("Double-Edge", Type.NORMAL, MoveType.PHYSICAL, 120, 100));
	}
}
