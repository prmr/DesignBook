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
	 * Keyword: start
	 * This is the start method that is called when the application is launched. It takes a Stage as a parameter.
	 * 
	 * Keyword: primaryStage
	 * This is the Stage that is passed to the start method. It is the main window of the application. 
	 * 
	 * Keyword: throws
	 * This is a keyword that is used to indicate that the method may throw an exception. 
	 * 
	 * Keyword: Exception
	 * This is a class that is used to represent an exception.
	 */
	public void start(Stage primaryStage) throws Exception
	{
        TextField textfield1 = new TextField("text field 1");
        TextField textfield2 = new TextField("text field 2");
        /*?
         * Keyword: button
         * This is a Button that is used to display text and perform an action when it is clicked. The text that is displayed on the button is "Swap".
         */
        Button button = new Button("Swap");
        /*?
         * Keyword: setOnAction
         * This is a method that is used to set the action that is performed when the button is clicked.
         * 
         * Keyword: new EventHandler<ActionEvent>()
         * This is an anonymous class that is used to handle the ActionEvent that is passed to the handle method. EventHandler is an interface that is used to handle events and ActionEvent is a class that is used to represent an event that is triggered when an action is performed.
         * 
         * Internal: EventHandler
         * new EventHandler<ActionEvent>()
         * This is an interface that is used to handle events, it has a single method called handle that is used to handle the event that is passed to it as a parameter. 
         * 
         * Internal: ActionEvent
         * new EventHandler<ActionEvent>()
         * This is a class that is used to represent an event that is triggered when an action is performed, it has a single method called getActionCommand that is used to get the command that is associated with the action that was performed. ActionEvent is a subclass of Event and Event is a class that is used to represent an event that is triggered when something happens.
         */
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /*?
             * Keyword: handle
             * This is the handle method that is called when the event is triggered. It takes an ActionEvent as a parameter. We define the handle method in the anonymous class that is passed to the setOnAction method of the button to handle the ActionEvent that is triggered when the button is clicked and perform the action that is associated with the event being triggered (in this case, swapping the text that is displayed in the text fields).
             */
            public void handle(ActionEvent event) {
                String temp = textfield1.getText();
                textfield1.setText(textfield2.getText());
                textfield2.setText(temp);
            }
        });
        /*?
         * Keyword: setScene
         * This is a method that is used to set the scene that is displayed in the window.
         *
         */
        primaryStage.setScene(new Scene(new VBox(new HBox(textfield1, textfield2), button)));
        primaryStage.show();

	}
}
