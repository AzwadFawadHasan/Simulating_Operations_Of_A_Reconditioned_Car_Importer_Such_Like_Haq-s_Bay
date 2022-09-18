/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import users.Manager;
import Nonuser.Car;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import users.Customer;
import users.Dealer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import users.Manager;
/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class ManagerAssignDeliveryTaskToEmployeeController implements Initializable {

    private Manager m;
    @FXML
    private TextField CustomerNamefxid;
    @FXML
    private TextField CustomerPhoneNumberfxid;
    @FXML
    private TextField CustomerCustomerAddressfxid;
    @FXML
    private TextField carregistrationnumberfxid;
    @FXML
    private TextField cardetailsfxid;
    @FXML
    private TextArea textareafxid;

    public void initData(Manager m){
        this.m = m;
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/*
File f = null;
        FileOutputStream fos = null;
        //BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Emp.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            
            dos.writeInt(Integer.parseInt(idTextField.getText()));
            dos.writeUTF(nameTextField.getText());
            dos.writeUTF(desigTextField.getText());
            dos.writeFloat(Float.parseFloat(salaryTextField.getText()));

        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
*/
    @FXML 
    private void handlePostIt(ActionEvent event) {
        
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("ManagerAssignDeliveryTask.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            dos.writeUTF(CustomerNamefxid.getText());
            dos.writeUTF(CustomerPhoneNumberfxid.getText());
            dos.writeUTF(CustomerCustomerAddressfxid.getText());
            dos.writeUTF(carregistrationnumberfxid.getText());
            dos.writeUTF(cardetailsfxid.getText());
                    
            //dos.writeInt(Integer.parseInt(idTextField.getText()));
            //dos.writeUTF(nameTextField.getText());
            //dos.writeUTF(desigTextField.getText());
            //dos.writeFloat(Float.parseFloat(salaryTextField.getText()));

        }  catch (IOException ex) {
            Logger.getLogger(ManagerAssignDeliveryTaskToEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerAssignDeliveryTaskToEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }        
        
    }
    }

    @FXML
      
    private void handleBackButton(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("ManagerHomepage.fxml"));
        Parent ManagerHomepage = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene ManagerHomepageScene = new Scene(ManagerHomepage);

        ManagerHomepageController controller = loader.getController();
        controller.initData(m);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ManagerHomepageScene);
        window.show();
        
    }

    @FXML
    private void handelseewhatyouposted(ActionEvent event) {
        textareafxid.setText("");
        File f = null;
        FileInputStream fis = null;
        //BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("ManagerAssignDeliveryTask.bin");
            if(!f.exists()){
                textareafxid.setText("Oops! ManagerAssignDeliveryTask.bin binary file does not exist...");
            }
            else{
                
                fis = new FileInputStream(f);
                //bis = new BufferedInputStream(fis);
                //dis = new DataInputStream(bis);
                dis = new DataInputStream(fis);
                //String str="";
                while(true){
                  
                    str+= "Customer Name:"+dis.readUTF()+";   "
                        + "Customer Phone Number:"+dis.readUTF()+";   "
                        + "Customer Address:"+dis.readUTF()+ ";   "
                            + "Car Registration Number:"+dis.readUTF()+";   "
                            + "Car Details:"+dis.readUTF()+";   "
                            //+ "Customer Address:"+dis.readUTF()+";   "
                        +"\n\n";
                    //outputTextArea.setText(str);
                }//while
                //outputTextArea.setText(str);
            }//else
        } catch (IOException ex) {
            textareafxid.setText(str);
            Logger.getLogger(ManagerAssignDeliveryTaskToEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerAssignDeliveryTaskToEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
                
    }
    
}
