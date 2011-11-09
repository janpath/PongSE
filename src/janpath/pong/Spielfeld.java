/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janpath.pong;

/**
 *
 * @author Jan Path
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.TimerTask;

public class Spielfeld extends JPanel {

    public Ball ball;
    public Schlaeger schlaeger1;
    public Schlaeger schlaeger2;
    public Rectangle2D.Double paddle1;
    public Rectangle2D.Double paddle2;
    public Ellipse2D.Double ballImage;
    public Line2D.Double line;
    private java.util.Timer timer = new java.util.Timer(true);
    public int score;
    public int geschwindigkeit = 999;
    public JLabel scoreLabel;
    public Ellipse2D.Double[] echo = new Ellipse2D.Double[10];

    public Spielfeld(Rectangle rect) {
        setBounds(rect);

        ball = new Ball((getWidth() / 2) - 6, (getHeight() / 2) - 6, 12, this);

        setBackground(Color.BLACK);

        schlaeger1 = new Spieler(0, getHeight() / 2 - 45, 12, 90, this);
        schlaeger2 = new Computer(getWidth() - 12, getHeight() / 2 - 45, 12, 90, this);

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(img,
                new Point(0, 0), "wech");
        setCursor(cursor);

        line = new Line2D.Double(getWidth() / 2, 0, getWidth() / 2, getHeight());

        paddle1 = new Rectangle2D.Double(schlaeger1.getX(), schlaeger1.getY(),
                schlaeger1.getWidth(), schlaeger1.getHeight());
        paddle2 = new Rectangle2D.Double(schlaeger2.getX(), schlaeger2.getY(),
                schlaeger2.getWidth(), schlaeger2.getHeight());
        ballImage = new Ellipse2D.Double(ball.getX(), ball.getY(),
                ball.getRadius(), ball.getRadius());

        setLayout(null);
        scoreLabel = new JLabel();
        scoreLabel.setBounds(100, 30, 200, 30);
        scoreLabel.setText(String.valueOf(score));

        add(scoreLabel);

        timer.schedule(new Renderer(), 0, 1);

        ball.setGeschwindigkeit(geschwindigkeit);
        ball.richtungX = ((int) (Math.random() * 2) == 0) ? 1 : -1;
        ball.richtungY = ((int) (Math.random() * 2) == 0) ? 1 : -1;
        ball.aufteilung = Math.random();
        ball.start();

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        int alpha = 0xFF;
        for (int i = 0; i < echo.length; ++i) {
            if (echo[i] != null) {
                g2.setColor(new Color(0xFF, 00, 00, (alpha -= 20)));
                g2.fill(echo[i]);
            } else {
                break;
            }
        }

        BufferedImage bi = new BufferedImage(1, 2, BufferedImage.TYPE_INT_RGB);
        Graphics2D big = bi.createGraphics();
        big.setColor(Color.WHITE);
        big.fillRect(0, 0, 1, 1);
        big.setColor(new Color(0x555555));
        big.fillRect(0, 1, 1, 1);
        Rectangle r1 = new Rectangle(0, 0, 1, 2);
        g2.setPaint(new TexturePaint(bi, r1));

        paddle1 = new Rectangle2D.Double(schlaeger1.getX(), schlaeger1.getY(),
                schlaeger1.getWidth(), schlaeger1.getHeight());
        g2.fill(paddle1);

        paddle2 = new Rectangle2D.Double(schlaeger2.getX(), schlaeger2.getY(),
                schlaeger2.getWidth(), schlaeger2.getHeight());
        g2.fill(paddle2);
        Stroke drawingStroke = new BasicStroke(8, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 0, new float[]{16}, 0);
        g2.setStroke(drawingStroke);
        g2.draw(line);

        ballImage = new Ellipse2D.Double(ball.getX(), ball.getY(),
                ball.getRadius(), ball.getRadius());
        g2.fill(ballImage);


        for (int i = echo.length - 1; i < 0; --i) {
            echo[i + 1] = echo[i];
            echo[i + 1].height -= 0d;
            echo[i + 1].width -= 0d;
        }
        echo[0] = ballImage;

    }

    public void resetBall() {
        score = 0;
        scoreLabel.setText(String.valueOf(score));

        synchronized (ball) {
            ball.setX(getWidth() / 2 - ball.durchmesser / 2);
            ball.setY(getHeight() / 2 - ball.durchmesser / 2);
            ball.richtungX = ((int) (Math.random() * 2) == 0) ? 1 : -1;
            ball.richtungY = ((int) (Math.random() * 2) == 0) ? 1 : -1;
            do {
                ball.aufteilung = Math.random();
            } while (ball.aufteilung < 0.3);
            ball.setGeschwindigkeit(geschwindigkeit);
        }
    }

    private class Renderer extends TimerTask {

        @Override
        public void run() {
            repaint();
        }
    }
}
