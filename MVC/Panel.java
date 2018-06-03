package MVC;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Panel extends JPanel implements MouseListener{
    private Model m;
    private View v;

    public Panel(Model m, View v) {
        this.m = m;
        this.v = v;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
