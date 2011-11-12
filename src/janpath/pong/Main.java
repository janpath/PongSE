/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package janpath.pong;

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
	File probFile = new File("pong.properties");
	if (probFile.isFile()) {
	    try {
		PongProperties.prop.load(new FileInputStream(probFile));
                PongProperties.prop.setProperty("control", "mouse");
                FileOutputStream probOut = new FileOutputStream(probFile);
                PongProperties.prop.store(probOut, "");
                } catch (IOException ex) {
	    }
	} else {
            try {
                FileOutputStream probOut = new FileOutputStream(probFile);
                PongProperties.prop.setProperty("control", "mouse");
                PongProperties.prop.store(probOut, "");
            } catch (Exception ex) {}
        }
	
	Hauptfenster fenster = new Hauptfenster();
	fenster.setVisible(true);
	Thread.sleep(500);
	fenster.spielfeld.ball.start();

    }
}
