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


/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class CustomerHomepageController implements Initializable {
    private Dealer d;
    private Car car;
    private Customer c;
    @FXML
    private Button bookForServicingfxid;
    @FXML
    private Button applyForInsuranceFxid;
    @FXML
    private Button buysparepartsandaccessoriesFxid;
    @FXML
    private Button SearchLoadVehiclesFxid;
    public void initData(Customer i){
       c = i;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handlebookForServicingfxid(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("ApplyForServicing.fxml"));
        Parent applyforservicing = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene applyforservicingScene = new Scene(applyforservicing);

        ApplyForServicingController controller = loader.getController();
        controller.initData(c);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(applyforservicingScene);
        window.show();
        
        
    }

    @FXML
    private void handleapplyForInsuranceFxid(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("CustomerApplyForInsurance.fxml"));
        Parent CustomerApplyForInsurance = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene CustomerApplyForInsuranceScene = new Scene(CustomerApplyForInsurance);

        CustomerApplyForInsuranceController controller = loader.getController();
        controller.initData(c);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerApplyForInsuranceScene);
        window.show();
    }

    @FXML
    private void handlebuysparepartsandaccessoriesFxid(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("CustomerBuyParts.fxml"));
        Parent CustomerBuyParts = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene CustomerBuyPartsScene = new Scene(CustomerBuyParts);

        CustomerBuyPartsController controller = loader.getController();
        controller.initData(c);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(CustomerBuyPartsScene);
        window.show();
    }

    @FXML
    private void handleSearchLoadVehiclesFxid(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoadVehicles.fxml"));
        Parent loadVehicles = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene loadVehiclesScene = new Scene(loadVehicles);

        LoadVehiclesController controller = loader.getController();
        controller.initData(car, d);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loadVehiclesScene);
        window.show();
        
        
        
    }

    @FXML
    private void handleCheckPromoCodes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CheckPromoCodes.fxml"));
        Parent cpc = loader.load();
        
        Scene CheckPromoCodesScene = new Scene(cpc);
        
        CheckPromoCodesController controller = loader.getController();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(CheckPromoCodesScene);
        window.show();
        
       // controller.initData()
        
        
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
        controller.initData(c);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(LoginScene);
        window.show();
        
    }

   

   
    
    
}
