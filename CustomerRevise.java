/*
still need to implement an array or arraylist of Vehicles 
add vehicle method
read vehicle (owned) method

in here call PaymentMethod to be read from DB.... 
*/
public class CustomerRevise {
	private int broncoID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String address;
	private int vehicleCount;
	private boolean student;
	private Vehicle vehicle;
	private PaymentMethod payment;
	private CustomerDB db = new CustomerDB();

	//constructor
	Customer()
	{
		broncoID=0;
		firstName = "";
		lastName = "";
		emailAddress = "";
		address = "";
		vehicleCount = 0;
		vehicle = new Vehicle();
		payment = new PaymentMethod();
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
		
	//connection
	/**
	purpose: calls database to fill information about this Customer
	*/
	public void getInfoFromDB() throws Exception
	{
		db.selectCustomer(this);
	}
}
