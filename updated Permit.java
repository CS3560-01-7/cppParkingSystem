package parkingProgram.java;

public class Permit extends Rate {
	
	private int permitNumber;
	private String studentPermit = "Student Permit";
	private String facultyPermit = "Faculty Permit";
	private int vin;
	private int rate;
	private boolean studentStatus;
	
	public Permit(int studentRate, int facultyRate, int permitNumber, String student, String faculty, int vin, int rate, boolean studentStatus) {
		super(studentRate, facultyRate);
		permitNumber = 0;
		studentPermit = student;
		facultyPermit = faculty;
		vin = 0;
		rate = 0;
		studentStatus = true;
		
	}

	public int getPermitNumber()
	{
		return permitNumber;
	}
	public void setPermitNumber (int pn)
	{
		pn = permitNumber + 1;
		permitNumber = pn;
	}
	
	public boolean getStudentStatus()
	{
		return studentStatus;
	}
	
	public int getVIN()
	{
		return vin;
	}
	
	public int getRate()
	{
		return rate;
	}
	
	public void setRate()
	{
		if (studentStatus = true) {
			rate = super.studentRate;
		} else {
			rate = super.facultyRate;
		}
	}
	
	{
	
	if (studentStatus = true) {
		System.out.println(studentPermit);
		System.out.println(super.studentRate);
		
	} else {
		System.out.println(facultyPermit);
		System.out.println(super.facultyRate);
	}
	
	
		
	}
	
}
