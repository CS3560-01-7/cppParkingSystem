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
import javafx.stage.Stage;

public class Main extends Application{
	static Cart cart = new Cart();
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		//set title 
		NewWindow window = new NewWindow();
		primaryStage.setScene(window.BroncoID(primaryStage, cart));
		
		primaryStage.show();
		
	}
}
	
