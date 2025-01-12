package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Exeggcute extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Exeggcute(int level) {
		super("Exeggcute",Type.GRASS,level);
		initializeStats(60,40,80,60,45,40);
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
		return new Exeggutor(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Mega Drain", Type.GRASS, MoveType.PHYSICAL, 40, 100));
	}
}
