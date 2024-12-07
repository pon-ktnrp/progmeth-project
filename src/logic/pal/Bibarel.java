package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Bibarel extends BasePal {

	public Bibarel(int level) {
		super("Bibarel", Type.NORMAL, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 79;
		this.baseAtk = 85;
		this.baseDef = 60;
		this.baseSpAtk = 55;
		this.baseSpDef = 60;
		this.baseSpd = 71;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Headbutt", Type.NORMAL, MoveType.PHYSICAL, 70, 100));
		this.moves.add(new Move("Water Gun", Type.WATER, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Aqua Jet", Type.WATER, MoveType.PHYSICAL, 40, 100));
	}
}
