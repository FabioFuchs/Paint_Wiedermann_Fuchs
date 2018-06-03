package MVC;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Model extends JPanel {
    private Color hintergrund;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Aller Getter und Setter Methoden der Klasse Model
     */
    public Color getHintergrund() {
        return hintergrund;
    }

    public void setHintergrund(Color hintergrund) {
        this.hintergrund = hintergrund;
        this.setBackground(this.hintergrund);

        this.repaint();
    }



}
