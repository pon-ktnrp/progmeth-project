package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Staryu extends BasePal implements Evolvable {
	private final int evolutionLevel = 24;
	
	public Staryu(int level) {
		super("Staryu",Type.WATER,level);
		initializeStats(30,45,55,70,55,85);
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
		return new Starmie(this.level);
	}


	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Water Gun", Type.WATER, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Rapid Spin", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
	}
}
