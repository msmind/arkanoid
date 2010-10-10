package ru.game.corp;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameLogic extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2002728017859000985L;

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);

		this.setBackground(Color.WHITE);

		g.setColor(Color.GREEN);
		g.fillRect(25, 25, 100, 30);

	}
}
