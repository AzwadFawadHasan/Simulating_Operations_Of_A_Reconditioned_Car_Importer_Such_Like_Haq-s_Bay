/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import Nonuser.Parts;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
public class PostPartsListingsController implements Initializable {
    private Dealer d;
    @FXML
    private TextField PartName;
    @FXML
    private TextField Price;
    @FXML
    private TextField PartCompatibility;
    @FXML
    private TableView<Parts> TableView;
    @FXML
    private TableColumn<Parts, String> PartNameTableColumn;
    @FXML
    private TableColumn<Parts, String> PartCompatibiltyTableColumn;
    @FXML
    private TableColumn<Parts, String> PriceTableColumn;
public void initData(Dealer dd){
    this.d=dd;
}
    /**
     * Initializes the controller class.
     */
/*ObservableList <Parts> list = FXCollections.observableArrayList(
        new Parts ("Car Horn", "Type:Universal", "1000")


);*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         PartNameTableColumn.setCellValueFactory(new PropertyValueFactory<Parts, String>("partName"));
        PartCompatibiltyTableColumn.setCellValueFactory(new PropertyValueFactory<Parts, String>("partCombatibility"));
        PriceTableColumn.setCellValueFactory(new PropertyValueFactory<Parts, String>("price"));
        //TableView.setItems(list);
       // PriceTableColumn.setCellValueFactory(cellData -> cellData.getValue().getPrice());
    }    

    @FXML
    private void handlePostIt(ActionEvent event) throws FileNotFoundException {
        Parts newParts = new Parts(
                                       
                                       PartName.getText(),
                                       PartCompatibility.getText(),
                                       Price.getText()
                                    );
                       PartName.setText(null);    
                       PartCompatibility.setText(null);  
                       Price.setText(null);
                       
                        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("storeParts.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newParts);
    }
             catch (IOException ex) {
            Logger.getLogger(PostPartsListingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PostPartsListingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
 }
    @FXML
    private void handleSeeWhatYouHavePosted(ActionEvent event) {
         File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("storeParts.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Parts np;
            Parts comp;
            Parts pp;
            try{
             
                while(true){
                    np = (Parts)ois.readObject();

                    TableView.getItems().add(np);
                    comp = (Parts)ois.readObject();

                    TableView.getItems().add(comp);
                    pp = (Parts)ois.readObject();

                    TableView.getItems().add(pp);
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