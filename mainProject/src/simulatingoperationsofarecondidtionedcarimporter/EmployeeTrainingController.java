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
public class EmployeeTrainingController implements Initializable {
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

    @FXML
    private void handleLoad(ActionEvent event) {
        
         File f = null;
        FileInputStream fis = null;
        //BufferedInputStream bis = null;
        DataInputStream dis = null;
        String str="";
        try {
            f = new File("TrainingProgramObjects.bin");
            if(!f.exists()){
               System.out.println("Oops! TrainingProgramObjects.bin binary file does not exist...");
            }
            else{
                
                fis = new FileInputStream(f);
                //bis = new BufferedInputStream(fis);
                //dis = new DataInputStream(bis);
                dis = new DataInputStream(fis);
                //String str="";
                while(true){
                    str+= "Training Program Details: "+ dis.readUTF()+"\n";
                         
                      
                        //+"; Designation:"+dis.readUTF()
                        //+"; Salary:"+Float.toString(dis.readFloat())+"\n";
                       // "\n\n";
                        
                    //outputTextArea.setText(str);
                }//while
                //outputTextArea.setText(str);
            }//else
        } catch (IOException ex) {
            textArea.setText(str);
            Logger.getLogger(EmployeeTrainingController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeTrainingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
}
