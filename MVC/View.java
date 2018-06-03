package MVC;

import javax.swing.*;

public class View extends JFrame{
    private Panel p;

    public View(Panel p){
        super("Ein Zeichenbrett für die Welt&quot;");
        this.add(p);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1300, 1000);
        this.setLocationRelativeTo(null);
    }
}
