package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Fearow extends BasePal {
	
	public Fearow(int level) {
		super("Fearow", Type.NORMAL, level);
		initializeStats(65,90,65,61,61,100);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Wing Attack", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
		this.moves.add(new Move("Drill Peck", Type.NORMAL, MoveType.PHYSICAL, 80, 100));
	}
}
