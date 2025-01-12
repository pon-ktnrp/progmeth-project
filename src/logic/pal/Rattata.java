package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Rattata extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Rattata(int level) {
		super("Rattata", Type.NORMAL, level);
		initializeStats(30,56,35,25,35,72);
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
		return new Raticate(this.level);
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Quick Attack", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
	}
}
