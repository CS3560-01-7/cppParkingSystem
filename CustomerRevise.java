/*
still need to implement an array or arraylist of Vehicles 
add vehicle method
read vehicle (owned) method
*/
package application;

public class Customer {
	protected int broncoID;
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected String address;
	protected int vehicleCount;
	protected boolean student;
	protected Vehicle vehicle;
	protected PaymentMethod payment;
	private CustomerDB dbc = new CustomerDB();
	private PaymentMethodDB dbpm = new PaymentMethodDB(); 

	//constructor
	Customer()
	{
		broncoID=0;
		firstName = "";
		lastName = "";
		emailAddress = "";
		address = "";
		vehicleCount = 0;
		vehicle = null;
		payment = null;
	}
		
	//getters
	public int getBroncoID()
	{
		return broncoID;
	}
		
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public String getAddress()
	{
		return address;
	}
	public boolean getStudent()
	{
		return student;
	}
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	public PaymentMethod getPayment()
	{
		return payment;
	}
	
		
	//setters
	public void setBroncoID(int id)
	{
		broncoID = id;
	}
	public void setFirstName(String name)
	{
		firstName = name;
	}
	public void setLastName(String name)
	{
		lastName = name;
	}
	public void setEmailAddress(String address)
	{
		emailAddress = address;
	}
	public void setStudent(boolean s)
	{
		student = s;
	}

	public void setAddress(String ad) {
		address = ad;
		
	}
	public void setVehicle(Vehicle v)
	{
		vehicle = v;
	}
	public void setPayment(PaymentMethod p)
	{
		payment = p;
	}
	
	
	
	
	//connection
	public void getInfoFromDBC() throws Exception
	{
		dbc.selectCustomer(this);
	}
	
	//connection and db 
	public PaymentMethod getInfoFromDBPM() throws Exception
	{
		payment = dbpm.selectPaymentMethod(this);
		return payment;
	}
	public void deleteInfoFromDBPM()
	{
		payment = dbpm.deletePaymentMethod(this);
	}
	
	public void addInfoToDBPM() throws Exception
	{
		dbpm.addPaymentMethod(this);
	}
}

