package paint;

import java.awt.Graphics;
/**
 * Enthält alle Funktionen für das Zeichenobjekt Rechteck
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 */
public class Rechteck extends Drawable {
	// Serializable
	private static final long serialVersionUID = -2728663063087907104L;

	/**
	 * {@link Element#draw(Graphics)}
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(foreground);
		int x = poly.xpoints[0];
		int y = poly.ypoints[0];

		int width = 0;
		int height = 0;
		if (poly.npoints > 0) {
			if (poly.xpoints[0] > poly.xpoints[poly.npoints - 1]) {
				x = poly.xpoints[poly.npoints - 1];
			}

			if (poly.ypoints[0] > poly.ypoints[poly.npoints - 1]) {
				y = poly.ypoints[poly.npoints - 1];
			}
			width = poly.xpoints[poly.npoints - 1] - poly.xpoints[0];
			height = poly.ypoints[poly.npoints - 1] - poly.ypoints[0];
		}

		if (width < 0) {
			width = width * (-1);
		}
		if (height < 0) {
			height = height * (-1);
		}

		if (filled) {
			System.out.print("gefülltes Rechteck");
			g.fillRect(x, y, width, height);
		} else {
			g.drawRect(x, y, width, height);
		}

	}

	/**
	 * {@link Element#clone()}
	 */
	@Override
	public Element clone() {
		Rechteck copy = new Rechteck();

		for (int i = 0; i < poly.npoints; i++) {
			copy.addPoint(poly.xpoints[i], poly.ypoints[i]);
		}

		copy.setFilled(this.getFilled());
		copy.setColor(this.getColor());

		return copy;
	}
}
