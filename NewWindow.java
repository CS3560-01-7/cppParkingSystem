package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class NewWindow
{
	public void BroncoID(Stage primaryStage, Customer customer)
	{
        primaryStage.setTitle("LOG IN TO CPP");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 8 pixels
		grid.setHgap(10);//set horizontal spacing to 8 pixels
		
		//set up username label and input
		Label username = new Label("BroncoID: ");
		GridPane.setConstraints(username, 0, 0);//set on grid
		TextField id = new TextField();
		id.setPromptText("BrocoID");
		GridPane.setConstraints(id, 1, 0);//set on grid
		
		//set up password label and input
		Label password = new Label("Username: ");
		GridPane.setConstraints(password, 0, 1);//set on grid
		PasswordField pw = new PasswordField();
		pw.setPromptText("password");
		GridPane.setConstraints(pw, 1, 1);//set on grid
		
		Button button = new Button("Next");
		GridPane.setConstraints(button, 1, 2);//under the textfields
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				customer.setBroncoID(Integer.parseInt(id.getText()));
				try {
					customer.getInfoFromDB();
					System.out.println(customer.getFullName());
					Platform.exit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		
		//set up grid
		grid.getChildren().addAll(username, id, password, pw, button);
		
		//set up scene
		Scene scene = new Scene(grid, 300, 125);
		scene.getStylesheets().add("Green.css");
		primaryStage.setScene(scene);
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
