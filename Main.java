/*
Project name: Main.java

Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan

Purpose: main method for the cpp parking systems project.
This system will allow users to purchase, look up, and update their parking permit for a specific semester.  
In the main class, there are lines of code that allow customer to enter their BroncoID to login.
It will also have a drop-down menu of permit Type (long/short semester). Showing customer permit's price.
And finally, let customer enter their credit card's information to pay. 

put all user prompts here...
*/
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application{
	Scene scene1, scene2;
	static Customer customer = new Customer();
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		//set up the stage and button
		Button button = new Button();
		button.setText("Next");
		primaryStage.setTitle("CPP LOG IN");
		Label label = new Label ("Enter your broncoID and password");
		
		//Form
		TextField id = new TextField();
		
		
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				customer.setBroncoID(Integer.parseInt(id.getText()));
				try {
					customer.getInfoFromDB();
					System.out.println(customer.getFullName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		
		//layout 1 stack objects on top of one another
		VBox layout = new VBox();
		layout.getChildren().addAll(label, id, button);
		
		//display
		scene1 = new Scene(layout, 600, 500);
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		/*new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				
			}
		});
		*/
	}
}
	
