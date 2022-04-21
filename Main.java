/*
Project name: Main.java

Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan

Purpose: main method for the cpp parking systems project.
This system will allow users to purchase, look up, and update their parking permit for a specific semester.  
In the main class, there are lines of code that allow customer to enter their BroncoID to login.
It will also have a drop-down menu of permit Type (long/short semester). Showing customer permit's price.
And finally, let customer enter their credit card's information to pay. 

put all user prompts here...
*/

import java.io.*;
import java.util.*;
import java.swing.*;

class Main
{
  public class static void main(String[] args)
  {
    //broncoId and password window, get user input, get info from Customer database
    
    //create new Customer object based on input
    Customer customer = new Customer();
    
    //open permit window and ask for information
    Permit permit = new Permit();
    
    //get new vehicle or show saved vehicle information
    Vehicle vehicle = new Vehicle();
    
    //ask for payment if 
    PaymentMethod = new PaymentMethod;
    
  }//end main
}
