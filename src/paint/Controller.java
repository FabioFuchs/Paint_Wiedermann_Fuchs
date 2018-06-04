package paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Model m;
    private Panel p;
    private View v;

    public Controller() {
        this.m = new Model();
        this.p = new Panel(this);
        this.v = new View(this.p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }


}
