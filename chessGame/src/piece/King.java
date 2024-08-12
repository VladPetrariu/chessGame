package piece;

import main.gamePanel;

public class King extends Piece{

	public King(int color, int col, int row) {
		super(color, col, row);
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-king(tata)");
		}else {
			image = getImage("/piece/black-king");
		}
	}
	
	public boolean canMove(int targetCol, int targetRow) {
		
		if(isWithinBoard(targetCol,targetRow)) {
			
			if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
					Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow)==1) {
				
				if(isValidSquare(targetCol,targetRow)) {
					return true;
				}
				
			}
		}
		
		return false;
	}

}
