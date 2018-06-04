package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Drawable {
	private Dimension size;
    private Point position;
    private Color colour;

    private Graphics g;

    public Drawable(Dimension size, Point position, Color colour, Graphics g) {
        this.size = size;
        this.position = position;
        this.colour = colour;
        this.g = g;
    }

    public Drawable(Graphics g) {
        this.size = new Dimension((int) (Math.random() * (100 - 5 + 1) + 5), (int) (Math.random() * (100 - 5 + 1) + 5));

        this.position = new Point((int) (Math.random() * (100 - 5 + 1) + 5), (int) (Math.random() * (100 - 5 + 1) + 5));

        this.colour = new Color((int) (Math.random() * (255 - 0 + 1)), (int) (Math.random() * (255 - 0 + 1)), (int) (Math.random() * (255 - 0 + 1)));

        this.g = g;
    }

    public abstract void draw();

    public abstract Drawable clone();


    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public abstract String toString();

    public String makeStringFromArray(Point[] points, int xy) {
        String x = "";
        for (int i=0; i<points.length; i++) {
            x += points[i].x+",";
        }
        String y = "";
        for (int i=0; i<points.length; i++) {
            y += points[i].y+",";
        }
        String erg = x.substring(0,x.length()-1) + " " + y.substring(0,y.length()-1);
        return erg;
    }
}
