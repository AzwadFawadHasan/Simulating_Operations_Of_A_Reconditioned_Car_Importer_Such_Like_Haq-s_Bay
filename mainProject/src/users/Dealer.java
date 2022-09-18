/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import Nonuser.Car;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import simulatingoperationsofarecondidtionedcarimporter.AppendableObjectOutputStream;
/**
 *
 * @author hpflyernew
 */
public class Dealer extends User implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
    private String address;
    private String phoneNo;
    
    private String passportNo;
   
    
    
    public Dealer(){}
    
    public Dealer(String email,String password, String address, String phoneNo,String name,String passportNo){
        
        super(email, password);//The super keyword refers to superclass (parent) objects.
//The syntax for calling a superclass constructor is super(parameter list);
//It is used to call superclass methods, and to access the superclass constructor.
        
        this.name = name;
        this.address = address;
        this. phoneNo=  phoneNo;
        
        
        
    }
    
 /* 
public Car addCar(int CarRegistrationId, String carMake, String carModel,  String carColor, String carPrice,String carEngineCc) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        ArrayList<Car> clist = new ArrayList<Car>();
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        
      try {
            f = new File("CarObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            try{
                while(true){
                    clist.add((Car)ois.readObject());
                }
            }
            catch(IOException | ClassNotFoundException e){
                //Logger.getLogger(ScheduleappointmentsceneController.class.getName()).log(Level.SEVERE, null, e);
            }          
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) {
                //Logger.getLogger(ScheduleappointmentsceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    //getCarRegistrationId
    
    
        
        Car c;
        if(!clist.isEmpty()){
            c = new Car(clist.get(clist.size()-1).getCarRegistrationId(), carMake,carModel,  carColor,  carPrice, carEngineCc);
        }
        else{
            c = new Car(1, carMake, carModel,  carColor,  carPrice, carEngineCc);
        }
        
        try {
            f = new File("CarObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
                
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(PostVehicleListingForSaleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PostVehicleListingForSaleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return c;
    }*/
//add  car ends 
    
    

  
    
    
}
