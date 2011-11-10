/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janpath.pong;

/**
 *
 * @author Jan Path
 */
import java.awt.event.*;
import javax.swing.*;

public abstract class Schlaeger {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
	protected int score = 0;
    protected Spielfeld spielfeld;

    public Schlaeger(int x, int y, int width, int height, Spielfeld spielfeld) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.spielfeld = spielfeld;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x >= 0 && x <= spielfeld.getWidth() / 2 - 100) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
            this.y = y;
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
