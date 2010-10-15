package ru.game.corp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameLogic extends JPanel implements KeyListener {
	public static final int DEFAULT_WINDOW_WIDTH = 600;
	public static final int DEFAULT_WINDOW_HEIGHT = 400;
	private static final int DEFAULT_POSITION_X = 25;
	private static final int DEFAULT_POSITION_Y = 10;
	private final int DEFAULT_WIDTH = 80;
	private final int DEFAULT_HEIGHT = 20;
	private final int DEFAULT_SPEED = 2;
	private final int DEFAULT_SHIFT_SPEED = 10;
	private static final int TIMER_DELAY = 20;
	private int xPlayer = DEFAULT_POSITION_X;
	private int yPlayer = DEFAULT_WINDOW_HEIGHT - DEFAULT_POSITION_Y
			- DEFAULT_HEIGHT;
	private static int xOpponnent = DEFAULT_POSITION_X;
	private static int yOpponnent = DEFAULT_POSITION_Y;
	private static int xBall = 200;
	private static int yBall = 200;
	private static final int BALL_DIAMETER = 10;

	private int speed = DEFAULT_SPEED;

	public GameLogic() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(DEFAULT_WINDOW_WIDTH,
				DEFAULT_WINDOW_HEIGHT));
		ArkanoidDllLibrary.INSTANCE.net_open("192.168.0.103", 44522);
		// player
		this.addKeyListener(this);
		this.setFocusable(true);

		// opponnent
		Timer timerForOpponent = new Timer(TIMER_DELAY, new ActionListener() {
			Random r = new Random();

			int count = 0;
			int direction = 1;
			int speed = (r.nextInt(2) == 0) ? DEFAULT_SPEED
					: DEFAULT_SHIFT_SPEED;

			public void actionPerformed(ActionEvent arg0) {

				if (count <= 0) {
					count = r.nextInt(DEFAULT_WINDOW_WIDTH);
					direction = r.nextInt(2);
					speed = (r.nextInt(2) == 0) ? DEFAULT_SPEED
							: DEFAULT_SHIFT_SPEED;
				}
				if (direction == 0) {
					xOpponnent -= speed;
					xOpponnent = Math.max(0, xOpponnent);
					if (xOpponnent <= 0) {
						count -= count / 2;
					}
				} else {
					xOpponnent += speed;
					xOpponnent = Math.min(DEFAULT_WINDOW_WIDTH - DEFAULT_WIDTH,
							xOpponnent);
					if (xOpponnent >= DEFAULT_WINDOW_WIDTH - DEFAULT_WIDTH) {
						count -= count / 2;
					}
				}
				count--;

				GameLogic.this.repaint();
			}
		});
		timerForOpponent.start();

		// ball
		Timer timerForBall = new Timer(TIMER_DELAY, new ActionListener() {
			Random r = new Random();
			int countX = 0;
			int countY = 0;
			int directionX = r.nextInt(2);
			int directionY = r.nextInt(2);
			int speedX = (r.nextInt(2) == 0) ? DEFAULT_SPEED
					: DEFAULT_SHIFT_SPEED;
			int speedY = (r.nextInt(2) == 0) ? DEFAULT_SPEED
					: DEFAULT_SHIFT_SPEED;

			public void actionPerformed(ActionEvent arg0) {
				if (countX <= 0) {
					countX = r.nextInt(DEFAULT_WINDOW_WIDTH);
					directionX = r.nextInt(2);
					speedX = (r.nextInt(2) == 0) ? DEFAULT_SPEED
							: DEFAULT_SHIFT_SPEED;
				}
				if (directionX == 0) {
					xBall -= speedX;
					xBall = Math.max(0, xBall);
					if (xBall <= 0) {
						countX -= countX / 2;
					}
				} else {
					xBall += speedX;
					xBall = Math.min(DEFAULT_WINDOW_WIDTH - BALL_DIAMETER,
							xBall);
					if (yBall >= DEFAULT_WINDOW_WIDTH - BALL_DIAMETER) {
						countX -= countX / 2;
					}
				}
				countX--;

				if (countY <= 0) {
					countY = r.nextInt(DEFAULT_WINDOW_WIDTH);
					directionY = r.nextInt(2);
					speedY = (r.nextInt(2) == 0) ? DEFAULT_SPEED
							: DEFAULT_SHIFT_SPEED;
				}
				if (directionY == 0) {
					yBall -= speedY;
					yBall = Math.max(0, yBall);
					if (xBall <= 0) {
						countY -= countY / 2;
					}
				} else {
					yBall += speedY;
					yBall = Math.min(DEFAULT_WINDOW_HEIGHT - BALL_DIAMETER
							- DEFAULT_POSITION_Y, yBall);
					if (yBall >= DEFAULT_WINDOW_WIDTH - BALL_DIAMETER) {
						countY -= countY / 2;
					}
				}
				countY--;
				GameLogic.this.repaint();

			}
		});

		timerForBall.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);
		g.fillRect(xPlayer, yPlayer, DEFAULT_WIDTH, DEFAULT_HEIGHT);

		g.setColor(Color.RED);
		g.fillRect(xOpponnent, yOpponnent, DEFAULT_WIDTH, DEFAULT_HEIGHT);

		g.setColor(Color.BLUE);
		g.fillOval(xBall, yBall, BALL_DIAMETER, BALL_DIAMETER);

	}

	public void keyPressed(KeyEvent e) {
		if (e.isShiftDown()) {
			speed = DEFAULT_SHIFT_SPEED;
		} else {
			speed = DEFAULT_SPEED;
		}

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			xPlayer -= speed;
			xPlayer = Math.max(xPlayer, 0);
			break;
		case KeyEvent.VK_RIGHT:
			xPlayer += speed;
			xPlayer = Math.min(xPlayer, DEFAULT_WINDOW_WIDTH - DEFAULT_WIDTH);
			break;
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

	public void freeResources() {
		ArkanoidDllLibrary.INSTANCE.net_close();
	}
}
