package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Charmeleon extends BasePal implements Evolvable {
	
	private final int evolutionLevel = 36 ;
	
	public Charmeleon(int level) {
		super("Charmeleon",Type.FIRE,level);
		initializeStats(58,64,58,80,65,80);
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
		return new Charizard(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Fire Fang", Type.FIRE, MoveType.PHYSICAL, 65, 95));
		this.moves.add(new Move("Flamethrower", Type.FIRE, MoveType.SPECIAL, 90, 100));
	}
}
