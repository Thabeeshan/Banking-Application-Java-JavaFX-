/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thabeeshan
 */
public class Client_PageController implements Initializable {
    
    @FXML
    private TextField amount;
    
    @FXML
    private Label balance;
    
    double d_amount = 0, w_amount = 0, b_amount = 0;
    
    @FXML
    public void deposit(ActionEvent event){
        if (amount.getText() == null|| amount.getText().isEmpty()){
            balance.setText("Enter Value");
        }
        else{
            d_amount = Double.parseDouble(amount.getText());
            LoginController.client_1.deposit(d_amount);
            LoginController.client_1.level.changeLevel(LoginController.client_1);
        }
        
    }
    @FXML
    public void withdraw(ActionEvent event){
        if (amount.getText() == null|| amount.getText().isEmpty()){
            balance.setText("Enter Value");
        }
        else{
           d_amount = Double.parseDouble(amount.getText());
            if (d_amount > LoginController.client_1.getBalance()){
                balance.setText("Not enough to Withdraw");
            }
            else{
                LoginController.client_1.withdraw(d_amount);
                LoginController.client_1.level.changeLevel(LoginController.client_1);
            } 
       }
    }
    @FXML
    public void check_balance(ActionEvent event) {
        balance.setText("Balance: $" + LoginController.client_1.getBalance());
    }
    @FXML
    public void buy_online(ActionEvent event){
        if (amount.getText() == null|| amount.getText().isEmpty()){
            balance.setText("Enter Value");
        }
        else{
            b_amount = Double.parseDouble(amount.getText());
            double fee;
            fee = LoginController.client_1.level.getFee();
            if (b_amount >= 50 && b_amount +fee < LoginController.client_1.getBalance()){
                LoginController.client_1.purchase(b_amount+fee);
                LoginController.client_1.level.changeLevel(LoginController.client_1);
            }
            else{
                balance.setText("Not enough to Purchase");
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
