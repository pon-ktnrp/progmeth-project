package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Mewtwo extends BasePal {
	
	public Mewtwo(int level) {
		super("Mewtwo",Type.NORMAL,level);
		initializeStats(106,110,90,154,90,130);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Fire Blast", Type.FIRE, MoveType.SPECIAL, 110, 85));
		this.moves.add(new Move("Blizzard", Type.WATER, MoveType.SPECIAL, 110, 70));
		this.moves.add(new Move("Solar Beam", Type.GRASS, MoveType.SPECIAL, 120, 100));
		this.moves.add(new Move("Psystrike", Type.NORMAL, MoveType.SPECIAL, 100, 100));
	}
}
