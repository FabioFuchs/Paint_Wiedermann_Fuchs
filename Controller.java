package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Der Controller reagiert auf alle Interaktionen des Benutzers
 * Weiteres instanziert er das Model und die View
 * @author Barbara
 *
 */
public class Controller implements ActionListener{
	Frame frame;
	Panel panel;
	
	Color stift;
	Color bg;
	
	public enum Modus {
		none, freihand, linie, rect, abger_rect, ellipse, poly, trans;
	}
	
	Modus modus;
	boolean activeTrans = false;
	
	public Controller() {
		modus = Modus.freihand;
		frame = new Frame("Ein Zeichenbrett für die Welt", panel, this);
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	
	/* *********************** *
	 * ****** LISTENER ******* *
	 * *********************** */

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
}
