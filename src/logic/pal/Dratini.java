package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Dratini extends BasePal implements Evolvable {

	private final int evolutionLevel = 25 ;
	
	public Dratini(int level) {
		super("Dratini",Type.DRAGON,level);
		initializeStats();
		initializeMoves();
	}
	
	public boolean isEvolvable() {
		// TODO Auto-generated method stub
		return this.level >= evolutionLevel;
	}
	
	@Override
	public BasePal evolve() {
		// TODO Auto-generated method stub
		return new Dragonair(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 41;
		this.baseAtk = 64;
		this.baseDef = 45;
		this.baseSpAtk = 50;
		this.baseSpDef = 50;
		this.baseSpd = 50;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Twister", Type.DRAGON, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Dragon Tail", Type.DRAGON, MoveType.PHYSICAL, 60, 90));
	}
}
