package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Persian extends BasePal {
	
	public Persian(int level) {
		super("Persian",Type.NORMAL,level);
		initializeStats(65,70,60,65,65,115);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Bite", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Play Rough", Type.NORMAL, MoveType.PHYSICAL, 90, 90));
	}
}
