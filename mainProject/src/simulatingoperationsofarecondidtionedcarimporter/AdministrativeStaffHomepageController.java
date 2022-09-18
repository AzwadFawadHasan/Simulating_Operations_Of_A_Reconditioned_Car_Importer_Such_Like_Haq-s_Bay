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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import users.AdministrativeStaff;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class AdministrativeStaffHomepageController implements Initializable {
    private AdministrativeStaff aaa;

    public void  initData(AdministrativeStaff aaa){this.aaa=aaa;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handleNotifyOtherUsersAboutMeetingsOrConferenceCallsFxid(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("AdminNotifyOthers.fxml"));
        Parent AdminNotifyOthers = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene AdminNotifyOthersScene = new Scene(AdminNotifyOthers);

        AdminNotifyOthersController controller = loader.getController();
       controller.initData(aaa);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(AdminNotifyOthersScene);
        window.show();
    }


    @FXML
    private void handleMaintainWeeklySchedulesOfEmployeesFxid(ActionEvent event) throws IOException{
        Parent fileChooserViewParent = FXMLLoader.load(getClass().getResource("FileChooserView.fxml"));
        Scene fileChooserViewScene = new Scene(fileChooserViewParent);
        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage newWindow  = new Stage();
        
        newWindow.setTitle("File Chooser Test Stage");
        newWindow.setScene(fileChooserViewScene);
        newWindow.show();
    }


    @FXML
    private void handleViewIncomeReportAndExpenseReportFxid(ActionEvent event) throws IOException{
        
         FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("ViewNetProfit.fxml"));
        Parent ViewNetProfit = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene ViewNetProfitScene = new Scene(ViewNetProfit);

        ViewNetProfitController controller = loader.getController();
       //controller.initData(aaa);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewNetProfitScene);
        window.show();
    }


    @FXML
    private void handleApproveOrDisapproveLeaveApplicationForStaffFxid(ActionEvent event) {
    }


    @FXML
    private void handleProcessVehicleStocksAndKeepRecordsUpdatedfxid(ActionEvent event) {
    }
    
}
