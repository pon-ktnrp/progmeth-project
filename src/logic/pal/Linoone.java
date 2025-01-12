package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Linoone extends BasePal {
	
	public Linoone(int level) {
		super("Linoone", Type.NORMAL, level);
		initializeStats(78,70,61,50,61,100);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Pin Missile", Type.GRASS, MoveType.PHYSICAL, 40, 95));
		this.moves.add(new Move("Headbutt", Type.NORMAL, MoveType.PHYSICAL, 70, 100));
		this.moves.add(new Move("Double-Edge", Type.NORMAL, MoveType.PHYSICAL, 120, 100));
	}
}
