package com;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by twohyjr on 4/13/16.
 */
public class Circle implements BaseObject {

    private double x,y;
    private double width, height;
    private double velX, velY;

    public Circle(double x, double y,double width, double height){
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillOval(x,y,width,height);
    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(x,y,width,height);
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }
}
