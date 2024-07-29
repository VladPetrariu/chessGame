package main;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[]args) {
		
		JFrame window = new JFrame("chessGame");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setResizable(false);
		
		//add game panel to the window
		gamePanel gp = new gamePanel();
		window.add(gp);
		window.pack();
		
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		//Once game is created, launch this method to start game loop
		gp.launchGame();
		
		
	}
	
}
