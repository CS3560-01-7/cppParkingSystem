package application;

public class Rate {
    //attributes
    private int rateID;
    private int rate;
    private String description;
    private boolean studentcheck;
    private String validDate;
    private String expirationDate;
    RateDB db = new RateDB();

    //constructor
    public Rate()
    {
        rateID=0;
    }

    //methods
    //mutators
    /**
     setRate method stores a value in the rate field
     @param r The value to store in rate
     */
    public void setRateID(int r) throws Exception
    {
        this.rateID = r;
        //this.selectRate();
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
    public void setDescription(String d)
    {
        this.description = d;
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
    public Integer getRateID()
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
        return this.description;
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

    public void selectRate() throws Exception{
        db.selectRate(this);
    }


}
