package janpath.pong;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Computer extends Schlaeger implements Runnable {

    private Thread thread;

    public Computer(int x, int y, int width, int height, Spielfeld spielfeld) {
        super(x, y, width, height, spielfeld);
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    private class MausSteuerung extends MouseMotionAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public void start() {
        thread.start();
    }

    public void run() {
        int r2 = 0;
        int r3 = 0;
        while (true) {
            double tmpY;
            if (spielfeld.ball.getX() - x < 500
                    && spielfeld.ball.getX() - x > -500) {
                if ((tmpY = spielfeld.ball.getY() - getHeight() / 2
                        + spielfeld.ball.getDurchmesser() / 2 - y) != 0) {

                    synchronized (this) {
                        if (tmpY < 0) {
                            --y;
                        } else if (tmpY > 0) {
                            ++y;
                        }
                    }
                }

                int random2 = (int) (Math.random() * 5000);
                if (random2 <= 5) {
                    r3 = (int) (Math.random() * 5) + 1;
                } else if (random2 > 500 && random2 < 4950) {
                } else {
                    if (r2 != 0) {
                        --r2;
                    }
                    r3 = 0;
                }

                if (r2 < r3) {
                    ++r2;
                }

                try {
                    Thread.sleep(r2);
                } catch (InterruptedException e) {
                }

            } else {
                tmpY = spielfeld.getHeight() / 2 - getHeight() / 2 - y;
                if (tmpY < 0) {
                    --y;
                } else if (tmpY > 0) {
                    ++y;
                }

                try {
                    Thread.sleep(4, 500);
                } catch (InterruptedException e) {
                }
            }

            try {
                Thread.sleep((int) (Math.random() * 3 + 1),
                        (int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
