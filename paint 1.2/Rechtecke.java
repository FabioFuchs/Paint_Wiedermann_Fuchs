package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Rechtecke extends JPanel implements Element{

	private Rectangle selection;
	private MouseAdapter ma = new MouseAdapter() {

        private Point clickPoint;

        @Override
        public void mousePressed(MouseEvent e) {
            clickPoint = e.getPoint();
            selection = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point dragPoint = e.getPoint();
            int x = Math.min(clickPoint.x, dragPoint.x);
            int y = Math.min(clickPoint.y, dragPoint.y);

            int width = Math.max(clickPoint.x, dragPoint.x) - x;
            int height = Math.max(clickPoint.y, dragPoint.y) - y;

            if (selection == null) {
                selection = new Rectangle(x, y, width, height);
            } else {
                selection.setBounds(x, y, width, height);
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            selection = null;
            repaint();
        }

    };

	@Override
	public void draw(Graphics g) {
		int x;
		
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

}
