/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.janpath.pongSE;

/**
 *
 * @author Jan
 */
import java.util.Properties;
import javax.swing.JDialog;
import java.awt.event.*;
import java.io.*;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;

public class PongProperties {

	public static Properties prop = new Properties();
	private static File file = new File(".properties");
	private static PropertiesDialog dialog;

	public static void showDialog() {
		dialog = new PropertiesDialog();
		dialog.setModal(true);
		dialog.setSize(550, 270);
		dialog.setVisible(true);

	}
	
	public static void load() {
		try {
			prop.load(new FileInputStream(file));
		} catch (IOException ex) { }
	}
	
	public static void store() {
		try {
			prop.store(new FileOutputStream(file), "");
		} catch (IOException ex) { }
	}

	private static class PropertiesDialog extends JDialog {

		private Properties propBuffer = (Properties) prop.clone();

		PropertiesDialog() {
			getContentPane().add(new PropertiesPanel());
		}

		private class PropertiesPanel extends javax.swing.JPanel {

			/** Creates new form NewJPanel */
			public PropertiesPanel() {
				initComponents();

			}

			/** This method is called from within the constructor to
			 * initialize the form.
			 * WARNING: Do NOT modify this code. The content of this method is
			 * always regenerated by the Form Editor.
			 */
			// <editor-fold defaultstate="collapsed" desc="Generated Code">
			private void initComponents() {
				java.awt.GridBagConstraints gridBagConstraints;

				buttonGroup1 = new javax.swing.ButtonGroup();
				jPanel2 = new javax.swing.JPanel();
				jLabel3 = new javax.swing.JLabel();
				jLabel4 = new javax.swing.JLabel();
				buttonGroup2 = new javax.swing.ButtonGroup();
				jTabbedPane1 = new javax.swing.JTabbedPane();
				steuerung = new javax.swing.JPanel();
				steuerungPanel = new javax.swing.JPanel();
				steuerungLabel = new javax.swing.JLabel();
				steuerungMaus = new javax.swing.JRadioButton();
				steuerungTastatur = new javax.swing.JRadioButton();
				filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				spieler1Panel = new javax.swing.JPanel();
				spieler1Label = new javax.swing.JLabel();
				spieler1Hoch = new javax.swing.JToggleButton();
				spieler1Runter = new javax.swing.JToggleButton();
				spieler1Links = new javax.swing.JToggleButton();
				spieler1Rechts = new javax.swing.JToggleButton();
				filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
				filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(4, 0), new java.awt.Dimension(4, 0), new java.awt.Dimension(4, 32767));
				filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				spieler2Panel = new javax.swing.JPanel();
				spieler2Label = new javax.swing.JLabel();
				spieler2Hoch = new javax.swing.JToggleButton();
				spieler2Runter = new javax.swing.JToggleButton();
				spieler2Links = new javax.swing.JToggleButton();
				spieler2Rechts = new javax.swing.JToggleButton();
				filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(3, 0), new java.awt.Dimension(3, 0), new java.awt.Dimension(3, 32767));
				filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 4), new java.awt.Dimension(0, 4), new java.awt.Dimension(32767, 4));
				filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
				filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
				filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
				okButton = new javax.swing.JButton();
				setButton = new javax.swing.JButton();
				abortButton = new javax.swing.JButton();
				filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 0), new java.awt.Dimension(2, 0), new java.awt.Dimension(2, 32767));
				filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
				filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));

				javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
				jPanel2.setLayout(jPanel2Layout);
				jPanel2Layout.setHorizontalGroup(
						jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
				jPanel2Layout.setVerticalGroup(
						jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

				jLabel3.setText("jLabel3");

				jLabel4.setText("jLabel4");

				setLayout(new java.awt.GridBagLayout());

				steuerung.setLayout(new java.awt.GridBagLayout());

				steuerungPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
				steuerungPanel.setLayout(new java.awt.GridBagLayout());

				steuerungLabel.setText("Steuerung");
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.gridheight = 2;
				steuerungPanel.add(steuerungLabel, gridBagConstraints);

				buttonGroup1.add(steuerungMaus);
				steuerungMaus.setSelected(true);
				steuerungMaus.setText("Maus");
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 2;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
				steuerungPanel.add(steuerungMaus, gridBagConstraints);

				buttonGroup1.add(steuerungTastatur);
				steuerungTastatur.setText("Tastatur");
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 2;
				gridBagConstraints.gridy = 2;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
				steuerungPanel.add(steuerungTastatur, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridheight = 3;
				steuerungPanel.add(filler1, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridwidth = 2;
				steuerungPanel.add(filler2, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridheight = 3;
				steuerungPanel.add(filler3, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.gridwidth = 2;
				steuerungPanel.add(filler4, gridBagConstraints);

				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridwidth = 3;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
				gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 105);
				steuerung.add(steuerungPanel, gridBagConstraints);

				spieler1Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
				spieler1Panel.setLayout(new java.awt.GridBagLayout());

				spieler1Label.setText("Spieler 1");
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.gridwidth = 3;
				spieler1Panel.add(spieler1Label, gridBagConstraints);

				buttonGroup2.add(spieler1Hoch);
				spieler1Hoch.setText("Hoch");
				spieler1Hoch.setToolTipText("Hoch");
				spieler1Hoch.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 2;
				spieler1Panel.add(spieler1Hoch, gridBagConstraints);

				buttonGroup2.add(spieler1Runter);
				spieler1Runter.setText("Runter");
				spieler1Runter.setToolTipText("Runter");
				spieler1Runter.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 2;
				spieler1Panel.add(spieler1Runter, gridBagConstraints);

				buttonGroup2.add(spieler1Links);
				spieler1Links.setText("Links");
				spieler1Links.setToolTipText("Links");
				spieler1Links.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 4;
				spieler1Panel.add(spieler1Links, gridBagConstraints);

				buttonGroup2.add(spieler1Rechts);
				spieler1Rechts.setText("Rechts");
				spieler1Rechts.setToolTipText("Rechts");
				spieler1Rechts.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 4;
				spieler1Panel.add(spieler1Rechts, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.gridwidth = 3;
				spieler1Panel.add(filler10, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 2;
				gridBagConstraints.gridy = 2;
				gridBagConstraints.gridheight = 3;
				spieler1Panel.add(filler11, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridwidth = 3;
				spieler1Panel.add(filler16, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 5;
				gridBagConstraints.gridwidth = 3;
				spieler1Panel.add(filler17, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 4;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridheight = 5;
				spieler1Panel.add(filler18, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridheight = 6;
				spieler1Panel.add(filler19, gridBagConstraints);

				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 1;
				steuerung.add(spieler1Panel, gridBagConstraints);

				spieler2Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
				spieler2Panel.setLayout(new java.awt.GridBagLayout());

				spieler2Label.setText("Spieler 2");
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.gridwidth = 3;
				spieler2Panel.add(spieler2Label, gridBagConstraints);

				buttonGroup2.add(spieler2Hoch);
				spieler2Hoch.setText("Hoch");
				spieler2Hoch.setToolTipText("Hoch");
				spieler2Hoch.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 2;
				spieler2Panel.add(spieler2Hoch, gridBagConstraints);

				buttonGroup2.add(spieler2Runter);
				spieler2Runter.setText("Runter");
				spieler2Runter.setToolTipText("Runter");
				spieler2Runter.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 2;
				spieler2Panel.add(spieler2Runter, gridBagConstraints);

				buttonGroup2.add(spieler2Links);
				spieler2Links.setText("Links");
				spieler2Links.setToolTipText("Links");
				spieler2Links.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 4;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
				spieler2Panel.add(spieler2Links, gridBagConstraints);

				buttonGroup2.add(spieler2Rechts);
				spieler2Rechts.setText("Rechts");
				spieler2Rechts.setToolTipText("Rechts");
				spieler2Rechts.addItemListener(new java.awt.event.ItemListener() {

					@Override
					public void itemStateChanged(java.awt.event.ItemEvent evt) {
						contolButtons(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 4;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
				spieler2Panel.add(spieler2Rechts, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 2;
				gridBagConstraints.gridy = 2;
				gridBagConstraints.gridheight = 3;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
				gridBagConstraints.weighty = 0.1;
				spieler2Panel.add(filler8, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.gridwidth = 3;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
				spieler2Panel.add(filler9, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 4;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.gridheight = 4;
				spieler2Panel.add(filler20, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 1;
				gridBagConstraints.gridheight = 4;
				spieler2Panel.add(filler21, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 5;
				gridBagConstraints.gridwidth = 5;
				spieler2Panel.add(filler22, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridwidth = 5;
				spieler2Panel.add(filler23, gridBagConstraints);

				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 1;
				steuerung.add(spieler2Panel, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 2;
				steuerung.add(filler12, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 2;
				gridBagConstraints.gridwidth = 3;
				steuerung.add(filler13, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 4;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridheight = 2;
				steuerung.add(filler14, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridheight = 2;
				steuerung.add(filler15, gridBagConstraints);

				jTabbedPane1.addTab("Steuerung", steuerung);

				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 0;
				gridBagConstraints.gridwidth = 5;
				gridBagConstraints.gridheight = 2;
				gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
				add(jTabbedPane1, gridBagConstraints);

				okButton.setText("Ok");
				okButton.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						okButtonActionPerformed(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
				add(okButton, gridBagConstraints);

				setButton.setText("Übernehmen");
				setButton.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						setButtonActionPerformed(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 2;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
				add(setButton, gridBagConstraints);

				abortButton.setText("Abbrechen");
				abortButton.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						abortButtonActionPerformed(evt);
					}
				});
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 4;
				gridBagConstraints.gridy = 3;
				gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
				add(abortButton, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 1;
				gridBagConstraints.gridy = 3;
				add(filler5, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 3;
				gridBagConstraints.gridy = 3;
				add(filler6, gridBagConstraints);
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = 0;
				gridBagConstraints.gridy = 2;
				gridBagConstraints.gridwidth = 4;
				add(filler7, gridBagConstraints);
			}// </editor-fold>

			private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
				if ("Maus".equals(buttonGroup1.getSelection().getActionCommand())) {
					propBuffer.setProperty("control", "mouse");
				} else if("Tastatur".equals(buttonGroup1.getSelection().getActionCommand())) {
					propBuffer.setProperty("control", "keyboard");
				}
				
				prop = propBuffer;
				store();
				dialog.setVisible(false);
				
			}

			private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {
				if ("Maus".equals(buttonGroup1.getSelection().getActionCommand())) {
					propBuffer.setProperty("control", "mouse");
				} else if("Tastatur".equals(buttonGroup1.getSelection().getActionCommand())) {
					propBuffer.setProperty("control", "keyboard");
				}
				
				prop = propBuffer;
				store();
			}

			private void contolButtons(java.awt.event.ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					((JToggleButton) evt.getSource()).addKeyListener(controlButtonListener);
				}
				if (evt.getStateChange() == ItemEvent.DESELECTED) {
					((JToggleButton) evt.getSource()).removeKeyListener(controlButtonListener);
				}
			}

			private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {
				getParent().setVisible(false);
				dialog.setVisible(false);
			}
			
			private KeyListener controlButtonListener = new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					((JToggleButton) e.getSource()).setText(KeyEvent.getKeyText(e.getKeyCode()));
					
					String propKey = null;
					
					if (e.getSource() == spieler1Links) {
						propKey = "player1Left";
					} else if (e.getSource() == spieler1Rechts) {
						propKey = "player1Right";
					} else if (e.getSource() == spieler1Hoch) {
						propKey = "player1Up";
					} else if (e.getSource() == spieler1Runter) {
						propKey = "player1Down";
					} else if (e.getSource() == spieler2Links) {
						propKey = "player2Left";
					} else if (e.getSource() == spieler2Rechts) {
						propKey = "player2Right";
					} else if (e.getSource() == spieler2Hoch) {
						propKey = "player2Up";
					} else if (e.getSource() == spieler2Runter) {
						propKey = "player2Down";
					}
					
					propBuffer.setProperty(propKey, String.valueOf(e.getKeyCode()));
				}
			};
			// Variables declaration - do not modify
			private javax.swing.JButton abortButton;
			private javax.swing.ButtonGroup buttonGroup1;
			private javax.swing.ButtonGroup buttonGroup2;
			private javax.swing.Box.Filler filler1;
			private javax.swing.Box.Filler filler10;
			private javax.swing.Box.Filler filler11;
			private javax.swing.Box.Filler filler12;
			private javax.swing.Box.Filler filler13;
			private javax.swing.Box.Filler filler14;
			private javax.swing.Box.Filler filler15;
			private javax.swing.Box.Filler filler16;
			private javax.swing.Box.Filler filler17;
			private javax.swing.Box.Filler filler18;
			private javax.swing.Box.Filler filler19;
			private javax.swing.Box.Filler filler2;
			private javax.swing.Box.Filler filler20;
			private javax.swing.Box.Filler filler21;
			private javax.swing.Box.Filler filler22;
			private javax.swing.Box.Filler filler23;
			private javax.swing.Box.Filler filler3;
			private javax.swing.Box.Filler filler4;
			private javax.swing.Box.Filler filler5;
			private javax.swing.Box.Filler filler6;
			private javax.swing.Box.Filler filler7;
			private javax.swing.Box.Filler filler8;
			private javax.swing.Box.Filler filler9;
			private javax.swing.JLabel jLabel3;
			private javax.swing.JLabel jLabel4;
			private javax.swing.JPanel jPanel2;
			private javax.swing.JTabbedPane jTabbedPane1;
			private javax.swing.JButton okButton;
			private javax.swing.JButton setButton;
			private javax.swing.JToggleButton spieler1Hoch;
			private javax.swing.JLabel spieler1Label;
			private javax.swing.JToggleButton spieler1Links;
			private javax.swing.JPanel spieler1Panel;
			private javax.swing.JToggleButton spieler1Rechts;
			private javax.swing.JToggleButton spieler1Runter;
			private javax.swing.JToggleButton spieler2Hoch;
			private javax.swing.JLabel spieler2Label;
			private javax.swing.JToggleButton spieler2Links;
			private javax.swing.JPanel spieler2Panel;
			private javax.swing.JToggleButton spieler2Rechts;
			private javax.swing.JToggleButton spieler2Runter;
			private javax.swing.JPanel steuerung;
			private javax.swing.JLabel steuerungLabel;
			private javax.swing.JRadioButton steuerungMaus;
			private javax.swing.JPanel steuerungPanel;
			private javax.swing.JRadioButton steuerungTastatur;
			// End of variables declaration
		}
	}
}
