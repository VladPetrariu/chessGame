package piece;

import main.Type;
import main.gamePanel;

public class Pawn extends Piece{

	public Pawn(int color, int col, int row) {
		super(color, col, row);
		
		type = Type.PAWN;
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-pawn");
		}else {
			image = getImage("/piece/black-pawn");
		}
	}
	
	public boolean canMove(int targetCol, int targetRow) {
		if(isWithinBoard(targetCol,targetRow) && isSameSquare(targetCol,targetRow) == false) {
			
			//define move value based on color
			int moveValue;
			if(color == gamePanel.WHITE) {
				moveValue = -1;
			}else {
				moveValue = 1;
			}
			
			//check hitting piece
			hittingP = getHittingP(targetCol,targetRow);
			
			//1 square for the movement
			if(targetCol== preCol && targetRow == preRow + moveValue && hittingP == null) {
				return true;
			}
			
			//2 square movement for the first pawn movement
			if(targetCol == preCol && targetRow == preRow + moveValue*2 && hittingP == null && moved == false && 
					pieceIsOnStraightLine(targetCol, targetRow)==false) {
				return true;
			}
			
			//diagonal movement for capturing pieces
			if(Math.abs(targetCol - preCol) == 1 && targetRow == preRow + moveValue && hittingP != null && hittingP.color != color) {
				return true;
			}
			
			//en passant
			if(Math.abs(targetCol - preCol) == 1 && targetRow == preRow + moveValue) {
				for(Piece piece : gamePanel.simPieces) {
					if(piece.col == targetCol && piece.row == preRow && piece.twoStepped == true) {
						hittingP = piece;
						return true;
					}
				}
			}
			
		}
		return false;
	}

}
