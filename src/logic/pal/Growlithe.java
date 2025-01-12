package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Growlithe extends BasePal implements Evolvable {
	private final int evolutionLevel = 24;
	
	public Growlithe(int level) {
		super("Growlithe",Type.FIRE,level);
		initializeStats(55,70,45,70,50,60);
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
		return new Arcanine(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Ember", Type.FIRE, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Flame Wheel", Type.FIRE, MoveType.PHYSICAL, 60, 100));
	}
}
