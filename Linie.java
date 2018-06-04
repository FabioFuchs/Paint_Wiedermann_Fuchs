package paint;

import java.awt.Graphics;
/**
 * Enthält alle Funktionen des Zeichenobjekts Line
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 */
public class Linie extends Drawable {

	private static final long serialVersionUID = 7129910282657393237L;

	/**
	 * {@link Element#draw(Graphics)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(foreground);
		int x1 = poly.xpoints[0];
		int x2 = x1;
		if (poly.npoints>0) {
			x2 = poly.xpoints[poly.npoints-1];
		}
	
		int y1 = poly.ypoints[0];
		int y2 = y1;
		if (poly.npoints>0) {
			y2 = poly.ypoints[poly.npoints-1];
		}
		
		g.drawLine(x1, y1, x2, y2);
		
	}
	
	/**
	 * {@link Element#clone()}
	 */
	@Override
	public Element clone() {
		Linie copy = new Linie();
		
		for (int i = 0; i<poly.npoints; i++) {
			copy.addPoint(poly.xpoints[i], poly.ypoints[i]);
		}
		
		copy.setFilled(this.getFilled());
		copy.setColor(this.getColor());
		
		return copy;
	}

}
