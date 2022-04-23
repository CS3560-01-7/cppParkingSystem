package parkingProgram.java;

public class Rate {
	//attributes
	public int studentRate;
	public int facultyRate;
	
	//constructor
	public Rate (int studentRate, int facultyRate)
	{
		this.studentRate = studentRate;
		this.facultyRate = facultyRate;
	}

	public int getStudentRate()
	{
		return studentRate;
	}
	
	public void setStudentRate (int sr)
	{
		sr = 150;
		studentRate = sr;
	}
	
	public int getFacultyRate ()
	{
		return facultyRate;
	}
	
	public void setFacultyRate(int fr)
	{
		fr = 100;
		facultyRate = fr;
	}
}
