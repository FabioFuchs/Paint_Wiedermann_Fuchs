package Rechtecke;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document; 

/**
 * Hier werden die Elemente auf dem JPanel hinzugefügt.
 * @author Fabio Fuchs
 * @version 2017-05-15
 *  
 */

public class VieleRechteckeTextfeldPanel extends JPanel {

	private JTextField textfeld;
	private VieleRechteckeKomponentenGrafik rechtecke;
	
	public VieleRechteckeTextfeldPanel() {
		
		textfeld = new JTextField(5);
		textfeld.setEditable(true);
		textfeld.setBackground(new Color(0, 0, 0));
		textfeld.setForeground(new Color(255, 255, 255));
		textfeld.setHorizontalAlignment(JTextField.CENTER);
		this.setLayout(new BorderLayout());
		TextfeldHandler textH = new TextfeldHandler();
		Document doc = textfeld.getDocument();
		doc.addDocumentListener(textH);
		this.add(textfeld, BorderLayout.PAGE_START);
		
		rechtecke = new VieleRechteckeKomponentenGrafik();
		this.add(rechtecke);
		
	}
	
	private class TextfeldHandler implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent ev) {
		// Nicht benötigte Methode, deswegen bleibt sie leer
		}
		
		@Override
		public void insertUpdate(DocumentEvent ev) {
			
			int zahl;
			
			try {
				
			zahl = Integer.parseInt(textfeld.getText());
			
			}
			catch(NumberFormatException nfe) {
				zahl = 0;
			}
			
			if(zahl < 0) {
				
				zahl = 0;
				
			}
			
			else if(zahl > 250) {
				
				zahl = 250;
				
			}
			
			rechtecke.setAnzahl(zahl);
			
		}
		
		@Override
		public void removeUpdate(DocumentEvent ev) {
			
			int zahl;
			
			try {
				
			zahl = Integer.parseInt(textfeld.getText());
			
			}
			catch(NumberFormatException nfe) {
				zahl = 0;
			}
			
			if(zahl < 0) {
				
				zahl = 0;
				
			}
			
			else if(zahl > 50) {
				
				zahl = 50;
				
			}
			
			rechtecke.setAnzahl(zahl);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
