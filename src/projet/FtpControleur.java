package projet;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

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
		/*
		String hote = hotefield.getText();
		String login = loginfield.getText();
		String pass = passfield.getText();
		Integer port = Integer.parseInt( portfield.getText() );
		*/
		String hote = ("stockage.univ-brest.fr");
		String login = ("e21502323");
		String pass = ("@Benji@Benjo@29");
		Integer port = 21;
		
		try {
	         sc = new Scanner(System.in);
	         //Ftp ftp = new Ftp("cysboy");
	         ftp = new Ftp(hote, port, login);
	         System.out.println("Connexion au FTP");

	         ftp.connect();
	         ftp.debugMode(true);
	         
	         cmdarea.appendText("-------------------------------------------------------\n");
	         cmdarea.appendText("Vous êtes maintenant connecté au FTP\n");
	         cmdarea.appendText("Vous avez le droit aux commandes PWD, CWD, LIST, RMD, MKDIR et QUIT\n");
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
        
        case "LIST":
           String list = ftp.list();
           cmdarea.appendText(list);
           cmdarea.appendText("\n");
           break;
        case "QUIT":
           ftp.quit();
           break;
         default :
        	if(reponse.substring(0, 3).equals("CWD")) {
        		
               String dir = reponse.substring(4,reponse.length());
               cmdarea.appendText(ftp.cwd(dir));
               cmdarea.appendText("\n");
        	}
        	else
        		if(reponse.substring(0, 5).equals("MKDIR")) {
        		
               String dir = reponse.substring(6,reponse.length());
               cmdarea.appendText(ftp.mkdir(dir));
               cmdarea.appendText("\n");
        	} else if(reponse.substring(0, 3).equals("RMD")) {
        		
                String dir = reponse.substring(4,reponse.length());
                cmdarea.appendText(ftp.rm(dir));
                cmdarea.appendText("\n");}
        	else{
        		cmdarea.appendText("Commande inconnue !");
            	cmdarea.appendText("\n");
        	}
            break;
        }
		} catch (IOException e) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	}
	
	
	
	public void affiche(String str) {
		

	}
	
	
	
	
}

/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
/*=======================*/
