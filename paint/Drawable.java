package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * Vorlage für alle Zeichenobjekte
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 */
public abstract class Drawable implements Element, Serializable {
	
	//Attribute
	Polygon poly;
	Graphics g;
	boolean filled = false;
	Color foreground = Color.BLACK;
	
	//Serializable:
	private static final long serialVersionUID = 5237851222374064774L;
	
	/**
	 * Konstruktor, der Polygon instanziert.
	 */
	public Drawable() {
		poly = new Polygon();
	}
	
	/**
	 * Zeichnet eine Figur auf dem Graphics-Kontext
	 * @param g Graphics-Kontext
	 */
	public abstract void draw(Graphics g);
	
	public void trans(Graphics g) {
		Rectangle r = poly.getBounds();
		
		g.setColor(Color.gray);
		g.drawRect((int) (r.getX()-r.getX()/20), (int) (r.getY()-r.getY()/20), (int) (r.getWidth()+r.getX()/10), (int) (r.getHeight()+r.getY()/10));
	}
	
	
	/**
	 * Erzeugt eine Kopie vom eigenen Objekt in die Home-Position
	 */
	@Override
	public abstract Element clone();
	
	
	/**
	 * Einen neuen Punkt hinzufügen<br>
	 * Einige Zeichenmethoden benoetigen mehrere Punkte:<br>
	 * z.b.: Freihand, Line (Start- und Endpunkt),...
	 * wird auch fuer die Methode setHomePosition benoetigt
	 * 
	 * Jedes Objekt sollte ein Polygon im Hintergrund haben
	 * 
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public void addPoint(int x, int y) {
		poly.addPoint(x,y);
	}
	
	
	/**
	 * entfernt den letzten Punkt
	 */
	public void removeLastPoint() {
		poly.npoints--;
	}
	
	
	/**
	 * Element wird auf Position (0/0) gesetzt
	 * poly.getBounds -> poly.translate(-r.x, -r.y)
	 */
	public void setHomePosition() {
		Rectangle b = poly.getBounds();
		int dx = (int) b.getX();
		int dy = (int) b.getY();

		poly.translate(-dx, -dy);
	}
	
	/**
	 * Verschiebt das Element basierend auf x und y Daten der Maus.
	 */
	public void move(int x, int y) {
		Rectangle b = poly.getBounds();
		int dx = x- (int) b.getX();
		int dy = y- (int) b.getY();

		poly.translate(dx, dy);
	}
	
	
	/**
	 * Gibt die aktuelle Farbe foreground zurueck
	 * @return Color
	 */
	public Color getColor() {
		return foreground;
	}
	
	
	/**
	 * Setzt die Farbe des Vordergrundes
	 * @param c the c to set
	 */
	public void setColor(Color foreground) {
		this.foreground = foreground;
	}
	
	/**
	 * Gibt den boolean Wert von filled zurück.
	 */
	public boolean getFilled() {
		return filled;
	}
	
	/**
	 * Setzt den boolean Wert von filled.
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
}
