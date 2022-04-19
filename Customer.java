/*
Class name: Customer.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: The Customer class holds the attributes: broncoID (primary key), password, first name, last name, email address,
vehicle, and paymentMethod.
The Customer class' methods recieve, update, and compares user input to the system database's info.
Customers calls Vehicle and PaymentMethod objects.

We are assuming everyone has a valid broncoID, that the Customer exists, and the email address is valid.

Checklist:
basics done


*/

import javax.swing.*;
import java.io.*;
import java.util.*;

class Customer
{
  //attributes
  private int broncoID;//pk
  private String password;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String address;
  private Vehicle vehicle;
  private PaymentMethod payment = new PaymentMethod();
  
  //constructor
  public Customer()
  {
    //
  }
  
  //methods
  //mutators
  /**
  setBroncoID method stores a value in the broncoID field
  @param id The value to store in broncoID
  */
  public void setBroncoID(int id)
  {
    broncoID = id;
  }
  
   /**
  setPassword method stores a value in the password field
  @param pw The value to store in password
  */
  public void setPassword(String pw)
  {
    password = pw;
  }
  
  /**
  setFirstName method stores value in the firstName field
  @param first The value to store in firstName
  */
  public void getFirstName(String first)
  {
    firstName = first;
  }
  
  /**
  setLastName method stores a value in the lastName field
  @param last The value to store into lastName 
  */
  public void setLastName(String last)
  {
    lastName = last;
  }
  
  /**
  setEmailAddress method stores a value in the emailAddress field
  @param ea The value to store in emailAddress
  */
  public void setEmailAddress(String ea)
  {
    emailAddress = ea;
  }
  
  //accessors
  /**
  getBroncoID method returns a Customer object's broncoID
  @return The value in the broncoID field
  */
  public int getBroncoID()
  {
    return broncoID;
  }
  
  /**
  getPassword method returns a Customer object's password
  @return The value in the password field
  */
  public String getPassword()
  {
    return password;
  }
  
  /**
  getFirstName method returns a Customer object's firstName
  @return The value in the firstName field
  */
  public String getFirstName()
  {
    return firstName;
  }
  
  /**
  getLastName method returns a Customer object's lastName
  @return The value in the lastName field
  */
  public String getLastName()
  {
    return lastName;
  }
  
  /**
  getEmailAddress method returns a Customer object's emailAddress
  @return The value in the emailAddress field
  */
  public String getEmailAddress()
  {
    return emailAddress;
  }
  
  //login
   /**
  checkBrocoID method returns boolean depending on if broncoID matches userInput
  @return Boolean value
  */
  public boolean checkBrocoID(int userInput)
  {
    //compare userInput to broncoID
    //if it does ot match return false.  if it does match return true
  }
  
  /**
  checkPassword method returns boolean depending on password matches userInput
  @return Boolean value
  */
  public boolean checkPassword(String userInput)
  {
    //compare userInput to password
    //if it does ot match return false.  if it does match return true
  }
  
  /**
  addVehicle method adds a vehicle class and returns true if successful
  @param plateNum The vehicle's license plate number
  @param type The type of vehicle
  @param make The vehicle's manufacturer
  @param model The vehicle's model
  @param year The year the vehicle's model was released
  @param color The vehicle's color
  @return Boolean value
  */
  public boolean addVehicle(String plateNum, String type, String make, String model, int year, String color) {
    vehicle = new Vehicle(plateNum, type, make, model, year, color);
    return true;
  }
  /**
  addPaymentMethod() method adds a payment method and returns true if successful.
  @param cardNum The credit or debit card's number
  @param secCode The card's security code
  @param billAddr The card's billing address
  @return Boolean vehicle
  */
  public boolean addPaymentMethod(String cardNum, int exDateM, int exDateY, String secCode, String name, String billAddr)
  {
     paymentMethod = new paymentMethod(cardNum, exDateM, exDateY, secCode, name, billAddr);
     return true;
  }
}
