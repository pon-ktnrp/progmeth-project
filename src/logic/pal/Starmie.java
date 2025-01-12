package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Starmie extends BasePal {

	public Starmie(int level) {
		super("Starmie", Type.WATER, level);
		initializeStats(60,75,85,100,85,115);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Rapid Spin", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Surf", Type.WATER, MoveType.SPECIAL, 90, 100));
		this.moves.add(new Move("Hydro Pump", Type.WATER, MoveType.SPECIAL, 110, 80));
	}
}
