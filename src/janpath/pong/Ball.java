/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janpath.pong;

import java.awt.geom.Rectangle2D;

/**
 * 
 * @author Jan Path
 */
public class Ball implements Runnable {

    private double x;
    private double y;
    public int durchmesser;
    private int geschwindigkeit;
    public int richtungX;
    public int richtungY;
    public double aufteilung;
    private Spielfeld spielfeld;
    private Thread thread;
    double[] debug = new double[4];

    public Ball(int x, int y, int radius, Spielfeld spielfeld) {
        this.spielfeld = spielfeld;

        if (x >= 0 && x <= spielfeld.getWidth()) {
            this.x = x;
        }

        if (y >= 0 && y <= spielfeld.getHeight()) {
            this.y = y;
        }

        this.durchmesser = radius;

        thread = new Thread(this);
        thread.setDaemon(true);
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public boolean setGeschwindigkeit(int geschwindigkeit) {
        if (geschwindigkeit <= 1000 && geschwindigkeit >= 0) {
            this.geschwindigkeit = geschwindigkeit;
            return true;
        }

        return false;
    }

    public double getX() {
        return x;
    }

    public boolean setX(int x) {
        if (x >= 0 && x <= spielfeld.getWidth()) {
            this.x = x;
            return true;
        }

        return false;
    }

    public double getY() {
        return y;
    }

    public boolean setY(int y) {
        if (y >= 0 && y <= spielfeld.getHeight()) {
            this.y = y;
            return true;
        }

        return false;
    }

    public int getRadius() {
        return durchmesser;
    }

    public boolean setRadius(int radius) {
        this.durchmesser = radius;
        return true;
    }

    public void start() {
        thread.start();
    }
    private int count = 0;
    private boolean amSchlag = true;

    @Override
    public void run() {
        while (true) {

            if (x <= 0 || x >= spielfeld.getWidth() - this.getRadius()) {
                PongSound.PONG_POINT.playSound();
                spielfeld.resetBall();
                continue;
            }

            if (y <= 0 || y + durchmesser >= spielfeld.getHeight()) {
                PongSound.PONG_WALL.playSound();
                richtungY *= -1;
                if (y < 0) {
                    y = 0;
                }
                if (y + durchmesser > spielfeld.getHeight()) {
                    y = spielfeld.getHeight() - durchmesser;
                }
            }



            //Schlaeger1
            synchronized (spielfeld.schlaeger1) {
                if (amSchlag
                        && spielfeld.ballImage.intersects(spielfeld.paddle1)) {
                    richtungX *= -1;

                    double tmp;
                    debug[0] = tmp = (spielfeld.schlaeger1.y + spielfeld.schlaeger1.height / 2) - (y + durchmesser / 2);
                    debug[1] = tmp = tmp / (spielfeld.schlaeger1.height / 2);
                    if (tmp >= 0) {
                        debug[2] = tmp = 1 - tmp;
                    } else {
                        debug[2] = tmp = -1 - tmp;
                    }
                    //debug[3] = tmp = (aufteilung * richtungY * -1 + tmp) / 2;
                    if (tmp >= 0) {
                        richtungY = 1;
                        aufteilung = tmp;
                    } else if (tmp < 0) {
                        richtungY = -1;
                        aufteilung = tmp * -1;
                    }

                    setGeschwindigkeit(999);
                    count = 0;
                    ++spielfeld.score;
                    spielfeld.scoreLabel.setText(String.valueOf(spielfeld.score));
                    amSchlag = false;
                    PongSound.PONG_PADDLE.playSound();

                }
            }


            synchronized (spielfeld.schlaeger2) {
                if (amSchlag
                        && spielfeld.ballImage.intersects(spielfeld.paddle2)) {
                    richtungX *= -1;

                    double tmp;
                    debug[0] = tmp = (spielfeld.schlaeger2.y + spielfeld.schlaeger2.height / 2) - (y + durchmesser / 2);
                    debug[1] = tmp = tmp / (spielfeld.schlaeger2.height / 2);
                    if (tmp >= 0) {
                        debug[2] = tmp = 1 - tmp;
                    } else {
                        debug[2] = tmp = -1 - tmp;
                    }
                    //debug[3] = tmp = (aufteilung * richtungY * -1 + tmp) / 2;
                    if (tmp >= 0) {
                        richtungY = 1;
                        aufteilung = tmp;
                    } else if (tmp < 0) {
                        richtungY = -1;
                        aufteilung = tmp * -1;
                    }

                    setGeschwindigkeit(999);
                    count = 0;
                    ++spielfeld.score;
                    spielfeld.scoreLabel.setText(String.valueOf(spielfeld.score));
                    amSchlag = false;
                    PongSound.PONG_PADDLE.playSound();

                }
            }

            Rectangle2D rect = spielfeld.line.getBounds2D();
            rect = new Rectangle2D.Double(rect.getX(), rect.getY(), 10,
                    rect.getHeight());

            if (spielfeld.ballImage.intersects(rect) && !amSchlag) {
                amSchlag = true;
            }

            x += aufteilung * richtungX;
            y += (1 - aufteilung) * richtungY;

            if (count++ == 400) {
                if (geschwindigkeit > 999) {
                    setGeschwindigkeit(geschwindigkeit - 1);
                }
                count = 0;
            }

            try {

                Thread.sleep(0, 1000 - geschwindigkeit);
            } catch (InterruptedException ex) {
            }
        }
    }
}
