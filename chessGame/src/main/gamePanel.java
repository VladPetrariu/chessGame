package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class gamePanel extends JPanel implements Runnable{
	
	public static final int width = 1100;
	public static final int height = 800;
	final int FPS = 60;
	Thread gameThread;
	
	public gamePanel() {
		setPreferredSize(new Dimension (width, height));
		setBackground(Color.black);
	}
	
	public void launchGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
	
	@Override //create a game loop
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			
			//call update and repaint once every 1/60 of a second
			if(delta >=1) {
				update();
				repaint(); 
				delta--;
			}
		}
		
	}
	
	//updates the moves of the game
	private void update() {
		
	}
	
	//part that draws the chess pieces
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	

}
