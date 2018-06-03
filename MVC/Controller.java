package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Model m;
    private Panel p;

    public Controller() {
        this.m = new Model();
        this.p = new Panel(this, this.m);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }


}
