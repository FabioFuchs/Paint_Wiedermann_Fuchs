package paint;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Controller implements ActionListener, MouseListener, MouseMotionListener {
    private Model m;
    private Panel p;
    private View v;
    
    private Color c;
    private Point ponta;
    private ArrayList<Point> al;
    private Color stift = new Color(49, 179, 0);

    
    public Controller() {
        this.m = new Model();
        this.p = new Panel(this);
        this.v = new View(this.p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand() == "Stift") {
    		this.p.getBg().setBackground(this.m.chooseColor());
    	}else if(e.getActionCommand() == "Hintergrund"){
    		this.c = m.chooseColor();
    		this.p.setBackground(c);
    	}
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.ponta = e.getPoint();
		if(this.p.getFreihand().isSelected()){
			this.al = new ArrayList<>();
			Point[] pa = new Point[this.al.size()];
			for(int i = 0; i < al.size(); i++){
				pa[i] = al.get(i);
			}
			
			Drawable d = new FreihandZeichnen(null, this.stift, null, pa);
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.p.getFreihand().isSelected()) {
            al.add(e.getPoint());
            Point[] pa = new Point[this.al.size()];
            for (int i = 0; i < al.size(); i++) {
                pa[i] = al.get(i);
            }
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
	public static void main(String[] args) {
        Controller c = new Controller();
    }
}
