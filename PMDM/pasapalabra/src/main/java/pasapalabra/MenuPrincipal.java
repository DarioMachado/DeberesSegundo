package pasapalabra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPrincipal extends JPanel {


    private BufferedImage logo;
    public MenuPrincipal(){

        this.setSize(1280,720);
        this.setLayout(null);
       this.add(new Rosco());
        try {
            logo = ImageIO.read(new File("src/main/resources/pasapalabralogo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //Explicación de esto de abajo: no encontraba un fondo bueno para el pasapalabra, así que decidí pintar varios gradientes azules a diferentes opacidades
        //para crearme mi propio fondo
        g2d.setPaint(Color.black);
        g2d.fillRect(0,0,getWidth(),getHeight());

        GradientPaint gradiente = new GradientPaint(
                new Point2D.Double(300, 150), new Color(30, 0, 250, 50),
                new Point2D.Double(400, 500), new Color(64, 161, 222, 50));
        GradientPaint gradiente2 = new GradientPaint(
                new Point2D.Double(100, 700), new Color(27, 98, 191, 50),
                new Point2D.Double(900,100), new Color(15, 49, 163, 50));
        GradientPaint gradiente3 = new GradientPaint(
                new Point2D.Double(400, 0), new Color(14, 30, 207, 50),
                new Point2D.Double(0,400), new Color(0, 54, 247, 50));



        g2d.setPaint(gradiente);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setPaint(gradiente2);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setPaint(gradiente3);
        g2d.fillRect(0,0,getWidth(),getHeight());

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(logo, getWidth()-logo.getWidth()-100, 50, null);

    }





}
