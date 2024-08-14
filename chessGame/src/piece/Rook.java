package piece;

import main.Type;
import main.gamePanel;

public class Rook extends Piece{

	public Rook(int color, int col, int row) {
		super(color, col, row);
		
		type = Type.ROOK;
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-rook");
		}else {
			image = getImage("/piece/black-rook");
		}
	}
	
	public boolean canMove(int targetCol, int targetRow)  {
		if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol,targetRow) == false) {
			if(targetCol == preCol || targetRow == preRow) {
				if(isValidSquare(targetCol,targetRow) && pieceIsOnStraightLine(targetCol,targetRow) == false) {
					return true;
				}
			}
		}
		return false;
	}

}