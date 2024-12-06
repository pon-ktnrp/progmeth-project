package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Wartortle extends BasePal implements Evolvable {
	private final int evolutionLevel = 36 ;
	
	public Wartortle(int level) {
		super("Wartortle",Type.GRASS,level);
		initializeStats();
		initializeMoves();
	}
	
	@Override
	public boolean isEvolvable() {
		// TODO Auto-generated method stub
		return this.level >= evolutionLevel;
	}
	
	@Override
	public void evolve() {
		// TODO Auto-generated method stub
		if(isEvolvable()) {
			
		}
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 59;
		this.baseAtk = 63;
		this.baseDef = 80;
		this.baseSpAtk = 65;
		this.baseSpDef = 80;
		this.baseSpd = 58;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Rapid Spin", Type.NORMAL, MoveType.PHYSICAL, 50, 100));
		this.moves.add(new Move("Water Pulse", Type.WATER, MoveType.SPECIAL, 60, 100));
		this.moves.add(new Move("Aqua Tail", Type.WATER, MoveType.PHYSICAL, 90, 100));
	}
}
