/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.io.DataOutputStream;
import java.io.File;
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
import users.Manager;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class MakeEmployeeTrainingProgramController implements Initializable {

    private Manager mmm;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    public void initData(Manager mmm){this.mmm=mmm;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePostIt(ActionEvent event) {
         File f = null;
        FileOutputStream fos = null;
        //BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("TrainingProgramObjects.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            //bos = new BufferedOutputStream(fos);
            //dos = new DataOutputStream(bos);
            dos = new DataOutputStream(fos);
            
            //dos.writeInt(Integer.parseInt(idTextField.getText()));
            dos.writeUTF(textField.getText());
             //dos.writeUTF(details.getText());
            //dos.writeUTF(desigTextField.getText());
            //dos.writeFloat(Float.parseFloat(salaryTextField.getText()));
            textField.setText("");
        } catch (IOException ex) {
            Logger.getLogger(MakeEmployeeTrainingProgramController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(MakeEmployeeTrainingProgramController.class.getName()).log(Level.SEVERE, null, ex);
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
        controller.initData(mmm);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ManagerHomepageScene);
        window.show();
    }
    
}
