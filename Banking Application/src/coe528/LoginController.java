/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 *
 * @author Thabeeshan
 */
public class LoginController implements Initializable {
    
    ObservableList<String> usertypeList = FXCollections.observableArrayList("Client", "Admin");
    
    protected Manager manager = new Manager();
    
    static Client client_1;
    
    @FXML
    private Label title;
    
    @FXML
    private Label Status;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private ChoiceBox usermenu;
    @FXML
    private Button button;
    
    private void initialize(){
        usermenu.setValue("Client");
        usermenu.setItems(usertypeList);
    }
    
    public void user_def(ActionEvent event) throws Exception{
        
    }
    @FXML
    public void Login(ActionEvent event) throws Exception{
        if (usermenu.getValue() == "Admin") {            
            if (username.getText().equals("admin") && password.getText().equals("admin")){
                Status.setText("Login Successful");
                Parent root = FXMLLoader.load(getClass().getResource("Manager_Page.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            else{
                Status.setText("Login Unsuccessful");
            }
        }
        else if (usermenu.getValue() == "Client"){
           for (Client client : manager.clientList){               
               if  (username.getText().equals(client.name)){
                   BufferedReader br = null;
                   try{
                       br = new BufferedReader(new FileReader(client.name + ".txt"));
                       String line;                      
                       while ((line = br.readLine()) != null){
                        if (password.getText().equals(line)){
                            client_1 = client;
                            Parent customerUIParent = FXMLLoader.load(getClass().getResource("Client_Page.fxml"));          
                            Scene customerUIScene = new Scene(customerUIParent);
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setScene(customerUIScene);
                            window.show();
                        }
                   }
                   } catch (IOException e ){
                       System.out.println("Error");
                   }
               }
                Status.setText("Login Successful"); 
                
           }
           Status.setText("Login Unsuccessful");
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }    
    
}
