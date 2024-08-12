package piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Board;
import main.gamePanel;

public class Piece {

	public BufferedImage image;
	public int x, y;
	public int col, row, preCol, preRow;
	public int color;
	public Piece hittingP;
	
	public Piece(int color, int col, int row) {
		this.color = color;
		this.col = col;
		this.row = row;
		x = getX(col);
		y = getY(row);
		preCol = col;
		preRow = row;
	}
	public BufferedImage getImage(String imagePath) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public int getX(int col) {
		return col * Board.SQUARE_SIZE;
	}
	public int getY(int row) {
		return row * Board.SQUARE_SIZE;
	}
	public int getCol(int x) {
		return (x + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
	}
	public int getRow(int y) {
		return (y + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
	}
	public int getIndex() {
		for(int index = 0; index < gamePanel.simPieces.size(); index++) {
			if(gamePanel.simPieces.get(index) == this){
				return index;
			}
		}
		return 0;
	}
	public void updatePosition() {
		
		x = getX(col);
		y = getY(row);
		preCol = getCol(x);
		preRow = getRow(y);
		
	}
	public void resetPosition() {
		col = preCol;
		row = preRow;
		x = getX(col);
		y = getY(row);
	}
	public boolean canMove(int targetCol, int targetRow) {
		return false;
	}
	public boolean isWithinBoard(int targetCol, int targetRow) {
		if(targetCol >= 0 && targetCol <= 7 && targetRow >= 0 && targetRow <= 7) {
			return true;
		}
		return false;
	}
	public boolean isSameSquare(int targetCol, int targetRow) {
		if(targetCol == preCol && targetRow == preRow) {
			return true;
		}
		return false;
	}
	public Piece getHittingP(int targetCol, int targetRow) {
		for(Piece piece : gamePanel.simPieces) {
			if(piece.col == targetCol && piece.row == targetRow && piece != this) {
				return piece;
			}
		}
		return null;
	}
	public boolean isValidSquare(int targetCol, int targetRow) {
		hittingP = getHittingP(targetCol, targetRow);
		if(hittingP == null) { //this square is vacant
			return true;
		}
		else { //this square is not vacant
			if(hittingP.color != this.color) { //if color is different it can be captured
				return true;
			}
			else {
				hittingP = null;
			}
		}
		return false;
	}
	public boolean pieceIsOnStraightLine(int targetCol, int targetRow) {
		
		//when the piece is moving to the left
		for(int c = preCol-1; c>targetCol; c--) {
			for(Piece piece : gamePanel.simPieces) {
				if(piece.col == c && piece.row == targetRow) {
					hittingP = piece;
					return true;
				}
			}
		}
		//when the piece is moving to the right
		for(int c = preCol+1; c<targetCol; c++) {
			for(Piece piece : gamePanel.simPieces) {
				if(piece.col == c && piece.row == targetRow) {
					hittingP = piece;
					return true;
				}
			}
		}
		//when the piece is moving up
		for(int r = preRow-1; r>targetRow; r--) {
			for(Piece piece : gamePanel.simPieces) {
				if(piece.col == targetCol && piece.row == r) {
					hittingP = piece;
					return true;
				}
			}
		}
		//when the piece is moving down
		for(int r = preRow+1; r<targetRow; r++) {
			for(Piece piece : gamePanel.simPieces) {
				if(piece.col == targetCol && piece.row == r) {
					hittingP = piece;
					return true;
				}
			}
		}
		
		return false;
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(image, x, y, Board.SQUARE_SIZE,  Board.SQUARE_SIZE, null); 
	}
	
}
