package projet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class FtpControleur {
	
	@FXML
	private TextField loginfield;
	@FXML
	private TextField portfield;
	@FXML
	private TextField hotefield;
	@FXML
	private TextField distantfield;
	@FXML
	private TextField localfield;
	@FXML
	private TextArea cmdarea;
	
	@FXML
	private PasswordField passield;
	@FXML
	private Button connectbutton;
	@FXML
	private TitledPane fullfields;
	@FXML
	private void connection() {
	cmdarea.setText("blabla");
	}
}