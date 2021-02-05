/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author moham
 */
public class HomeController implements Initializable {

 @FXML
    private Button ItemsBtn;
    @FXML
    private Button OrdersBtn;
    @FXML
    private Button CostumersBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    
    
    @FXML
    private void openitemswindow(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        ItemsBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/views/Items.fxml"));
        Scene scene = new Scene(root1);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
      @FXML
    private void openorderswindow(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        OrdersBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/views/orders.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
      @FXML
    private void opencostumerswindow(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        CostumersBtn.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/views/costumers.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
}
