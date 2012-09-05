/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.github.janpath.pongSE;

/**
 *
 * @author Jan Path
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class Spielfeld extends JPanel implements Runnable {

	public final Ball ball;
	public final Schlaeger schlaeger1;
	public final Schlaeger schlaeger2;
	public Line2D.Double line;
	private Thread thread;
	public int geschwindigkeit = 999;
	public JLabel scoreLabelPlayer1;
	public JLabel scoreLabelPlayer2;
	public Ellipse2D.Double[] echo = new Ellipse2D.Double[15];
	private int count;
	private int maxAlpha = 0xFF;
	private double alphaabnahme = (double) maxAlpha / echo.length;
	private double durchmesserabnahme;
	private int echodichte = 0;

	public Spielfeld(Rectangle rect) {
		setBounds(rect);

		ball = new Ball((getWidth() / 2) - 6, (getHeight() / 2) - 6, 12, this);
		durchmesserabnahme = (double) ball.durchmesser / (double) echo.length;

		setBackground(Color.BLACK);

		schlaeger1 = new Spieler(0, getHeight() / 2 - 45, 12, 90, this);
		if (schlaeger1 instanceof Spieler) {
			try {
				((Spieler) schlaeger1).up = Integer.parseInt(PongProperties.prop.getProperty("player1Up", String.valueOf(KeyEvent.VK_UP)));
				((Spieler) schlaeger1).down = Integer.parseInt(PongProperties.prop.getProperty("player1Down", String.valueOf(KeyEvent.VK_DOWN)));
				((Spieler) schlaeger1).left = Integer.parseInt(PongProperties.prop.getProperty("player1Left", String.valueOf(KeyEvent.VK_LEFT)));
				((Spieler) schlaeger1).right = Integer.parseInt(PongProperties.prop.getProperty("player1Right", String.valueOf(KeyEvent.VK_RIGHT)));
			} catch (NumberFormatException e) {
			}
		}

		schlaeger2 = new Computer(getWidth() - 12, getHeight() / 2 - 45, 12, 90, this);
		if (schlaeger2 instanceof Spieler) {
			try {
				((Spieler) schlaeger2).up = Integer.parseInt(PongProperties.prop.getProperty("player2Up", String.valueOf(KeyEvent.VK_UP)));
				((Spieler) schlaeger2).down = Integer.parseInt(PongProperties.prop.getProperty("player2Down", String.valueOf(KeyEvent.VK_DOWN)));
				((Spieler) schlaeger2).left = Integer.parseInt(PongProperties.prop.getProperty("player2Left", String.valueOf(KeyEvent.VK_LEFT)));
				((Spieler) schlaeger2).right = Integer.parseInt(PongProperties.prop.getProperty("player2Right", String.valueOf(KeyEvent.VK_RIGHT)));
			} catch (NumberFormatException e) {
			}
		}

		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(img,
				new Point(0, 0), "wech");
		setCursor(cursor);

		line = new Line2D.Double(getWidth() / 2, 0, getWidth() / 2, getHeight());

		setLayout(null);

		scoreLabelPlayer1 = new JLabel();
		scoreLabelPlayer1.setBounds(100, 30, 200, 30);
		scoreLabelPlayer1.setText(String.valueOf(schlaeger1.score));

		scoreLabelPlayer2 = new JLabel();
		scoreLabelPlayer2.setBounds(getWidth() - 100, 30, 200, 30);
		scoreLabelPlayer2.setText(String.valueOf(schlaeger2.score));


		add(scoreLabelPlayer1);
		add(scoreLabelPlayer2);

		thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();

		synchronized (ball) {
			ball.setX(getWidth() / 2 - ball.durchmesser / 2);
			ball.setY(getHeight() / 2 - ball.durchmesser / 2);
			ball.richtungX = ((int) (Math.random() * 2) == 0) ? 1 : -1;
			ball.richtungY = ((int) (Math.random() * 2) == 0) ? 1 : -1;
			do {
				ball.aufteilung = Math.random();
			} while (ball.aufteilung > 0.6);
			ball.setGeschwindigkeit(geschwindigkeit);
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		BufferedImage bi = new BufferedImage(1, 2, BufferedImage.TYPE_INT_RGB);
		Graphics2D big = bi.createGraphics();
		big.setColor(Color.WHITE);
		big.fillRect(0, 0, 1, 1);
		big.setColor(new Color(0x555555));
		big.fillRect(0, 1, 1, 1);
		Rectangle r1 = new Rectangle(0, 0, 1, 2);
		Paint paint = new TexturePaint(bi, r1);
		g2.setPaint(paint);
		
		Stroke drawingStroke = new BasicStroke(8, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[]{16}, 0);
		g2.setStroke(drawingStroke);
		g2.draw(line);
		
		double alpha = maxAlpha;
		for (int i = 0; i < echo.length; ++i) {
			if (echo[i] != null) {
				g2.setColor(new Color(0xFF, 00, 00, (int) alpha));
				g2.fill(echo[i]);
				alpha -= alphaabnahme;
				
				if (alpha < 0)
					alpha = 0;
				
			} else {
				break;
			}
		}
		
		g2.setPaint(paint);
		
		g2.fill(ball.ballImage);
		
		g2.fill(schlaeger1.paddleImage);
		g2.fill(schlaeger2.paddleImage);

		if (++count > echodichte) {
			for (int i = echo.length - 1; i > 0; --i) {
				echo[i] = echo[i - 1];
				if (echo[i] != null) {
					echo[i].height -= durchmesserabnahme;
					echo[i].width -= durchmesserabnahme;
					echo[i].y += durchmesserabnahme / 2;
					echo[i].x += durchmesserabnahme / 2;
				}
			}
			if (ball.getGeschwindigkeit() != 0)
				echo[0] = (Ellipse2D.Double) ball.ballImage.clone();
			count = 0;
		}
		
		

	}

	public void resetBall() {

		resetBall(((int) (Math.random() * 2) == 0) ? 1 : -1);

	}

	public void resetBall(int richtung) {


		synchronized (ball) {
			schlaeger1.amSchalg = true;
			schlaeger2.amSchalg = true;

			ball.setX(getWidth() / 2 - ball.durchmesser / 2);
			ball.setY(getHeight() / 2 - ball.durchmesser / 2);
			ball.richtungX = richtung;
			ball.richtungY = ((int) (Math.random() * 2) == 0) ? 1 : -1;
			do {
				ball.aufteilung = Math.random();
			} while (ball.aufteilung > 0.6);
			ball.setGeschwindigkeit(geschwindigkeit);
		}
	}
	
	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
		}
	}
}
