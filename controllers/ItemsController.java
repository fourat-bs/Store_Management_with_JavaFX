/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.SQLException;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.item;
/**
 * FXML Controller class
 *
 * @author moham
 */
public class ItemsController implements Initializable {
   
 @FXML
  private Button backBtn;
 @FXML
  private Button addBtn;
 @FXML
 private Button deleteBtn;
 @FXML
 private Button modBtn;
 @FXML
 private TableView<models.item> itemstable;
 @FXML
 private TableColumn<models.item, Integer> id;
 @FXML
 private TableColumn<models.item, String> name;
 @FXML
 private TableColumn<models.item, String> categorie;
 @FXML
 private TableColumn<models.item, String> color;
 @FXML
 private TableColumn<models.item, String> size;
 @FXML
 private TableColumn<models.item, Float> price;   
 
 ObservableList<models.item> oblistitem= FXCollections.observableArrayList();
 @Override
  public void initialize(URL url, ResourceBundle rb) {
        try {
             
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
            ResultSet rs = connect.createStatement().executeQuery
            ("SELECT id,name,categorie,color,size,price  FROM items");
            
            while(rs.next())
            {
                oblistitem.add(new item(rs.getInt("id"),rs.getString("name"), rs.getString("categorie"), rs.getString("color"), rs.getString("size"), rs.getFloat("price")));
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            color.setCellValueFactory(new PropertyValueFactory<>("color"));
            size.setCellValueFactory(new PropertyValueFactory<>("size"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));
          
            itemstable.setItems(oblistitem);
    } 
    @FXML
     private void openaddwindow(ActionEvent e) throws IOException
    {
        Stage stage = new Stage();
        addBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/views/additem.fxml"));
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
        root2 = FXMLLoader.load(getClass().getResource("/views/updateitem.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
       
}
            
   
            
      @FXML
    private void delete(ActionEvent e) throws IOException, ClassNotFoundException
    {
        PreparedStatement pst;

                String x = itemstable.getSelectionModel().getSelectedItem().getName();
                itemstable.getItems().removeAll(itemstable.getSelectionModel().getSelectedItem());
                String sql="DELETE FROM items WHERE name ='"+x+"'";
                     
                     
    
     try {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/eshop", "root" ,"");
            pst = connect.prepareStatement(sql);   
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Item Successfuly deleted !");
                alert.showAndWait();
            System.out.println("item successfuly deleted");
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
 
