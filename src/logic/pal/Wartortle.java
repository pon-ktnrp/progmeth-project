package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Wartortle extends BasePal implements Evolvable {
	private final int evolutionLevel = 36 ;
	
	public Wartortle(int level) {
		super("Wartortle",Type.WATER,level);
		initializeStats(59,63,80,65,80,58);
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
		return new Blastoise(this.level);
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Rapid Spin", Type.NORMAL, MoveType.PHYSICAL, 50, 100));
		this.moves.add(new Move("Water Pulse", Type.WATER, MoveType.SPECIAL, 60, 100));
		this.moves.add(new Move("Aqua Tail", Type.WATER, MoveType.PHYSICAL, 90, 100));
	}
}
