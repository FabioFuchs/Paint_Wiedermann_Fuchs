package MVC;

import java.awt.event.*;

public class Controller implements ActionListener {
    private Model m;
    private View v;

    public Controller() {
        this.m = new Model();
        this.v = new View(this, this.m);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Controller c = new Controller();
    }
}


