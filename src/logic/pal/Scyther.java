package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Scyther extends BasePal implements Evolvable {
	private final int evolutionLevel = 24;
	
	public Scyther(int level) {
		super("Scyther",Type.GRASS,level);
		initializeStats(70,110,80,55,80,105);
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
		return new Scizor(this.level);
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Fury Cutter", Type.GRASS, MoveType.PHYSICAL, 40, 95));
		this.moves.add(new Move("Slash", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
	}
}
