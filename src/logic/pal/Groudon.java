package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Groudon extends BasePal {

	public Groudon(int level) {
		super("Groudon",Type.FIRE,level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 100;
		this.baseAtk = 150;
		this.baseDef = 140;
		this.baseSpAtk = 100;
		this.baseSpDef = 90;
		this.baseSpd = 90;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Fire Punch", Type.FIRE, MoveType.PHYSICAL, 75, 100));
		this.moves.add(new Move("Hammer Arm", Type.NORMAL, MoveType.PHYSICAL, 100, 90));
		this.moves.add(new Move("Solar Beam", Type.GRASS, MoveType.SPECIAL, 120, 100));
		this.moves.add(new Move("Eruption", Type.FIRE, MoveType.SPECIAL, 150, 100));
	}
}
