package com.movieposter.movieposter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;

public class ApplicationController {
    @FXML
    private Label actorName;
    @FXML
    private Button btNext;
    @FXML
    private Button btPrevious;
    @FXML
    private Hyperlink hyperLink;
    @FXML
    private ImageView actorPhoto;

    private int arrayController = 0;

    private final String actorArray[] = {"Ian McKellen", "Martin Freeman", "Richard Armitage", "Ken Stott"};

    @FXML
    private void next(ActionEvent e){
        if(arrayController == 3) {
            arrayController = 0;
        }
        else {
            arrayController++;
        }
        actorName.setText(actorArray[arrayController]);
        actorPhoto.setImage(new Image(getImagePath(arrayController)));
    }

    @FXML
    private void previous(ActionEvent e){
        if(arrayController == 0) {
            arrayController = 3;
        }
        else {
            arrayController--;
        }
        actorName.setText(actorArray[arrayController]);
        actorPhoto.setImage(new Image(getImagePath(arrayController)));
    }

    @FXML
    private void toLink() {
        try {
            new ProcessBuilder("x-www-browser", hyperLink.getText()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getImagePath(int i) {
       if(i == 0) {
           return getClass().getResource("imgs/ian.jpg").toString();
       }
       else if (i == 1) {
           return getClass().getResource("imgs/martin.jpg").toString();
       }
       else if (i == 2) {
           return getClass().getResource("imgs/richard.jpg").toString();
       }
       else {
           return getClass().getResource("imgs/ken.jpg").toString();
       }
    }
}