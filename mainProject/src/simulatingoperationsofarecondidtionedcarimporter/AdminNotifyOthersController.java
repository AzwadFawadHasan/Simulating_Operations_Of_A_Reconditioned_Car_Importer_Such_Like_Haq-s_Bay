/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import users.AdministrativeStaff;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class AdminNotifyOthersController implements Initializable {
    
    private AdministrativeStaff aaa;
    @FXML
    private TextField subject;
    @FXML
    private TextField details;
    @FXML
    private TextArea textarea;
    
    public void  initData(AdministrativeStaff aaa){this.aaa=aaa;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSendNotification(ActionEvent event) {
        
        File f = null;
        FileOutputStream fos = null;
        //BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("NotificationObjects.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            
            //dos.writeInt(Integer.parseInt(idTextField.getText()));
            dos.writeUTF(subject.getText());
             dos.writeUTF(details.getText());
            //dos.writeUTF(desigTextField.getText());
            //dos.writeFloat(Float.parseFloat(salaryTextField.getText()));

        } catch (IOException ex) {
            Logger.getLogger(AdminNotifyOthersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(AdminNotifyOthersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
       
       
       
       
       
       
    }

    @FXML
    private void handleload(ActionEvent event) {
        
        subject.setText("");
        details.setText("");
        File f = null;
        FileInputStream fis = null;
        //BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("NotificationObjects.bin");
            if(!f.exists()){
               System.out.println("Oops! NotificationObjects.bin binary file does not exist...");
            }
            else{
                
                fis = new FileInputStream(f);
                //bis = new BufferedInputStream(fis);
                //dis = new DataInputStream(bis);
                dis = new DataInputStream(fis);
                //String str="";
                while(true){
                    str+= "Subject: "+ dis.readUTF()+"\n"+
                          "Details: "+ dis.readUTF()+
                      
                        //+"; Designation:"+dis.readUTF()
                        //+"; Salary:"+Float.toString(dis.readFloat())+"\n";
                        "\n\n";
                        
                    //outputTextArea.setText(str);
                }//while
                //outputTextArea.setText(str);
            }//else
        } catch (IOException ex) {
            textarea.setText(str);
            Logger.getLogger(AdminNotifyOthersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(AdminNotifyOthersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("AdministrativeStaffHomepage.fxml"));
        Parent AdministrativeStaffHomepage = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene AdministrativeStaffHomepageScene = new Scene(AdministrativeStaffHomepage);

        AdministrativeStaffHomepageController controller = loader.getController();
       controller.initData(aaa);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdministrativeStaffHomepageScene);
        window.show();
    }
    
}
