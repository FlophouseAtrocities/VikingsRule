package com;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{

    @FXML
    private Canvas canvas;
    @FXML
    public Label tickLabel,objectCountLabel;

    private Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game(this);
    }

    public Canvas getCanvas(){return canvas;}
    public void setTickLabel(int ticks){tickLabel.setText(String.valueOf(ticks));}
    public void setObjectCountLabel(int count){objectCountLabel.setText(String.valueOf(count));}


}
