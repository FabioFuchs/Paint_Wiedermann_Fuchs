package Rechtecke;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Hier werden die Elemente auf dem JPanel hinzugefügt.
 * @author Fabio Fuchs
 * @version 2017-05-15
 *  
 */

public class VieleRechteckeRBCBPanel extends JPanel {

	private JRadioButton rb0, rb1, rb10;
	private JCheckBox cb1;
	private VieleRechteckeKomponentenGrafik rechtecke;
	
	public VieleRechteckeRBCBPanel() {
		
		this.setLayout(new BorderLayout());
		JPanel oben = new JPanel(new GridLayout(1, 4, 0, 4));
		ActionHandler actionH = new ActionHandler();
		CheckBoxHandler checkboxH = new CheckBoxHandler();
		ButtonGroup group1 = new ButtonGroup();
		
		rb0 = new JRadioButton("Feld clearen");
		rb0.addActionListener(actionH);
		group1.add(rb0);
		oben.add(rb0);
		
		rb1 = new JRadioButton("1 Rechteck");
		rb1.addActionListener(actionH);
		group1.add(rb1);
		oben.add(rb1);
		
		rb10 = new JRadioButton("10 Rechtecke");
		rb10.addActionListener(actionH);
		group1.add(rb10);
		oben.add(rb10);
		
		cb1 = new JCheckBox("Rechtecke ausgefüllt");
		cb1.addItemListener(checkboxH);
		cb1.setSelected(true);
		oben.add(cb1);
		
		this.add(oben, BorderLayout.PAGE_START);
		
		rechtecke = new VieleRechteckeKomponentenGrafik();
		this.add(rechtecke);
		
		
	}
	public class ActionHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == rb0) {
				
				rechtecke.setAnzahl(0);
				
			}
			
			else if(e.getSource() == rb1) {
				
				rechtecke.setAnzahl(1);
				
			}
			
			else if(e.getSource() == rb10) {
				
				rechtecke.setAnzahl(10);
				
			}
		}
	}
	private class CheckBoxHandler implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(cb1.isSelected()) {
				
				rechtecke.setBefuellt(true);
				
			}
			
			else {
				
				rechtecke.setBefuellt(false);
				
		}
	}
}
}