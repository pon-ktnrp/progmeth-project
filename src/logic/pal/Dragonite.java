package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Dragonite extends BasePal {

	public Dragonite(int level) {
		super("Dragonite",Type.DRAGON,level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 91;
		this.baseAtk = 134;
		this.baseDef = 95;
		this.baseSpAtk = 100;
		this.baseSpDef = 100;
		this.baseSpd = 80;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Twister", Type.DRAGON, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Dragon Tail", Type.DRAGON, MoveType.PHYSICAL, 60, 90));
		this.moves.add(new Move("Aqua Tail", Type.WATER, MoveType.PHYSICAL, 90, 90));
		this.moves.add(new Move("Outrage", Type.DRAGON, MoveType.PHYSICAL, 120, 100));
	}
}
