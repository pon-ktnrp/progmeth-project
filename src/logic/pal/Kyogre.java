package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Kyogre extends BasePal {

	public Kyogre(int level) {
		super("Kyogre",Type.WATER,level);
		initializeStats(100,100,90,150,140,90);
		initializeMoves();
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Aqua Tail", Type.WATER, MoveType.PHYSICAL, 90, 90));
		this.moves.add(new Move("Hydro Pump", Type.WATER, MoveType.SPECIAL, 110, 80));
		this.moves.add(new Move("Double-Edge", Type.NORMAL, MoveType.PHYSICAL, 120, 100));
		this.moves.add(new Move("Water Spout", Type.WATER, MoveType.SPECIAL, 150, 100));
	}
}
