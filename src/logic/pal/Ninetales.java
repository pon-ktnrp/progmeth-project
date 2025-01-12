package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Ninetales extends BasePal {

	public Ninetales(int level) {
		super("Ninetales",Type.FIRE,level);
		initializeStats(73,76,75,81,100,100);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Incainerate", Type.FIRE, MoveType.SPECIAL, 60, 100));
		this.moves.add(new Move("Inferno", Type.FIRE, MoveType.SPECIAL, 100, 50));
		this.moves.add(new Move("Fire Blast", Type.FIRE, MoveType.SPECIAL, 110, 85));
	}
}
