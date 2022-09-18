/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nonuser;


import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author hpflyernew
 */
public class Parts implements Serializable {
    private String partName;
    private String partCombatibility;
    private String price;
    
    public Parts(String partName, String partCombatibility, String price) {
        this.partName = partName;
        this.partCombatibility = partCombatibility;
        this.price = price;
    }
    
    
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartCombatibility() {
        return partCombatibility;
    }

    public void setPartCombatibility(String partCombatibility) {
        this.partCombatibility = partCombatibility;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
  
 
            
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpflyernew
 */
