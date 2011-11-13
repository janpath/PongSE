/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.github.janpath.pongSE;

/**
 *
 * @author Jan Path
 */
import java.awt.geom.Rectangle2D;

public abstract class Schlaeger {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int score = 0;
	protected Spielfeld spielfeld;
	public boolean amSchalg = true;
	public Rectangle2D.Double paddleImage;
	//set to true to enable paddle moving on the x-Axis
	public boolean xAxisMoving;

	public Schlaeger(int x, int y, int width, int height, Spielfeld spielfeld) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.spielfeld = spielfeld;

		paddleImage = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (!xAxisMoving) {
			return;
		}

		if (x >= 0 && x <= (spielfeld.getWidth() - width) / 2 - 100) {
			this.x = x;
			paddleImage = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
		} else if (x < 0) {
			this.x = 0;
			paddleImage = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
		} else if (x > (spielfeld.getWidth() - width) / 2 - 100) {
			this.x = (spielfeld.getWidth() - width) / 2 - 100;
			paddleImage = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y >= (0 - height / 2) && y <= (spielfeld.getHeight() - height / 2)) {
			this.y = y;
			paddleImage.setRect(x, this.y, width, height);
		} else if (y < (0 - height / 2)) {
			y = 0 - height / 2;
			paddleImage.setRect(x, this.y, width, height);
		} else if (y <= (spielfeld.getHeight() - height / 2)) {
			y = spielfeld.getHeight() - height / 2;
			paddleImage.setRect(x, this.y, width, height);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
