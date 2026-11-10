package chapter8;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserInterface extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Parent root = null; // Initialize with a component graph
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
