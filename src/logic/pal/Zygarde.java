package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Zygarde extends BasePal {

	public Zygarde(int level) {
		super("Zygarde",Type.GRASS,level);
		initializeStats();
		initializeMoves();
	}

	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 216;
		this.baseAtk = 100;
		this.baseDef = 121;
		this.baseSpAtk = 91;
		this.baseSpDef = 95;
		this.baseSpd = 85;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Solar Beam", Type.GRASS, MoveType.SPECIAL, 120, 100));
		this.moves.add(new Move("Dragon Pulse", Type.DRAGON, MoveType.SPECIAL, 85, 100));
		this.moves.add(new Move("Earthquake", Type.GRASS, MoveType.PHYSICAL, 100, 100));
		this.moves.add(new Move("Outrage", Type.DRAGON, MoveType.PHYSICAL, 120, 100));
	}
}
