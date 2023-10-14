package pasapalabra;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

public class Rosco extends JPanel {


    //EN PASAPALABRA NO HAY K NI W LE HE PREGUNTADO A MI ABUELA
    //Hay que usar String en lugar de char, debido a que Ñ no puede ser char.
    private String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T",
            "U", "V", "X", "Y", "Z"};

    private Bola bolas[] = new Bola[25];


    private int radio = 220;
    private double incremento = 2 * Math.PI / letras.length;
    private double angulo = 3 * Math.PI / 2;

    public Rosco(){
        this.setSize(1280,720);
        this.setLayout(null);
        this.setOpaque(false);

        for (int i = 0; i < letras.length; i++) {

            int x = (int) (getWidth()/2 + radio * Math.cos(angulo));
            int y = (int) (getHeight()/2-50 + radio * Math.sin(angulo));


            bolas[i] = new Bola(letras[i], x, y);


            angulo+=incremento;
        }



        this.setVisible(true);
    }
    public String[] getLetras(){
        return letras;
    }
    public Bola getBola(int indice){
        return bolas[indice];
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



        g2d.setFont(new Font("SansSerif", Font.BOLD, 18));

        for (int i = 0; i < bolas.length; i++) {
            Bola bola = bolas[i];
            //g2d.rotate(Math.toRadians(360/25d));

            g2d.setPaint(Color.decode(bola.estado.hexValue));
            g2d.fill(new Ellipse2D.Double((double) bola.getX(), (double) bola.getY(), bola.getDiametro(), bola.getDiametro()));


            g2d.setPaint(Color.white);
            g2d.draw(new Ellipse2D.Double((double) bola.getX(), (double) bola.getY(), bola.getDiametro(), bola.getDiametro()));
            g2d.drawString(bola.getLetra() + "", bola.getX() + 15, bola.getY() + 25);
        }


    }




    public class Bola {

        private String letra;
        private int x,y;
        private double diametro;

        public Estado estado;

        public Bola(String letra, int x, int y) {
            this.letra=letra;
            this.x = x;
            this.y = y;
            this.diametro = 40;
            this.estado=Estado.AZUL;
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

        public String getLetra(){
            return letra;
        }



    }

    public enum Estado{
        AZUL("#084CF6"), VERDE("#0DCA48"), ROJO("#EA005B"), ACTIVO("#94C5F7");

        private final String hexValue;

        Estado(String hexValue) {
            this.hexValue = hexValue;
        }

        public String getHexValue() {
            return hexValue;
        }
    }

}



