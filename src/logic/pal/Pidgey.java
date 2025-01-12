package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Pidgey extends BasePal implements Evolvable {
	private final int evolutionLevel = 18;
	
	public Pidgey(int level) {
		super("Pidgey", Type.NORMAL, level);
		initializeStats(40,45,40,35,35,56);
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
		return new Pidgeotto(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Tackle", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Gust", Type.NORMAL, MoveType.SPECIAL, 40, 100));
	}
}
