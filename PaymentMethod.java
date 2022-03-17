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
import javax.swing.*;

class PaymentMethod
{
  //attributes
  private int cardNumber;//pk
  private int securityCode;
  private int expDate;
  private String name;
  private String billingAddress;  
  
  //constructor
  public PaymentMethod(int cardNumber, int securityCode, int expDate, String name, String billingAddress)
  {
  }
  //methods 
  //mutators
  /**
  setCreditCard method stores a value into creditCard field
  @param cc The value to store in creditCard
  */
  public void setCardNumber(int cc)
  {
    cardNumber = cc;
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
  setName method stores a value into name field
  @param ba The value to store in name
  */
  public void setName(String n)
  {
    name = n;
  }
  /**
  setBillingAddress method stores a value into billingAddress field
  @param ba The value to store in billingAddress
  */
  public void setBillingAddress(int ba)
  {
    billingAddress = ba;
  }
  
  //accessors
  /**
  getCardNumber method returns PaymentMethod object's cardNumber
  @return The value in cardNumber
  */
  public int getCardNumber()
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
  @return The value in name
  */
  public int getName()
  {
    return name;
  }
  
  /**
  getBillingAddress method returns PaymentMethod object's billingAddress
  @return The value in billingAddress
  */
  public String getBillingAddress()
  {
    return billingAddress;
  }
  //
  
  
}
