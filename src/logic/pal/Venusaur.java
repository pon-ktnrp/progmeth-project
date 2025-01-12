package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Venusaur extends BasePal {
	public Venusaur(int level) {
		super("Venusaur",Type.GRASS,level);
		initializeStats(80,82,83,100,100,80);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Seed Bomb", Type.GRASS, MoveType.PHYSICAL, 80, 100));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
		this.moves.add(new Move("Power Whip", Type.GRASS, MoveType.PHYSICAL, 120, 85));
		this.moves.add(new Move("Solar Beam", Type.GRASS, MoveType.SPECIAL, 120, 100));
	}

}
