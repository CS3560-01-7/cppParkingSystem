/*
Class name: PaymentMethod.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: PaymentMethod class holds the attributes: creditNumber, expirationDateM, expirationY,
securityCode, name, and billingAddress.  
The PaymentMethod class's methods recieve, send, update, and validate user input.

We are assuming for this system that all cc are valid and so is the billing address.

Gets called by Customer.

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
  private int expirationDateM;
  private int expirationDateY;
  private int securityCode;
  private String name;
  private String billingAddress;  
  
  //constructor
  public PaymentMethod(int cardnum, int expirationM, int expirationY, int securityCode, String name, String address)
  {
  }
  //methods 
  //mutators
  /**
  setCreditCard method stores a value into creditCard field
  @param cc The value to store in creditCard
  */
  public void setCreditCard(int cc)
  {
    creditCard = cc;
  }
  
  /**
  setDebitCard method stores a value into debitCard field
  @param dc The value to store in debitCard
  */
  public void setDebitCard(int dc)
  {
    debitCard = dc;
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
  setBillingAddress method stores a value into billingAddress field
  @param ba The value to store in billingAddress
  */
  public void setBillingAddress(int ba)
  {
    billingAddress = ba;
  }
  
  //accessors
  /**
  getCreditCard method returns PaymentMethod object's creditCard
  @return The value in creditCard
  */
  public int getCreditCard()
  {
    return creditCard;
  }
  
  /**
  getDebitCard method returns PaymentMethod object's debitCard
  @return The value in debitCard
  */
  public int getDebitCard()
  {
    return debitCard;
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
  getBillingAddress method returns PaymentMethod object's billingAddress
  @return The value in billingAddress
  */
  public String getBillingAddress()
  {
    return billingAddress;
  }
  //
  
  
}
