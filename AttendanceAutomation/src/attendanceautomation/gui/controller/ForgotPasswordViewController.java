/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.gui.util.AnimationUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ForgotPasswordViewController implements Initializable {

    @FXML
    private AnchorPane ancMain;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblFirstLine;
    @FXML
    private Label lblSecondLine;
    @FXML
    private JFXButton btnSend;
    @FXML
    private JFXButton btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        showElements();      
        createTextFieldsListener();
    }   
    
    private void createTextFieldsListener()
    {
        txtUsername.setOnKeyPressed(new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent key) 
                    {
                        if(key.getCode() == KeyCode.ENTER)
                        {
                            btnSend.fire();
                        }
                    }
                    
                }
            );
    }

    
    private void showElements()
    {
        List<Node> elements = new ArrayList();
        elements.add(lblTitle);
        elements.add(lblFirstLine);
        elements.add(lblSecondLine);
        elements.add(txtUsername);
        ParallelTransition transition = AnimationUtil.createVerticalSlideWithFadingIn(-300, 0, elements);
        transition.play();
    }

    @FXML
    private void clickLogin(ActionEvent event) throws IOException 
    {
        List<Node> elements = new ArrayList();
        elements.add(lblTitle);
        elements.add(lblFirstLine);
        elements.add(lblSecondLine);
        elements.add(txtUsername);
        ParallelTransition transition = AnimationUtil.createVerticalSlideWithFadingOut(0, -300, elements);
        
        transition.setOnFinished(new EventHandler(){
            @Override
            public void handle(Event event) {
                showLoginView();
            }
        });
        
        transition.play();
        

    }
    
    private void showLoginView()
    {
        try
        {
           Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/LoginView.fxml"));
           Scene currentScene = btnSend.getScene();
           Stage currentStage = (Stage)btnSend.getScene().getWindow();
           currentStage.setScene(new Scene(root, currentScene.getWidth(), currentScene.getHeight()));
        }
        catch(IOException e)
        {
            
        }
    }
    
}
