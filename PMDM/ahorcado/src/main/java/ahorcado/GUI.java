package ahorcado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



public class GUI extends JFrame {
    private int errores = 0;
    private Scanner sca = new Scanner(System.in);

    private String[] palabras = {"DINOSAURIO", "TECLADO", "SAXOFONISTA","SEXAGESIMAL", "ONOMATOPEYA", "UBICUIDAD", "DESORDENADAMENTE", "QUIMIOTERAPIA","PARALELOGRAMO"};

    private Random rng = new Random();
    private String palabra = palabras[rng.nextInt(palabras.length)];
    private HashMap dichas = new HashMap();

    private int turno = 0;

    private String letra = "_";
    private String mensaje = "";

    public GUI(){

        this.setTitle("Ahorcado");
        this.setLocationRelativeTo(null);
        this.setSize(600,500);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setResizable(false);


        centerFrame();

        JPanel panel = new JPanel(){


            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;


                g2d.setPaint(new GradientPaint(0,0,Color.decode("#B5FF33"),400,400,Color.decode("#B6FB3D")));
                g2d.fillRect(0,0,600,500);
                g2d.setPaint(Color.black);
                g2d.setStroke(new BasicStroke(30f));
                g2d.drawRect(0,0,600,500);


                g2d.setFont(new Font("Arial", Font.BOLD, 24));

                String[] lines = imprimirAhorcado(errores).split("\n");

                int posicion = 30;
                for (String line : lines) {
                    g2d.drawString(line, 50, posicion);
                    posicion += 20;
                }

                g2d.drawString(imprimirPalabra(palabra, dichas),250,170);

                g2d.setPaint(Color.blue);
                g2d.drawString(letra,500,400);

                g2d.setPaint(Color.red);
                g2d.drawString(mensaje, 200,400);

            }


        };


        panel.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLetter(keyChar)) {
                    letra = (keyChar+"").toUpperCase();
                    panel.repaint();
                }

                if(e.getKeyCode()==KeyEvent.VK_ENTER&&!letra.equals("_")){
                    turno++;
                    if (palabra.contains(letra)&&!dichas.containsValue(letra)) {
                        mensaje = "La letra está";
                        dichas.put(turno, letra);
                        letra = "_";
                        if (palabra.equals(imprimirPalabra(palabra, dichas))) {
                            mensaje = "Has ganado";
                            panel.removeKeyListener(this);
                        }
                        panel.repaint();
                        return;

                    }
                    else if(!palabra.contains(letra))
                        mensaje = "La letra no está.";

                    else if(dichas.containsValue(letra))
                        mensaje = "Esa letra ya la has dicho";

                    errores++;
                    if(errores>5) {
                        mensaje = "Has perdido";
                        panel.removeKeyListener(this);
                    }
                    panel.repaint();


                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }


        });
        panel.setFocusable(true);
        this.add(panel);

    

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



    private String imprimirAhorcado(int errores) {

        String dibujo = "  ---------\n";
        dibujo+= "  |       |\n";
        switch(errores) {
            case 0:
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;
            case 1:
                dibujo+= "  O      |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;
            case 2:
                dibujo+= "  O      |\n";
                dibujo+= "  |       |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;
            case 3:
                dibujo+= "  O      |\n";
                dibujo+= " /|       |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;
            case 4:
                dibujo+= "  O      |\n";
                dibujo+= " /|\\      |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;
            case 5:
                dibujo+= "  O      |\n";
                dibujo+= " /|\\      |\n";
                dibujo+= " /        |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;

            case 6:
                dibujo+= "  O      |\n";
                dibujo+= " /|\\      |\n";
                dibujo+= " / \\      |\n";
                dibujo+= "          |\n";
                dibujo+= "          |\n";
                dibujo+= " ----------\n";
                break;


        }



        return dibujo;
    }

    private String imprimirPalabra(String palabra, HashMap dichas) {

        String ret="";

        for(int i = 0; i<palabra.length();i++) {
            if(dichas.containsValue(palabra.charAt(i)+"")) {
                ret+=palabra.charAt(i);
            }
            else
                ret+="_ ";

        }



        return ret;
    }




}
