/*
Class name: Permit.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: The permit class holds the atributes: permitNumber, permitType, permitRate, Vehicle and Rate.
The Permit class' methods receive information from user input about what permitType they want to buy.
Then system decides what kind of permitRate should system apply for this particular customer.
Last, the system will create/generate a permitNumber for customer.

Permit calls Rate object and get calld by Vehicle's object

Check list:
basics completed
*/

package application;

public class Permit extends Rate {

    private int permitNumber;
    String vin;
    protected PermitDB pdb = new PermitDB();

    public Permit() {
        super();
        permitNumber = 0;
        vin = "";
    }

    public Permit(int permitNumber, String vin) {
        super();
        this.permitNumber = permitNumber;
        this.vin = vin;
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

    public String getVIN()
    {
        System.out.println(vin + "This is in permit");
        return vin;

    }
    public void setVIN(String v) throws Exception
    {
        vin = v;
        this.addPermit();

    }

    public void addPermit() throws Exception{
        PermitDB.addPermit(this);
    }


}
