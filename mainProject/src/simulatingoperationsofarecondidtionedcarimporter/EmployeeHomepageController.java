/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

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
import javafx.stage.Stage;
import users.Employee;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class EmployeeHomepageController implements Initializable {
    private Employee  eee;
    public void initData(Employee eee){
        this.eee= eee;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleChecknotificationfromadministration(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("EmployeeCheckForTraining.fxml"));
        Parent EmployeeCheckForTraining = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene EmployeeCheckForTrainingScene = new Scene(EmployeeCheckForTraining);

        EmployeeCheckForTrainingController controller = loader.getController();
       controller.initData(eee);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(EmployeeCheckForTrainingScene);
        window.show();
    }

    @FXML
    private void HandleCheckForupcomingTrainingEvents(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("EmployeeTraining.fxml"));
        Parent EmployeeTraining = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene EmployeeTrainingScene = new Scene(EmployeeTraining);

        EmployeeTrainingController controller = loader.getController();
       controller.initData(eee);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(EmployeeTrainingScene);
        window.show();
    }

    @FXML
    private void handleDeliveryAutomobileToClient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("EmployeeDeliveryAutomobile.fxml"));
        Parent EmployeeDeliveryAutomobile = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene EmployeeDeliveryAutomobileScene = new Scene(EmployeeDeliveryAutomobile);

     EmployeeDeliveryAutomobileController controller = loader.getController();
       controller.initData(eee);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(EmployeeDeliveryAutomobileScene);
        window.show();
    }
    
}
