package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Moltres extends BasePal {

	public Moltres(int level) {
		super("Moltres", Type.FIRE, level);
		initializeStats(90,100,90,125,85,90);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Overheat", Type.FIRE, MoveType.SPECIAL, 130, 90));
		this.moves.add(new Move("Sky Attack", Type.NORMAL, MoveType.PHYSICAL, 140, 90));
	}
}
