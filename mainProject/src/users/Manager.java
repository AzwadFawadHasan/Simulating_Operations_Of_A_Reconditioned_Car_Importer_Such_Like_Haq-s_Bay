/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
/**
 *
 * @author hpflyernew
 */
public class Manager extends User implements Serializable{
    private String name;
    private String address;
    private String phoneNo;
    
    private String tinNumber;
    private String nidNo;

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

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getNidNo() {
        return nidNo;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nidNo;
    }
    
   
    
    public Manager(){}
    
    public Manager(String email,String password, String address, String phoneNo,String name,String tinNumber, String nidNo){
        
        super(email, password);//The super keyword refers to superclass (parent) objects.
//The syntax for calling a superclass constructor is super(parameter list);
//It is used to call superclass methods, and to access the superclass constructor.
        
        this.name = name;
        this.address = address;
        this. phoneNo=  phoneNo;
        this.tinNumber = tinNumber;
        this.nidNo = nidNo;
      
        
    }
    
   

}
