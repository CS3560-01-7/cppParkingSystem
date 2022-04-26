/*
Class name: PaymentMethod.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: PaymentMethod class holds the attributes: cardNumber, securityCode, expDate, name, billingAddress, and Custumer
The PaymentMethod class's methods recieve, send, update, and validate user input (credit card's information)
PaymentMethod calls Customer object.

We are assuming for this system that all cards are valid and so is the billing address.

Checklist:
basics completed.
*/

import java.io.*;
import java.util.*;
package application;

public class PaymentMethod {
	private long cardNumber;//pk
	  private int securityCode;
	  private int expDate;
	  private String firstName;
	  private String lastName;
	  private String billingAddress; 
	  private int zip;
	  
	  //private PaymentMethodDB db;
	  
	  //constructor
	  public PaymentMethod()
	  {
	    cardNumber = 0;
	    securityCode = 0;
	    expDate = 0;
	    firstName = "";
	    lastName = "";
	    billingAddress = "";
	  }
	  public PaymentMethod(long cardNumber, int securityCode, int expDate, String firstName, String lastName, String billingAddress)
	  {
	    this.cardNumber = cardNumber;
	    this.securityCode = securityCode;
	    this.expDate = expDate;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.billingAddress = billingAddress;
	  }
	  //methods 
	  //mutators
	  /**
	  setCreditCard method stores a value into creditCard field
	  @param cn The value to store in creditCard
	  */
	  public void setCardNumber(long cn)
	  {
	    cardNumber = cn;
	  }
	  
	  
	  /**
	  setSecurityCode method stores a value into securityCode field
	  @param sc The value to store in securityCode
	  */
	  public void setSecurityCode(int sc)
	  {
	    securityCode = sc;
	  }
	  
	  
	  /**
	  setExpDate method stores a value into expDate field
	  @param ba The value to store in expDate
	  */
	  public void setExpDate(int ed)
	  {
	    expDate = ed;
	  }
	  
	  
	  /**
	  setFirstName method stores a value into name field
	  @param ba The value to store in name
	  */
	  public void setFirstName(String n)
	  {
	    firstName = n;
	  }
	  /**
	  setLastName method stores a value into name field
	  @param ba The value to store in name
	  */
	  public void setLastName(String n)
	  {
	    lastName = n;
	  }
	  /**
	  setBillingAddress method stores a value into billingAddress field
	  @param ba The value to store in billingAddress
	  */
	  public void setBillingAddress(String ba)
	  {
	    billingAddress = ba;
	  }
	  
	  //accessors
	  /**
	  getCardNumber method returns PaymentMethod object's cardNumber
	  @return The value in cardNumber
	  */
	  public long getCardNumber()
	  {
	    return cardNumber;
	  }
	  
	  /**
	  getSecurityCode method returns PaymentMethod object's securityCode
	  @return The value in securityCode
	  */
	  public int getSecurityCode()
	  {
	    return securityCode;
	  }
	  
	  
	  /**
	  getExpDate method returns PaymentMethod object's expDate
	  @return The value in expDate
	  */
	  public int getExpDate()
	  {
	    return expDate;
	  }
	  
	  /**
	  getName method returns PaymentMethod object's name
	  @return The full name
	  */
	  public String getName()
	  {
	    return firstName + " " + lastName;
	  }
	  
	  /**
	  getFirstName method returns PaymentMethod object's name
	  @return The value in firstName
	  */
	  public String getFirstName()
	  {
	    return firstName;
	  }
	  
	  /**
	  getFirstName method returns PaymentMethod object's name
	  @return The value in firstName
	  */
	  public String getLastName()
	  {
	    return lastName;
	  }
	  /**
	  getBillingAddress method returns PaymentMethod object's billingAddress
	  @return The value in billingAddress
	  */
	  public String getBillingAddress()
	  {
	    return billingAddress;
	  }
	 
}
