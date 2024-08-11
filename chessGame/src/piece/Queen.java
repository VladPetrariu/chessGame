package piece;

import main.gamePanel;

public class Queen extends Piece{

	public Queen(int color, int col, int row) {
		super(color, col, row);
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-queen(mama)");
		}else {
			image = getImage("/piece/black-queen");
		}
	}

}