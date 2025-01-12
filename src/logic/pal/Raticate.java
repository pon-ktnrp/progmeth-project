package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Raticate extends BasePal {

	public Raticate(int level) {
		super("Raticate", Type.NORMAL, level);
		initializeStats(55,81,60,50,70,97);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Quick Attack", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Bite", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
	}
}
