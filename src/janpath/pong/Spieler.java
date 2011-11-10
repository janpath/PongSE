/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package janpath.pong;

import java.awt.event.*;

/**
 *
 * @author Jan
 */
public class Spieler extends Schlaeger {

	public Spieler(int x, int y, int width, int height, Spielfeld spielfeld) {
		super(x, y, width, height, spielfeld);

		MausSteuerung mausSteuerung = new MausSteuerung();

		this.spielfeld.setFocusable(true);
		this.spielfeld.addKeyListener(new Steuerung());
		this.spielfeld.addMouseMotionListener(mausSteuerung);
	}

	private class MausSteuerung extends MouseMotionAdapter {

		@Override
		public void mouseMoved(MouseEvent e) {
			//setX(e.getX() - width/2);
			setY(e.getY() - height / 2);
		}
	}

	private class Steuerung extends KeyAdapter implements Runnable {

		private int geschwindigkeit;
		private char richtung;
		private Thread thread;

		private Steuerung() {
			thread = new Thread(this);
			thread.setDaemon(true);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e);
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT) {
				richtung = 'x';
				geschwindigkeit = -20;
				thread.run();
			} else if (key == KeyEvent.VK_LEFT) {
				richtung = 'x';
				geschwindigkeit = 20;
				thread.run();
			} else if (key == KeyEvent.VK_UP) {
				richtung = 'y';
				geschwindigkeit = -20;
				thread.run();
			} else if (key == KeyEvent.VK_DOWN) {
				richtung = 'y';
				geschwindigkeit = 20;
				thread.run();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT
					|| key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
				thread.interrupt();
			}
		}

		@Override
		public void run() {
			System.out.println(richtung);
			if (richtung == 'x') {
				setX(getX() + geschwindigkeit);
			} else if (richtung == 'y') {
				setY(getY() + geschwindigkeit);
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
		}
	}
}
