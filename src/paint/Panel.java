package paint;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    private Controller c;

    private JMenuBar bar = new JMenuBar();
    private JMenuItem neu, laden, speichern;
    private JMenuItem loeschen, wiederherstellen, duplizieren, home, aendern;
    private JRadioButtonMenuItem freihand, linie, rechteck, rechteckab, ellipse, polygon;
    private JCheckBoxMenuItem gefuellt;
    private Color color;
    private JMenuItem stift, bg;

    public Panel (Controller c){
        this.c = c;
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.PAGE_START, bar);
        this.addDatei();
        this.addBearbeiten();
        this.addZeichnen();
        this.addFarbe();
        this.addInfo();
        this.addAbout();
        this.setVisible(true);
    }

    /**
     * Menüpunkt Datei mit Unterpunkten Datei, Neu, Öffnen, Speichern
     */
    private void addDatei() {
        JMenu menu = new JMenu("Datei");

        this.neu = new JMenuItem("Neu");

        this.laden = new JMenuItem("�ffnen...");

        this.speichern = new JMenuItem("Speichern...");

        menu.add(this.neu);
        menu.add(this.laden);
        menu.add(this.speichern);

        this.bar.add(menu);
    }

    /**
     * Menüpunkt Bearbeiten mit Unterpunkt Bearbeiten, Element löschen, Element wiederherstellen, Element duplizieren, Element in Home Position, Elementfarbe ändern
     */
    private void addBearbeiten() {
        JMenu menu = new JMenu("Bearbeiten");

        this.loeschen = new JMenuItem("Element löschen");

        this.wiederherstellen = new JMenuItem("Element wiederherstellen");

        this.duplizieren = new JMenuItem("Element duplizieren");

        this.home = new JMenuItem("Element in Home Position");

        this.aendern = new JMenuItem("Elementfarbe ändern");

        menu.add(this.loeschen);
        menu.add(this.wiederherstellen);
        menu.add(this.duplizieren);

        menu.addSeparator();

        menu.add(this.home);
        menu.add(this.aendern);

        this.bar.add(menu);
    }

    private void addZeichnen() {
        JMenu menu = new JMenu("Zeichnen");
        ButtonGroup group = new ButtonGroup();

        freihand = new JRadioButtonMenuItem("Freihand zeichnen");
        group.add(freihand);
        freihand.addActionListener(c);

        linie = new JRadioButtonMenuItem("Linie zeichnen");
        group.add(linie);
        linie.addActionListener(c);

        rechteck = new JRadioButtonMenuItem("Rechteck zeichnen");
        group.add(rechteck);
        rechteck.addActionListener(c);

        rechteckab = new JRadioButtonMenuItem("Rechteck abgerundet zeichnen");
        rechteckab.setSelected(true);
        group.add(rechteckab);
        rechteckab.addActionListener(c);

        ellipse = new JRadioButtonMenuItem("Ellipsen zeichnen");
        group.add(ellipse);
        ellipse.addActionListener(c);

        polygon = new JRadioButtonMenuItem("Polygon zeichnen");
        group.add(polygon);
        polygon.addActionListener(c);

        gefuellt = new JCheckBoxMenuItem("Gefuellt");
        polygon.addActionListener(c);

        menu.add(freihand);
        menu.add(linie);
        menu.add(rechteck);
        menu.add(rechteckab);
        menu.add(ellipse);
        menu.add(polygon);

        menu.addSeparator();

        menu.add(gefuellt);

        this.bar.add(menu);
    }

    private void addFarbe() {
        JMenu menu = new JMenu("Farbe");

        stift = new JMenuItem("Stift");
        stift.setHorizontalAlignment(0);
        stift.addActionListener(c);

        bg = new JMenuItem("Hintergrund");
        bg.setHorizontalAlignment(0);
        bg.addActionListener(c);

        menu.add(stift);
        menu.add(bg);

        this.bar.add(menu);
    }
    private void addInfo() {
        JMenu menu = new JMenu("Info");

        JLabel info = new JLabel(
                "<html><body>Ein Zeichenbrett, <br>welches eine einfache <br>Paint-Applikation darstellt.</body></html>");


        /**
         * damit das Infomenu rechtsbuendig ist
         */
        this.bar.add(Box.createHorizontalGlue());
        menu.add(info);

        this.bar.add(menu);
    }

    private void addAbout() {
        JMenu menu = new JMenu("About");

        JLabel about = new JLabel(
                "Autor: Barbara Wiedermann und Fabio Fuch");


        /**
         * damit das Infomenu rechtsbuendig ist
         */
        //this.bar.add(Box.createHorizontalGlue());
        menu.add(about);

        this.bar.add(menu);
    }


    public Controller getC() {
        return c;
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public JMenuBar getBar() {
        return bar;
    }

    public void setBar(JMenuBar bar) {
        this.bar = bar;
    }

    public JMenuItem getNeu() {
        return neu;
    }

    public void setNeu(JMenuItem neu) {
        this.neu = neu;
    }

    public JMenuItem getLaden() {
        return laden;
    }

    public void setLaden(JMenuItem laden) {
        this.laden = laden;
    }

    public JMenuItem getSpeichern() {
        return speichern;
    }

    public void setSpeichern(JMenuItem speichern) {
        this.speichern = speichern;
    }

    public JMenuItem getLoeschen() {
        return loeschen;
    }

    public void setLoeschen(JMenuItem loeschen) {
        this.loeschen = loeschen;
    }

    public JMenuItem getWiederherstellen() {
        return wiederherstellen;
    }

    public void setWiederherstellen(JMenuItem wiederherstellen) {
        this.wiederherstellen = wiederherstellen;
    }

    public JMenuItem getDuplizieren() {
        return duplizieren;
    }

    public void setDuplizieren(JMenuItem duplizieren) {
        this.duplizieren = duplizieren;
    }

    public JMenuItem getHome() {
        return home;
    }

    public void setHome(JMenuItem home) {
        this.home = home;
    }

    public JMenuItem getAendern() {
        return aendern;
    }

    public void setAendern(JMenuItem aendern) {
        this.aendern = aendern;
    }

    public JRadioButtonMenuItem getFreihand() {
        return freihand;
    }

    public void setFreihand(JRadioButtonMenuItem freihand) {
        this.freihand = freihand;
    }

    public JRadioButtonMenuItem getLinie() {
        return linie;
    }

    public void setLinie(JRadioButtonMenuItem linie) {
        this.linie = linie;
    }

    public JRadioButtonMenuItem getRechteck() {
        return rechteck;
    }

    public void setRechteck(JRadioButtonMenuItem rechteck) {
        this.rechteck = rechteck;
    }

    public JRadioButtonMenuItem getRechteckab() {
        return rechteckab;
    }

    public void setRechteckab(JRadioButtonMenuItem rechteckab) {
        this.rechteckab = rechteckab;
    }

    public JRadioButtonMenuItem getEllipse() {
        return ellipse;
    }

    public void setEllipse(JRadioButtonMenuItem ellipse) {
        this.ellipse = ellipse;
    }

    public JRadioButtonMenuItem getPolygon() {
        return polygon;
    }

    public void setPolygon(JRadioButtonMenuItem polygon) {
        this.polygon = polygon;
    }

    public JCheckBoxMenuItem getGefuellt() {
        return gefuellt;
    }

    public void setGefuellt(JCheckBoxMenuItem gefuellt) {
        this.gefuellt = gefuellt;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public JMenuItem getStift() {
        return stift;
    }

    public void setStift(JMenuItem stift) {
        this.stift = stift;
    }

    public JMenuItem getBg() {
        return bg;
    }

    public void setBg(JMenuItem bg) {
        this.bg = bg;
    }

}
