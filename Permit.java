/*
Class name: Permit.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: 

Calls Rate.
Gets called by Vehicle.

Check list:
basics completed
*/

import javax.swing.*;
import java.io.*;
import java.util.*;

class Permit
{
  private int permitNumber;//pk
  private String permitType;  
  private int vehicleNum = 0;
  private Rate rate;
  
  //constructor
  public Permit()
  {
  }
  
  //methods
  //mutators
  /**
  setPermitNumber method stores a value in the permitNumber field
  @param pn The value to store in permitNumber
  */
  public void setPermitNumber(int pn)
  {
    permitNumber = pn;
  }
  
  /**
  setpermitType method stores a value in the permitType field
  @param pt The value to store in permitType
  */
  public void setPermitType(String pt)
  {
    permitType = pt;
  }
  
  //accessors
  /**
  getPermitNumber method returns a object's permitNumber
  @return The value in the permitNumber field
  */
  public int getPermitNumber()
  {
    return permitNumber;
  }
  
  /**
  getPermitType method returns a object's permitType
  @return The value in the permitType field
  */
  public String getPermitType()
  {
    return permitType;
  }
  
}
