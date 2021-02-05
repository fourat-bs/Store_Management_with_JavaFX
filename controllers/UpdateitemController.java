/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class UpdateitemController implements Initializable {
  @FXML
 private Button backBtn;
@FXML
private Button updateBtn;
@FXML
private TextField txt1;
@FXML
private TextField txt11;
@FXML
private TextField txt2;
@FXML
private TextField txt3;
@FXML
private TextField txt4;
@FXML
private TextField txt5;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void update(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        
           Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
           
                     
                     
    
     try {
          String sql2="update items set name='"+txt1.getText()+"', categorie='"+txt2.getText()+"',color='"+txt3.getText()+"',size='"+txt4.getText()+"',price='"+Float.parseFloat(txt5.getText())+"' where id='"+txt11.getText()+"'";
         PreparedStatement pst;
            pst = connect.prepareStatement(sql2);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Item Successfuly updated !");
                alert.showAndWait();
            System.out.println("item successfuly updated");
        } catch (NumberFormatException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Error");
                alert.showAndWait();
            System.out.println(ex);
        }
} 
      @FXML
private void goback(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        backBtn.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/views/Items.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
} 
}
