package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Persian extends BasePal {
	
	public Persian(int level) {
		super("Persian",Type.NORMAL,level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 65;
		this.baseAtk = 70;
		this.baseDef = 60;
		this.baseSpAtk = 65;
		this.baseSpDef = 65;
		this.baseSpd = 115;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Bite", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Play Rough", Type.NORMAL, MoveType.PHYSICAL, 90, 90));
	}
}
