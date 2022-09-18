/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

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
import users.Manager;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class ManagerHomepageController implements Initializable {

       private Manager m ;
       
     public void initData(Manager i){
         m = i;
     }
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
        
        loader.setLocation(getClass().getResource("LoginSceneFXML.fxml"));
        Parent loginscene = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene LoginScene = new Scene(loginscene);

        LoginSceneController controller = loader.getController();
        controller.initData(m);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(LoginScene);
        window.show();
        
    }

    @FXML
    private void handleDeliveryTask(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("ManagerAssignDeliveryTaskToEmployee.fxml"));
        Parent ManagerAssignDeliveryTaskToEmployee = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene ManagerAssignDeliveryTaskToEmployeeScene = new Scene(ManagerAssignDeliveryTaskToEmployee);

        ManagerAssignDeliveryTaskToEmployeeController controller = loader.getController();
        controller.initData(m);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ManagerAssignDeliveryTaskToEmployeeScene);
        window.show();
        
    }

    @FXML
    private void handleNotification(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("ManagerCheckNotification.fxml"));
        Parent ManagerCheckNotification = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene ManagerCheckNotificationScene = new Scene(ManagerCheckNotification);

        ManagerCheckNotificationController controller = loader.getController();
        controller.initData(m);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ManagerCheckNotificationScene);
        window.show();
    }

    @FXML
    private void handleEmployeeTrainingProgram(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("MakeEmployeeTrainingProgram.fxml"));
        Parent MakeEmployeeTrainingProgram = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene MakeEmployeeTrainingProgramScene = new Scene(MakeEmployeeTrainingProgram);

        MakeEmployeeTrainingProgramController controller = loader.getController();
        controller.initData(m);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(MakeEmployeeTrainingProgramScene);
        window.show();
    }
    
}
