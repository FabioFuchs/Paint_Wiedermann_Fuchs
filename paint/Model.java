package paint;

import java.awt.Color;

import javax.swing.JColorChooser;

public class Model {
	
	public Color chooseColor() {
		Color c = JColorChooser.showDialog(null, "Farbe", Color.BLACK);
		return c;
	}
}
