package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Meowth extends BasePal implements Evolvable {
	private final int evolutionLevel = 28;
	
	public Meowth(int level) {
		super("Meowth",Type.NORMAL,level);
		initializeStats();
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
		return new Persian(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 40;
		this.baseAtk = 45;
		this.baseDef = 35;
		this.baseSpAtk = 40;
		this.baseSpDef = 40;
		this.baseSpd = 90;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Scratch", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
		this.moves.add(new Move("Pay Day", Type.NORMAL, MoveType.PHYSICAL, 40, 100));
	}
}
