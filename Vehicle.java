/*
Class name: Vehicle.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: 
*/
import javax.swing.*;
import java.io.*;
import java.util.*;

class Vehicle
{
  //attributes
  private String licensePlate;//pk
  private String vehicleType;
  private String vehicleMake;
  private String vehicleModel;
  private int modelYear;
  private String vehicleColor;
  
  
  //constructor
  public Vehicle(String lPlate, String vType, String vMake, String vModel, int mYear, String vColor)
  {
    //set to default values
  }
  
  /**
  setLicensePlate method stores a string in the licensePlate field
  @param lp The value to store in licensePlate
  */
  public void setLicensePlate(String lp)
  {
    licensePlate = lp;
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
  
  //accessors
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
}
