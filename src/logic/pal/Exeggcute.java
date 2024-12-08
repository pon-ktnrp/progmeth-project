package logic.pal;

import logic.move.Move;
import utils.Evolvable;
import utils.MoveType;
import utils.Type;

public class Exeggcute extends BasePal implements Evolvable {
	private final int evolutionLevel = 20;
	
	public Exeggcute(int level) {
		super("Exeggcute",Type.GRASS,level);
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
		return new Exeggutor(this.level);
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 60;
		this.baseAtk = 40;
		this.baseDef = 80;
		this.baseSpAtk = 60;
		this.baseSpDef = 45;
		this.baseSpd = 40;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Mega Drain", Type.GRASS, MoveType.PHYSICAL, 40, 100));
	}
}
