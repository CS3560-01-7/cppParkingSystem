package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class NewWindow
{
	public Scene BroncoID(Stage primaryStage, Customer customer)
	{
        primaryStage.setTitle("LOG IN TO CPP");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
		grid.setVgap(10);//set vertical spacing to 10 pixels
		grid.setHgap(10);//set horizontal spacing to 10 pixels
		grid.setAlignment(Pos.CENTER);
		
		//set up username label and input textfield
		Label username = new Label("BroncoID: ");//create new label
		username.setTextFill(Color.WHITE);//set font color
		username.setFont(new Font("Verdana",12));//set font type and size
		GridPane.setConstraints(username, 0, 0);//set on grid
		TextField id = new TextField();//create user input space
		id.setPromptText("BrocoID");//user prompt
		GridPane.setConstraints(id, 0, 1);//set on grid
		
		//set up password label and input
		Label password = new Label("Password: ");
		password.setTextFill(Color.WHITE);//set font color
		password.setFont(new Font("Verdana",12));//set font type and size
		GridPane.setConstraints(password, 0, 2);//set on grid
		PasswordField pw = new PasswordField();
		pw.setPromptText("Password");
		GridPane.setConstraints(pw, 0, 3);//set on grid
		
		Button button = new Button("Next");
		GridPane.setConstraints(button, 0, 4);//under the textfields
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
					System.out.println("IN BRONCOID");//check if fail
					Text error = new Text("Invalid BrocoID");
					error.setFill(Color.RED);
					GridPane.setConstraints(error, 0, 5);
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		
		//set up grid
		grid.getChildren().addAll(username, id, password, pw, button);
		
		//set up scene
		Scene scene = new Scene(grid, 400, 300);
		
		//background
		BackgroundFill bf = new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		grid.setBackground(bg);
		
		//scene setting
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		return scene;
	}
	
	public Scene payForPermit(Stage primaryStage, Customer customer)
	{
		primaryStage.setTitle("Payment Information");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(10);//set vertical spacing to 8 pixels
		grid.setHgap(10);//set horizontal spacing to 8 pixels
		grid.setAlignment(Pos.CENTER);
		//total cost is a temp for total of permit cost
		
		//Label
		Label total = new Label("Total: $");
		GridPane.setConstraints(total, 0, 0);
		Label firstName = new Label("First name: ");
		GridPane.setConstraints(firstName, 0, 1);
		Label lastName = new Label("Last name: ");
		GridPane.setConstraints(lastName, 0, 2);
		Label cardNumber = new Label("Card Number: ");
		GridPane.setConstraints(cardNumber, 0, 3);
		Label expiration = new Label("Expiration Date: ");
		GridPane.setConstraints(expiration, 0, 4);
		Label securityCode = new Label("Security Code: ");
		GridPane.setConstraints(securityCode, 0, 5);
		Label billingAddress = new Label("Billing Address: ");
		GridPane.setConstraints(billingAddress, 0, 6);
		Label zip = new Label("ZIP: ");
		GridPane.setConstraints(zip, 0, 7);
		
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
			GridPane.setConstraints(button, 2, 8);//under the textfields
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
		Scene scene = new Scene(grid, 600, 450);
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
		grid.setVgap(10);//set vertical spacing to 8 pixels
		grid.setHgap(10);//set horizontal spacing to 8 pixels
		grid.setAlignment(Pos.CENTER);
		
		Text thank = new Text("Thank you for your purchase!");
		thank.setFont(Font.font("Verdana",20));
		thank.setFill(Color.WHITE);
		GridPane.setConstraints(thank, 0, 0);
		Text text1 = new Text("The temporary permit has been sent to your cpp email.");
		text1.setFont(Font.font("Verdana",12));
		text1.setFill(Color.WHITE);
		GridPane.setConstraints(text1, 0, 1);
		Text text2 = new Text("Your permit will be mailed between 2-3 business days.");
		text2.setFont(Font.font("Verdana",12));
		text2.setFill(Color.WHITE);
		GridPane.setConstraints(text2, 0, 2);
		Button button = new Button("Exit");
		GridPane.setConstraints(button, 1, 3);//under the textfields
		button.setOnAction(event -> Platform.exit());
		
		
		//set up grid
		grid.getChildren().addAll(thank,text1, text2, button);
		
		//set up scene
		Scene scene = new Scene(grid, 600, 450);
		//background
		BackgroundFill bf = new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		grid.setBackground(bg);
		//scene.getStylesheets().add("Green.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		return scene;
	}
}
