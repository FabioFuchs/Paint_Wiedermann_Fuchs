package Rechtecke;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Hier werden die Elemente auf dem JPanel hinzugefügt.
 * @author Fabio Fuchs
 * @version 2017-05-15
 *  
 */

public class VieleRechteckeSliderPanel extends JPanel {

	private JSlider slider1;
	private VieleRechteckeKomponentenGrafik rechtecke;
	
	public VieleRechteckeSliderPanel() {
		
		this.setLayout(new BorderLayout());
		SliderHandler sliderH = new SliderHandler();
		
		slider1 = new JSlider(1, 20);
		slider1.addChangeListener(sliderH);
		this.add(slider1, BorderLayout.PAGE_START);
		
		rechtecke = new VieleRechteckeKomponentenGrafik();
		this.add(rechtecke);
		
	}
	
	private class SliderHandler implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			
			if(e.getSource() != null) {
			
				rechtecke.setAnzahl(slider1.getValue());
			
			}
		}
		
	}
	
}
