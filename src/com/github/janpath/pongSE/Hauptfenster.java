/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.github.janpath.pongSE;

/**
 *
 * @author Jan Path
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Hauptfenster extends JFrame implements ActionListener {

	Spielfeld spielfeld;
	JMenuBar menu = new JMenuBar();
	JMenu menuSpiel = new JMenu();
	JMenuItem menuSpielNeu = new JMenuItem();
	JMenuItem menuSpielBeenden = new JMenuItem();

	public Hauptfenster() {
		super("Pong");

		setSize(816, 661);

		setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 416,
				(Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 361);

		menuSpiel.setText("Spiel");

		menuSpielNeu.setText("Neues Spiel");
		menuSpielNeu.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
		menuSpielNeu.addActionListener(this);

		menuSpielBeenden.setText("Beenden");
		menuSpielBeenden.addActionListener(this);

		menuSpiel.add(menuSpielNeu);
		menuSpiel.add(menuSpielBeenden);

		menu.add(menuSpiel);

		setJMenuBar(menu);

		getContentPane().setLayout(null);

		spielfeld = new Spielfeld(new Rectangle(0, 0, getWidth() - 6,
				getHeight() - 48));

		getContentPane().add(spielfeld);

		setResizable(false);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuSpielNeu) {
			spielfeld.schlaeger1.score = 0;
			spielfeld.schlaeger2.score = 0;

			spielfeld.scoreLabelPlayer1.setText(String.valueOf(spielfeld.schlaeger1.score));
			spielfeld.scoreLabelPlayer2.setText(String.valueOf(spielfeld.schlaeger2.score));

			spielfeld.resetBall();

		} else if (e.getSource() == menuSpielBeenden) {
			System.exit(0);
		}
	}
}
