package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Snorlax extends BasePal {
	
	public Snorlax(int level) {
		super("Snorlax",Type.NORMAL,level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 160;
		this.baseAtk = 110;
		this.baseDef = 65;
		this.baseSpAtk = 65;
		this.baseSpDef = 110;
		this.baseSpd = 30;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Snore", Type.NORMAL, MoveType.SPECIAL, 50, 100));
		this.moves.add(new Move("Body Slam", Type.NORMAL, MoveType.PHYSICAL, 85, 100));
		this.moves.add(new Move("Giga Impact", Type.NORMAL, MoveType.PHYSICAL, 150, 90));
	}
}
