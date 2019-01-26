package interfaceActiveObject;
import java.io.IOException;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Interface extends Application{
	private Stage primaryStage;
	
	
	public static void main(String[] args) throws Exception {
	launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage=primaryStage;
		primaryStage.setTitle("ActiveObject");
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("aoc.fxml"));
		Scene scene = new Scene(root,800,400);
		primaryStage.setScene(scene);
//		FXMLLoader loader = new FXMLLoader();
//		PanePrincipal = loader.load();
		primaryStage.show();
		
		
	} 
	


}
