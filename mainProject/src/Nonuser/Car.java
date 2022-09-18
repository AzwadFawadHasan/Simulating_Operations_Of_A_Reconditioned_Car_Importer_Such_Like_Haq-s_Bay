/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nonuser;

import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author hpflyernew
 */
public class Car implements Serializable {
    
    private int carRegistrationId;
    private String carRegNo;
    public int getCarRegistrationId() {
        return carRegistrationId;
    }

    public void setCarRegistrationId(int carRegistrationId) {
        this.carRegistrationId = carRegistrationId;
    }
    private String carMake, carModel, carColor, carPrice, carEngineCc;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarEngineCc() {
        return carEngineCc;
    }

    public void setCarEngineCc(String carEngineCc) {
        this.carEngineCc = carEngineCc;
    }

   
    
    /*public Car (String carMake, String carModel,  String carColor, String carPrice,String carEngineCc){
         this.carMake =  carMake;
         this.carColor= carColor;
         this.carEngineCc= carEngineCc;
         this.carPrice=carPrice;
         this.carModel=carModel;
    }*/
    
    /*public Car (int carRegistrationId,String carMake, String carModel,  String carColor, String carPrice,String carEngineCc){
         this.carMake =  carMake;
         this.carRegistrationId=carRegistrationId;
         this.carColor= carColor;
         this.carEngineCc= carEngineCc;
         this.carPrice=carPrice;
         this.carModel=carModel;
    }*/
    
     public Car (String carMake, String carModel,  String carColor,String carEngineCc, String carRegNo ,String carPrice ){
         this.carMake =  carMake;
         this.carModel=carModel;
          this.carColor= carColor;
          this.carEngineCc= carEngineCc;
         this.carRegNo = carRegNo;
         this.carPrice=carPrice;
    }
    
}
