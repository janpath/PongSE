/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.github.janpath.pongSE;

/**
 *
 * @author Jan Path & Maximilian Mader
 */
import java.io.*;

public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		//Soundklasse initialisieren
		PongSound.PONG_POINT.hashCode();

		//Einstellungen laden
		File probFile = new File(".properties");
		if (probFile.isFile()) {
			try {
				PongProperties.prop.load(new FileInputStream(probFile));
			} catch (IOException ex) {
			}
		}

		Hauptfenster fenster = new Hauptfenster();
		fenster.setVisible(true);
		Thread.sleep(500);
		fenster.spielfeld.ball.start();

	}
}
