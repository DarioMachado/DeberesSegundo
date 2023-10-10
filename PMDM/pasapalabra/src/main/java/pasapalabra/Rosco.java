package pasapalabra;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

public class Rosco extends JPanel {


    //EN PASAPALABRA NO HAY K NI Ñ LE HE PREGUNTADO A MI ABUELA
    private char letras [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
             'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};

    private Bola bolas[] = new Bola[25];

    public Rosco(){
        this.setSize(1280,720);
        this.setLayout(null);
        this.setOpaque(false);

        for (int i = 0; i < letras.length; i++) {
            bolas[i] = new Bola(letras[i], 30*i, 200);
        }



        this.setVisible(true);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.red);

        for(int i = 0; i < bolas.length; i++){
            g2d.fill(new Ellipse2D.Double((double) bolas[i].getX(), (double) bolas[i].getY(),bolas[i].getDiametro(),bolas[i].getDiametro()));
        }


    }




    private class Bola {

        private char letra;
        private int x,y;
        private double diametro;
        public Bola(char letra, int x, int y) {
            this.letra=letra;
            this.x = x;
            this.y = y;
            this.diametro = 40;

        }

        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public double getDiametro(){
            return diametro;
        }

        public char getLetra(){
            return letra;
        }


    }
}



