/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import Nonuser.Parts;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class CustomerBuyPartsController implements Initializable {
    Customer ccc;
    @FXML
    private TableView<Parts> myTable;
    @FXML
    private TableColumn<Parts, String> partNameColumn;
    @FXML
    private TableColumn<Parts, String> partCompatibiltyColumn;
    @FXML
    private TableColumn<Parts, String> partPriceColumn;
    public void initData(Customer p){
     ccc=p;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         partNameColumn.setCellValueFactory(new PropertyValueFactory<Parts,String>("PartName"));
       partCompatibiltyColumn.setCellValueFactory(new PropertyValueFactory<Parts,String>("PartCompatibility1"));
       partPriceColumn.setCellValueFactory(new PropertyValueFactory<Parts,String>("Price1"));
    }    

    @FXML
    private void handleLoad(ActionEvent event) {
        
         File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("storeParts.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Parts ss;
            try{
             
                while(true){
                    ss = (Parts)ois.readObject();

                    myTable.getItems().add(ss);
                }
                
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
                    
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        
        
    }
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
    
}
