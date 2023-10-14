package pasapalabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int contador;
    private int tiempo;
    Timer timer;
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
        contador = 0;
        //120 es muy poco teniendo en cuenta que hay que escribirlo, y tal
        tiempo = 180;
        rosco.getBola(cursor).estado = Rosco.Estado.ACTIVO;

        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();


        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempo--;
                repaint();
                if(tiempo<=0)
                    fin();
            }
        });


        timer.start();


    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setPaint(Color.black);
        g2d.fillRect(0,0,getWidth(),getHeight());

        GradientPaint gradiente = new GradientPaint(
                new Point2D.Double(300, 150), new Color(33, 22, 230, 70),
                new Point2D.Double(400, 500), new Color(14, 131, 252, 85));
        GradientPaint gradiente2 = new GradientPaint(
                new Point2D.Double(400, 300), new Color(17, 28, 181, 80),
                new Point2D.Double(900,400), new Color(15, 49, 193, 80));
        GradientPaint gradiente3 = new GradientPaint(
                new Point2D.Double(400, 0), new Color(14, 32, 217, 55),
                new Point2D.Double(300,400), new Color(0, 54, 227, 85));



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
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(40,575,100,100);
        g2d.drawString(tiempo+"",50, 640);

        g2d.setFont(new Font("Arial", Font.PLAIN, 16));
        g2d.drawString(preguntas[cursor].getPregunta(),getWidth()/2-g2d.getFontMetrics().stringWidth(preguntas[cursor].getPregunta())/2, 50);

    }

    private void moverCursor(){
        cursor++;
        if (cursor >= preguntas.length){
            cursor=-1;
            moverCursor();
        }
        if(rosco.getBola(cursor).estado == Rosco.Estado.AZUL)
            return;
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
            contador++;
        }
        else if(!input.equals(preguntas[cursor].getRespuesta())){
            rosco.getBola(cursor).estado = Rosco.Estado.ROJO;
            contador++;
            //System.out.println("mal");
        }

        if(contador==25){
            fin();
            return;
        }
        moverCursor();
        rosco.getBola(cursor).estado = Rosco.Estado.ACTIVO;
        //System.out.println(preguntas[cursor].getRespuesta());

    }


    public void fin(){
        int resultado = 0;
        for(int i = 0 ; i < preguntas.length;i++){
            if(rosco.getBola(i).estado== Rosco.Estado.VERDE){
                resultado++;
            }
        }
        this.removeKeyListener(this);
        timer.stop();
        JFrame frame = new JFrame("Fin");
        frame.setUndecorated(true);
        frame.setLayout(null);

        JLabel felicidades = new JLabel("Has acertado "+resultado+" preguntas de 25");
        felicidades.setFont(new Font("Arial", Font.BOLD,30));
        felicidades.setBounds(0,0,500,100);


        JButton otra = new JButton("JUGAR OTRA VEZ");
        otra.setBounds(0,100,500,100);
        otra.setFocusable(false);
        otra.addActionListener(e -> {
            Main.otra();
            frame.setVisible(false);

        });

        JButton salir = new JButton("SALIR");
        salir.setBounds(0,200,500,100);
        salir.setFocusable(false);
        salir.addActionListener(e -> {
            System.exit(0);
        });




        frame.add(felicidades);
        frame.add(otra);
        frame.add(salir);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);


    }

}
