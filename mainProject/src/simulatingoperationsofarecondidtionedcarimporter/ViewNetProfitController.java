/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingoperationsofarecondidtionedcarimporter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author hpflyernew
 */
public class ViewNetProfitController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Jan",205));
        series.getData().add(new XYChart.Data<String,Number>("Feb",150));
        series.getData().add(new XYChart.Data<String,Number>("Mar",160));
        series.getData().add(new XYChart.Data<String,Number>("Apr",120));
        series.setName("Monthly Net Profit");
        barChart.getData().add(series);
        // TODO
    }    
    
}
