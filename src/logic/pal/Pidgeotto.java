package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Pidgeotto extends BasePal implements Evolvable {
	private final int evolutionLevel = 36;
	
	public Pidgeotto(int level) {
		super("Pidgeotto", Type.NORMAL, level);
		initializeStats(63,60,55,50,50,71);
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
		return new Pidgeot(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Twister", Type.DRAGON, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Wing Attack", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
	}
}
