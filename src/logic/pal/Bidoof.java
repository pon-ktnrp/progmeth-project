package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Bidoof extends BasePal implements Evolvable {
	private final int evolutionLevel = 15;
	
	public Bidoof(int level) {
		super("Bidoof", Type.NORMAL, level);
		initializeStats(59,45,40,35,40,31);
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
		return new Bibarel(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Headbutt", Type.NORMAL, MoveType.PHYSICAL, 70, 100));
	}
}
