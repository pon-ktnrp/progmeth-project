package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Meowth extends BasePal implements Evolvable {
	private final int evolutionLevel = 28;
	
	public Meowth(int level) {
		super("Meowth",Type.NORMAL,level);
		initializeStats(40,45,35,40,40,90);
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
		return new Persian(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Pay Day", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
	}
}
