package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Zigzagoon extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Zigzagoon(int level) {
		super("Zigzagoon", Type.NORMAL, level);
		initializeStats(38,30,41,30,41,60);
		initializeMoves();
	}

	@Override
	public boolean isEvolvable() {
		// TODO Auto-generated method stub
		return this.level >= evolutionLevel;
	}
	
	@Override
	public BasePal evolve() {
		// TODO Auto-generated method stub
		return new Linoone(this.level);
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Pin Missile", Type.GRASS, MoveType.PHYSICAL, 40, 95));
	}
}
