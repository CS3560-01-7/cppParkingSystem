package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class NewWindow
{
	public Scene BroncoID(Stage primaryStage, Cart cart)//COMPLETE DO NOT TOUCH PLEASE
	{
        primaryStage.setTitle("LOG IN TO CPP");
		
		//create a GridPane
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.getColumnConstraints().add(new ColumnConstraints(150));
		grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 10 pixels
		grid.setHgap(10);//set horizontal spacing to 10 pixels
		grid.setAlignment(Pos.CENTER);
		
		//set up username label and input textfield
		Label username = new Label("BroncoID: ");//create new label
		username.setTextFill(Color.WHITE);//set font color
		username.setFont(new Font("Times New Roman",15));//set font type and size
		grid.add(username, 0, 0, 1, 1);//set on grid
		TextField id = new TextField();//create user input space
		id.setPromptText("BrocoID");//user prompt
		id.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(id, 0, 1, 1, 1);//set on grid
		
		//set up password label and input
		Label password = new Label("Password: ");
		password.setTextFill(Color.WHITE);//set font color
		password.setFont(new Font("Times New Roman",15));//set font type and size
		grid.add(password, 0, 2,1,1);//set on grid
		PasswordField pw = new PasswordField();
		pw.setPromptText("Password");
		pw.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(pw, 0, 3,1,1);//set on grid
		
		//create button 
		Button button = new Button("Next");
		grid.add(button, 0, 5,1,1);//under the textfields
		GridPane.setHalignment(button, HPos.CENTER);
		button.setMinSize(70,20);
		button.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				try {
					cart.getCustomer().setBroncoID(Integer.parseInt(id.getText()));
					cart.getCustomer().getInfoFromDBC();
					//System.out.println(customer.getFullName());
					primaryStage.setScene(selectVehicles(primaryStage, cart));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN BRONCOID");//check if fail
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		
		//set up grid
		//grid.getChildren().addAll(username, id, password, pw, button);
		
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
	
	public Scene selectVehicles(Stage primaryStage, Cart cart)//ETHAN
	{
        primaryStage.setTitle("Vehicle Selection");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 10 pixels
		grid.setHgap(10);//set horizontal spacing to 10 pixels
		grid.setAlignment(Pos.CENTER);
		
		Text text = new Text("Select the Vehicle for your Permit");
		text.setFont(Font.font("Times New Roman",20));
		text.setFill(Color.WHITE);
		GridPane.setConstraints(text, 0, 0);
		
		
		//create button 
		Button button = new Button("Next");
		GridPane.setConstraints(button, 0, 1);//under the textfields
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				try {
					primaryStage.setScene(payForPermit(primaryStage, cart));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN SELECT");//check if fail
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		//create button 
		Button add = new Button("Add");
		GridPane.setConstraints(add, 1,1);//under the textfields
		add.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				try {
					primaryStage.setScene(vehicleInformation(primaryStage, cart));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN ADD");//check if fail
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
				
		//set up grid
		grid.getChildren().addAll(text, add, button);
		
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
	
	public Scene vehicleInformation(Stage primaryStage, Cart cart)//Amal
	{
        primaryStage.setTitle("Vehicle Information");
		
		//create a GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 10 pixels
		grid.setHgap(10);//set horizontal spacing to 10 pixels
		grid.setAlignment(Pos.CENTER);
		
		Text text = new Text("Please Input your Vehicle Information");
		text.setFont(Font.font("Times New Roman",20));
		text.setFill(Color.WHITE);
		GridPane.setConstraints(text, 0, 0);
		
		
		//create button 
		Button button = new Button("Next");
		GridPane.setConstraints(button, 0, 1);//under the textfields
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				try {
					primaryStage.setScene(selectVehicles(primaryStage, cart));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN BRONCOID");//check if fail
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		
		//set up grid
		grid.getChildren().addAll(text, button);
		
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
	
	
	
	
	public Scene payForPermit(Stage primaryStage, Cart cart) throws Exception//Pay for permit 2
	{
		primaryStage.setTitle("Payment Information");
		//create new grid
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.getColumnConstraints().add(new ColumnConstraints(150));
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(10);//set vertical spacing to 8 pixels
		grid.setHgap(5);//set horizontal spacing to 8 pixels
		grid.setAlignment(Pos.CENTER);
		
		//get information from DB
		cart.getCustomer().getInfoFromDBPM();
		
		//check to see if cc exists to decide which form to call
		if (cart.getCustomer().getPayment().getCardNumber() != 0)//if there is a cc already
		{
			//lets you know that there is a cc on file asks whether or not to use
			Text ask = new Text("Do you want to use this credit card?");
			ask.setFont(Font.font("Times New Roman",25));
			ask.setFill(Color.WHITE);
			grid.add(ask, 0, 0, 2,1);
			GridPane.setHalignment(ask, HPos.CENTER);
			
			//Labels
			Label name = new Label("Name: ");
			name.setFont(Font.font("Times New Roman",15));
			name.setTextFill(Color.WHITE);
			grid.add(name, 0, 1,1,1);
			Label cardNum = new Label("Card Number: ");
			cardNum.setFont(Font.font("Times New Roman",15));
			cardNum.setTextFill(Color.WHITE);
			grid.add(cardNum, 0, 2,1,1);
			Label exp = new Label("Expiration: ");
			exp.setFont(Font.font("Times New Roman",15));
			exp.setTextFill(Color.WHITE);
			grid.add(exp, 0, 3,1,1);
			
			//get values from database to show
			TextField n = new TextField(cart.getCustomer().getPayment().getFirstName() + " " + cart.getCustomer().getPayment().getLastName());
			n.setFont(Font.font("Times New Roman",15));
			grid.add(n, 1, 1,1,1);
			n.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
			
			TextField c = new TextField("" + cart.getCustomer().getPayment().getCardNumber());
			c.setFont(Font.font("Times New Roman",15));
			grid.add(c, 1, 2,1,1);
			c.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
			
			TextField e = new TextField(cart.getCustomer().getPayment().getExpDateM() + "/" + cart.getCustomer().getPayment().getExpDateY());
			e.setFont(Font.font("Times New Roman",15));
			grid.add(e, 1, 3,1,1);
			e.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
			
			//set up buttons
			Button yes = new Button("Yes");
			Button no = new Button("No");
			grid.add(yes, 0, 4,1,1);
			grid.add(no, 1, 4,1,1);
			GridPane.setHalignment(yes, HPos.CENTER);
			GridPane.setHalignment(no, HPos.CENTER);
			yes.setMinSize(70,20);
			yes.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
			no.setMinSize(70,20);
			no.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
			
			//set children
			//grid.getChildren().addAll(ask,cardNum,name,exp,yes,no,n,c,e);
			
			//button actions go to next stage if user likes payment
			yes.setOnAction(event->primaryStage.setScene(finalVerification(primaryStage, cart)));   
			
			//delete current data in database and replace
			no.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
					{
						@Override
							public void handle (ActionEvent event)
							{
								try {
									cart.getCustomer().deleteInfoFromDBPM();
									primaryStage.setScene(newPayment(primaryStage,cart));   
								} catch (Exception e) {
									// TODO Auto-generated catch block
									System.out.println("IN PAYFORPERMIT");
									e.printStackTrace();
								}	
							}
					});
			
		}//end if
		else//if there is no cc info get info
		{
			return newPayment(primaryStage,cart);
		}//end else
	
		
		//set up scene
		Scene scene = new Scene(grid, 600, 450);
				
		//background
		BackgroundFill bf = new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		grid.setBackground(bg);
		primaryStage.setScene(scene);
		primaryStage.show();
		return scene;
	}
	
	public Scene newPayment(Stage primaryStage, Cart cart)
	{
		//top of stage
		primaryStage.setTitle("Payment Information");
		
		//create a GridPane
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.getColumnConstraints().add(new ColumnConstraints(115));
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(10);//set vertical spacing to 8 pixels
		grid.setHgap(5);//set horizontal spacing to 8 pixels
		grid.setAlignment(Pos.CENTER);
		//total cost is a temp for total of permit cost
		
		//heading
		Text info = new Text("Payment Information");
		info.setFont(Font.font("Times New Roman",20));
		info.setFill(Color.WHITE);
		grid.add(info, 0, 0,1,1);
		
		//total label
		Label total = new Label("Total: $");
		total.setFont(Font.font("Times New Roman",15));
		total.setTextFill(Color.WHITE);
		grid.add(total, 0, 1,1,1);
		
		//first name label
		Label firstName = new Label("First name: ");
		firstName.setFont(Font.font("Times New Roman",15));
		firstName.setTextFill(Color.WHITE);
		grid.add(firstName, 0, 2,1,1);
		
		//last name label
		Label lastName = new Label("Last name: ");
		lastName.setFont(Font.font("Times New Roman",15));
		lastName.setTextFill(Color.WHITE);
		grid.add(lastName, 0, 3,1,1);
		
		//card number label
		Label cardNumber = new Label("Card Number: ");
		cardNumber.setFont(Font.font("Times New Roman",15));
		cardNumber.setTextFill(Color.WHITE);
		grid.add(cardNumber, 0, 4,1,1);
		
		//expiration label
		Label expiration = new Label("Expiration Date: ");
		expiration.setFont(Font.font("Times New Roman",15));
		expiration.setTextFill(Color.WHITE);
		grid.add(expiration, 0, 5,1,1);
		
		//security code label
		Label securityCode = new Label("Security Code: ");
		securityCode.setFont(Font.font("Times New Roman",15));
		securityCode.setTextFill(Color.WHITE);
		grid.add(securityCode, 0, 6,1,1);
		
		//billing address label
		Label billingAddress = new Label("Billing Address: ");
		billingAddress.setFont(Font.font("Times New Roman",15));
		billingAddress.setTextFill(Color.WHITE);
		grid.add(billingAddress, 0, 7,1,1);
		
		//zip code label
		Label zip = new Label("ZIP: ");
		zip.setFont(Font.font("Times New Roman",15));
		zip.setTextFill(Color.WHITE);
		grid.add(zip, 0, 8,1,1);
		
		//user input total
		TextField totalF = new TextField();
		totalF.setText("" + cart.getPermit().getRate());
		totalF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(totalF, 2, 1,2,1);
		
		//user input first name
		TextField firstNameF = new TextField();
		firstNameF.setPromptText("Billy");
		firstNameF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(firstNameF, 2, 2,2,1);
		
		//user input last name
		TextField lastNameF = new TextField();
		lastNameF.setPromptText("Bronco");	
		lastNameF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(lastNameF, 2, 3,2,1);
		
		//user input card number
		TextField cardNumberF = new TextField();
		cardNumberF.setPromptText("XXXX-XXXX-XXXX-XXXX");	
		cardNumberF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(cardNumberF, 2, 4,2,1);
		
		//Choicebox
		ChoiceBox<Integer> expirationF1 = new ChoiceBox<>();
		expirationF1.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);						
		ChoiceBox<Integer> expirationF2 = new ChoiceBox<>();
		expirationF2.getItems().addAll(22,23,24,25,26,27,28,29,30,31,32,33,34);//can add more as needed
		expirationF2.setValue(23);
		expirationF1.setValue(1);
		//expirationF1.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		//expirationF2.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(expirationF1, 2, 5,1,1);
		grid.add(expirationF2, 3, 5,1,1);
		
		//user input security code
		TextField securityCodeF = new TextField();
		securityCodeF.setPromptText("xxx");
		securityCodeF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(securityCodeF, 2, 6,2,1);
		
		//user input billing address
		TextField billingAddressF = new TextField();
		billingAddressF.setPromptText("123 Sesame Street");
		billingAddressF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(billingAddressF, 2, 7,2,1);
		
		//user input zip
		TextField zipF = new TextField();
		zipF.setPromptText("xxxxx");
		zipF.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
		grid.add(zipF, 2, 8,2,1);
		
		//set up button
		Button button = new Button("Next");
		grid.add(button, 2, 9,1,1);//under the textfields
		GridPane.setHalignment(button, HPos.CENTER);
		button.setMinSize(70,20);
		button.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
				public void handle (ActionEvent event)
				{
					try {
						//get values
						cart.getCustomer().getPayment().setFirstName(firstNameF.getText());
						cart.getCustomer().getPayment().setLastName(lastNameF.getText());
						cart.getCustomer().getPayment().setCardNumber(Long.parseLong(cardNumberF.getText()));
						cart.getCustomer().getPayment().setExpDateM(expirationF1.getValue());
						cart.getCustomer().getPayment().setExpDateY(expirationF2.getValue());
						cart.getCustomer().getPayment().setSecurityCode(Integer.parseInt(securityCodeF.getText()));
						cart.getCustomer().getPayment().setBillingAddress(billingAddressF.getText());
						cart.getCustomer().getPayment().setZIP(Integer.parseInt(zipF.getText()));
						
						//add values to database
						cart.getCustomer().addInfoToDBPM();
						
						//go to next scene
						primaryStage.setScene(finalVerification(primaryStage, cart));   
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("IN PAYFORPERMIT");
						e.printStackTrace();
					}	
				}
		});
		
		//set children
		//grid.getChildren().addAll(info,total, firstName, lastName, cardNumber, expiration, securityCode, billingAddress, zip,
		//		totalF, firstNameF, lastNameF, cardNumberF, expirationF1, expirationF2, securityCodeF, billingAddressF, zipF, button);
		
		//set up scene
		Scene scene = new Scene(grid, 600, 450);
		//scene.getStylesheets().add("Green.css");
				
		//set up the background
		BackgroundFill bf = new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		grid.setBackground(bg);
		
		//display the scene
		primaryStage.setScene(scene);
		primaryStage.show();
		
		return scene;
	}
	
	public Scene finalVerification(Stage primaryStage, Cart cart)//ETHAN
	{
        primaryStage.setTitle("Verify the information submitted");
		
		//create a GridPane
		GridPane grid = new GridPane();
		
		grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
		grid.setVgap(8);//set vertical spacing to 10 pixels
		grid.setHgap(10);//set horizontal spacing to 10 pixels
		grid.setAlignment(Pos.CENTER);
		
		Text text = new Text("Is this Information Correct?");
		text.setFont(Font.font("Times New Roman",20));
		text.setFill(Color.WHITE);
		GridPane.setConstraints(text, 0, 0);
		
		
		//create button 
		Button button = new Button("Yes");
		GridPane.setConstraints(button, 0, 1);//under the textfields
		button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				try {
					primaryStage.setScene(end(primaryStage));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN SELECT");//check if fail
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
		
		//create button 
		Button add = new Button("No");
		GridPane.setConstraints(add, 1, 1);//under the textfields
		add.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
		{
			@Override
			public void handle (ActionEvent event)
			{
				try {
					primaryStage.setScene(selectVehicles(primaryStage, cart));   
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("IN ADD");//check if fail
					e.printStackTrace();
				}
				
			}
		});//go here when pressed
				
		//set up grid
		grid.getChildren().addAll(text, add, button);
		
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
	
	
	public Scene end(Stage primaryStage)//COMPLETE DO NOT TOUCH PLEASE 
	{
		primaryStage.setTitle("THANK YOU");
		
		//create a GridPane
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.getColumnConstraints().add(new ColumnConstraints(500));
		grid.setPadding(new Insets(10,10,10,10));//amount of padding around each edge
		grid.setVgap(10);//set vertical spacing to 8 pixels
		grid.setHgap(12);//set horizontal spacing to 8 pixels
		grid.setAlignment(Pos.CENTER);
		
		Text thank = new Text("Thank you for your purchase!");
		thank.setFont(Font.font("Times New Roman",25));
		thank.setFill(Color.WHITE);
		GridPane.setConstraints(thank, 0, 0);
		GridPane.setHalignment(thank, HPos.CENTER);
		
		Text text1 = new Text("The temporary permit has been sent to your cpp email.\nYour permit will be mailed between 2-3 business days.");
		text1.setFont(Font.font("Times New Roman",18));
		text1.setFill(Color.WHITE);
		GridPane.setConstraints(text1, 0, 1);
		GridPane.setHalignment(text1, HPos.CENTER);
		
		Button button = new Button("Exit");
		GridPane.setConstraints(button, 0, 2);//under the textfields
		GridPane.setHalignment(button, HPos.CENTER);
		button.setMinSize(70,20);
		button.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
		button.setOnAction(event -> Platform.exit());
		
		
		//set up grid
		grid.getChildren().addAll(thank,text1, button);
		
		//set up scene
		Scene scene = new Scene(grid, 600, 450);
		
		//background
		BackgroundFill bf = new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		grid.setBackground(bg);
		
		//display scene
		primaryStage.setScene(scene);
		primaryStage.show();
		
		return scene;
	}
}
