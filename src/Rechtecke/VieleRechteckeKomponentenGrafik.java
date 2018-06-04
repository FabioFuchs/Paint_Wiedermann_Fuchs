package Rechtecke;

import java.util.Random;
import java.awt.*;

import javax.swing.*;

/**
 * Hier wird die Grafik erzeugt, um sie nachher als Objekt verwenden zu können.
 * @author Fabio Fuchs
 * @version 2017-05-09
 *  
 */

public class VieleRechteckeKomponentenGrafik extends JPanel{
	
	private int anzahl;
	private boolean befuellt;
	
	public void setBefuellt(boolean befuellt) {
		this.befuellt = befuellt;
		repaint();
	}

	public void setAnzahl(int anzahl) {
		
		this.anzahl = anzahl;
		repaint();
		
	}
	
	public VieleRechteckeKomponentenGrafik() {
		
		anzahl = 0;
		befuellt = true;
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if(anzahl == 0) {
			int b = this.getWidth();
			int h = this.getHeight();
			g.setColor(getBackground());
			g.fillRect(0, 0, b, h);
		}
		else {
			int b = this.getWidth();
			int h = this.getHeight();
			Random random = new Random();
			Color[] farben = {Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.PINK, Color.RED, Color.ORANGE, Color.LIGHT_GRAY};
			int x;
			int y;
			int farbe;
			for(int i = 0;i < this.anzahl; i++) {
				
				x = random.nextInt(b - 20);
				y = random.nextInt(h - 20);
				farbe = random.nextInt(farben.length-1);
				g.setColor(farben[farbe]);
				if(this.befuellt) {
					
					g.fillRect(x, y, 20, 20);
					
				}
				
				else {
					
					g.drawRect(x, y, 20, 20);
					
				}
			}
		}
	}
}

