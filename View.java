package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import paint.Controller.Modus;
/**
* Die Frame erstellt alle Graphischen Komponenten
* @author Barbara Wiedermann und Fabio Fuchs
* @version 04.06.2018
*/
public class View extends JFrame {
	private static final long serialVersionUID = 4768648555633531885L;

	JMenuBar mb;
	JMenu datei, edit, zeichnen, farbe, info, platzhalter;
	JMenuItem[] idatei, iedit, izeich, ifarb, iinfo;
	ButtonGroup modi;

	public View(JPanel panel, Controller c) {
		super("Ein Zeichenbrett für die Welt!");

		// DATEI-MENÜPUNKT
		datei = new JMenu("Datei"); // Array mit allen MenuItems
		JMenuItem[] idatei = { new JMenuItem("Neu"), new JMenuItem("Laden..."), new JMenuItem("Speichern..."), };
		this.idatei = idatei; // Attribut auf die selbe Referenz verweisen lassen

		KeyStroke[] kdatei = { // Array mit allen Shortcuts für die Items
				// STRG+N (NEU)
				KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), };

		// Die zwei Arrays mittels for-Schleife durchgehen
		for (int i = 0; i < idatei.length; i++) {
			datei.add(idatei[i]); // Menüitem zum Menüpunkt hinzufügen
			idatei[i].setAccelerator(kdatei[i]); // Shortcut hinzufügen
			idatei[i].addActionListener(c); // ActionListener hinzufügen
		}

		// EDIT
		edit = new JMenu("Bearbeiten");
		JMenuItem[] iedit = { new JMenuItem("Element löschen"), new JMenuItem("Element wiederherstellen"),
				new JMenuItem("Element duplizieren"), new JMenuItem("Element verschieben"),
				new JMenuItem("Element in Home Position"), new JMenuItem("Elementfarbe ändern") };
		this.iedit = iedit;

		KeyStroke[] kedit = {
				// STRG+N (NEU)
				KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) };

		for (int i = 0; i < iedit.length; i++) {
			edit.add(iedit[i]);
			iedit[i].addActionListener(c);

			if (i < kedit.length) {
				iedit[i].setAccelerator(kedit[i]);
			}

			if (i == 2) {
				edit.addSeparator();
			}
		}

		// ZEICHNEN
		zeichnen = new JMenu("Zeichnen");
		JMenuItem[] izeich = { new JRadioButtonMenuItem("Freihand zeichnen"),
				new JRadioButtonMenuItem("Linien zeichnen"), new JRadioButtonMenuItem("Rechtecke zeichnen"),
				new JRadioButtonMenuItem("Abgerundete Rechtecke zeichnen"),
				new JRadioButtonMenuItem("Ellipsen zeichnen"), new JRadioButtonMenuItem("Polygone zeichnen"),
				new JCheckBoxMenuItem("Ausgefüllt") };
		this.izeich = izeich;
		this.izeich[0].setSelected(true);

		modi = new ButtonGroup();

		for (int i = 0; i < izeich.length; i++) {
			zeichnen.add(izeich[i]);
			if (i != 6) {
				modi.add(izeich[i]);
			}

			if (izeich[i].getClass().equals(JCheckBoxMenuItem.class)) { // Wenn es die Checkbox ist
				izeich[i].addItemListener(c); // Itemlistener hinzufügen
			} else {
				izeich[i].addActionListener(c);
			}

			if (i == 5) {
				zeichnen.addSeparator();
			}
		}

		// FARBE
		farbe = new JMenu("Farbe");
		// TODO Farbvorschau statt / zusätzlich zu Menüpunkt?

		JMenuItem[] ifarb = { new JMenuItem("Stift"), new JMenuItem("Hintergrund") };
		this.ifarb = ifarb;

		for (int i = 0; i < ifarb.length; i++) {
			farbe.add(ifarb[i]);
			ifarb[i].addActionListener(c);
			this.setStift(Color.BLACK);
			this.setBg(Color.WHITE);
		}

		// INFO
		info = new JMenu("Info");
		JMenuItem[] iinfo = { new JMenuItem("About"), new JMenuItem("Hilfe") };
		this.iinfo = iinfo;

		this.iinfo[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));

		for (int i = 0; i < iinfo.length; i++) {
			info.add(iinfo[i]);
			iinfo[i].addActionListener(c);
		}

		platzhalter = new JMenu("             ");
		
		// MENÜ BAR
		mb = new JMenuBar();
		mb.add(datei);
		mb.add(edit);
		mb.add(zeichnen);
		mb.add(farbe);
		this.mb.add(Box.createHorizontalGlue());
		mb.add(info);
		mb.add(platzhalter);

		this.add(mb);
		this.setJMenuBar(mb);

		// FRAME STUFF
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		this.setMinimumSize(getSize());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Setzt die Stiftfarbe.
	 * 
	 * @param c die neue Farbe
	 */
	public void setStift(Color c) {
		JMenuItem item = ifarb[0];
		item.setOpaque(true);
		item.setBackground(c);
		if (c.getRed() + c.getBlue() + c.getGreen() < Color.GRAY.getBlue() + Color.GRAY.getRed()
				+ Color.GRAY.getGreen()) {
			item.setForeground(Color.WHITE);
		}
	}

	/**
	 * Setzt die Hintergrundfarbe.
	 * 
	 * @param c
	 */
	public void setBg(Color c) {
		JMenuItem item = ifarb[1];
		item.setOpaque(true);
		item.setBackground(c);
		if (c.getRed() + c.getBlue() + c.getGreen() < Color.GRAY.getBlue() + Color.GRAY.getRed()
				+ Color.GRAY.getGreen()) {
			item.setForeground(Color.WHITE);
		}
	}

	/**
	 * Gibt den aktuell ausgewählten Modus zurück
	 * 
	 * @return aktuell ausgewählten Modus der Radio-Buttons
	 */
	public Modus getModus() {
		int b = -1;
		for (int i = 0; i < izeich.length - 1; i++) {
			if (izeich[i].isSelected()) {
				b = i;
			}
		}

		switch (b) {
		case -1:
			return Modus.none;
		case 0:
			return Modus.freehand;
		case 1:
			return Modus.line;
		case 2:
			return Modus.rect;
		case 3:
			return Modus.roundrect;
		case 4:
			return Modus.ellipse;
		case 5:
			return Modus.poly;
		}

		return Modus.none;
	}

	/**
	 * Gibt den full (gefüllt) Wert zurück.
	 * 
	 * @return gefüllt (true / false)
	 */
	public boolean getFull() {
		if (izeich[6].isSelected()) {
			return true;
		}
		return false;
	}

	/**
	 * Erlaubt das Setzen von Fill / deaktiviert die Checkbox
	 * 
	 * @param b
	 *            den boolean-Wert
	 */
	public void enableFill(boolean b) {
		if (izeich[6].isSelected()) {
			izeich[6].setSelected(b);
		}
		izeich[6].setEnabled(b);
	}

	/**
	 * Macht die Auswahl von allen Modis weg.
	 */
	public void deselectAll() {
		modi.clearSelection();
	}

	/**
	 * Öffnet ein jeweiliges Fenster mit About / Hilfe.
	 * 
	 * @param i
	 *            bestimmt das Fenster (0... About | 1... Hilfe)
	 */
	public void open(int i) {
		String name = "";
		String text = "";
		if (i == 0) {
			name = "About";
			text = "<html>" + "<h1>Info / About</h1>" + 
					"<h2>Ein Zeichenbrett für die Welt ...</h2>" + 
					"<h3>Autor: Barbara Wiedermann und Fabio Fuchs 3A </h3>" +
					"<h4>Version: 04.06.2018</h4>" + 
					"<br/></br/>" + 
					"<b></b>" + 
					"</html>";
		} else {
			name = "Hilfe / Anleitungen";
			text = "<html>" + "<h2>Zeichnen:</h2>"
					+ "Man kann folgende Elemente zeichnen (Auswahl in der Menüleiste):</br>" + "<ul>"
					+ "<li>Rechteck</li><li>Rundes Rechteck</li><li>Ellipse</li><li>Linie</li><li>Polygon</li><li>Freihand</li>"
					+ "</ul><br/>Das Zeichnen wird durchgeführt, indem man mit der linken Maustaste gedrückt über die Zeichenfläche fährt."
					+ "" + "<h2>Farbauswahl:</h2>"
					+ "Die Farbe kann ausgewählt werden, indem man auf die jeweilige Fläche im Menüpunkt <b>Farbe</b> oder auf die <b>Flächen links</b> drückt."
					+ " Es öffnet sich dann ein Fenster, in dem man eine Farbe auswählt." + ""
					+ "<h2>Elemente verschieben</h2>"
					+ "Das ausgewählte (oder letzte) Element kann verschoben werden indem man unter Menüpunkt <b>Bearbeiten</b> verschieben auswählt oder STRG+T betätigt"
					+ "</html>";
		}
		JFrame f = new JFrame(name);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel ltext = new JLabel();
		ltext.setVerticalAlignment(JLabel.TOP);

		ltext.setText(text);

		ltext.setBorder(new EmptyBorder(0, 10, 0, 10)); // top,left,bottom,right
		panel.add(ltext);
		f.add(panel);
		f.setName(name);
		f.setMinimumSize(new Dimension(500, 600));
		f.pack();
		f.setLocationRelativeTo(null);

		f.setVisible(true);
	}
}
