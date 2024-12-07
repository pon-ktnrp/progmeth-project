package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Arcanine extends BasePal {

	public Arcanine(int level) {
		super("Arcanine", Type.FIRE, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 90;
		this.baseAtk = 110;
		this.baseDef = 80;
		this.baseSpAtk = 100;
		this.baseSpDef = 80;
		this.baseSpd = 95;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
		this.moves.add(new Move("Flamethrower", Type.FIRE, MoveType.SPECIAL, 90, 100));
		this.moves.add(new Move("Flare Blitz", Type.FIRE, MoveType.PHYSICAL, 120, 100));
	}
}
