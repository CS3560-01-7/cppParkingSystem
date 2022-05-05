/*
Class name: Vehicle.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: The Vehicle class holds the attributes: licensePlate, vehicleType, vehicleMake, vehicleModel, vehicleColor, vehicleYear, Customer and Permit.
The Vehicle class' methods recieve and update user input in the database.
Vehicle calls Customer and Permit objects. 

We are assuming that these vehices exist and have a valid license plate.
*/
import java.io.*;
import java.util.*;

class Vehicle
{
  //attributes
  private String vin;//pk
  private String licensePlate;//pk
  private String vehicleType;
  private String vehicleMake;
  private String vehicleModel;
  private int modelYear;
  private String vehicleColor;
  
  //constructor
  public Vehicle(String vin, String lPlate, String vType, String vMake, String vModel, int mYear, String vColor, Customer customer)
  {
    this.vin = vin
    this.licensePlate = lPlate;
    this.vehicleType = vType;
    this.vehicleMake = vMake;
    this.vehicleModel = vModel;
    this.modelYear = mYear;
    this.vehicleColor = vColor;
    this.driver = customer;
    //create new entry in vehicle table for this customer and fill in the values
  }
  
  /**
  setVIN method stores a string in the vin field
  @param vID The value to store in vin
  */
  public void setVin(String vID)
  {
    this.vin = vID;
  }
  
  /**
  setLicensePlate method stores a string in the licensePlate field
  @param lp The value to store in licensePlate
  */
  public void setLicensePlate(String lp)
  {
    licensePlate = lp;
    //change license plate attribute in database
  }
  
  /**
  setVehicleType method stores a string in the vehicleType field
  @param vt The value to store in vehicleType 
  */
  public void setVehicleType(String vt)
  {
    vehicleType = vt;
  }
  
  /**
  setVehicleMake() method stores a string in the vehicleMake field
  @param vmak Value to store in vehicleMake
  */
  public void setVehicleMake(String vmak)
  {
    vehicleMake = vmak;
  }
  
  /**
  setVehicleModel method stores a string in the vehicleModel field
  @param vmod Value to store in vehicleModel
  */  
  public void setVehicleModel(String vmod)
  {
    vehicleModel = vmod;
  }
  
  public void setModelYear(int mYear)
  {
    modelYear = mYear;
  }
  
  /**
  setVehicleColor method stores a string in the vehicleColor field
  @param vc Value to store in vehicleColor
  */
  
  public void setVehicleColor(String vc)
  {
    vehicleColor = vc;
  }
  
  /**
  setDriver method stores a customer object in the driver field
  @param customer Value to store in driver
  */
  public void setDriver(Customer customer)
  {
    this.driver = customer;
  }
  
  /**
  setPermit method stores a Permit object in the permit field
  @param perm Value to store in permit
  */
  public void setPermit(Permit perm)
  {
    this.permit = perm;
  }
  
  //accessors
  /**
  getVIN method returns vin
  @return Value of vin field
  */
  public String getVIN()
  {
    return vin;
  }
  
  /**
  getLicensePlate method returns licensePlate
  @return Value of licensePlate field
  */
  public String getLicensePlate()
  {
    return licensePlate;
  }
  
  /**
  getVehicleType method returns vehicleType
  @return Value of vehicleType field
  */
  public String getVehicleType()
  {
    return vehicleType;
  }
  
   /**
  getVehicleMake method returns vehicleMake
  @return Value of vehicleMake field
  */
  public String getVehicleMake()
  {
    return vehicleMake;
  }
  
   /**
  getVehicleModel method returns vehicleModel
  @return Value of vehicleModel field
  */
  public String getVehicleModel()
  {
    return vehicleModel;
  }
  
  /**
  getModelYear method returns modelYear
  @return Value of modelYear field
  */
  public int getModelYear()
  {
    return modelYear;
  }
  
  /**
  getVehicleColor method returns vehicleColor
  @return Value of vehicleColor field
  */
  public String getVehicleColor()
  {
    return vehicleColor;
  }
  
  /**
  getDriver method returns driver
  @return Value of driver field
  */
  public Customer getDriver()
  {
    return driver;
  }
