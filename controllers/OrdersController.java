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
import java.sql.Timestamp;
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
import models.order;
/**
 * FXML Controller class
 *
 * @author moham
 */
public class OrdersController implements Initializable {
@FXML
  private Button backBtn;
 @FXML
  private Button addBtn;
 @FXML
 private Button deleteBtn;
 @FXML
 private Button modBtn;
 @FXML
 private TableView<models.order> orderstable;
 @FXML
 private TableColumn<models.order,Integer> costumerid;
 @FXML
 private TableColumn<models.order, Integer> itemid;
 @FXML
 private TableColumn<models.order, Integer> quantity;
 @FXML
 private TableColumn<models.costumer, Timestamp> date;
 ObservableList<models.order> oblistord= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT costumerid,itemid,quantity,date  FROM orders");
            
            while(rs.next())
            {
                oblistord.add(new order(rs.getInt("costumerid"),rs.getInt("itemid"), rs.getInt("quantity"), rs.getTimestamp("date")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            costumerid.setCellValueFactory(new PropertyValueFactory<>("costumerid"));
            itemid.setCellValueFactory(new PropertyValueFactory<>("itemid"));
            quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
             date.setCellValueFactory(new PropertyValueFactory<>("date"));
           
          
            orderstable.setItems(oblistord);
    } 
    @FXML
     private void openaddwindow(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        addBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/views/addorder.fxml"));
        Scene scene = new Scene(root1);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}

      @FXML
    private void delete(ActionEvent e) throws IOException
    {
         PreparedStatement pst;

                Timestamp x = orderstable.getSelectionModel().getSelectedItem().getDate();
                orderstable.getItems().removeAll(orderstable.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM orders WHERE date ='"+x+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Order Successfuly deleted !");
                alert.showAndWait();
            System.out.println("Order successfuly deleted");
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
