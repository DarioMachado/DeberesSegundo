package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JFrame implements ActionListener{

    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1, mi2, mi3;
    public static void main(String[] args) {

        new Main();
    }

    Main(){
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        JPanel panelBotones = new JPanel();
        JPanel panelMensaje = new JPanel();
        JPanel bienvenido = new JPanel();
        JLabel lbienvenido = new JLabel("Bienvenido: ");
        JLabel etiquetaMensaje = new JLabel("Mensaje: ");
        JButton botones[] = new JButton[3];
        for(int i = 0; i < botones.length; i++){
            final int index = i;
            botones[i] = new JButton("Botón "+(i+1));
            botones[i].setBackground(Color.BLACK);
            botones[i].setForeground(Color.white);
            botones[i].setFocusable(false);
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    etiquetaMensaje.setText("Mensaje: " +((JButton) e.getSource()).getText());
                    setLocation(200*index,100*index);
                    lbienvenido.setText("Bienvenido: " +((JButton) e.getSource()).getText());
                }
            });
            panelBotones.add(botones[i]);
        }
        panelMensaje.add(etiquetaMensaje);
        bienvenido.add(lbienvenido);


        this.add(panelMensaje);
        panelMensaje.setBounds(0,0,600,50);
        this.add(panelBotones);
        panelBotones.setBounds(0,50,600,50);
        this.add(bienvenido);
        bienvenido.setBounds(0,100,600,50);

        JPanel ventanas = new JPanel();
        JButton botonesVentanas[] = new JButton[3];
        for(int i = 0; i < botonesVentanas.length; i++){
            final int index = i;
            botonesVentanas[i] = new JButton();
            botonesVentanas[i].setText("Ventana " +(i+1));
            botonesVentanas[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame();
                    JLabel texto = new JLabel("Has pulsado la ventana "+(index+1));
                    frame.add(texto);
                    frame.setSize(200,100);
                    frame.setVisible(true);
                    new Main();
                }
            });
            ventanas.add(botonesVentanas[i]);
        }
        this.add(ventanas);
        ventanas.setBounds(0,150,600,50);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Clientes");
        mb.add(menu1);

        mi1 = new JMenuItem("Añadir");
        mi1.addActionListener(this);
        menu1.add(mi1);

        mi2 = new JMenuItem("Listado");
        mi2.addActionListener(this);
        menu1.add(mi2);

        mi3 = new JMenuItem("Salir");
        mi3.addActionListener(this);
        menu1.add(mi3);





        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Container contentPane = getContentPane();
        if (e.getSource() == mi1) {
            contentPane.setBackground(new Color(255, 0, 0));
        }
        if (e.getSource() == mi2) {
            contentPane.setBackground(new Color(0, 255, 0));
        }
        if (e.getSource() == mi3) {
            contentPane.setBackground(new Color(0, 0, 255));
        }
    }
}