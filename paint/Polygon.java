package paint;

import java.awt.Graphics;
/**
 * Enthält alle Funktionen des Zeichenobjekts Polygon
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 *
 */
public class Polygon extends Drawable {
	private static final long serialVersionUID = 1376732162572434572L;

	/**
	 * {@link Element#draw(Graphics)}
	 */
	@Override
	public void draw(Graphics g) {
		if (filled) {
			g.fillPolygon(poly);
		} else {
			g.drawPolygon(poly);
		}

	}

	/**
	 * {@link Element#clone()}
	 */
	@Override
	public Element clone() {
		Polygon copy = new Polygon();

		for (int i = 0; i < poly.npoints; i++) {
			copy.addPoint(poly.xpoints[i], poly.ypoints[i]);
		}

		copy.setFilled(this.getFilled());
		copy.setColor(this.getColor());

		return copy;
	}

}
