/*
Class name: Rate.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: The purpose of rate.java is to set the price of the permit for students and faculty. It also checks the status of the customer and decides the rate to offer.
*/

class Rate
{
//attributes
  private int studentRate;
  private int facultyRate;
  private String shortSemester;
  private tring longSemester;
  private boolean faculty;
  
  //constructor
  public Rate()
  {
  }
  
  //methods
  //mutators
  /**
  setStudentRate() method stores a value in the studentRate field
  @param sr The value to store in studentRate
  */
  public void setStudentRate(int sr)
  {
    studentRate = sr;
  }
  
  /**
  setFacultyRate() method stores a value in the facultyRate field
  @param fr The value to store in facultyRate
  */
  public void setFacultyRate(int fr)
  {
    facultyRate = fr;
  }
  
  /**
  setLongSemester() method stores a value in the longSemester field
  @param ls The value to store in longSemester
  */
  public void setLongSemester(String ls)
  {
    longSemester = ls;
  }
  
  /**
  setShortSemester() method stores a value in the shortSemester field
  @param ss The value to store in shortSemester
  */
  public void setShortSemester(String ss)
  {
    shortSemester = ss;
  }
  
    /**
  getStudentRate() method returns a studentRate
  @return The value in the studentRate field
  */
  public int getStudentRate()
  {
    return studentRate;
  }
  
  /**
  getFacultyRate() method returns a facultyRate
  @return The value in the facultyRate field
  */
  public int getFacultyRate()
  {
    return facultyRate;
  }
  
  /**
  getLongSemester() method returns longSemester
  @return The value in the longSemester field
  */
  public String getLongSemester()
  {
    return longSemester;
  }
  
  /**
   getShortSemester() method returns shortSemester
  @return The value in the shortSemester field
  */
  public String getShortSemester()
  {
    return shortSemester;
  }
  
  /**
  Faculty() method checks status of the user and decides what rate to offer
  @return Boolean value
  */
  public boolean Faculty() (String userInput)
  //check if user entered Student or Faculty as their campus status. 
  //If faculty, return true. If student, return false.
  
}  
