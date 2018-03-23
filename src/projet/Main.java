package projet;
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		System.out.println("java version :"+System.getProperty("java.version"));;
		System.out.println("java(fx) version :"+System.getProperty("javafx.version"));;
		
		primaryStage.setTitle("TEST");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("projetftp.fxml"));
		TitledPane panneau = (TitledPane) loader.load();
		Scene scene = new Scene(panneau);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//FXMLLoader root = new FXMLLoader(getClass().getResource("clientftp (1).fxml"));
		//root.load();
/*
		Scene scene = new Scene(root, 300, 275);
		
		primaryStage.setTitle("FXML Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	System.getProperties().put("http.proxySet","true");
	System.getProperties().put("http.proxyPort","3128");
	System.getProperties().put("http.proxyHost","proxyubo.univ-brest.fr");
	
	}
}

/*
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
*/