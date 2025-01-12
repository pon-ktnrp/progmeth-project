package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Pidgeot extends BasePal {

	public Pidgeot(int level) {
		super("Pidgeot", Type.NORMAL, level);
		initializeStats(83,80,75,70,70,101);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Twister", Type.DRAGON, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Wing Attack", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Air Slash", Type.NORMAL, MoveType.SPECIAL, 75, 95));
		this.moves.add(new Move("Hurricane", Type.NORMAL, MoveType.SPECIAL, 110, 70));
	}
}
