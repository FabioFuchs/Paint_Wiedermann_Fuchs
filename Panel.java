package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Das Panel zeigt alle Erstellten Elemente aus PaintFrame an
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 */

public class Panel extends JPanel {
	//Serializable
	private static final long serialVersionUID = 1L;
	
	JRadioButton[] layers;
	int selectedLayer;
	JPanel rechts;
	
	
	/**
	 * Erzeugt das Panel mit dem Frame.
	 * 
	 * @param controller der PaintController
	 * @param brett das Frame
	 */
	public Panel(Controller controller) {
		//TODO Buttons
		JPanel links = new JPanel();
		links.setLayout(new GridLayout());
		
		
		
		
		
		
		
		this.setLayout(new BorderLayout());
		this.add(links, BorderLayout.WEST);
		this.add(rechts, BorderLayout.EAST);
	}
}
