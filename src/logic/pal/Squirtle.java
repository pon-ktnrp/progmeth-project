package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Squirtle extends BasePal implements Evolvable {
	private final int evolutionLevel = 16 ;
	
	public Squirtle(int level) {
		super("Squirtle",Type.WATER,level);
		initializeStats(44,48,65,50,64,43);
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
		return new Wartortle(this.level);
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Water Gun", Type.WATER, MoveType.PHYSICAL, 40, 100));
	}
}
