/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnLogin;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        createTextFieldsListeners();
    }    

    private void createTextFieldsListeners() 
    {
        txtUsername.setOnKeyPressed(new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent key) 
                    {
                        if(key.getCode() == KeyCode.ENTER)
                        {
                            txtPassword.requestFocus();
                        }
                    }
                    
                }
            );
        txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent key) 
                    {
                        if(key.getCode() == KeyCode.ENTER)
                        {
                            btnLogin.fire();
                        }
                    }
                    
                }
            );
    }

    @FXML
    private void clickForgotPassword(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/ForgotPasswordView.fxml"));
        Scene currentScene = ((Node)((EventObject) event).getSource()).getScene();
        Stage currentStage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
        currentStage.setScene(new Scene(root, currentScene.getWidth(), currentScene.getHeight()));
    }
    
}
