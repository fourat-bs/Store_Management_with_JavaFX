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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.costumer;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class CostumersController implements Initializable {
@FXML
  private Button backBtn;
 @FXML
  private Button addBtn;
 @FXML
 private Button deleteBtn;
 @FXML
 private Button modBtn;
 @FXML
 private TableView<models.costumer> costumerstable;
 @FXML
 private TableColumn<models.costumer, Integer> id;
 @FXML
 private TableColumn<models.costumer, String> name;
 @FXML
 private TableColumn<models.costumer, String> email;
 @FXML
 private TableColumn<models.costumer, Integer> phone;
 @FXML
 private TableColumn<models.costumer, String> adress;
  
 
 ObservableList<models.costumer> oblistcost= FXCollections.observableArrayList();
 @Override
  public void initialize(URL url, ResourceBundle rb) {
        try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT id,name,email,phone,adress  FROM costumers");
            
            while(rs.next())
            {
                oblistcost.add(new costumer(rs.getInt("id"),rs.getString("email"), rs.getString("name"), rs.getInt("phone"), rs.getString("adress")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
           
          
            costumerstable.setItems(oblistcost);
    } 
    @FXML
     private void openaddwindow(ActionEvent e) throws IOException
    {
        Stage stage = new Stage();
        addBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/views/addcostumer.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
}
      @FXML
    private void openmodwindow(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
    {
        Stage oitems = new Stage();
        modBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/views/updatecostumer.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
       
}
            
   
            
      @FXML
    private void delete(ActionEvent e) throws IOException, ClassNotFoundException
    {
        PreparedStatement pst;

                int x = costumerstable.getSelectionModel().getSelectedItem().getId();
                costumerstable.getItems().removeAll(costumerstable.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM costumers WHERE id ='"+x+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Costumer Successfuly deleted !");
                alert.showAndWait();
            System.out.println("Costumer successfuly deleted");
        } catch (ClassNotFoundException | SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Error");
                alert.showAndWait();
            System.out.println(ex.getMessage());
        }
}
   
  @FXML
private void goback(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        backBtn.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        Scene scene = new Scene(root3);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}    
}
