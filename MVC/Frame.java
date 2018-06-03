package MVC;

import javax.swing.*;

public class Frame extends JFrame{

    public Frame(Panel panel) {

        super("Ein Zeichenbrett für die Welt&quot;");
        this.add(panel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1300, 1000);
        this.setLocationRelativeTo(null);

    }
}
