package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Vulpix extends BasePal implements Evolvable {
	private final int evolutionLevel = 24 ;
	
	public Vulpix(int level) {
		super("Vulpix",Type.FIRE,level);
		initializeStats(38,41,40,50,65,65);
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
		return new Ninetales(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Ember", Type.FIRE, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Quick Attack", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
	}
}
