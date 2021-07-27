/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528_bank;

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
    
    public void deposit(ActionEvent event){
        d_amount = Double.parseDouble(amount.getText());
        Login_PageController.client_1.deposit(d_amount);
        Login_PageController.client_1.level.changeLevel(Login_PageController.client_1);
    }
    public void withdraw(ActionEvent event){
        d_amount = Double.parseDouble(amount.getText());
        if (d_amount > Login_PageController.client_1.getBalance()){
            balance.setText("Not enough to Withdraw");
        }
        else{
            Login_PageController.client_1.withdraw(d_amount);
            Login_PageController.client_1.level.changeLevel(Login_PageController.client_1);
        }
    }
    public void check_balance(ActionEvent event) {
        balance.setText("Balance: $" + Login_PageController.client_1.getBalance());
    }
    public void buy_online(ActionEvent event){
        b_amount = Double.parseDouble(amount.getText());
        double fee;
        fee = Login_PageController.client_1.level.getFee();
        if (b_amount >= 50 && b_amount +fee < Login_PageController.client_1.getBalance()){
            Login_PageController.client_1.purchase(b_amount+fee);
            Login_PageController.client_1.level.changeLevel(Login_PageController.client_1);
        }
        else{
            balance.setText("Not enough to Purchase");
        }
    }
    public void logout(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
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
