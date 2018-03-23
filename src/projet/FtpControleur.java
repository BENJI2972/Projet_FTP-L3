package projet;

import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;


public class FtpControleur {
	Ftp ftp;
	Scanner sc;
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
	private PasswordField passfield;
	@FXML
	private Button connectbutton;
	@FXML
	private TitledPane fullfields;
	@FXML
	private void connection() {
		
		String hote = hotefield.getText();
		String login = loginfield.getText();
		String pass = passfield.getText();
		Integer port = Integer.parseInt( portfield.getText() );
		
		try {
	         sc = new Scanner(System.in);
	         //Ftp ftp = new Ftp("cysboy");
	         ftp = new Ftp(hote, port, login);
	         System.out.println("Connexion au FTP");

	         ftp.connect();
	         ftp.debugMode(true);
	         
	         cmdarea.appendText("-------------------------------------------------------\n");
	         cmdarea.appendText("Vous êtes maintenant connecté au FTP\n");
	         cmdarea.appendText("Vous avez le droit aux commandes PWD, CWD, LIST et QUIT\n");
	         cmdarea.appendText("-------------------------------------------------------\n\n");
	         String reponse = "";


	      } catch (IOException e) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	
	}
	
	@FXML
	private void action() {
		try {
		String reponse = localfield.getText();
		switch (reponse) {
        case "PWD":
        	cmdarea.appendText(ftp.pwd());
        	cmdarea.appendText("\n");
           break;
        case "CWD":
        	cmdarea.appendText(">> Saisissez le nom du répertoire où vous voulez aller : ");
        	cmdarea.appendText("\n");
           String dir = sc.nextLine();
           cmdarea.appendText(ftp.cwd(dir));
           cmdarea.appendText("\n");
           break;
        case "LIST":
           String list = ftp.list();
           cmdarea.appendText(list);
           cmdarea.appendText("\n");
           break;
        case "QUIT":
           ftp.quit();
           break;
         default : 
            cmdarea.appendText("Commande inconnue !");
            cmdarea.appendText("\n");
            break;
        }
		} catch (IOException e) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	}
}
	/*
	 * switch (reponse) {
	            case "PWD":
	               System.out.println(ftp.pwd());
	               break;
	            case "CWD":
	               System.out.println(">> Saisissez le nom du répertoire où vous voulez aller : ");
	               String dir = sc.nextLine();
	               System.out.println(ftp.cwd(dir));
	               break;
	            case "LIST":
	               String list = ftp.list();
	               System.out.println(list);
	               break;
	            case "QUIT":
	               ftp.quit();
	               encore = false;
	               break;
	             default : 
	                System.err.println("Commande inconnue !");
	                break;
	            }
	            */
	 
