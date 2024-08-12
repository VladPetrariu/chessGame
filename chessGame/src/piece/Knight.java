package piece;

import main.gamePanel;

public class Knight extends Piece{

	public Knight(int color, int col, int row) {
		super(color, col, row);
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-knight(buk)");
		}else {
			image = getImage("/piece/black-knight(buk)");
		}
	}

}