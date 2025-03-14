package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Blastoise extends BasePal {
	
	public Blastoise(int level) {
		super("Blastoise",Type.WATER,level);
		initializeStats(79,83,100,85,105,78);
		initializeMoves();
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tera Blast", Type.NORMAL, MoveType.SPECIAL, 80, 100));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
		this.moves.add(new Move("Hydro Pump", Type.WATER, MoveType.SPECIAL, 110, 80));
		this.moves.add(new Move("Wave Crash", Type.WATER, MoveType.PHYSICAL, 120, 100));
	}
}
