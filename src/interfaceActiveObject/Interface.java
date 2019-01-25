package interfaceActiveObject;
import java.io.IOException;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Interface extends Application{
	private Stage primaryStage;
	private AnchorPane PanePrincipal;
	
	
	public static void main(String[] args) throws Exception {
	launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage=primaryStage;
		primaryStage.setTitle("ActiveObject");
		launchInterface();
		
		
	} 
	
	public void launchInterface() throws IOException {
		BorderPane borderPanTool = new BorderPane();
		Scene scene = new Scene(borderPanTool,800,400);
		primaryStage.setScene(scene);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Interface.class.getResource("MainView.fxml"));
		PanePrincipal = loader.load();
		primaryStage.show();
	}

}
