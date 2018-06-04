package paint;

import java.awt.Graphics;

/**
 * Enthält alle Funktionen des Zeichenobjekts Freihand Zeichnen
 * @author Barbara Wiedermann und Fabio Fuchs 
 * @version 04.06.2018
 */
public class Freihand extends Drawable {

	private static final long serialVersionUID = -3688877327118256067L;

	/**
	 * {@link Element#draw(Graphics)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(foreground);

		g.drawPolyline(poly.xpoints, poly.ypoints, poly.npoints);
	}

	/**
	 * {@link Element#clone()}
	 */
	@Override
	public Element clone() {
		Freihand copy = new Freihand();

		for (int i = 0; i < poly.npoints; i++) {
			copy.addPoint(poly.xpoints[i], poly.ypoints[i]);
		}

		copy.setColor(this.getColor());

		return copy;
	}

}
