package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Scizor extends BasePal {

	public Scizor(int level) {
		super("Scizor",Type.GRASS,level);
		initializeStats();
		initializeMoves();
	}
	
	@Override
	public void initializeStats() {
		// TODO Auto-generated method stub
		this.baseHp = 70;
		this.baseAtk = 130;
		this.baseDef = 100;
		this.baseSpAtk = 55;
		this.baseSpDef = 80;
		this.baseSpd = 65;
		updateStat();
        this.hp = maxHp;
	}

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Slash", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("X-Scissor", Type.GRASS, MoveType.PHYSICAL, 80, 100));
	}
}
