package ej3slider;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Ej3Controller implements Initializable{
	
	@FXML
	private Slider slider;
	
	@FXML
	private ProgressBar pgb;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				pgb.setProgress(slider.getValue()/100d);
				
			}
		});
	}
	
	

}
