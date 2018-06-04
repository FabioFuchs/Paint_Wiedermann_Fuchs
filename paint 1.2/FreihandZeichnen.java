package paint;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public class FreihandZeichnen extends Drawable{

	 private Point[] points;

	    public FreihandZeichnen(Point point, Color color, Graphics graphics, Point[] points) {
	        super(null, point, color, graphics);
	        this.points = points;
	    }

	    @Override
	    public void draw() {
	        int[] x = new int[this.points.length];
	        int[] y = new int[this.points.length];

	        for(int i = 0; i < this.points.length; i++){
	            x[i] = this.points[i].x;
	            y[i] = this.points[i].y;
	        }

	        Color temp = super.getG().getColor();
	        super.getG().setColor(this.getColour());

	        super.getG().drawPolyline(x, y, x.length);

	        super.getG().setColor(temp);
	    }

	    @Override
	    public Drawable clone() {
	    	FreihandZeichnen clone = new FreihandZeichnen(this.getPosition(), this.getColour(), this.getG(), points);
	        return clone;
	    }

	    @Override
	    public String toString() {
	        return Drawables.FREIHAND + "\t"+this.makeStringFromArray(this.points,0)+"\t"+this.getColour().getRed()+","+this.getColour().getGreen()+","+this.getColour().getBlue();
	    }

	    public Point[] getPoints() {
	        return points;
	    }

	    public void setPoints(Point[] points) {
	        this.points = points;
	    }
	
}
