package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Model extends JPanel{
	
	public Color chooseColor() {
		Color c = JColorChooser.showDialog(null, "Farbe", Color.BLACK);
		return c;
	}

}
