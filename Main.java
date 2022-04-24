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
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner scnr = new Scanner(System.in);
		Customer customer = new Customer();
		CustomerDB db = new CustomerDB();
		
		System.out.println("Enter bronco id:");
		customer.setBroncoID(scnr.nextInt());
		db.selectCustomer(customer);
		
		System.out.println(customer.getFullName());
	
	}
}
		
