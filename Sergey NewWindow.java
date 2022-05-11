package application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
        id.setPromptText("BroncoID");//user prompt
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
        button.setOnAction(new EventHandler<ActionEvent>()      //whenever button is clicked code to handle is in this class
        {
            @Override
            public void handle (ActionEvent event)
            {
                try {
                    cart.getCustomer().setBroncoID(Integer.parseInt(id.getText()));
                    cart.getCustomer().getInfoFromDBC();
                    System.out.println(cart.getCustomer().firstName);
                    if (cart.getCustomer().firstName.isBlank()) {
                        Label invalid = new Label("Invalid entry ");
                        invalid.setTextFill(Color.RED);//set font color
                        invalid.setFont(new Font("Times New Roman",15));//set font type and size
                        grid.add(invalid, 0, 4,1,1);//set on grid
                        button.setText("Try Again");
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle (ActionEvent event) {
                                BroncoID(primaryStage, cart);
                            }
                        });

                    } else {
                        primaryStage.setScene(selectPermit(primaryStage, cart));
                    }
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


    @SuppressWarnings("static-access")
    public Scene selectPermit(Stage primaryStage, Cart cart) throws Exception
    {

        primaryStage.setTitle("Permit Selection");

        RateDB DBR = new RateDB();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
        grid.setVgap(8);//set vertical spacing to 10 pixels
        grid.setHgap(10);//set horizontal spacing to 10 pixels
        grid.setAlignment(Pos.CENTER);

        cart.getCustomer().getInfoFromDBC();

        Text text = new Text("Select your permit type");
        text.setFont(Font.font("Times New Roman",20));
        text.setFill(Color.WHITE);
        grid.add(text, 0, 0, 1, 1);

        Text select = new Text("Select: ");//user prompt
        select.setFont(Font.font("Times New Roman",12));
        select.setFill(Color.WHITE);
        grid.add(select, 0, 1, 1, 1);//set on grid

        Text fee = new Text("Permit Fee: ");//user prompt
        fee.setFont(Font.font("Times New Roman",12));
        fee.setFill(Color.WHITE);
        grid.add(fee, 1, 1, 1, 1);//set on grid

        Text description = new Text("Description: ");//user prompt
        description.setFont(Font.font("Times New Roman",12));
        description.setFill(Color.WHITE);
        grid.add(description, 2, 1, 1, 1);//set on grid

        Text valid = new Text("Permit Valid: ");//user prompt
        valid.setFont(Font.font("Times New Roman",12));
        valid.setFill(Color.WHITE);
        grid.add(valid, 3, 1, 1, 1);//set on grid

        Text expires = new Text("Permit Expires: ");//user prompt
        expires.setFont(Font.font("Times New Roman",12));
        expires.setFill(Color.WHITE);
        grid.add(expires, 4, 1, 1, 1);//set on grid


        //fill data
        Rate student1 = DBR.selectRate(1);
        Rate student2 = DBR.selectRate(2);
        Rate student3 = DBR.selectRate(3);
        Rate student4 = DBR.selectRate(4);
        Rate faculty = DBR.selectRate(5);
        //get permit rate values and put into table

        if (cart.getCustomer().student == true) {
            //student rate 1
            Text student1Fee = new Text(String.valueOf(student1.getRate()));//user prompt
            student1Fee.setFont(Font.font("Times New Roman",12));
            student1Fee.setFill(Color.WHITE);
            grid.add(student1Fee, 1, 2, 1, 1);//set on grid

            Text student1Desc = new Text(student1.getDescription());//user prompt
            student1Desc.setFont(Font.font("Times New Roman",12));
            student1Desc.setFill(Color.WHITE);
            grid.add(student1Desc, 2, 2, 1, 1);//set on grid

            Text student1Valid = new Text(student1.getValidDate());//user prompt
            student1Valid.setFont(Font.font("Times New Roman",12));
            student1Valid.setFill(Color.WHITE);
            grid.add(student1Valid, 3, 2, 1, 1);//set on grid

            Text student1Expires = new Text(student1.getExpirationDate());//user prompt
            student1Expires.setFont(Font.font("Times New Roman",12));
            student1Expires.setFill(Color.WHITE);
            grid.add(student1Expires, 4, 2, 1, 1);//set on grid

            //student rate 2
            Text student2Fee = new Text(String.valueOf(student2.getRate()));//user prompt
            student2Fee.setFont(Font.font("Times New Roman",12));
            student2Fee.setFill(Color.WHITE);
            grid.add(student2Fee, 1, 3, 1, 1);//set on grid

            Text student2Desc = new Text(student2.getDescription());//user prompt
            student2Desc.setFont(Font.font("Times New Roman",12));
            student2Desc.setFill(Color.WHITE);
            grid.add(student2Desc, 2, 3, 1, 1);//set on grid

            Text student2Valid = new Text(student2.getValidDate());//user prompt
            student2Valid.setFont(Font.font("Times New Roman",12));
            student2Valid.setFill(Color.WHITE);
            grid.add(student2Valid, 3, 3, 1, 1);//set on grid

            Text student2Expires = new Text(student2.getExpirationDate());//user prompt
            student2Expires.setFont(Font.font("Times New Roman",12));
            student2Expires.setFill(Color.WHITE);
            grid.add(student2Expires, 4, 3, 1, 1);//set on grid

            //student rate 3
            Text student3Fee = new Text(String.valueOf(student3.getRate()));//user prompt
            student3Fee.setFont(Font.font("Times New Roman",12));
            student3Fee.setFill(Color.WHITE);
            grid.add(student3Fee, 1, 4, 1, 1);//set on grid

            Text student3Desc = new Text(student3.getDescription());//user prompt
            student3Desc.setFont(Font.font("Times New Roman",12));
            student3Desc.setFill(Color.WHITE);
            grid.add(student3Desc, 2, 4, 1, 1);//set on grid

            Text student3Valid = new Text(student3.getValidDate());//user prompt
            student3Valid.setFont(Font.font("Times New Roman",12));
            student3Valid.setFill(Color.WHITE);
            grid.add(student3Valid, 3, 4, 1, 1);//set on grid

            Text student3Expires = new Text(student3.getExpirationDate());//user prompt
            student3Expires.setFont(Font.font("Times New Roman",12));
            student3Expires.setFill(Color.WHITE);
            grid.add(student3Expires, 4, 4, 1, 1);//set on grid

            //student rate 4
            Text student4Fee = new Text(String.valueOf(student4.getRate()));//user prompt
            student4Fee.setFont(Font.font("Times New Roman",12));
            student4Fee.setFill(Color.WHITE);
            grid.add(student4Fee, 1, 5, 1, 1);//set on grid

            Text student4Desc = new Text(student4.getDescription());//user prompt
            student4Desc.setFont(Font.font("Times New Roman",12));
            student4Desc.setFill(Color.WHITE);
            grid.add(student4Desc, 2, 5, 1, 1);//set on grid

            Text student4Valid = new Text(student4.getValidDate());//user prompt
            student4Valid.setFont(Font.font("Times New Roman",12));
            student4Valid.setFill(Color.WHITE);
            grid.add(student4Valid, 3, 5, 1, 1);//set on grid

            Text student4Expires = new Text(student4.getExpirationDate());//user prompt
            student4Expires.setFont(Font.font("Times New Roman",12));
            student4Expires.setFill(Color.WHITE);
            grid.add(student4Expires, 4, 5, 1, 1);//set on grid

            final ToggleGroup options = new ToggleGroup();

            RadioButton rate1 = new RadioButton("1");
            RadioButton rate2 = new RadioButton("2");
            RadioButton rate3 = new RadioButton("3");
            RadioButton rate4 = new RadioButton("4");
            rate1.setToggleGroup(options);
            rate2.setToggleGroup(options);
            rate3.setToggleGroup(options);
            rate4.setToggleGroup(options);
            rate1.setSelected(true);
            grid.add(rate1, 0, 2, 1, 1);
            grid.add(rate2, 0, 3, 1, 1);
            grid.add(rate3, 0, 4, 1, 1);
            grid.add(rate4, 0, 5, 1, 1);

            Button button = new Button("Next");
            //Button test = new Button("Test");
            grid.add(button, 0, 6, 1, 1);
            //GridPane.setConstraints(button, 1, 6);
            //GridPane.setConstraints(test, 0,6);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle (ActionEvent event) {
                    if (rate1.isSelected()) {
                        cart.getPermit().setRateID(1);
                    }
                    else if (rate2.isSelected()) {
                        cart.getPermit().setRateID(2);
                    }
                    else if (rate3.isSelected()) {
                        cart.getPermit().setRateID(3);
                    }
                    else {
                        cart.getPermit().setRateID(4);
                    }

                    try {
                        primaryStage.setScene(selectVehicles(primaryStage, cart));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
        else {
            //faculty rate
            Text facultyFee = new Text(String.valueOf(faculty.getRate()));//user prompt
            facultyFee.setFont(Font.font("Times New Roman",12));
            facultyFee.setFill(Color.WHITE);
            grid.add(facultyFee, 1, 2, 1, 1);//set on grid

            Text facultyDesc = new Text(faculty.getDescription());//user prompt
            facultyDesc.setFont(Font.font("Times New Roman",12));
            facultyDesc.setFill(Color.WHITE);
            grid.add(facultyDesc, 2, 2, 1, 1);//set on grid

            Text facultyValid = new Text(faculty.getValidDate());//user prompt
            facultyValid.setFont(Font.font("Times New Roman",12));
            facultyValid.setFill(Color.WHITE);
            grid.add(facultyValid, 3, 2, 1, 1);//set on grid

            Text facultyExpires = new Text(faculty.getExpirationDate());//user prompt
            facultyExpires.setFont(Font.font("Times New Roman",12));
            facultyExpires.setFill(Color.WHITE);
            grid.add(facultyExpires, 4, 2, 1, 1);//set on grid

            final ToggleGroup options = new ToggleGroup();

            RadioButton rate1 = new RadioButton("1");
            rate1.setToggleGroup(options);
            rate1.setSelected(true);
            grid.add(rate1, 0, 2, 1, 1);

            Button button = new Button("Next");
            //Button test = new Button("Test");
            grid.add(button, 0, 3, 1, 1);
            //GridPane.setConstraints(button, 1, 6);
            //GridPane.setConstraints(test, 0,6);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle (ActionEvent event) {
                    if (rate1.isSelected()) {
                        cart.getPermit().setRateID(5);
                    }

                    try {
                        primaryStage.setScene(selectVehicles(primaryStage, cart));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }

        //set up scene
        Scene scene = new Scene (grid, 600, 450);

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
        //create a GridPane
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.setPadding(new Insets(20,20,20,20));//amount of padding around each edge
        grid.setVgap(8);//set vertical spacing to 10 pixels
        grid.setHgap(10);//set horizontal spacing to 10 pixels
        grid.setAlignment(Pos.CENTER);

        Text text = new Text("Please Input your Vehicle Information");
        text.setFont(Font.font("Times New Roman",20));
        text.setFill(Color.WHITE);
        GridPane.setConstraints(text, 0, 0, 1, 1);

        Label vin = new Label("VIN: ");
        vin.setTextFill(Color.WHITE);
        vin.setFont(new Font("Times New Roman",15));
        grid.add(vin, 0, 1, 1, 1);
        TextField vinField = new TextField();
        vinField.setPromptText("VIN");
        vinField.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(vinField, 1, 1, 1, 1);

        Label license = new Label("License Number: ");
        license.setTextFill(Color.WHITE);
        license.setFont(new Font("Times New Roman",15));
        grid.add(license, 0, 2, 1, 1);
        TextField plateNum = new TextField();
        plateNum.setPromptText("License Number");
        plateNum.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(plateNum, 1, 2, 1, 1);

        Label make = new Label("Vehicle Make: ");
        make.setTextFill(Color.WHITE);
        make.setFont(new Font("Times New Roman",15));
        grid.add(make, 0, 3, 1, 1);

        ObservableList<String> makeOptions = FXCollections.observableArrayList("Toyota","Honda","Chevrolet",
                "Ford","Mercedes-Benz");

        ComboBox<String> makeBox = new ComboBox<String>(makeOptions);
        makeBox.setPromptText("Make");
        makeBox.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(makeBox, 1, 3, 1, 1);

        EventHandler<ActionEvent> makeBoxEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                makeBox.setPromptText((String) makeBox.getValue());
            }
        };

        makeBox.setOnAction(makeBoxEvent);

        Label model = new Label("Vehicle Model: ");
        model.setTextFill(Color.WHITE);
        model.setFont(new Font("Times New Roman",15));
        grid.add(model, 0, 4, 1, 1);

        ObservableList<String> modelOptions = FXCollections.observableArrayList("RAV4","Camry","Corolla","CR-V","Civic",
                "Accord","Silverado","Equinox","Malibu","F-Series","Escape","Explorer","GLC","GLE","E-Class/CLS");

        ComboBox<String> modelBox = new ComboBox<String>(modelOptions);
        modelBox.setPromptText("Model");
        modelBox.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(modelBox, 1, 4, 1, 1);

        EventHandler<ActionEvent> modelBoxEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                modelBox.setPromptText((String) modelBox.getValue());
            }
        };

        modelBox.setOnAction(modelBoxEvent);

        Label year = new Label("Model Year: ");
        year.setTextFill(Color.WHITE);
        year.setFont(new Font("Times New Roman",15));
        grid.add(year, 0, 5, 1, 1);
        TextField yearField = new TextField();
        yearField.setPromptText("Year");
        yearField.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(yearField, 1, 5, 1, 1);

        Label color = new Label("Vehicle Color: ");
        color.setTextFill(Color.WHITE);
        color.setFont(new Font("Times New Roman",15));
        grid.add(color, 0, 6, 1, 1);
        ObservableList<String> colorOptions = FXCollections.observableArrayList("White","Black","Gray","Silver",
                "Red","Blue","Brown","Green","Beige","Orange","Gold","Yellow","Purple","Other");

        ComboBox<String> colorBox = new ComboBox<String>(colorOptions);
        colorBox.setPromptText("Color");
        colorBox.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(colorBox, 1, 6, 1, 1);

        EventHandler<ActionEvent> colorBoxEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                colorBox.setPromptText((String) colorBox.getValue());
            }
        };

        colorBox.setOnAction(colorBoxEvent);

        ObservableList<String> options = FXCollections.observableArrayList("AL","AK","AZ","AR","AS","CA","CO",
                "CT","DE","DC","FL","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","ME","MN",
                "MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","CM","OH","OK","OR","PA","PR","RI","SC","SD",
                "TN","TX","TT","UT","VT","VA","VI","WA","WV","WI","WY","Other");

        @SuppressWarnings({ "rawtypes", "unchecked" })
        ComboBox<String> stateBox = new ComboBox(options);
        Label state = new Label("State: ");
        state.setTextFill(Color.WHITE);
        state.setFont(new Font("Times New Roman",15));
        grid.add(state, 0, 7, 1, 1);
        stateBox.setPromptText("State");
        stateBox.setStyle("-fx-border-color: GREEN; -fx-border-width: 2px;");
        grid.add(stateBox, 1, 7, 1, 1);

        EventHandler<ActionEvent> stateBoxEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stateBox.setPromptText((String) stateBox.getValue());
            }
        };

        stateBox.setOnAction(stateBoxEvent);

        //create button
        Button button = new Button("Next");
        GridPane.setConstraints(button, 0, 8, 1, 1);//under the textfields
        button.setMinSize(70,20);
        button.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
        GridPane.setHalignment(button, HPos.CENTER);
        button.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
        {
            @Override
            public void handle (ActionEvent event)
            {
                try {
                    Vehicle v = new Vehicle(vinField.getText(), plateNum.getText(), modelBox.getValue(),
                            makeBox.getValue(), colorBox.getValue(), Integer.parseInt(yearField.getText()),
                            (String) stateBox.getValue());
                    cart.getCustomer().addVehicle(v);
                    cart.getCustomer().updateDBV();
                    primaryStage.setScene(selectVehicles(primaryStage, cart));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("IN VEHICLEINFO");//check if fail
                    e.printStackTrace();
                }

            }
        });//go here when pressed

        Button back = new Button("Back");
        GridPane.setConstraints(back, 1, 8, 1, 1);//under the textfields
        back.setMinSize(70,20);
        back.setStyle("-fx-border-color: WHITE; -fx-text-fill: BLACK;");
        GridPane.setHalignment(back, HPos.CENTER);
        back.setOnAction(new EventHandler<ActionEvent>()//whenever button is clicked code to handle is in this class
        {
            @Override
            public void handle (ActionEvent event)
            {
                try {
                    primaryStage.setScene(selectVehicles(primaryStage, cart));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("IN BACK");//check if fail
                    e.printStackTrace();
                }

            }
        });//go here when pressed

        //set up grid
        grid.getChildren().addAll(text, button, back);

        //set up scene
        Scene scene = new Scene(grid, 600,450);

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
            yes.setOnAction(event->primaryStage.setScene(end(primaryStage)));

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
                    primaryStage.setScene(end(primaryStage));
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
