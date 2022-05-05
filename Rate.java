/*
Class name: Rate.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: The Rate class holds the attributes: shortSemester, longSemester, studentRate, facultyRate and Permit.
The Rate class' methods set the price of the permit for students and faculty. They also check the status of the customer and decides the rate to offer.
Rate calls Permit objects

*/
package application;

public class Rate {
	 //attributes
    private int rateID;
    private int rate;
    private String rateDescription;
    private String validDate;
    private String expirationDate;
    private boolean studentcheck;
    RateDB rateDB = new RateDB();

    //constructor
    public Rate()
    {

    }

    //methods
    //mutators
    /**
     setRate method stores a value in the rate field
     @param r The value to store in rate
     */
    public void setRateID(int r)
    {
        this.rateID = r;
    }

    /**
     setRate method stores a value in the rate field
     @param r The value to store in rate
     */
    public void setRate(int r)
    {
        this.rate = r;
    }

    /**
     setDescription method stores description of rate
     @param d The value to store in longSemester
     */
    public void setRateDescription(String d)
    {
        this.rateDescription = d;
    }

    /**
     Faculty method checks status of the user and decides what rate to offer
     @return Boolean value
     */
    public void setStudent(boolean s)
    {
        this.studentcheck = s;
    }

    /**
     getRate method returns rate
     @return The value in the rate field
     */
    public int getRateID()
    {
        return this.rateID;
    }

    /**
     getRate method returns rate
     @return The value in the rate field
     */
    public int getRate()
    {
        return this.rate;
    }

    /**
     getFacultyRate method returns a facultyRate
     @return The value in the facultyRate field
     */
    public String getDescription()
    {
        return this.rateDescription;
    }


    public String getValidDate() {
        return validDate;
    }


    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     Faculty method checks status of the user and decides what rate to offer
     @return Boolean value
     */
    public boolean getStudent()
    {
        return this.studentcheck;
    }
    //check if user entered Student or Faculty as their campus status.
    //If faculty, return true. If student, return false.
}
