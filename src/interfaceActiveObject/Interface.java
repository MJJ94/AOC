package interfaceActiveObject;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Interface extends Application {
	private Stage primarStage;

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primarStage = primaryStage;
		primaryStage.setTitle("ActiveObject");
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("aoc.fxml"));
		Scene scene = new Scene(root, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
