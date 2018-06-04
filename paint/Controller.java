package paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Controller implements ActionListener {
    private Model m;
    private Panel p;
    private View v;
    
    private Color c;

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

	public static void main(String[] args) {
        Controller c = new Controller();
    }
}
