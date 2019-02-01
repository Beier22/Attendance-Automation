/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ForgotPasswordViewController implements Initializable {

    @FXML
    private JFXButton btnLogin;
    @FXML
    private AnchorPane ancMain;
    @FXML
    private JFXTextField txtUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void clickLogin(ActionEvent event) throws IOException 
    {
       Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/LoginView.fxml"));
       Scene currentScene = ((Node)((EventObject) event).getSource()).getScene();
       Stage currentStage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
       currentStage.setScene(new Scene(root, currentScene.getWidth(), currentScene.getHeight()));
    }
    
}
