package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Butterfree extends BasePal {

	public Butterfree(int level) {
		super("Butterfree", Type.GRASS, level);
		initializeStats(60,45,50,90,80,70);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Bug Bite", Type.GRASS, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Bug Buzz", Type.GRASS, MoveType.SPECIAL, 90, 100));
	}
}
