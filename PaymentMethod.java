/*
Class name: PaymentMethod.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: Checks and validates the Payment method entered by the user.  Attributes: creditCard,
debitCard, 

basics completed.
*/

import java.io.*;
import java.util.*;
import javax.swing.*;

class PaymentMethod
{
  //attributes
  private int creditCard;//pk
  private int debitCard;
  private int securityCode;
  private String billingAddress;  
  
  //constructor
  
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
