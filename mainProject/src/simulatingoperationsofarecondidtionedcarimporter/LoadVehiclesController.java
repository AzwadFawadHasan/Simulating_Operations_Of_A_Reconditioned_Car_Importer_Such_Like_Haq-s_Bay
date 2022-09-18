/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import Nonuser.Car;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import users.Dealer;
import javafx.scene.control.*;
/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class LoadVehiclesController implements Initializable {
    private Car car;
    private Dealer d;
    @FXML
    
    private TableColumn<String, Car> carMakeColumnFxid;
    @FXML
    private TableColumn<String, Car> carModelColumnFxid;
    @FXML
    private TableColumn<String, Car> carColorColumnFxid;
    @FXML
    private TableColumn<String, Car> carEngineCcFxid;
    @FXML
    private TableColumn<String, Car> carPriceFxid;
    @FXML
    private Button loadfxid;
    
    private TableView<Car> tableView;
    
    

    public void initData(Car car, Dealer d){
        this.car = car;
        this.d = d;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleloadfxid(ActionEvent event) {
        ObjectInputStream ois = null;
            try{
                Car car;
                ois = new ObjectInputStream(new FileInputStream("CarObjects.bin"));
                car = (Car)ois.readObject();
                tableView.getItems().add(car);
                
            }catch(Exception ex){
                    try{
                        if(ois!=null){
                            ois.close();
                        }
                        
                    }catch(IOException e){
                        e.printStackTrace();
                        
                    }
                    ex.printStackTrace();
            }
        
    }
    
}
