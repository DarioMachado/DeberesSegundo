package paneOpcion;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Ejercicios {
	
	public static void main (String args[]) {
		
		UIManager.put("OptionPane.yesButtonText", "Sí");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		UIManager.put("OptionPane.okButtonText", "Vale");

		
		ejercicios(1);
	}
	
	public static void ejercicios(int i) {
		
		switch(i) {
		case 1:
			
			JOptionPane.showMessageDialog(null, "Bienvenido al programa.",  "Buenas",JOptionPane.WARNING_MESSAGE);
			break;
		
		case 2:
			String input = JOptionPane.showInputDialog(null,"Dime tu nombre", "Datos personales", JOptionPane.QUESTION_MESSAGE);
			if(input!=null)
				JOptionPane.showMessageDialog(null, "Tu nombre es " +input,"Vale", 1);
			else
				JOptionPane.showMessageDialog(null, "¡Le has dado a cancelar!","¡Bro!", 0);
			break;
		
		case 3:
			int codigo = JOptionPane.showConfirmDialog(null, "Elige", "Sí o no", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			
			if(codigo == JOptionPane.YES_OPTION) 
				JOptionPane.showMessageDialog(null, "Le has dado a sí","Tu elección", 1);
			else if(codigo == JOptionPane.NO_OPTION)
				JOptionPane.showMessageDialog(null, "Le has dado a no","Tu elección", 1);
			else
				JOptionPane.showMessageDialog(null, "No le des a cancelar...","Bro", 0);
			break;
		
		case 4:
			UIManager.put("OptionPane.yesButtonText", "Bien");
			UIManager.put("OptionPane.noButtonText", "Muy bien");
			UIManager.put("OptionPane.cancelButtonText", "Super bien");
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Qué te ha parecido el programa?", "Para terminar", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "Estoy de acuerdo","Gracias", 1);
	
			
		default:
			System.exit(0);
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejercicios(i+1);
		
			
	}
	
	
	
	

}
