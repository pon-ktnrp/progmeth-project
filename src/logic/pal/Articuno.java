package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Articuno extends BasePal {

	public Articuno(int level) {
		super("Articuno", Type.WATER, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 90;
		this.baseAtk = 85;
		this.baseDef = 100;
		this.baseSpAtk = 95;
		this.baseSpDef = 125;
		this.baseSpd = 85;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Aerial Ace", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Ice Shard", Type.WATER, MoveType.PHYSICAL, 80, 100));
		this.moves.add(new Move("Blizzard", Type.WATER, MoveType.SPECIAL, 110, 70));
	}
}
