/*
Class name: Cart.java
Contributers: Lynn Takahashi
Purpose: Cart class acts an association class between PaymentMethod,
Permit, and Customer.

*/

import java.util.*;

public class Cart
{
  private Permit permit;
  private Customer customer;
  private PaymentMethod payment;
  
  public Cart()
  {
    permit = new Permit();
    customer = new Customer();
    payment = new PaymentMethod();
  }
  
  public Cart(Permit p, Customer c, PaymentMethod pm)
  {
    permit = p;
    customer = c;
    payment = pm;
  }
  
  
  //getters and setters
  public void setPermit(Permit p)
  {
    permit = p;
  }
  
  public void setCustomer(Customer c)
  {
    customer = c;
  }
  
  public void setPaymentMethod(PaymentMethod pm)
  {
    payment = pm;
  }
  
  public Permit getPermit()
  {
    return permit;
  }
  
  public Customer getCustomer()
  {
    return customer;
  }
  
  public PaymentMethod getPaymentMethod()
  {
    return payment;
  }
  
}//end class
