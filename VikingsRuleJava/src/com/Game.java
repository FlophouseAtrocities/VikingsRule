package com;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by twohyjr on 4/13/16.
 */
public class Game {

    //Variables for game loop timer
    long lastLoopTime = System.nanoTime();
    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    double lastFpsTime = 0;
    double fps = 0;

    private MainWindowController window;
    private Canvas canvas;
    private Handler handler;

    public Game(MainWindowController window){
        this.window = window;
        this.canvas = window.getCanvas();

        init();
    }

    public void init(){
        handler = new Handler(window);

        startGameLoop();
    }



    public void startGameLoop(){
        new AnimationTimer(){
            public void handle(long currentNanoTime){

                long now = System.nanoTime();
                long updateLength = now - lastLoopTime;
                lastLoopTime = now;
                double delta = updateLength / ((double)OPTIMAL_TIME);

                // update the frame counter
                lastFpsTime += updateLength;
                fps++;

                // update our FPS counter if a second has passed since
                // we last recorded
                if (lastFpsTime >= 1000000000)
                {
                    System.out.println("(FPS: "+fps+")");
                    window.setTickLabel((int)fps);
                    lastFpsTime = 0;
                    fps = 0;
                }
                window.setObjectCountLabel(handler.baseObjects.size());

                // game logic
                tick();

                // collision detection
                detectCollision();

                // render
                render();


            }
        }.start();
    }

    public void detectCollision(){
        handler.detectCollision();
    }


    public void tick(){
        handler.tick();
    }


    public void render(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 800,800);
        handler.render(gc);
        Rectangle2D rect = new Rectangle2D(0,0,0,0);


    }
}
