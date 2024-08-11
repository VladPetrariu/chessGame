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

}
