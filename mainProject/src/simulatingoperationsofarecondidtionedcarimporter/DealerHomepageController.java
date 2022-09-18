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
import javafx.stage.Stage;
import users.Dealer;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class DealerHomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Car car;
    private Dealer d;
    @FXML
    private Button postVehicleListingsForSaleFxid;
    @FXML
    private Button provideDiscountsAndPromotionalOffersMaintenanceServicesFxid;
    @FXML
    private Button uploadVehicleHistoryReportsAndOtherDocumentsfxml;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void initData(Dealer i){
        d=i;
    }


    @FXML
    private void handlePostVehicleListiingFxid  (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("PostCarFXML.fxml"));
        Parent PostCarFXML = loader.load();
        
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene pvfs= new Scene(PostCarFXML);

        PostCarFXMLController controller = loader.getController();
        controller.initData(d);
       

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(pvfs);
        window.show();
        
    }


    @FXML
    private void handleProvideDiscountsAndPromotionalOffersMaintenanceServicesFxid(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PostProvideDiscounts.fxml"));
        Parent PostProvideDiscounts = loader.load();
        Scene ppd = new Scene(PostProvideDiscounts);
        PostProvideDiscountsController controller = loader.getController();
        controller.initData(d);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ppd);
        window.show();
        //ontroller.initData(d);1
                
        //Stage window = (Stage)((Node)event.getSource().getS)
        
        
    }


    @FXML
    private void handleUploadVehicleHistoryReportsAndOtherDocumentsfxml(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("PostVehicleHistoryDetails.fxml"));
        Parent PostVehicleHistoryDetails = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene PostVehicleHistoryDetailsScene = new Scene(PostVehicleHistoryDetails);

       PostVehicleHistoryDetailsController controller = loader.getController();
        controller.initData(d);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(PostVehicleHistoryDetailsScene);
        window.show();
        
        
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("LoginSceneFXML.fxml"));
        Parent loginscene = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene LoginScene = new Scene(loginscene);

        LoginSceneController controller = loader.getController();
        controller.initData(d);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(LoginScene);
        window.show();
    }

   

    @FXML
    private void handlepostparts(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("PostPartsFXML.fxml"));
        Parent PostPartsFXML = loader.load();
        
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene PostPartsFXMLScene= new Scene(PostPartsFXML);

        PostPartsFXMLController controller = loader.getController();
        //controller.initData(d);
       

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(PostPartsFXMLScene);
        window.show();
        
    }
    
}
