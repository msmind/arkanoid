package ru.game.corp;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Arkanoid extends JFrame {

	GameLogic gameLogic;

	public Arkanoid() {
		this("Arkanoid");
	}

	public Arkanoid(String title) {

		gameLogic = new GameLogic();

		this.getContentPane().add(gameLogic, BorderLayout.NORTH);

		this.setTitle(title);
		this.pack();

		gameLogic.requestFocus();

	}

	public static void main(String[] args) {
		JFrame f = new Arkanoid();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

	}
}
