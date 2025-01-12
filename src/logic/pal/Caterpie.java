package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Caterpie extends BasePal implements Evolvable {
	private final int evolutionLevel = 7;
	
	public Caterpie(int level) {
		super("Caterpie",Type.GRASS,level);
		initializeStats(45,30,35,20,20,45);
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
		return new Metapod(this.level);
	}
	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Bug Bite", Type.GRASS, MoveType.PHYSICAL, 60, 100));
	}
}
