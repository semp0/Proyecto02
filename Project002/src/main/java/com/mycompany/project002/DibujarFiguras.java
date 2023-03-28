package com.mycompany.project002;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class DibujarFiguras extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int figuraSeleccionada = 0; // 0: ninguna, 1: cuadrado, 2: círculo, 3: triángulo
    private Color colorSeleccionado = Color.BLACK;

    public DibujarFiguras() {
        super("Dibujar Figuras");

        JMenuBar menuBar = new JMenuBar();

        JMenu herramientaMenu = new JMenu("Herramienta");
        ButtonGroup figuraGroup = new ButtonGroup();
        JRadioButtonMenuItem cuadradoItem = new JRadioButtonMenuItem("Cuadrado");
        cuadradoItem.addActionListener(this);
        figuraGroup.add(cuadradoItem);
        herramientaMenu.add(cuadradoItem);
        JRadioButtonMenuItem circuloItem = new JRadioButtonMenuItem("Círculo");
        circuloItem.addActionListener(this);
        figuraGroup.add(circuloItem);
        herramientaMenu.add(circuloItem);
        JRadioButtonMenuItem trianguloItem = new JRadioButtonMenuItem("Triángulo");
        trianguloItem.addActionListener(this);
        figuraGroup.add(trianguloItem);
        herramientaMenu.add(trianguloItem);
        menuBar.add(herramientaMenu);

        JMenu colorMenu = new JMenu("Color");
        JMenuItem negroItem = new JMenuItem("Negro");
        negroItem.addActionListener(this);
        colorMenu.add(negroItem);
        JMenuItem rojoItem = new JMenuItem("Rojo");
        rojoItem.addActionListener(this);
        colorMenu.add(rojoItem);
        JMenuItem azulItem = new JMenuItem("Azul");
        azulItem.addActionListener(this);
        colorMenu.add(azulItem);
        JMenuItem verdeItem = new JMenuItem("Verde");
        verdeItem.addActionListener(this);
        colorMenu.add(verdeItem);
        menuBar.add(colorMenu);

        setJMenuBar(menuBar);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DibujarFiguras();
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "Cuadrado":
                figuraSeleccionada = 1;
                break;
            case "Círculo":
                figuraSeleccionada = 2;
                break;
            case "Triángulo":
                figuraSeleccionada = 3;
                break;
            case "Negro":
                colorSeleccionado = Color.BLACK;
                break;
            case "Rojo":
                colorSeleccionado = Color.RED;
                break;
            case "Azul":
                colorSeleccionado = Color.BLUE;
                break;
            case "Verde":
                colorSeleccionado = Color.GREEN;
                break;
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(colorSeleccionado);
        switch (figuraSeleccionada) {
            case 1:
                g.fillRect(50, 50, 100, 100);
                break;
            case 2:
                g.fillOval(50, 50, 100, 100);

                break;
            case 3:
                int[] xPoints = {75, 150, 10};
                int[] yPoints = {10, 150, 150};
                g.fillPolygon(xPoints, yPoints, 3);
                break;
        }
    }
}

      
