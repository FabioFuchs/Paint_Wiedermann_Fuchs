package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Drawable{
    private boolean filled;

    public Rectangle(Dimension size, Point position, Color colour, Graphics g, boolean filled) {
        super(size, position, colour, g);
        this.filled = filled;
    }

    public Rectangle(Graphics g) {
        super(g);
    }

    @Override
    public void draw() {
        Color old = super.getG().getColor();
        super.getG().setColor(super.getColour());
        if(this.filled==true){
            super.getG().fillRect((int)super.getPosition().getX(), (int)super.getPosition().getY(), (int)super.getSize().getWidth(), (int)super.getSize().getHeight() );
        }else{
            super.getG().drawRect((int)super.getPosition().getX(), (int)super.getPosition().getY(), (int)super.getSize().getWidth(), (int)super.getSize().getHeight() );
        }
        super.getG().setColor(old);
    }

    @Override
    public Drawable clone() {
        Dimension temps = super.getSize();
        Point tempp = super.getPosition();
        Color tempc = super.getColour();
        Graphics tempg = super.getG();

        return new Rectangle(temps, tempp, tempc, tempg, this.filled);
    }

    @Override
    public String toString() {
        return Drawables.RECTANGLE+
                "\t"+this.getSize().width+","+this.getSize().height+
                "\t"+this.getPosition().x+","+this.getPosition().y+
                "\t"+this.getColour().getRed()+","+this.getColour().getGreen()+","+this.getColour().getBlue()+"\t"+this.filled;
    }

}
