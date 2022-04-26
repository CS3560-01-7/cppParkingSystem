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
	public Scene BroncoID(Stage primaryStage, Customer customer)
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
					primaryStage.setScene(payForPermit(primaryStage, customer));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN BRONCOID");
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
		return scene;
	}
	
	public Scene payForPermit(Stage primaryStage, Customer customer)
	{
		primaryStage.setTitle("Payment Information");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 8 pixels
		grid.setHgap(10);//set horizontal spacing to 8 pixels
		
		//total cost is a temp for total of permit cost
		
		//Label
		Label total = new Label("Total: $");
		GridPane.setConstraints(total, 1, 0);
		Label firstName = new Label("First name: ");
		GridPane.setConstraints(firstName, 1, 1);
		Label lastName = new Label("Last name: ");
		GridPane.setConstraints(lastName, 1, 2);
		Label cardNumber = new Label("Card Number: ");
		GridPane.setConstraints(cardNumber, 1, 3);
		Label expiration = new Label("Expiration Date: ");
		GridPane.setConstraints(expiration, 1, 4);
		Label securityCode = new Label("Security Code: ");
		GridPane.setConstraints(securityCode, 1, 5);
		Label billingAddress = new Label("Billing Address: ");
		GridPane.setConstraints(billingAddress, 1, 6);
		Label zip = new Label("ZIP: ");
		GridPane.setConstraints(zip, 1, 7);
		
		//TextField
		TextField totalF = new TextField();
		totalF.setText("Permit Cost");
		TextField firstNameF = new TextField();
		firstNameF.setPromptText("Billy");
		TextField lastNameF = new TextField();
		lastNameF.setPromptText("Bronco");
		TextField cardNumberF = new TextField();
		cardNumberF.setPromptText("xxxx-xxxx-xxxx-xxxx");
		TextField expirationF = new TextField();
		expirationF.setPromptText("xx");
		TextField securityCodeF = new TextField();
		securityCodeF.setPromptText("xxx");
		TextField billingAddressF = new TextField();
		billingAddressF.setPromptText("123 Sesame Street");
		TextField zipF = new TextField();
		zipF.setPromptText("xxxxx");
		
		if (customer.getPayment().getCardNumber() != 0)//if there is a cc already
		{
			//Use this card?
			//yes and no
		}//end if
		else//if there is no cc infor get info
		{
			//set up
			GridPane.setConstraints(totalF, 2, 0);
			GridPane.setConstraints(firstNameF, 2, 1);
			GridPane.setConstraints(lastNameF, 2, 2);
			GridPane.setConstraints(cardNumberF, 2, 3);
			GridPane.setConstraints(expirationF, 2, 4);
			GridPane.setConstraints(securityCodeF, 2, 5);
			GridPane.setConstraints(billingAddressF, 2, 6);
			GridPane.setConstraints(zipF, 2, 7);
			
			//set up button
			Button button = new Button("Next");
			GridPane.setConstraints(button, 3, 8);//under the textfields
			button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
			{
				@Override
					public void handle (ActionEvent event)
					{
						try {
							//get values
							customer.getPayment().setFirstName(firstNameF.getText());
							customer.getPayment().setLastName(lastNameF.getText());
							customer.getPayment().setCardNumber(Long.parseLong(cardNumberF.getText()));
							customer.getPayment().setExpDate(Integer.parseInt(expirationF.getText()));
							customer.getPayment().setSecurityCode(Integer.parseInt(securityCodeF.getText()));
							customer.getPayment().setBillingAddress(billingAddressF.getText());
							
							System.out.println(customer.getPayment().getBillingAddress());
							primaryStage.setScene(End(primaryStage));   
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("IN PAYFORPERMIT");
							e.printStackTrace();
						}	
					}
			});
			
			//set children
			grid.getChildren().addAll(total, firstName, lastName, cardNumber, expiration, securityCode, billingAddress, zip,
					totalF, firstNameF, lastNameF, cardNumberF, expirationF, securityCodeF, billingAddressF, zipF, button);
		}//end else
		
		//set up scene
		Scene scene = new Scene(grid, 800, 700);
		scene.getStylesheets().add("Green.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		return scene;
	}
	
	public Scene End(Stage primaryStage)
	{
		primaryStage.setTitle("THANK YOU");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 8 pixels
		grid.setHgap(10);//set horizontal spacing to 8 pixels
		
		//set up username label and input
		Label username = new Label("Your temporary permit has been sent to your cpp email.\nHave a nice semester!");
		GridPane.setConstraints(username, 0, 0);//set on grid
		
		Button button = new Button("Exit");
		GridPane.setConstraints(button, 3, 3);//under the textfields
		button.setOnAction(event -> Platform.exit());
		
		
		//set up grid
		grid.getChildren().addAll(username, button);
		
		//set up scene
		Scene scene = new Scene(grid, 700, 600);
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
		return scene;
	}
}
