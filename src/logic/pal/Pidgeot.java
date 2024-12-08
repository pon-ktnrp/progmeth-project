package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Pidgeot extends BasePal {

	public Pidgeot(int level) {
		super("Pidgeot", Type.NORMAL, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 83;
		this.baseAtk = 80;
		this.baseDef = 75;
		this.baseSpAtk = 70;
		this.baseSpDef = 70;
		this.baseSpd = 101;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Twister", Type.DRAGON, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Wing Attack", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Air Slash", Type.NORMAL, MoveType.SPECIAL, 75, 95));
		this.moves.add(new Move("Hurricane", Type.NORMAL, MoveType.SPECIAL, 110, 70));
	}
}
