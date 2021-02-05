/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
/**
 * FXML Controller class
 *
 * @author moham
 */
public class LoginController implements Initializable {

   @FXML
    private TextField login;

    @FXML
    private PasswordField pswd;

    @FXML
    private Button loginBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
   
   @FXML
    public void login(ActionEvent e) throws IOException, ClassNotFoundException
    {
        try { String url="jdbc:mysql://localhost:3308/eshop";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, username, password);
           String sql="select username,password from admin where username='"+login.getText()+"' and password='"+pswd.getText()+"'";
           PreparedStatement ps=conn.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               if((login.getText().equalsIgnoreCase(rs.getString("username")))&&(pswd.getText().equalsIgnoreCase(rs.getString("password")))){
             System.out.println("logged in!");
                
                Stage logp = new Stage();
                logp.setTitle("Home");
                loginBtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
                Scene scene = new Scene(rootA);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);           
           }          
           }          
           else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("please verify your login credentials !");
                alert.showAndWait();
           }
       }catch(Exception ee){
           System.out.println(ee);
       }
    }
}
    


