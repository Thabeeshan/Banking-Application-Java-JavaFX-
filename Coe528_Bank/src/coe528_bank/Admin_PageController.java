/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528_bank;

import static coe528_bank.Manager.clientList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;

/**
 * FXML Controller class
 *
 * @author Thabeeshan
 */

public class Admin_PageController implements Initializable {
    
    @FXML
    private TextField user;
    
    @FXML
    private TextField pass;
    
    @FXML
    private TextField bal;
    
    @FXML
    private Label status;
    
    double b;
    
    protected Manager manager = new Manager();
    
    public void add_c(ActionEvent event) throws Exception{
        if (bal.getText() == null|| bal.getText().isEmpty()){
            status.setText("Enter intial balance");
        }
        else if (Double.parseDouble(bal.getText()) == 100){
             if (manager.createClient(user.getText(), pass.getText(), Double.parseDouble(bal.getText()))){
                 status.setText("Customer Added");
             }
             else {
                status.setText("Username already taken");
            }
        }
        else{
            if (Double.parseDouble(bal.getText()) != 100){
                status.setText("Enter $100");
            }
        }
    }
    
    public void logout(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    public void delete_c(ActionEvent event) throws Exception{
        if (manager.deleteClient(user.getText())){
            status.setText("Customer Deleted");
        }
        else{
            status.setText("Customer does not exist");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
