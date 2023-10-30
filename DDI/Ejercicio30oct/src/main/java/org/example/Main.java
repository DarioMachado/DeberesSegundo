package org.example;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panel;
    public JLabel label;

    public static void main(String[] args) {

        new Main();

    }

    public Main(){
        this.setSize(600,300);
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton botones[] = new JButton[3];
        label = new JLabel("");
        for(int i = 0; i < botones.length; i++){
            botones [i] = agregarBoton("Botón "+(i+1), 100*(i+1),50);
        }
        label.setBounds(160,130,100,30);
        panel.add(label);
    }


    private JButton agregarBoton(String nombre, int x, int y){
        JButton jb = new JButton(nombre);
        jb.setBounds(x,y,100,50);
        panel.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               // new Ventana("Has pulsado el "+nombre); //EJ 5
                label.setText("Mensaje: "+nombre);

            }
        });
        return jb;
    }


    private class Ventana extends JFrame{
        Ventana(String s){
            this.setSize(200,100);
            JLabel jl = new JLabel(s);
            this.add(jl);
            this.setVisible(true);
        }
    }
}
