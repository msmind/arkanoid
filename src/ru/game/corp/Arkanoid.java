package ru.game.corp;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class Arkanoid extends JFrame implements WindowListener,
		WindowFocusListener, WindowStateListener {

	private GameLogic gameLogic;

	public Arkanoid() {
		this("Arkanoid");
	}

	public Arkanoid(String title) {

		gameLogic = new GameLogic();

		CloseListener cl = new CloseListener(
				"Are you sure you want to exit the application",
				"Exit Application");
		JFrame frame = new JFrame("Closing an Application");
		frame.addWindowListener(cl);

		this.getContentPane().add(gameLogic, BorderLayout.NORTH);

		this.setTitle(title);
		this.pack();

		gameLogic.requestFocus();

	}

	public void freeResources() {
		gameLogic.freeResources();
	}

	public static void main(String[] args) {
		JFrame f = new Arkanoid();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

	}

	@Override
	public void windowStateChanged(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		freeResources();
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}
