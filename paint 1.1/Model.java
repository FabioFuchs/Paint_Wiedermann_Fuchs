package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Model extends JPanel{
	 protected LinkedList<Drawable> deck = new LinkedList<>();
	 private LinkedList<Drawable> friedhof = new LinkedList<>();
	 private Color hintergrund = new JPanel().getBackground();

	
	public Color chooseColor() {
		Color c = JColorChooser.showDialog(null, "Farbe", Color.BLACK);
		return c;
	}
	

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable d : deck) {
            d.setG(g);
            d.draw();
        }
    }

    /**
     * @param d das Objekt das in die Liste aufgenommen werden soll
     *          <p>
     *          Speichert die gezeichneten Objekte Temporaer
     */
    public void addToDeck(Drawable d) {
        deck.add(d);
    }

    /**
     * Verschiebt das letzte Objekt aus dem aktuellem Speicher in den Zwischenspeicher und loescht es aus dem aktuellem Speicher
     */
    public void moveToFriedhof() {
        if (!deck.isEmpty()) {
            friedhof.add(deck.removeLast());
        }
    }

    /**
     * Verschiebt das letzte Objekt aus dem Zwischenspeicher in den aktuellen Speicher und loescht es aus dem Zwischenspeicher
     */
    public void moveToDeck() {
        if (!friedhof.isEmpty()) {
            deck.add(friedhof.removeLast());
        }
    }

    /**
     * Veraendert die Koordinaten des letzten Objektes auf (0/0)
     */
    public void moveLastHOME() {
        if (!deck.isEmpty()) {
            deck.getLast().setPosition(new Point(0, 0));

        }
    }

    /**
     * Veraendert die Koordinaten des letzten Objektes um -10 auf der Y-Achse
     */
    public void moveLastUP() {
        if (!deck.isEmpty()) {
            if (deck.getLast() instanceof Freihand) {
                for (int i = 0; i < ((Freihand) deck.getLast()).getPoints().length; i++) {
                    ((Freihand) deck.getLast()).getPoints()[i].setLocation(((Freihand) deck.getLast()).getPoints()[i].x, ((Freihand) deck.getLast()).getPoints()[i].y - 10);
                }
            } else if (deck.getLast() instanceof Line) {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x, deck.getLast().getPosition().y - 10));
                ((Line) deck.getLast()).setPosition2(new Point(((Line) deck.getLast()).getPosition2().x, ((Line) deck.getLast()).getPosition2().y - 10));
            } else {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x, deck.getLast().getPosition().y - 10));
            }
        }
    }

    /**
     * Veraendert die Koordinaten des letzten Objektes um +10 auf der Y-Achse
     */
    public void moveLastDOWN() {
        if (!deck.isEmpty()) {
            if (deck.getLast() instanceof Freihand) {
                for (int i = 0; i < ((Freihand) deck.getLast()).getPoints().length; i++) {
                    ((Freihand) deck.getLast()).getPoints()[i].setLocation(((Freihand) deck.getLast()).getPoints()[i].x, ((Freihand) deck.getLast()).getPoints()[i].y + 10);
                }
            } else if (deck.getLast() instanceof Line) {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x, deck.getLast().getPosition().y + 10));
                ((Line) deck.getLast()).setPosition2(new Point(((Line) deck.getLast()).getPosition2().x, ((Line) deck.getLast()).getPosition2().y + 10));
            } else {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x, deck.getLast().getPosition().y + 10));
            }
        }
    }

    /**
     * Veraendert die Koordinaten des letzten Objektes um -10 auf der X-Achse
     */
    public void moveLastLEFT() {
        if (!deck.isEmpty()) {
            if (deck.getLast() instanceof Freihand) {
                for (int i = 0; i < ((Freihand) deck.getLast()).getPoints().length; i++) {
                    ((Freihand) deck.getLast()).getPoints()[i].setLocation(((Freihand) deck.getLast()).getPoints()[i].x - 10, ((Freihand) deck.getLast()).getPoints()[i].y);
                }
            } else if (deck.getLast() instanceof Line) {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x - 10, deck.getLast().getPosition().y));
                ((Line) deck.getLast()).setPosition2(new Point(((Line) deck.getLast()).getPosition2().x - 10, ((Line) deck.getLast()).getPosition2().y));
            } else {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x - 10, deck.getLast().getPosition().y));
            }
        }
    }

    /**
     * Veraendert die Koordinaten des letzten Objektes um +10 auf der X-Achse
     */
    public void moveLastRIGHT() {
        if (!deck.isEmpty()) {
            if (deck.getLast() instanceof Freihand) {
                for (int i = 0; i < ((Freihand) deck.getLast()).getPoints().length; i++) {
                    ((Freihand) deck.getLast()).getPoints()[i].setLocation(((Freihand) deck.getLast()).getPoints()[i].x + 10, ((Freihand) deck.getLast()).getPoints()[i].y);
                }
            } else if (deck.getLast() instanceof Line) {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x + 10, deck.getLast().getPosition().y));
                ((Line) deck.getLast()).setPosition2(new Point(((Line) deck.getLast()).getPosition2().x + 10, ((Line) deck.getLast()).getPosition2().y));
            } else {
                deck.getLast().setPosition(new Point(deck.getLast().getPosition().x - 10, deck.getLast().getPosition().y));
            }
        }
    }

    /**
     * Erstellt ein neues Objekt ident mit dem letzten erstellten Objekt platziert das neue aber auf den (0/0) Position
     */
    public void duplicate() {
        Drawable d = this.deck.getLast().clone();
        this.addToDeck(d);
        this.moveLastHOME();
    }

    /**
     * Erstellt eine neue Liste ergo werden alle jetzigen Objekte geloescht
     */
    public void newFile() {
        this.deck = new LinkedList<>();
    }

    /**
     * Speichert die Liste in einem RandomAccessFile
     */
    public void saveToFile() {
        String speicher = "";
        speicher += this.hintergrund.getRed() + "," + this.hintergrund.getGreen() + "," + this.hintergrund.getBlue() + "\n";
        for (Drawable d : deck) {
            speicher += d.toString() + "\n";
        }


        try {

            File path = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File
                    (System.getProperty("user.home") + System.getProperty("file.separator") + "Documents"));
            int returnValue = fileChooser.showSaveDialog(null);
            path = fileChooser.getSelectedFile();


            RandomAccessFile deck = new RandomAccessFile(path, "rw");


            deck.setLength(0);
            deck.writeBytes(speicher);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Laedt ein ausgewaehltes RandomAccessFile und uebertraegt die Daten daraus in eine neue Liste
     */
    public void readFromFile() {
        this.deck = new LinkedList<>();

        File path = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File
                (System.getProperty("user.home") + System.getProperty("file.separator") + "Documents"));
        int returnValue = fileChooser.showOpenDialog(null);
        path = fileChooser.getSelectedFile();

        try {
            Scanner s = new Scanner((path));

            int z = 0;

            while (s.hasNext()) {
                String temp = s.nextLine();

                if (z == 0) {
                    String[] bg = temp.split(",");
                    this.setHintergrund(new Color(
                            Integer.parseInt(bg[0]),
                            Integer.parseInt(bg[1]),
                            Integer.parseInt(bg[2])
                    ));
                    z++;
                } else {


                    String[] temps = (temp.split("\t"));


                    Drawable d = null;


                    if (temps[0].equals(Drawables.OVAL.name())) {

                        Dimension size = new Dimension(Integer.parseInt(temps[1].split(",")[0]), Integer.parseInt(temps[1].split(",")[1]));

                        Point position = new Point(Integer.parseInt(temps[2].split(",")[0]), Integer.parseInt(temps[2].split(",")[1]));

                        Color color = new Color(Integer.parseInt(temps[3].split(",")[0]), Integer.parseInt(temps[3].split(",")[1]), Integer.parseInt(temps[3].split(",")[2]));

                        d = new Ellipse(size, position, color, null, Boolean.parseBoolean(temps[4])) {
                        };
                    }

                    if (temps[0].equals(Drawables.RECTANGLE.name())) {

                        Dimension size = new Dimension(Integer.parseInt(temps[1].split(",")[0]), Integer.parseInt(temps[1].split(",")[1]));

                        Point position = new Point(Integer.parseInt(temps[2].split(",")[0]), Integer.parseInt(temps[2].split(",")[1]));

                        Color color = new Color(Integer.parseInt(temps[3].split(",")[0]), Integer.parseInt(temps[3].split(",")[1]), Integer.parseInt(temps[3].split(",")[2]));

                        d = new Schule.AU24.Drawable.Rectangle(size, position, color, null, Boolean.parseBoolean(temps[4])) {
                        };
                    }

                    if (temps[0].equals(Drawables.RECTANGLEAB.name())) {

                        Dimension size = new Dimension(Integer.parseInt(temps[1].split(",")[0]), Integer.parseInt(temps[1].split(",")[1]));

                        Point position = new Point(Integer.parseInt(temps[2].split(",")[0]), Integer.parseInt(temps[2].split(",")[1]));

                        Color color = new Color(Integer.parseInt(temps[3].split(",")[0]), Integer.parseInt(temps[3].split(",")[1]), Integer.parseInt(temps[3].split(",")[2]));

                        d = new Rectangleab(size, position, color, null, Boolean.parseBoolean(temps[4])) {
                        };
                    }

                    if (temps[0].equals(Drawables.FREIHAND.name())) {
                        String[] coord = temps[1].split(" ");
                        String[] coord_x = coord[0].split(",");
                        String[] coord_y = coord[1].split(",");
                        String[] colors = temps[2].split(",");
                        Point[] p = new Point[coord_x.length];
                        for (int i = 0; i < coord_x.length; i++) {
                            p[i] = new Point(Integer.parseInt(coord_x[i]), Integer.parseInt(coord_y[i]));
                        }

                        d = new Freihand(
                                null,
                                new Color(
                                        Integer.parseInt(colors[0]),
                                        Integer.parseInt(colors[1]),
                                        Integer.parseInt(colors[2])
                                ),
                                this.getGraphics(),
                                p
                        );
                        this.deck.add(d);
                    }

                    if (temps[0].equals(Drawables.POLYGON.name())) {
                        String[] coord = temps[1].split(" ");
                        String[] coord_x = coord[0].split(",");
                        String[] coord_y = coord[1].split(",");
                        String[] colors = temps[2].split(",");
                        Point[] p = new Point[coord_x.length];
                        for (int i = 0; i < coord_x.length; i++) {
                            p[i] = new Point(Integer.parseInt(coord_x[i]), Integer.parseInt(coord_y[i]));
                        }
                        int[] x = new int[p.length];
                        int[] y = new int[p.length];
                        for (int i = 0; i < x.length; i++) {
                            x[i] = p[i].x;
                            y[i] = p[i].y;
                        }
                        d = new Polygon(
                                x, y,
                                new Color(
                                        Integer.parseInt(colors[0]),
                                        Integer.parseInt(colors[1]),
                                        Integer.parseInt(colors[2])
                                ),
                                this.getGraphics(),
                                Boolean.getBoolean(temps[3])
                        );
                        this.addToDeck(d);
                    }

                    if (temps[0].equals(Drawables.LINE.name())) {
                        String[] coord = temps[1].split(" ");
                        String[] coord_x = coord[0].split(",");
                        String[] coord_y = coord[1].split(",");
                        String[] colors = temps[2].split(",");
                        Point[] p = new Point[coord_x.length];
                        for (int i = 0; i < coord_x.length; i++) {
                            p[i] = new Point(Integer.parseInt(coord_x[i]), Integer.parseInt(coord_y[i]));
                        }
                        d = new Line(
                                null,
                                p[0], p[1],
                                new Color(
                                        Integer.parseInt(colors[0]),
                                        Integer.parseInt(colors[1]),
                                        Integer.parseInt(colors[2])
                                ),
                                this.getGraphics()
                        );
                        this.addToDeck(d);
                    }

                    this.addToDeck(d);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Aller Getter und Setter Methoden der Klasse Model
     */
    public LinkedList<Drawable> getDeck() {
        return deck;
    }

    public void setDeck(LinkedList<Drawable> deck) {
        this.deck = deck;
    }

    public LinkedList<Drawable> getFriedhof() {
        return friedhof;
    }

    public void setFriedhof(LinkedList<Drawable> friedhof) {
        this.friedhof = friedhof;
    }

    public Color getHintergrund() {
        return hintergrund;
    }

    public void setHintergrund(Color hintergrund) {
        this.hintergrund = hintergrund;
        this.setBackground(this.hintergrund);
        this.repaint();
    }

}
