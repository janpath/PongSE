/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package janpath.pong;

/**
 *
 * @author Jan Path & Maximilian Mader
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		//Soundklasse initialisieren
		PongSound.PONG_POINT.hashCode();

		Hauptfenster fenster = new Hauptfenster();
		fenster.setVisible(true);
		Thread.sleep(500);
		fenster.spielfeld.ball.start();

	}
}
