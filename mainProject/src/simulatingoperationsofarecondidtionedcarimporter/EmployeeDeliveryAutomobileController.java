/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.stage.Stage;
import users.Employee;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class EmployeeDeliveryAutomobileController implements Initializable {
private Employee eee;
public void initData(Employee eee){this.eee=eee;}
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLoad(ActionEvent event) {
          File f = null;
        FileInputStream fis = null;
        //BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("ManagerAssignDeliveryTask.bin");
            if(!f.exists()){
                //textareafxid.setText("Oops! ManagerAssignDeliveryTask.bin binary file does not exist...");
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
            textArea.setText(str);
            Logger.getLogger(ManagerAssignDeliveryTaskToEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ManagerAssignDeliveryTaskToEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    @FXML
   private void handleBackButton(ActionEvent event) throws IOException {
         
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("EmployeeHomepage.fxml"));
        Parent EmployeeHomepage = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene EmployeeHomepageScene = new Scene(EmployeeHomepage);

        EmployeeHomepageController controller = loader.getController();
       controller.initData(eee);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(EmployeeHomepageScene);
        window.show();
    }

    
}
