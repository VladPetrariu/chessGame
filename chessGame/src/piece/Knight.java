package piece;

import main.Type;
import main.gamePanel;

public class Knight extends Piece{

	public Knight(int color, int col, int row) {
		super(color, col, row);
		
		type = Type.KNIGHT;
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-knight(buk)");
		}else {
			image = getImage("/piece/black-knight(buk)");
		}
	}
	public boolean canMove(int targetCol, int targetRow) {
		
		if(isWithinBoard(targetCol,targetRow)) {
			// knight can only move on a ratio of 2:1 or 1:2 between col and row
			
			if(Math.abs(targetCol - preCol)* Math.abs(targetRow - preRow) == 2) {
				if(isValidSquare(targetCol,targetRow)) {
					return true;
				}
			}
		}
		return false;
	}

}