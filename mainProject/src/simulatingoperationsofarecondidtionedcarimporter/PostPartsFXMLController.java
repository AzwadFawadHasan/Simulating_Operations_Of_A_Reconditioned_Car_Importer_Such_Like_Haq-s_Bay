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
public class PostPartsFXMLController implements Initializable {
    private Dealer d;
    @FXML
    private Label Price;
    @FXML
    private TextField PartCompatibility1;
    @FXML
    private TextField PartName;
    @FXML
    private Label PartCompatibility;
    @FXML
    private TextField Price1;
    @FXML
    private TableView<Parts> TableView;
    @FXML
    private TableColumn<Parts, String> PartNameTableColumn;
    private TableColumn<Parts, String> PartCompatibiltyTableColumn;
    private TableColumn<Parts, String> PriceTableColumn;
    @FXML
    private TableColumn<Parts, String> compColumn;
    @FXML
    private TableColumn<Parts, String> pricecolumn;

    /**
     * Initializes the controller class.
     */
    public void initData(Dealer d){
        this.d= d;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       PartNameTableColumn.setCellValueFactory(new PropertyValueFactory<Parts,String>("PartName"));
       compColumn.setCellValueFactory(new PropertyValueFactory<Parts,String>("PartCompatibility1"));
       pricecolumn.setCellValueFactory(new PropertyValueFactory<Parts,String>("Price1"));
        
    }    

    @FXML
    private void handlePostIt(ActionEvent event) throws FileNotFoundException {
                          Parts newParts = new Parts(
                                       
                                       PartName.getText(),
                                       PartCompatibility1.getText(),
                                       Price1.getText()
                                    );
                       PartName.setText(null);    
                       PartCompatibility1.setText(null);  
                       Price1.setText(null);  
                      
                      
                       
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
            Logger.getLogger(PostPartsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PostPartsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
            Parts ss;
            try{
             
                while(true){
                    ss = (Parts)ois.readObject();

                    TableView.getItems().add(ss);
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





