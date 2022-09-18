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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class ApplyForServicingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Customer ccc;
    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio2;
    @FXML
    private Label label;
    @FXML
    private ToggleGroup toggleGroup;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void initData(Customer customerdata) {
        ccc= customerdata;
       
    }

    @FXML
     
    private void handleBackButton(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("CustomerHomepage.fxml"));
        Parent CustomerHomepage = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene CustomerHomepageScene = new Scene(CustomerHomepage);

        CustomerHomepageController controller = loader.getController();
       controller.initData(ccc);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerHomepageScene);
        window.show();
    }
    
    @FXML
    private void handleClickHere(ActionEvent event)  throws IOException{
        
       if( radio1.isSelected()){
        
        
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("ApplyForServicingTwo.fxml"));
        Parent ApplyForServicingTwo = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene ApplyForServicingTwoScene = new Scene(ApplyForServicingTwo);

        ApplyForServicingTwoController controller = loader.getController();
       //controller.initData(ccc);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ApplyForServicingTwoScene);
        window.show();


       }
       else if (radio2.isSelected()){
           label.setText("Sorry can't be applied at the moment");
       }
    }
    
}
