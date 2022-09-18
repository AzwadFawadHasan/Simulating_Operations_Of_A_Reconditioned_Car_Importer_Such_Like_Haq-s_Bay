/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import users.*;

/**
 *
 * @author hpflyernew
 */
public class LoginSceneController implements Initializable {
    
    private Dealer dd; private Manager mm; private Employee ee; private AdministrativeStaff aa;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private ComboBox<String> typeOfUserComboBox;
    
   private Customer cc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        typeOfUserComboBox.getItems().addAll("Customer","Dealer","Manager", "Administrative Staff", "Employee");
                
    }    
    
  public void initData(Customer cc){
      this.cc = cc;
  }
  
   public void initData(Dealer dd){
      this.dd = dd;
  }
public void initData(Manager mm){
      this.mm = mm;
  }
public void initData(AdministrativeStaff aa){
      this.aa = aa;
  }
public void initData(Employee  ee){
      this.ee = ee;
  }

   
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
       // label.setText("Hello World!");
            File f = null;
            FileInputStream  fis = null;
            ObjectInputStream ois= null;
            
         if(typeOfUserComboBox.getValue().equals("Customer"))
        {
            //Object Serialization is a process of converting an object into a series of bytes so that they can be written into a disk
            ArrayList<Customer> c = new ArrayList<Customer>();
           
            try {
                f = new File("CustomerObjects.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                
                    try{
                        while(true){
                            c.add((Customer)ois.readObject());
                            
                        }
                    }
                    catch(IOException | ClassNotFoundException e){
                        
                    }
                    
                    
                
            }
            catch(IOException ex){}
            finally{
                try{
                    if(ois!=null){ois.close();}
                }catch(IOException ex){}
            }
            for(Customer i:c){
                
                if(i.verifyUser(emailInput.getText(), passwordInput.getText() )){
                   FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(getClass().getResource("CustomerHomepage.fxml"));
                   Parent chp = loader.load();
                   
                   Scene CustomerHp = new Scene(chp);
                   CustomerHomepageController controller = loader.getController();
                   controller.initData(i);
                   
                   Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                   window.setScene(CustomerHp);
                   window.show();
                   break;
                   
            }
              else{
                    label.setText("Incorrect Email or Password! oooopsss");
                    
                }
                
            }
            
            
        }
         
        else if(typeOfUserComboBox.getValue().equals("Dealer"))
        {
            ArrayList<Dealer> d = new ArrayList<Dealer>();
            
            try{
                f = new File("DealerObjects.bin");
                fis = new FileInputStream(f);//A FileInputStream obtains input bytes from a file in a file system. What files are available depends on the host environment.
//FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
                ois = new ObjectInputStream(fis);
                
                try{
                    while(true){
                        d.add((Dealer)ois.readObject());
                    }
                }
                catch(IOException | ClassNotFoundException e){
                    
                }
                        
            }
            catch(IOException ex){
            }
            finally{
                try{
                    if(ois!=null){
                        ois.close();
                    }
                }
                catch(IOException ex){
                    
                }
            }
            for(Dealer i : d){
                if(i.verifyUser(emailInput.getText(), passwordInput.getText())){
                    System.out.println("Working");
                    FXMLLoader loader  = new FXMLLoader();
                    loader.setLocation(getClass().getResource("DealerHomepage.fxml"));
                    Parent dhp = loader.load();
                    Scene DealerHp = new Scene(dhp);
                    DealerHomepageController controller = loader.getController();
                    controller.initData(i);   
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(DealerHp);
                    window.show();
                    System.out.println("Working 2");
                    break;
                }
                else{
                     label.setText("Incorrect Email or Password! oooopsss");
                }
            }
                  
                       
            /*ArrayList<Dealer> d = new ArrayList<Dealer>(); 
            try{
               
                f = new File ("DealerObjects.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                //An ObjectInputStream deserializes primitive data and objects previously written using an ObjectOutputStream.
//ObjectOutputStream and ObjectInputStream can provide an application with persistent storage for graphs of objects when used with a FileOutputStream and FileInputStream respectively.
                
                try {
                    while(true){
                        d.add((Dealer)ois.readObject());
                      }
                    }catch(IOException | ClassNotFoundException e){
                    }
                
                }catch(IOException ex){}
                
                
            finally{
                try{
                    if(ois!=null){ois.close();}
                    
                    
                }catch(IOException ex){}
                
            }
              for(Dealer dd : d){     
                  
                  if(dd.verifyUser(emailInput.getText(), passwordInput.getText())){
                       FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(getClass().getResource("DealerHomepage.fxml"));
                   Parent dhp = loader.load();
                   
                   Scene CustomerHp = new Scene(dhp);
                   CustomerHomepageController controller = loader.getController();
                   controller.initData(dd);
                   
                   Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                   window.setScene(CustomerHp);
                   window.show();
                   break;
                  }
                  else{label.setText("Incorrect Email or Password! oooopsss");}
                  
              }
                   
                */
            
            
            }//end of else if getvalue().equals to (dealer);
         
        
        else if(typeOfUserComboBox.getValue().equals("Administrative Staff"))
        {
           ArrayList <AdministrativeStaff> a = new ArrayList<AdministrativeStaff>();
           
          
           
           try{
                f = new File("AdministrativeStaffObjects.bin");
                 fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
               
                try{
                    while(true){
                        a.add((AdministrativeStaff)ois.readObject());
                    }
                }
                catch(IOException| ClassNotFoundException ex){
                    
                }
           }catch(IOException ex){
               
           }finally{
               try{
                   if(ois!=null){ois.close();}
               }catch(IOException ex){}
               
           }
           for(AdministrativeStaff i :a){
               if(i.verifyUser(emailInput.getText(), passwordInput.getText())){
                   FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(getClass().getResource("AdministrativeStaffHomepage.fxml"));
                   Parent ahp = loader.load();
                   Scene AdministrativeStaffHp = new Scene (ahp);
                   AdministrativeStaffHomepageController controller = loader.getController();
                   Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
                   window.setScene(AdministrativeStaffHp);
                   window.show();
                   break;
                           
                   
                   
               }
               else{
                   label.setText("Incorrect Email or Password! oooopsss");
                   
               }
           }
           
           
            
        }
        
        
            
       
            
            
        
            
            
        else if(typeOfUserComboBox.getValue().equals("Employee"))
        {
            ArrayList <Employee> e = new ArrayList<Employee>();
            try {
                f = new File("EmployeeObjects.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                try{
                    while(true){
                        e.add((Employee)ois.readObject());
                    }
                }catch(IOException | ClassNotFoundException ex){
                            
                    }
            }catch(IOException ex){
            }
            finally{
                try{
                    if(ois!=null){ois.close();}
                }catch(IOException ex){
                    
                }
                }
            
            for(Employee i : e){
                
                if(i.verifyUser(emailInput.getText(), passwordInput.getText())){
                    FXMLLoader loader = new FXMLLoader ();
                    loader.setLocation(getClass().getResource("EmployeeHomepage.fxml"));
                    
                    Parent ehp = loader.load();
                    
                    Scene EmployeeHp = new Scene(ehp);
                    
                    EmployeeHomepageController controller = loader.getController ();
                    controller.initData(i);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(EmployeeHp);
                    window.show();
                    break;
                    
                }
                else{
                     label.setText("Incorrect Email or Password! oooopsss");
                }
                
            }
                
        }
         
        //getValue() The type of the value that has been selected or otherwise entered in to this ComboBox.
        else if (typeOfUserComboBox.getValue().equals("Manager")){
            
            ArrayList <Manager> m = new ArrayList<Manager>();
            
            try{
                f= new File ("ManagerObjects.bin");
                fis = new FileInputStream (f);//A FileInputStream obtains input bytes from a file in a file system. 
                ois = new ObjectInputStream(fis);
                
                try {
                    while(true){
                        m.add((Manager)ois.readObject());
                        
                    }
                    
                    
                }catch(IOException | ClassNotFoundException ex){
                    
                }
                
            }catch(IOException ex){
            }
            finally{
                try {
                    if (ois!=null){
                        ois.close();
                    }
                    
                }catch(IOException ex){}
            }
            
            for (Manager i : m ){
                
                if(i.verifyUser(emailInput.getText(), passwordInput.getText())){
                    
                    FXMLLoader loader = new FXMLLoader ();
                    loader.setLocation (getClass().getResource("ManagerHomepage.fxml"));
                    Parent mph = loader.load();
                    Scene ManagerHp =  new Scene (mph); 
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(ManagerHp);
                    window.show();
                    break;
                }
                else{
                    label.setText("Incorrect Email or Password! oooopsss");
                }
                
                
            }
            
        }
         
            
            
            
       }

    @FXML
    private void handleEmailInput(ActionEvent event) {
    }

    @FXML
    private void handlePasswordInput(ActionEvent event) {
    }

    @FXML
    private void handleTypeOfUserComboBox(ActionEvent event) {
    }
        
    }
    

