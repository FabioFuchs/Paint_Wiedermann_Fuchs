package Rechtecke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Hier werden die Elemente auf dem JPanel hinzugefügt.
 * @author Fabio Fuchs
 * @version 2017-05-09
 *  
 */

public class RechteckePanel extends JPanel{
	
	private JButton bNix, bEins, bZehn;
	private RechteckeGrafik rechtecke;
	
	public RechteckePanel() {
		
		this.setLayout(new BorderLayout());
		SarahMachtDasSchon sarah = new SarahMachtDasSchon();
		
		rechtecke = new RechteckeGrafik();
		this.add(rechtecke);
		
		JPanel gl = new JPanel(new GridLayout(1, 3, 1, 3));
		bNix = new JButton("Feld clearen");
		bNix.addActionListener(sarah);
		gl.add(bNix);
		
		bEins = new JButton("Ein Rechteck");
		bEins.addActionListener(sarah);
		gl.add(bEins);
		
		bZehn = new JButton("Zehn Rechtecke");
		bZehn.addActionListener(sarah);
		gl.add(bZehn);
		
		this.add(gl, BorderLayout.PAGE_START);
	

		
		
	}
	
	/**
	 * Hier wird der ActionHandler (SarahMachtDasSchon) eingebaut.
	 * @author Fabio Fuchs
	 * @version 2017-05-09
	 *  
	 */
	
	public class SarahMachtDasSchon implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == bNix) {
				
				rechtecke.setAnzahl(0);
				
			}
			
			else if(e.getSource() == bEins) {
				
				rechtecke.setAnzahl(1);
				
			}
			
			else if(e.getSource() == bZehn) {
				
				rechtecke.setAnzahl(10);
				
			}
		}
	}
}
