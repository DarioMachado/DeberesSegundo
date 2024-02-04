package ej6reto;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Ej6Controller implements Initializable {
	
	@FXML
	private Label texto;
	
	@FXML
	private ImageView piano;
	@FXML
	private ImageView guitarra1;
	@FXML
	private ImageView guitarra2;
	@FXML
	private ImageView percusion;
	@FXML
	private ImageView chipi;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	   String audioFile = getClass().getResource("/ej6reto/cancion.mp3").toString();
       Media media = new Media(audioFile);
       MediaPlayer mediaPlayer = new MediaPlayer(media);

       mediaPlayer.setAutoPlay(true);
		
		hiloTexto().start();
		hiloPiano().start();
		hiloPercusion().start();
		hiloChipi().start();
		hiloGuitarra().start();
	}
	
	
	Thread hiloTexto() {
		return new Thread (() ->{
				try {
					Thread.sleep(2000);
					Platform.runLater(()->{
					texto.setText("Me he tomado la libertad de hacer esto...");
					});
					Thread.sleep(2000);
					Platform.runLater(()->{
					texto.setText("En lugar de 3 trabajos sin sentido...");
					});
					texto.setStyle("-fx-text-fill: red;");
					Thread.sleep(3000);
					Platform.runLater(()->{
					texto.setText("Simplemente... espere un segundo...");
					});
					Thread.sleep(8000);
					Platform.runLater(()->{
					texto.setText("");
					});
					Thread.sleep(80000);
					System.exit(0);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		});
	}
	
	Thread hiloPiano() {
		return new Thread (() ->{
			Image imagen = new Image(getClass().getResourceAsStream("/ej6reto/cat-piano.gif"));
			Image imagen2 = new Image(getClass().getResourceAsStream("/ej6reto/cat-piano2.gif"));

			try {
				Thread.sleep(1500);
				Platform.runLater(()->{
				piano.setImage(imagen);
				});
				Thread.sleep(29500);
				Platform.runLater(()->{
				piano.setImage(null);
				});
				Thread.sleep(4000);
				Platform.runLater(()->{
					piano.setImage(imagen2);
					});
				Thread.sleep(14500);
				Platform.runLater(()->{
					piano.setImage(null);
					});
				Thread.sleep(15500);
				Platform.runLater(()->{
					piano.setImage(imagen2);
					});
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	});
	}
	
	
	Thread hiloPercusion() {
		return new Thread (() ->{
			Image imagen = new Image(getClass().getResourceAsStream("/ej6reto/cat-percusion.gif"));

			try {
				Thread.sleep(15000);
				Platform.runLater(()->{
				percusion.setImage(imagen);
				});
				Thread.sleep(16000);
				Platform.runLater(()->{
				percusion.setImage(null);
				});
				Thread.sleep(19000);
				Platform.runLater(()->{
				percusion.setImage(imagen);
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	});
		
	}
	
	Thread hiloChipi() {
		return new Thread (() ->{
			Image imagen = new Image(getClass().getResourceAsStream("/ej6reto/cat-chipi.gif"));

			try {
				Thread.sleep(31000);
				Platform.runLater(()->{
				chipi.setImage(imagen);
				});
				Thread.sleep(4000);
				Platform.runLater(()->{
				chipi.setImage(null);
				});
				Thread.sleep(30000);
				Platform.runLater(()->{
				chipi.setImage(imagen);
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	});
		
	}
	
	Thread hiloGuitarra() {
		
		return new Thread (() ->{
			Image imagen1 = new Image(getClass().getResourceAsStream("/ej6reto/cat-guitar1.gif"));
			Image imagen2 = new Image(getClass().getResourceAsStream("/ej6reto/cat-guitar2.gif"));

			try {
				Thread.sleep(50000);
				Platform.runLater(()->{
				guitarra1.setImage(imagen1);
				guitarra2.setImage(imagen2);
				});
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	});
		
	}

	
	
}
