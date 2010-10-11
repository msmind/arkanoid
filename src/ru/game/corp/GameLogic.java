package ru.game.corp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameLogic extends JPanel implements KeyListener {
	public static final int DEFAULT_WINDOW_WIDTH = 600;
	public static final int DEFAULT_WINDOW_HEIGHT = 400;
	private final int DEFAULT_POSITION_X = 25;
	private final int DEFAULT_POSITION_Y = 10;
	private final int DEFAULT_WIDTH = 80;
	private final int DEFAULT_HEIGHT = 20;
	private final int DEFAULT_SPEED = 2;
	private final int DEFAULT_SHIFT_SPEED = 10;
	private int x = DEFAULT_POSITION_X;
	private int y = DEFAULT_POSITION_Y;

	private int speed = DEFAULT_SPEED;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2002728017859000985L;

	public GameLogic() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(DEFAULT_WINDOW_WIDTH,
				DEFAULT_WINDOW_HEIGHT));
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);
		g.fillRect(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);

	}

	public void keyPressed(KeyEvent e) {
		if (e.isShiftDown()) {
			speed = DEFAULT_SHIFT_SPEED;
		} else {
			speed = DEFAULT_SPEED;
		}

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			x -= speed;
			x = Math.max(x, 0);
			break;
		case KeyEvent.VK_RIGHT:
			x += speed;
			x = Math.min(x, DEFAULT_WINDOW_WIDTH - DEFAULT_WIDTH);
			break;
		/*
		 * case KeyEvent.VK_UP: y -= speed; y = Math.max(y, 0); break; case
		 * KeyEvent.VK_DOWN: y += speed; y = Math.min(y, 200); break;
		 */
		}
		speed = DEFAULT_SPEED;
		this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		// System.out.println("2test2");
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("3test3");
	}
}
