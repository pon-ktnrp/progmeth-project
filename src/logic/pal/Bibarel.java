package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Bibarel extends BasePal {

	public Bibarel(int level) {
		super("Bibarel", Type.NORMAL, level);
		initializeStats(79,85,60,55,60,71);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Headbutt", Type.NORMAL, MoveType.PHYSICAL, 70, 100));
		this.moves.add(new Move("Water Gun", Type.WATER, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Aqua Jet", Type.WATER, MoveType.PHYSICAL, 40, 100));
	}
}
