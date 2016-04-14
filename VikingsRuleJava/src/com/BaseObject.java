package com;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by twohyjr on 4/13/16.
 */
public interface BaseObject {

    public void tick();

    public void render(GraphicsContext gc);

    public Rectangle2D getBounds();


}
