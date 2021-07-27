/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

import static coe528.Manager.clientList;
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

public class Manager_PageController implements Initializable {
    
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
    
    @FXML
    public void add_c(ActionEvent event) throws Exception{
        if (bal.getText() == null|| bal.getText().isEmpty()||user.getText() == null|| user.getText().isEmpty()||pass.getText() == null|| pass.getText().isEmpty()){
            status.setText("Complete all fields");
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
    
    @FXML
    public void logout(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @FXML
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
