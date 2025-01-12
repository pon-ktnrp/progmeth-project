package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Zygarde extends BasePal {

	public Zygarde(int level) {
		super("Zygarde",Type.GRASS,level);
		initializeStats(216,100,121,91,95,85);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Solar Beam", Type.GRASS, MoveType.SPECIAL, 120, 100));
		this.moves.add(new Move("Dragon Pulse", Type.DRAGON, MoveType.SPECIAL, 85, 100));
		this.moves.add(new Move("Earthquake", Type.GRASS, MoveType.PHYSICAL, 100, 100));
		this.moves.add(new Move("Outrage", Type.DRAGON, MoveType.PHYSICAL, 120, 100));
	}
}
