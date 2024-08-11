package piece;

import main.gamePanel;

public class Rook extends Piece{

	public Rook(int color, int col, int row) {
		super(color, col, row);
		
		if(color == gamePanel.WHITE) {
			image = getImage("/piece/white-bishop");
		}else {
			image = getImage("/piece/black-bishop");
		}
	}

}