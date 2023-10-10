package pasapalabra;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Rosco extends JPanel {


    //EN PASAPALABRA NO HAY K NI Ñ LE HE PREGUNTADO A MI ABUELA
    private char letras [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
             'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};

    private Bola bolas[] = new Bola[25];

    public Rosco(){
        this.setSize(1280,720);
        this.setOpaque(false);

        for (int i = 0; i < letras.length; i++) {
            bolas[i] = new Bola(letras[i]);
            this.add(bolas[i]);
        }


    }




    private class Bola extends JComponent {

        private char letra;
        private int x,y,diametro;
        public Bola(char letra) {
            this.letra=letra;
            this.x = 200;
            this.y = 200;
            this.diametro = 40;
            this.setVisible(true);


        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Ellipse2D ball = new Ellipse2D.Double(x, y, diametro, diametro);
            g2d.setColor(Color.RED);
            g2d.fill(ball);
            System.out.println("hey");
        }
    }
}



