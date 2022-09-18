/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import users.AdministrativeStaff;
import users.Customer;
import users.Dealer;
import users.Employee;
import users.Manager;

/**
 *
 * @author hpflyernew
 */
public class SimulatingOperationsOfARecondidtionedCarImporter extends Application {
    
    
    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginSceneFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    

    
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("CustomerObjects.bin");
            if(!f.exists()){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);  
                //String email,String password, String address, String phoneNo,String name,String tinNumber, String nidNo
                Customer c1 = new Customer("customer@email.com","password","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(c1);
                Customer c2 = new Customer("1234@gmail.com","1234","Dhanmondi", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(c2);
                Customer c3 = new Customer("mrjones@email.com","mypass","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(c3);
            }

        } catch (IOException ex) {
            Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) {oos.close();}
            } catch (IOException ex) {
                Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
        /// For Dealer
        
        try {
            f = new File("DealerObjects.bin");
            if(!f.exists()){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);  
                //String email,String password, String address, String phoneNo,String name,String tinNumber, String nidNo
                Dealer d1 = new Dealer("dealer@email.com","password","Mirpur", "0171123124", "Mr. Jones", "888888888");
                oos.writeObject(d1);
                Dealer d2 = new Dealer("1234@gmail.com","1234","Dhanmondi", "0171123124", "Mr. Jones", "888888888");
                oos.writeObject(d2);
                Dealer d3 = new Dealer("mrjones@email.com","mypass","Mirpur", "0171123124", "Mr. Jones", "888888888");
                oos.writeObject(d3);
            }

        } catch (IOException ex) {
            Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) {oos.close();}
            } catch (IOException ex) {
                Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //For AdministrativeStaff
        try {
            f = new File("AdministrativeStaffObjects.bin");
            if(!f.exists()){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);  
                //String email,String password, String address, String phoneNo,String name,String tinNumber, String nidNo
                AdministrativeStaff a1 = new AdministrativeStaff("administrativestaff@email.com","password","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(a1);
                AdministrativeStaff a2 = new AdministrativeStaff("1234@gmail.com","1234","Dhanmondi", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(a2);
                AdministrativeStaff a3 = new AdministrativeStaff("mrjones@email.com","mypass","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(a3);
            }

        } catch (IOException ex) {
            Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) {oos.close();}
            } catch (IOException ex) {
                Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //for manager
        try {
            f = new File("ManagerObjects.bin");
            if(!f.exists()){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);  
                //String email,String password, String address, String phoneNo,String name,String tinNumber, String nidNo
                Manager m1 = new Manager("manager@email.com","password","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(m1);
                Manager m2 = new Manager("1234@gmail.com","1234","Dhanmondi", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(m2);
                Manager m3 = new Manager("mrjones@email.com","mypass","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(m3);
            }

        } catch (IOException ex) {
            Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) {oos.close();}
            } catch (IOException ex) {
                Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //employee
        try {
            f = new File("EmployeeObjects.bin");
            if(!f.exists()){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);  
                //String email,String password, String address, String phoneNo,String name,String tinNumber, String nidNo
                Employee e1 = new Employee("employee@email.com","password","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(e1);
                Employee e2 = new Employee("1234@gmail.com","1234","Dhanmondi", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(e2);
                Employee e3 = new Employee("mrjones@email.com","mypass","Mirpur", "0171123124", "Mr. Jones", "888888888", "99999999");
                oos.writeObject(e3);
            }

        } catch (IOException ex) {
            Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) {oos.close();}
            } catch (IOException ex) {
                Logger.getLogger(SimulatingOperationsOfARecondidtionedCarImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    
   public static void main(String[] args) {
        launch(args);
    } 

}