package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Snorlax extends BasePal {
	
	public Snorlax(int level) {
		super("Snorlax",Type.NORMAL,level);
		initializeStats(160,110,65,65,110,30);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Snore", Type.NORMAL, MoveType.SPECIAL, 50, 100));
		this.moves.add(new Move("Body Slam", Type.NORMAL, MoveType.PHYSICAL, 85, 100));
		this.moves.add(new Move("Giga Impact", Type.NORMAL, MoveType.PHYSICAL, 150, 90));
	}
}
