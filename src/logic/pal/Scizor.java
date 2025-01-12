package logic.pal;

import logic.move.Move;
import utils.MoveType;
import utils.Type;

public class Scizor extends BasePal {

	public Scizor(int level) {
		super("Scizor",Type.GRASS,level);
		initializeStats(70,130,100,55,80,65);
		initializeMoves();
	}
	

	@Override
	public void initializeMoves() {
		// TODO Auto-generated method stub
		this.moves.add(new Move("Slash", Type.NORMAL, MoveType.PHYSICAL, 60, 100));
		this.moves.add(new Move("X-Scissor", Type.GRASS, MoveType.PHYSICAL, 80, 100));
	}
}
