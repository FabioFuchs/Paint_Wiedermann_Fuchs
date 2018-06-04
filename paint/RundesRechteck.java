package paint;

import java.awt.Graphics;

public class RundesRechteck extends Drawable {

	private static final long serialVersionUID = 7798400949836029345L;

	/**
	 * {@link Element#draw(Graphics)}
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auswahl rundungsradius
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

		int corner = width / 10;
		if (height / 10 < corner) {
			corner = height / 10;
		}
		if (filled) {
			g.fillRoundRect(x, y, width, height, corner, corner);
		} else {
			g.drawRoundRect(x, y, width, height, corner, corner);
		}

	}

	/**
	 * {@link Element#clone()}
	 */
	@Override
	public Element clone() {
		RundesRechteck copy = new RundesRechteck();

		for (int i = 0; i < poly.npoints; i++) {
			copy.addPoint(poly.xpoints[i], poly.ypoints[i]);
		}

		copy.setFilled(this.getFilled());
		copy.setColor(this.getColor());

		return copy;
	}

}
