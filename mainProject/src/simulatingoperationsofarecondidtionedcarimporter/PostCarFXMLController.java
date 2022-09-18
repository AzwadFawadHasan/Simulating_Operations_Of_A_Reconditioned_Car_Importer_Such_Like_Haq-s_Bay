/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import Nonuser.Car;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import users.Dealer;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class PostCarFXMLController implements Initializable {
    private Dealer d; 
    @FXML
    private TableView<Car> tableview;
    @FXML
    private TableColumn<Car, String> carmakecolumn;
    @FXML
    private TableColumn<Car, String> carmodelcolumn;
    @FXML
    private TableColumn<Car, String> carcolorcolumn;
    @FXML
    private TableColumn<Car, String> carenginecolumn;
    @FXML
    private TableColumn<Car, String> carregnocolumn;
    @FXML
    private TableColumn<Car, String> carpricecolumn;
    @FXML
    private TextField carMakeFxid;
    @FXML
    private TextField carModelFxid;
    @FXML
    private TextField carColourFxid;
    @FXML
    private TextField CarEngineFxid;
    @FXML
    private TextField CarRegNoFxid;
    @FXML
    private TextField CarPriceFxid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carmakecolumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carmakecolumn"));
        carmodelcolumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carmodelcolumn"));
        carcolorcolumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carcolorcolumn"));
        carenginecolumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carenginecolumn"));
        carregnocolumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carregnocolumn"));
        carpricecolumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carpricecolumn"));
        // TODO
    }    
    
    public void initData(Dealer d){this.d =d;}

    @FXML
    private void handlePostIt(ActionEvent event)  throws FileNotFoundException {
        
         Car newCar = new Car(
                                       
                                       carMakeFxid.getText(),
                                       carModelFxid.getText(),
                                       carColourFxid.getText(),
                                       CarEngineFxid.getText(),
                                       CarRegNoFxid.getText(),
                                       CarPriceFxid.getText()
                                    );
         
                                       carMakeFxid.setText(null); 
                                       carModelFxid.setText(null); 
                                       carColourFxid.setText(null); 
                                       CarEngineFxid.setText(null); 
                                       CarRegNoFxid.setText(null); 
                                       CarPriceFxid.setText(null); 
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("carFile.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newCar);
    }
             catch (IOException ex) {
            Logger.getLogger(PostCarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PostCarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
                                       
        }                              
                                       
    }

    @FXML
    private void handleLoad(ActionEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        try {
            f = new File("carFile.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Car ss;
            try{
             
                while(true){
                    ss = (Car)ois.readObject();

                    tableview.getItems().add(ss);
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
        
        loader.setLocation(getClass().getResource("DealerHomepage.fxml"));
        Parent DealerHomepage = loader.load();
//The base class for all nodes that have children in the scene graph.
//This class handles all hierarchical scene graph operations, including adding/removing child nodes, marking branches dirty for layout and rendering, picking, bounds calculations, and executing the layout pass on each pulse
        Scene DealerHomepageScene = new Scene(DealerHomepage);

        DealerHomepageController controller = loader.getController();
       controller.initData(d);
        //System.out.println(d.getAge());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(DealerHomepageScene);
        window.show();
    }
    
}
