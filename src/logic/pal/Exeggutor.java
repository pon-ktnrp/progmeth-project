package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Exeggutor extends BasePal {

	public Exeggutor(int level) {
		super("Exeggutor",Type.GRASS,level);
		initializeStats(95,95,85,125,65,55);
		initializeMoves();
	}
	
	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Stomp", Type.NORMAL, MoveType.PHYSICAL, 65, 100));
		this.moves.add(new Move("SolarBeam", Type.GRASS, MoveType.SPECIAL, 120, 100));
	}
}
