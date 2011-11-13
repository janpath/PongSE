/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.github.janpath.pongSE;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jan
 */
public class Spieler extends Schlaeger {

	public Spieler(int x, int y, int width, int height, Spielfeld spielfeld) {
		super(x, y, width, height, spielfeld);

		MausSteuerung mausSteuerung = new MausSteuerung();

		this.spielfeld.setFocusable(true);

		if (PongProperties.prop.getProperty("control", "mouse").equalsIgnoreCase("keyboard")) {
			this.spielfeld.addKeyListener(new KeyboardSteuerung());
		} else if (PongProperties.prop.getProperty("control", "mouse").equalsIgnoreCase("mouse")) {
			this.spielfeld.addMouseMotionListener(mausSteuerung);
		} else {
			System.err.println("Steuerungungsoption " + PongProperties.prop.getProperty("control") + " nicht vorhanden!");
		}
	}

	private class MausSteuerung extends MouseMotionAdapter {

		@Override
		public void mouseMoved(MouseEvent e) {
			setX(e.getX() - width / 2);
			setY(e.getY() - height / 2);
		}
	}

	private class KeyboardSteuerung extends KeyAdapter implements Runnable {

		private int richtungX;
		private int richtungY;
		private Thread thread;

		private KeyboardSteuerung() {
			thread = new Thread(this);
			thread.setDaemon(true);
			thread.start();
		}

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT) {
				richtungX = 5;
				synchronized (this) {
					notify();
				}
			} else if (key == KeyEvent.VK_LEFT) {
				richtungX = -5;
				synchronized (this) {
					notify();
				}
			} else if (key == KeyEvent.VK_UP) {
				richtungY = -5;
				synchronized (this) {
					notify();
				}
			} else if (key == KeyEvent.VK_DOWN) {
				richtungY = 5;
				synchronized (this) {
					notify();
				}
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
				richtungX = 0;
			} else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
				richtungY = 0;
			}
		}

		@Override
		public void run() {
			while (true) {
				boolean stop = true;

				if (richtungX != 0) {
					setX(getX() + richtungX);
					stop = false;
				}

				if (richtungY != 0) {
					setY(getY() + richtungY);
					stop = false;
				}

				if (stop) {
					synchronized (this) {
						try {
							wait();
						} catch (InterruptedException ex) {
						}
					}
				}


				try {
					Thread.sleep(5);
				} catch (InterruptedException ex) {
				}
			}
		}
	}
}
