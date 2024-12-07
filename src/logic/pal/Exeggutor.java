package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Exeggutor extends BasePal {

	public Exeggutor(int level) {
		super("Exeggutor",Type.GRASS,level);
		initializeStats();
		initializeMoves();
	}
	
	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 95;
		this.baseAtk = 95;
		this.baseDef = 85;
		this.baseSpAtk = 125;
		this.baseSpDef = 65;
		this.baseSpd = 55;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Stomp", Type.NORMAL, MoveType.PHYSICAL, 65, 100));
		this.moves.add(new Move("SolarBeam", Type.GRASS, MoveType.SPECIAL, 120, 100));
	}
}
