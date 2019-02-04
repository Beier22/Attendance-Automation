/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.util;

import java.util.List;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author Acer
 */
public class AnimationUtil {
    
    public static ParallelTransition createHorizontalSequentialSlideWithFadingOut(int startingPosition, int endingPosition, List<Node> elements)
    {
        int slideDuration = 150;
        int fadeDuration = 150;
        ParallelTransition transition = new ParallelTransition();
        for(Node e: elements)
        {
            TranslateTransition translate = new TranslateTransition(Duration.millis(slideDuration), e);
            translate.setFromX(startingPosition);
            translate.setToX(endingPosition);
            FadeTransition fade = new FadeTransition(Duration.millis(fadeDuration), e);
            fade.setToValue(0);
            slideDuration += 80;
            fadeDuration+=80;
            transition.getChildren().addAll(translate,fade);
        }
        return transition;
    }
    
    public static ParallelTransition createHorizontalSequentialSlideWithFadingIn(int startingPosition, int endingPosition, List<Node> elements)
    {
        int slideDuration = 150;
        int fadeDuration = 150;
        ParallelTransition transition = new ParallelTransition();
        for(Node e: elements)
        {
            TranslateTransition translate = new TranslateTransition(Duration.millis(slideDuration), e);
            translate.setFromX(startingPosition);
            translate.setToX(endingPosition);
            FadeTransition fade = new FadeTransition(Duration.millis(fadeDuration), e);
            fade.setFromValue(0);
            fade.setToValue(1);
            slideDuration += 80;
            fadeDuration+=80;
            transition.getChildren().addAll(translate,fade);
        }
        return transition;
    }
    
    public static ParallelTransition createVerticalSlideWithFadingIn(int startingPosition, int endingPosition, List<Node> elements)
    {
        int slideDuration = 200;
        int fadeDuration = 200;
        ParallelTransition transition = new ParallelTransition();
        for(Node e: elements)
        {
            TranslateTransition translate = new TranslateTransition(Duration.millis(slideDuration), e);
            translate.setFromY(startingPosition);
            translate.setToY(endingPosition);
            FadeTransition fade = new FadeTransition(Duration.millis(fadeDuration), e);
            fade.setFromValue(0);
            fade.setToValue(1);
            transition.getChildren().addAll(translate,fade);
        }
        return transition;
    }
    
    public static ParallelTransition createVerticalSlideWithFadingOut(int startingPosition, int endingPosition, List<Node> elements)
    {
        int slideDuration = 200;
        int fadeDuration = 200;
        ParallelTransition transition = new ParallelTransition();
        for(Node e: elements)
        {
            TranslateTransition translate = new TranslateTransition(Duration.millis(slideDuration), e);
            translate.setFromY(startingPosition);
            translate.setToY(endingPosition);
            FadeTransition fade = new FadeTransition(Duration.millis(fadeDuration), e);
            fade.setFromValue(1);
            fade.setToValue(0);
            transition.getChildren().addAll(translate,fade);
        }
        return transition;
    }
}
