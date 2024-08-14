package piece;

import main.Type;
import main.gamePanel;

public class Queen extends Piece{

	public Queen(int color, int col, int row) {
		super(color, col, row);
		
		type = Type.QUEEN;
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-queen(mama)");
		}else {
			image = getImage("/piece/black-queen");
		}
	}
	public boolean canMove(int targetCol, int targetRow) {
		if(isWithinBoard(targetCol,targetRow)&&isSameSquare(targetCol,targetRow)==false) {
			
			//vertical & horizontal
			if(targetCol == preCol || targetRow == preRow) {
				if(isValidSquare(targetCol,targetRow) && pieceIsOnStraightLine(targetCol,targetRow) == false) {
					return true;
				}
			}
			
			//diagonal
			if(Math.abs(targetCol - preCol) == Math.abs(targetRow-preRow)) {
				if(isValidSquare(targetCol,targetRow) && pieceIsOnDiagonalLine(targetCol,targetRow)==false) {
					return true;
				}
			}
			
		}
		return false;
	}

}