/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.gui.util.AnimationUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    private StackPane stcImage;
    @FXML
    private StackPane stcRememberMe;
    @FXML
    private JFXButton btnForgotPassword;
    @FXML
    private JFXToggleButton tglRememberMe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        showElementsWithAnimation();
        checkRememberMe();
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
    
    private void checkRememberMe()
    {
        Preferences prefs = Preferences.userNodeForPackage(LoginViewController.class);
        String username = prefs.get("username", null);
        String password = prefs.get("password", null);
        txtUsername.setText(username);
        if(password!=null)
        {
            tglRememberMe.setSelected(true);
            txtPassword.setText(password);
        }
        
    }

    @FXML
    private void clickForgotPassword(ActionEvent event) throws IOException 
    {        
        List<Node> elements = new ArrayList();
        elements.add(stcImage);
        elements.add(txtUsername);
        elements.add(txtPassword);
        elements.add(stcRememberMe);
        ParallelTransition transition = AnimationUtil.createHorizontalSequentialSlideWithFadingOut(0, 650, elements);
        transition.setOnFinished(new EventHandler(){
            @Override
            public void handle(Event event) {
                showForgotPasswordView();
            }
        });
        transition.play();
    }

    @FXML
    private void clickLogin(ActionEvent event) 
    {
        Preferences prefs = Preferences.userNodeForPackage(LoginViewController.class);
        prefs.put("username", txtUsername.getText());
        if(tglRememberMe.isSelected())
        {
            prefs.put("password", txtPassword.getText());
        }
        else
        {
            prefs.remove("password");
        }
    }
    
    public void showElementsWithAnimation()
    {
        List<Node> elements = new ArrayList();
        elements.add(stcImage);
        elements.add(txtUsername);
        elements.add(txtPassword);
        elements.add(stcRememberMe);
        ParallelTransition transition = AnimationUtil.createHorizontalSequentialSlideWithFadingIn(-650, 0, elements);
        transition.play();
    }
            
    private void showForgotPasswordView()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/ForgotPasswordView.fxml"));
            Scene currentScene = btnLogin.getScene();
            Stage currentStage = (Stage) btnLogin.getScene().getWindow();
            currentStage.setScene(new Scene(root, currentScene.getWidth(), currentScene.getHeight()));
        }
        catch (IOException e)
        {
            
        }
    }
    
}
