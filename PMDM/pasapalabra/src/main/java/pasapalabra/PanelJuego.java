package pasapalabra;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelJuego extends JPanel {

    private Rosco rosco;
    private BufferedImage icono;
    public PanelJuego(BufferedImage icono){
        this.icono = icono;
        rosco = new Rosco();
        this.setSize(1280,720);
        this.setLayout(null);
        this.add(rosco);


    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(icono,500,200,300,300,null);


    }
}
