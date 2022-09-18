/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import users.Customer;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class CustomerApplyForInsuranceController implements Initializable {
    Customer c;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void initData(Customer p){
        this.c = p;
    }
    
}
