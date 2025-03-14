package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Dragonair extends BasePal implements Evolvable {
	
	private final int evolutionLevel = 45 ;
	
	public Dragonair(int level) {
		super("Dragonair",Type.DRAGON,level);
		initializeStats(61,84,65,70,70,70);
		initializeMoves();
	}
	
	public boolean isEvolvable() {
		// TODO Auto-generated method stub
		return this.level >= evolutionLevel;
	}
	
	@Override
	public BasePal evolve() {
		// TODO Auto-generated method stub
		return new Dragonite(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Twister", Type.DRAGON, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Dragon Tail", Type.DRAGON, MoveType.PHYSICAL, 60, 90));
		this.moves.add(new Move("Aqua Tail", Type.WATER, MoveType.PHYSICAL, 90, 90));
	}
}
