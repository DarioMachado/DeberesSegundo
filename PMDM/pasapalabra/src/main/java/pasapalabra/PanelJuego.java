package pasapalabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class PanelJuego extends JPanel implements KeyListener{

    private Rosco rosco;
    private BufferedImage icono;
    private Pregunta preguntas[];
    private int cursor;
    private String input;
    public PanelJuego(BufferedImage icono){
        this.icono = icono;
        rosco = new Rosco();
        this.setSize(1280,720);
        this.setLayout(null);
        this.add(rosco);
        preguntas = new Pregunta[rosco.getLetras().length];
        String indices [] = rosco.getLetras();
        for(int i = 0; i< preguntas.length;i++){
            preguntas[i] = new Pregunta(indices[i]);
        }
        cursor = 0;
        input = "";
        rosco.getBola(cursor).estado = Rosco.Estado.ACTIVO;

        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();
        /*
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        Component focusedComponent = focusManager.getFocusOwner();
        System.out.println(focusedComponent);
        */

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setPaint(Color.black);
        g2d.fillRect(0,0,getWidth(),getHeight());

        GradientPaint gradiente = new GradientPaint(
                new Point2D.Double(300, 150), new Color(33, 22, 230, 70),
                new Point2D.Double(400, 500), new Color(14, 131, 252, 35));
        GradientPaint gradiente2 = new GradientPaint(
                new Point2D.Double(400, 300), new Color(17, 28, 181, 30),
                new Point2D.Double(900,400), new Color(15, 49, 193, 80));
        GradientPaint gradiente3 = new GradientPaint(
                new Point2D.Double(400, 0), new Color(14, 32, 217, 55),
                new Point2D.Double(300,400), new Color(0, 54, 227, 55));



        g2d.setPaint(gradiente);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setPaint(gradiente2);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setPaint(gradiente3);
        g2d.fillRect(0,0,getWidth(),getHeight());

        g2d.drawImage(icono,500,200,300,300,null);
        g2d.setPaint(Color.white);

        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        g2d.drawString(input,1100-g2d.getFontMetrics().stringWidth(input), 650);

        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString(preguntas[cursor].getPregunta(),1100-g2d.getFontMetrics().stringWidth(preguntas[cursor].getPregunta()), 100);

    }

    private void moverCursor(){
        cursor++;
        if(rosco.getBola(cursor).estado == Rosco.Estado.AZUL)
            return;
        else if (cursor > preguntas.length){
            cursor=-1;
            moverCursor();
        }
        else
            moverCursor();
    }





    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
       // System.out.println("Hola");
        if (Character.isLetter(keyChar)) {
            input += (keyChar+"").toUpperCase();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE&&!input.isEmpty()) {
            input = input.substring(0,input.length()-1);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER&&!input.isEmpty()) {
          comprobarRespuesta(input);
          input="";
          repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void comprobarRespuesta(String input){

        if(input.equals("PASAPALABRA")){
            rosco.getBola(cursor).estado = Rosco.Estado.AZUL;
        }
        else if(input.equals(preguntas[cursor].getRespuesta())){
            rosco.getBola(cursor).estado = Rosco.Estado.VERDE;
            //System.out.println("bien");
        }
        else if(!input.equals(preguntas[cursor].getRespuesta())){
            rosco.getBola(cursor).estado = Rosco.Estado.ROJO;
            //System.out.println("mal");
        }

        moverCursor();
        rosco.getBola(cursor).estado = Rosco.Estado.ACTIVO;
        //System.out.println(preguntas[cursor].getRespuesta());

    }


}
