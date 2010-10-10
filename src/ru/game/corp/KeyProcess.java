package ru.game.corp;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyProcess implements KeyListener {
	public JFrame frame;

	public KeyProcess() {
		frame = new JFrame();
	}

	public KeyProcess(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			frame.add(new JPanel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = -1209071366658789253L;

				@Override
				public void paint(Graphics g) {

				}
			});
		}
		// TODO Auto-generated method stub
	}

}
