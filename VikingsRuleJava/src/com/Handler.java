package com;

import com.BaseObject;
import com.Circle;
import com.MainWindowController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by twohyjr on 4/13/16.
 */
public class Handler {

    private Canvas canvas;
    private MainWindowController window;
    private double canvasWidth, canvasHeight;

    public LinkedList<BaseObject> baseObjects = new LinkedList<>();

    public Handler(MainWindowController window){
        this.window = window;
        this.canvas = window.getCanvas();
        this.canvasWidth = canvas.getWidth();
        this.canvasHeight = canvas.getHeight();
    }

    public void detectCollision(){
        //TODO
    }

    public void tick(){
        for(BaseObject obj : baseObjects){
            obj.tick();
        }

        //TEMP
        createGameObject();
    }

    public void render(GraphicsContext gc){
        for(BaseObject obj : baseObjects){
            obj.render(gc);
        }
    }

    //TEMP METHOD FOR ADDING GAME OBJECTS
    Random rand = new Random();
    public void createGameObject(){
        int circleSize = 30;
        int x = rand.nextInt((int)window.getCanvas().getWidth() - circleSize );
        int speed = rand.nextInt(5) + 1;

        Circle circle  = new Circle(x,10,circleSize,circleSize);
        circle.setVelY(speed);
        baseObjects.add(circle);
    }

}
