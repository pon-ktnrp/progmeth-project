package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Groudon extends BasePal {

	public Groudon(int level) {
		super("Groudon",Type.FIRE,level);
		initializeStats(100,150,140,100,90,90);
		initializeMoves();
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
