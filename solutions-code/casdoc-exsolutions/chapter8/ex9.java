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
	/*?
	 * Keyword: throws
	 * This is a keyword that is used to indicate that the method may throw an exception. 
	 * 
	 * Keyword: Exception
	 * This is a class that is used to represent an exception.
     * 
     * Keyword: start
     * This is the start method that is called when the application is launched. It takes a Stage as a parameter.
	 */
	public void start(Stage primaryStage) throws Exception
	{
		/*?
		 * Keyword: label
		 * This is a Label that is used to display text. 
         * 
         * Keyword: LocalDateTime
         * This is a class that is used to represent a date and time.
		 * 
		 * Keyword: now
		 * This is a method that is used to get the current date and time.
		 */
		Label label = new Label(LocalDateTime.now().toString());

		/*?
		 * Keyword: button
		 * This is a Button that is used to display text and perform an action when it is clicked. The text that is displayed on the button is "Now".
		 */
		Button button = new Button("Now");

        /*?
		 * 
		 * Keyword: e
		 * This is a parameter that is passed to the lambda expression. It is used to represent the ActionEvent that is passed to the lambda expression.
		 * 
		 * Keyword: label.setText(LocalDateTime.now().toString())
		 * This is a method that is used to set the text that is displayed on the label. The text that is displayed on the label is the current date and time.
         * 
         * Keyword: button.setOnAction
         * This is a method that is used to set the action that is performed when the button is clicked. 
		 */
		button.setOnAction(e -> label.setText(LocalDateTime.now().toString()));

		/*?
		 * Keyword: setScene
		 * This is a method that is used to set the scene that is displayed in the window. The scene that is displayed in the window is a VBox that contains the label and button.
		 * 
		 * Internal: VBox
		 * setScene
		 * This is a class that is used to represent a vertical box. It is used to arrange the label and button vertically.
		 */
		primaryStage.setScene(new Scene(new VBox(label, button)));
		/*?
		 * Keyword: show
		 * This is a method that is used to display the window.
		 */
		primaryStage.show();
	}
}
