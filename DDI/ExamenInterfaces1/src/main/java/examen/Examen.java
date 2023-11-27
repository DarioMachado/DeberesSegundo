package examen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Examen extends JFrame {
	
	//Examen de Darío
	

	public static void main (String[] args) {
		
		
		//Ejercicio Opcional??
		String usuario = "admin";
		String password = "12345";
		
		
		
		JFrame jf = new JFrame("Autenticación");
		jf.setSize(300,300);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel lusuario = new JLabel("Usuario: ");
		lusuario.setBounds(10,50,100,20);
		jf.add(lusuario);
		
		JLabel lpass = new JLabel("Contraseña: ");
		lpass.setBounds(10,100,100,20);
		jf.add(lpass);
		
		JTextField tfusuario = new JTextField();
		tfusuario.setBounds(100,50,100,20);
		jf.add(tfusuario);
		
		
		//Lo siento no recuerdo cómo conseguir la contraseña introducida con un JPasswordfield
		//usaré JTextField en su lugar
		JTextField pfpass = new JTextField();
		pfpass.setBounds(100, 100, 100, 20);
		jf.add(pfpass);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBorder(null);
		cancelar.setBounds(150,200,70,30);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		jf.add(cancelar);
		
		JButton ok = new JButton("OK");
		ok.setBorder(null);
		ok.setBounds(70,200,70,30);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfusuario.getText().equals(usuario) && pfpass.getText().equals(password)) {
					//Ejercicio 4.1 aquí
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							new Examen();
							
						}
						
					});
					jf.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.", "Autenticación fallida", 0, null);
					
				
			}
			
			
		});
		jf.add(ok);
		
		
		
		jf.setVisible(true);
		
		
		
		
		
		
		//Ejercicio 4.1???
		
	}
	
	
	private Examen() {
		//Ejercicio 1.1
		this.setTitle("Examen práctico");
		this.setSize(400, 300);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Ejercicio 1.2
		JPanel botonPanel = new JPanel(new BorderLayout());
		JPanel panelNorte = new JPanel(new FlowLayout());
		JPanel panelSur = new JPanel(new FlowLayout());
		
		JButton jbotones[] = new JButton[6];
		
		//Aquí se procede a la creación de botones y a añadirlos a los paneles norte y sur, como
		//claramente puede verse.
		for(int i = 0; i < jbotones.length; i++) {
			jbotones[i] = new JButton("Botón "+(i+1));
			if(i<3)
				panelNorte.add(jbotones[i]);
			else
				panelSur.add(jbotones[i]);
		}
		//Aquí se añaden las cosas, efectivamente
		this.add(botonPanel);
		botonPanel.add(panelNorte, BorderLayout.NORTH);
		botonPanel.add(panelSur, BorderLayout.SOUTH);
		
		//Ejercicio 2.1
		JMenuBar jmb = new JMenuBar();
		JMenu botones = new JMenu("Botones"); //En mi humilde opinión, botones no es una buena forma de nombrar a un JMenu
		jmb.add(botones);
		this.setJMenuBar(jmb);
		
		//Ejercicio 2.2
		
		JMenuItem[] menuItems = new JMenuItem[6];		
		for(int i = 0; i< menuItems.length; i++) {
			menuItems[i] = crearElementosMenu("Botón "+(i+1));
			botones.add(menuItems[i]);
		}
		
		//Ejercicio 3.1
		
		for(JButton boton: jbotones) {
			configurarBotones(boton);
		}
		
		//Ejercicio 3.2
		
		for(int i = 0; i < 6 ; i++) {
			procesarBoton(jbotones[i]);
			procesarBoton(menuItems[i]);
		}
		
		
		
		this.setVisible(true);
	}
	
	
	
	private JMenuItem crearElementosMenu(String nombre) {
		JMenuItem jmi = new JMenuItem(nombre);
		/*
		jmi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});*/ //Más en el punto 3.2
		
		return jmi;
		
	}
	
	private void configurarBotones(JButton jb) {
		jb.setBackground(new Color(135,206,250));
		jb.setForeground(Color.black);
	}
	
	//Creo que lo de pedir un AbstractButton por argumento se merece 2 puntos extras.
	private void procesarBoton(AbstractButton ab) {
		ab.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Config del JFrame
				JFrame jf = new JFrame();
				jf.setBounds(500,500,200,200);
				jf.setLayout(null);
				jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				//Config del JLabel
				JLabel jl = new JLabel("Se ha pulsado el "+ab.getText());
				jl.setBounds(0,10,200,30);
				jf.add(jl);
				
				//Config del JButton
				JButton jb = new JButton("Cerrar");
				jb.setBounds(0,70,200, 30);
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jf.dispose();
						
					}
					
				});
				jf.add(jb);
				
				jf.setVisible(true);
			}
			
			
		});
		
	}
	
	
	
	
	
}
