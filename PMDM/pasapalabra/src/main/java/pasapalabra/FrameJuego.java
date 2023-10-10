package pasapalabra;

import javax.swing.*;
import java.awt.*;

public class FrameJuego extends JFrame {

    public FrameJuego(){

        this.setTitle("Ahorcado");
        this.setLocationRelativeTo(null);
        this.setSize(1280,720);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setResizable(false);


        centerFrame();

        MenuPrincipal mp = new MenuPrincipal();

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

}
