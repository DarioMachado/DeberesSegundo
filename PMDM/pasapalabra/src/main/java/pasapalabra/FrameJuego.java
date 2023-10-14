package pasapalabra;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FrameJuego extends JFrame {
    private MenuPrincipal mp;
    private PanelJuego juego;
    public FrameJuego(){

        this.setTitle("PASAPALABRA");
        this.setLocationRelativeTo(null);
        this.setSize(1280,720);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setResizable(false);


        centerFrame();

        mp = new MenuPrincipal(this);

        this.add(mp);

        this.setVisible(true);

    }

    private void centerFrame() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight =  gd.getDisplayMode().getHeight();
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        setLocation(x, y);
    }

    public void  jugar(BufferedImage icono){
        this.remove(mp);
        juego = new PanelJuego(icono);
        mp = null;
        this.add(juego);
        repaint();
    }

}
