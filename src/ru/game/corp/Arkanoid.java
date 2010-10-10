package ru.game.corp;

import javax.swing.JFrame;

public class Arkanoid {
	public static final int DEFAULT_WINDOW_WIDTH = 600;
	public static final int DEFAULT_WINDOW_HEIGHT = 400;

	public static void main(String[] args) {
		JFrame f = new JFrame("Arkanoid");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameLogic gl = new GameLogic();
		f.add(gl);

		f.setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		f.validate();
		f.setVisible(true);

		KeyProcess kp = new KeyProcess(f);
		f.getContentPane().addKeyListener(kp);
	}
}
