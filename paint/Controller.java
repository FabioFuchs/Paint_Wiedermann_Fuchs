package paint;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * Der Controller reagiert auf alle Interaktionen des Benutzers
 * Weiteres instanziert er das Model und die View
 * @author Barbara Wiedermann, Fabio Fuchs
 *
 */
public class Controller implements ActionListener, ItemListener, MouseListener, MouseMotionListener {
	View view;
	Panel panel;
	Frame frame;

	Color stift;
	Color bg;

	Drawable current;

	public enum Modus {
		none, freehand, line, rect, roundrect, ellipse, poly, move;
	}

	Modus modus;
	boolean activeTrans = false;

	public Controller() {
		modus = Modus.freehand;
		frame = new Frame();
		panel = new Panel(this, frame);
		view = new View(panel, this);
	}

	public static void main(String[] args) {
		new Controller();
	}

	//Listener
	@Override
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "Neu":
			this.neu();
			break;
		case "Stift":
			stift = JColorChooser.showDialog(null, "Stiftfarbe", null);
			if (stift != null) {
				view.setStift(stift);
			}
			break;
		case "Hintergrund":
			bg = JColorChooser.showDialog(null, "Stiftfarbe", null);
			if (bg != null) {
				view.setBg(bg);
				frame.setBg(bg);
			}

			break;
		case "Laden...":
			this.laden();
			break;
		case "Speichern...":
			this.speichern();
			break;
		case "Element in Home Position":
			this.homeposition();
			break;
		case "Element duplizieren":
			frame.addElement((Drawable) frame.getElements().get(frame.getIndex() - 1).clone());
			this.homeposition();
			break;
		case "Element löschen":
			frame.setIndex(frame.getIndex() - 1);
			break;
		case "Element wiederherstellen":
			frame.setIndex(frame.getIndex() + 1);
			break;
		case "Elementfarbe ändern":
			Color c = JColorChooser.showDialog(null, "Stiftfarbe", null);
			frame.setColor(frame.getIndex(), c);
			frame.repaint();
			break;
		case "Element verschieben":
			modus = Modus.move;
			break;
		case "About":
			this.open(0);
			break;
		case "Hilfe":
			this.open(1);
			break;
		}

		if (!modus.equals(Modus.move)) {
			modus = view.getModus();
		}

		if (modus.equals(Modus.freehand) || modus.equals(Modus.line)) {
			view.enableFill(false);
		} else {
			view.enableFill(true);
		}

	}

	/**
	 * not used
	 */
	@Override
	public void itemStateChanged(ItemEvent it) {
	}

	/**
	 * not used
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	/**
	 * not used
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	/**
	 * not used
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	/**
	 * Wenn die Maus gedrückt wird (ein Zeichenobjekt angefangen wird), wird
	 * überprüft, welcher Modus aktiv ist und setzt ein neues Element.
	 */
	@Override
	public void mousePressed(MouseEvent m) {
		if (!modus.equals(Modus.move)) {
			modus = view.getModus();
		}

		if (modus.equals(Modus.freehand)) {
			current = new Freihand();
		}
		if (modus.equals(Modus.poly)) {
			current = new Polygon();
		}
		if (modus.equals(Modus.line)) {
			current = new Linie();
		}
		if (modus.equals(Modus.rect)) {
			current = new Rechteck();
		}
		if (modus.equals(Modus.roundrect)) {
			current = new RundesRechteck();
		}
		if (modus.equals(Modus.ellipse)) {
			current = new Ellipse();
		}

		if (!modus.equals(Modus.none) && !modus.equals(Modus.move)) {
			current.setColor(stift);
			current.filled = view.getFull();
			frame.addElement(current);
		}

		if (modus.equals(Modus.move)) {
			activeTrans = true;
		}
	}

	/**
	 * Beendet den aktuellen Modus beim Loslassen der Maustaste.
	 */
	@Override
	public void mouseReleased(MouseEvent m) {
		if (!modus.equals(Modus.none) && !modus.equals(Modus.move)) {
			current.addPoint(m.getX(), m.getY());
			frame.repaint();
		}

		if (modus.equals(Modus.move)) {
			activeTrans = false;
			frame.setITrans(-1);
			modus = Modus.none;
		}

		panel.refreshLayers(frame);
	}

	/**
	 * Übergibt dem aktuellen Element die benötigten Werte je nach Modus.
	 */
	@Override
	public void mouseDragged(MouseEvent m) {
		if (!modus.equals(Modus.none) && !modus.equals(Modus.move)) {
			current.addPoint(m.getX(), m.getY());
			frame.repaint();
		}

		if (modus.equals(Modus.move)) {
			frame.verschieben(frame.getIndex(), m.getX(), m.getY());
		}
	}

	/**
	 * not used
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	//Methoden
	/**
	 * Neue Zeichnung starten
	 */
	public void neu() {
		frame.deleteElements();
		frame.setBg(Color.WHITE);
	}

	@SuppressWarnings("unchecked")
	/**
	 * Lädt das ausgewählte File.
	 */
	public void laden() {
		File file = null;
		final JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			System.out.println("Selectes File Laden: " + fc.getSelectedFile());
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<Drawable> dneu;
			try {
				Color bg = (Color) ois.readObject();
				dneu = (ArrayList<Drawable>) ois.readObject();
				frame.setElements(dneu);
				frame.setIndex(dneu.size());
				frame.setBg(bg);
				view.setBg(bg);
				frame.repaint();

				ois.close();
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(view, e.getMessage());
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(view, e.getMessage());
		}

		System.out.println(frame.getElements().size());
	}

	/**
	 * Die Zeichnung speichern.
	 */
	public void speichern() {
		File file = null;
		final JFileChooser fc = new JFileChooser();

		if (fc.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
			file = new File(fc.getSelectedFile().toString());
		}

		if (file == null) {
			JOptionPane.showMessageDialog(view, "Die aktuelle Zeichnung " + " wurde nicht gespeichert!");
			return;
		}

		ArrayList<Drawable> d = frame.getElements();
		int length = frame.getIndex();
		int ok = JOptionPane.YES_OPTION;

		if (file.exists()) {
			ok = JOptionPane.showConfirmDialog(view, "Soll das File " + " überschrieben werden?", "Speichern",
					JOptionPane.YES_NO_OPTION);
		} else {
			file = new File(fc.getSelectedFile().toString() + ".babsifuchsi");
			try {
				file.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(view, e.getMessage());
			}
		}

		if (ok == JOptionPane.YES_OPTION) {
			ObjectOutputStream oos = null;

			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				ArrayList<Drawable> dneu = new ArrayList<Drawable>();

				for (int i = 0; i < length; i++) {
					dneu.add(d.get(i));
				}

				System.out.println(dneu.size());

				oos.writeObject(frame.getBackground());
				oos.writeObject(dneu);
				oos.flush();
				oos.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(view, e.getMessage());
			}
		}
	}

	/**
	 * Verschiebt das Element in die Homeposition.
	 */
	public void homeposition() {
		frame.setHomeposition(-1);
	}

	/**
	 * Öffnet das About / Hilfe Fenster 0 ... About 1 ... Hilfe
	 * 
	 * @param i
	 *            Fensterauswahl
	 */
	private void open(int i) {
		view.open(i);
	}

}
