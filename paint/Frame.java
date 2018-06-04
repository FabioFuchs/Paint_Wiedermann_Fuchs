package paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;	
import java.awt.*;	
/**
 * Anzeige des Zeichenbretts
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 *
 */
public class Frame extends JPanel {
	private static final long serialVersionUID = -7244357726112586306L;

	//Attribute
	ArrayList<Drawable> elements;
	int index;		//Die Obergrenze der zu zeichnenden Elemente
	int itrans;		//Das Element, welches gerade verschoben wird (oder -1)
	String pfad;	
	
	/**
	 * Konstruktor für Frame
	 */
	public Frame() {
		elements = new ArrayList<Drawable>();
		index=0;
		itrans=-1;
		this.setBg(Color.WHITE);
		this.revalidate();
		this.repaint();
	}
	
	
	
	/**
	 * Zeichnet die Kreise nach Angabe der Attribute
	 */
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < index; i++) {
			elements.get(i).draw(g);
			if (itrans==i) {
				elements.get(i).trans(g);
			}
		}
	}
	
	/**
	 * Fügt ein neues Zeichenelement zur Element-Liste hinzu.
	 * 
	 * @param element
	 */
	public void addElement(Drawable element) {
		//Falls der Index nicht die Größe ist, mussen zuerst alle nachfolgenden Elemente gelöscht werden
		//"Resetten der Wiederherstellen-Kette"
		for (int i = elements.size()-1; i >= index; i--) {
			elements.remove(i);
		}	
		
		elements.add(element);	
		index++;	//Index hochzählen
		this.repaint();
		this.revalidate();
	}
	
	/**
	 * Setzt die Hintergrundfarbe des Zeichenbretts.
	 * 
	 * @param c
	 */
	public void setBg(Color c) {
		setBackground(c);
		this.revalidate();
	}
	
	/**
	 * Löscht alle Elemente aus dem Array.
	 */
	public void deleteElements() {
		elements = new ArrayList<Drawable>();
		index=0;
		this.repaint();
	}
	
	/**
	 * Gibt die Liste der Elemente zurück.
	 * 
	 * @return die Elemente (ArrayList)
	 */
	public ArrayList<Drawable> getElements() {
		return elements;
	}
	
	/**
	 * Gibt den aktuellen Index/Obergrenze zurück.
	 * 
	 * @return Index/Obergrenze
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Setzt den Index (Obergrenze)
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		if (index<0) {
			index = 0;
		}
		if (index > elements.size()) {
			index = elements.size();
		}
		this.index = index;
		this.repaint();
	}
	
	/**
	 * Setzt die ArrayListe auf die übergebene ArrayListe.
	 * 
	 * @param el
	 */
	public void setElements(ArrayList<Drawable> el) {
		elements = el;
		this.setIndex(elements.size());
	}

	/**
	 * Setzt das angebene Element in die Homeposition.
	 * 
	 * @param i Index (ab 0) (-1 wenn es das letzte Element sein soll)
	 */
	public void setHomeposition(int i) {
		if (i==-1) {
			i = index-1;
		}
		elements.get(i).setHomePosition();
		this.repaint();
	}
	
	/**
	 * Setzt die Farbe des übergebenen Elements auf die übergebene Farbe.
	 * 
	 * @param i den Index
	 * @param c die Farbe
	 */
	public void setColor(int i, Color c) {
		i = i-1;
		elements.get(i).setColor(c);
	}

	/**
	 * Verschiebt das Element auf die übergebene Position.
	 * 
	 * @param i das Element
	 * @param x 
	 * @param y
	 */
	public void verschieben(int i, int x, int y) {
		i = i-1;
		elements.get(i).move(x, y);
		this.repaint();
		
		this.setITrans(i);
	}
	
	/**
	 * Setzt den Index auf das Element das zu verschieben ist.
	 * 
	 * @param i
	 */
	public void setITrans(int i) {
		itrans = i;
	}
	
	public BufferedImage createImage(int index) {
		int w = this.getWidth();
		int h = this.getHeight();
		
		if (w!=0 && h!=0) {
			BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bi.createGraphics();
			this.print(g);
			return bi;
		} 
		return null;
	}
}