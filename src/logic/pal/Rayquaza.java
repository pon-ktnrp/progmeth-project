package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Rayquaza extends BasePal {

	public Rayquaza(int level) {
		super("Rayquaza",Type.DRAGON,level);
		initializeStats(105,150,90,150,90,95);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Extreme Speed", Type.NORMAL, MoveType.PHYSICAL, 80, 100));
		this.moves.add(new Move("Dragon Ascent", Type.DRAGON, MoveType.PHYSICAL, 120, 100));
		this.moves.add(new Move("Dragon Pulse", Type.DRAGON, MoveType.SPECIAL, 85, 100));
		this.moves.add(new Move("Hurricane", Type.NORMAL, MoveType.SPECIAL, 110, 70));
	}
}
