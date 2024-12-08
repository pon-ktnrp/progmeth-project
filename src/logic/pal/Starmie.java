package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Starmie extends BasePal {

	public Starmie(int level) {
		super("Starmie", Type.WATER, level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 60;
		this.baseAtk = 75;
		this.baseDef = 85;
		this.baseSpAtk = 100;
		this.baseSpDef = 85;
		this.baseSpd = 115;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Rapid Spin", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("Surf", Type.WATER, MoveType.SPECIAL, 90, 100));
		this.moves.add(new Move("Hydro Pump", Type.WATER, MoveType.SPECIAL, 110, 80));
	}
}
