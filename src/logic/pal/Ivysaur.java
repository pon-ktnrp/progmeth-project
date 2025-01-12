package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Ivysaur extends BasePal implements Evolvable {
	private final int evolutionLevel = 32 ;

	public Ivysaur(int level) {
		super("Ivysaur",Type.GRASS,level);
		initializeStats(60,62,63,80,80,60);
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
		return new Venusaur(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Vine Whip", Type.GRASS, MoveType.PHYSICAL, 45, 100));
		this.moves.add(new Move("Razor Leaf", Type.GRASS, MoveType.PHYSICAL, 55, 95));
		this.moves.add(new Move("Take Down", Type.NORMAL, MoveType.PHYSICAL, 90, 85));
	}
}
