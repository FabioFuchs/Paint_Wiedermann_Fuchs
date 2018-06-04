package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;

public class Rechtecke extends JPanel implements Element{

	private List<Rectangle> selection;
	private Point clickPoint;
	public List<Rectangle> getSelection() {
		return selection;
	}

	public void setSelection(List<Rectangle> selection) {
		this.selection = selection;
	}

	public void setClickPoint(Point clickPoint) {
		this.clickPoint = clickPoint;
	}

	

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPoint(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLastPoint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHomePosition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		
	}

	public Point getClickPoint() {
		// TODO Auto-generated method stub
		return this.clickPoint;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
