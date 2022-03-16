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
  private String vehicleColor;
  
  
  //constructor
  public Vehicle()
  {
  }
  
  //@param lp The value to store in licensePlate
  //setLicensePlate() method stores a string in the licensePlate field
    
  public void setLicensePlate(String lp)
  {
    licensePlate = lp;
  }
  
  //@param vt The value to store in vehicleType
  //setVehicleType() method stores a string in the vehicleType field
  
  public void setVehicleType(String vt)
  {
    vehicleType = vt;
  }
  
  //@param vmak Value to store in vehicleMake
  //setVehicleMake() method stores a string in the vehicleMake field
  
  public void setVehicleMake(String vmak)
  {
    vehicleMake = vmak;
  }
  
  //@param vmod Value to store in vehicleModel
  //setVehicleModel() method stores a string in the vehicleModel field
  
  public void setVehicleModel(String vmod)
  {
    vehicleModel = vmod;
  }
  
  //@param vc Value to store in vehicleColor
  //setVehicleColor() method stores a string in the vehicleColor field
  
  public void setVehicleColor(String vc)
  {
    vehicleColor = vc;
  }
  
  //accessors
  /**
  getLicensePlate() method returns licensePlate
  @return Value of licensePlate field
  */
  public String getLicensePlate()
  {
    return licensePlate:
  }
  
  /**
  getVehicleType() method returns vehicleType
  @return Value of vehicleType field
  */
  public String getVehicleType()
  {
    return vehicleType;
  }
  
   /**
  getVehicleMake() method returns vehicleMake
  @return Value of vehicleMake field
  */
  public String getVehicleMake()
  {
    return vehicleMake;
  }
  
   /**
  getVehicleModel() method returns vehicleModel
  @return Value of vehicleModel field
  */
  public String getVehicleModel()
  {
    return vehicleModel;
  }
  
   /**
  getVehicleColor() method returns vehicleColor
  @return Value of vehicleColor field
  */
  public String getVehicleColor()
  {
    return vehicleColor;
  }
  
  
  
}
