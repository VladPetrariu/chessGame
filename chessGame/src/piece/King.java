package piece;

import main.Type;
import main.gamePanel;

public class King extends Piece{

	public King(int color, int col, int row) {
		super(color, col, row);
		
		type = Type.KING;
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-king(tata)");
		}else {
			image = getImage("/piece/black-king");
		}
	}
	
	public boolean canMove(int targetCol, int targetRow) {
		
		if(isWithinBoard(targetCol,targetRow)) {
			
			//movement
			if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
					Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow)==1) {
				
				if(isValidSquare(targetCol,targetRow)) {
					return true;
				}
				
			}
			
			//castling
			if(moved == false) {
				
				//right castling
				if(targetCol == preCol+2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow)==false) {
					for(Piece piece : gamePanel.simPieces) {
						if(piece.col == preCol+3 && piece.row == preRow && piece.moved == false) {
							gamePanel.castlingP = piece;
							return true;
						}
					}
				}
				
				//left caslting
				if(targetCol == preCol-2 && targetRow == preRow && pieceIsOnStraightLine(targetCol,targetRow)==false) {
					Piece p[] = new Piece[2];
					for(Piece piece : gamePanel.simPieces) {
						if(piece.col == preCol-3 && piece.row == targetRow) {
							p[0] = piece;
						}
						if(piece.col == preCol-4 && piece.row == targetRow) {
							p[1] = piece;
						}
						if(p[0] == null && p[1] != null && p[1].moved == false) {
							gamePanel.castlingP = p[1];
							return true;
						}
					}
				}
				
			}
			
		}
		
		return false;
	}

}
