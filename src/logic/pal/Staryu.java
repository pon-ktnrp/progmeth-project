package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Staryu extends BasePal implements Evolvable {
	private final int evolutionLevel = 24;
	
	public Staryu(int level) {
		super("Staryu",Type.WATER,level);
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
		return new Starmie(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 30;
		this.baseAtk = 45;
		this.baseDef = 55;
		this.baseSpAtk = 70;
		this.baseSpDef = 55;
		this.baseSpd = 85;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Water Gun", Type.WATER, MoveType.SPECIAL, 40, 100));
		this.moves.add(new Move("Rapid Spin", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
	}
}
