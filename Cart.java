/*
Class name: Cart.java
Contributers: Lynn Takahashi
Purpose: Cart class acts an association class between PaymentMethod,
Permit, and Customer.

*/

import java.util.*;

public class Cart
{
  private ArrayList<Permit> cart = new ArrayList<Permit>();
  private String customerName;
  
  public Cart()
  {
    
  }
  
  public void addPermit(Permit p)
  {
    cart.add(p);
  }
  
  //remove permit???
  public void removePermit()
  {
    cart.remove(0);
  }
}//end class
