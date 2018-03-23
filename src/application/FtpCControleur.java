package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FtpCControleur {

	@FXML
	private TextField aTextField;
	@FXML
	private TextField bTextField;
	@FXML
	private Label sommeLabel;
	@FXML
	private void somme() {
	int x = Integer.parseInt(aTextField.getText());
	int y = Integer.parseInt(bTextField.getText());
	int z = x + y ;
	sommeLabel.setText("Somme = "+z);
	}
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
