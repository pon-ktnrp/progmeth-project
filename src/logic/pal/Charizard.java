package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Charizard extends BasePal {

	public Charizard(int level) {
		super("Charizard",Type.FIRE,level);
		initializeStats(78,84,78,109,85,100);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Dragon Breath", Type.DRAGON, MoveType.SPECIAL, 60, 100));
		this.moves.add(new Move("Slash", Type.NORMAL, MoveType.PHYSICAL, 70, 95));
		this.moves.add(new Move("Flamethrower", Type.FIRE, MoveType.SPECIAL, 90, 100));
		this.moves.add(new Move("Flare Blitz", Type.FIRE, MoveType.PHYSICAL, 120, 100));
	}

}
