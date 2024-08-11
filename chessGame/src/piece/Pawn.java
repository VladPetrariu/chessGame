package piece;

import main.gamePanel;

public class Pawn extends Piece{

	public Pawn(int color, int col, int row) {
		super(color, col, row);
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-pawn");
		}else {
			image = getImage("/piece/black-pawn");
		}
	}

}
