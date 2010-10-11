package ru.game.corp;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class KeyProcess implements KeyEventDispatcher {
	public JFrame frame;

	private final int DEFAULT_POSITION_X = 25;
	private final int DEFAULT_POSITION_Y = 25;
	private final int DEFAULT_WIDTH = 80;
	private final int DEFAULT_HEIGHT = 40;
	private int x = DEFAULT_POSITION_X;
	private int y = DEFAULT_POSITION_Y;

	public KeyProcess() {
		this(new JFrame());
	}

	public KeyProcess(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			System.out.println("KeyEventDispatcher tester");
		} else if (e.getID() == KeyEvent.KEY_RELEASED) {
			System.out.println("KeyEventDispatcher 2test2");
		} else if (e.getID() == KeyEvent.KEY_TYPED) {
			System.out.println("KeyEventDispatcher 3test3");
		}
		return false;
	}
}
