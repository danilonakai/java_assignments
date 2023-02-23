package assignment3_000000000;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of the door of the house
 * @author Danilo Nakai
 */
public class Door {
    /** x position of the door **/
    private double x;

    /** y position of the door **/
    private double y;

    /** Height of the door **/
    private double height;

    /**
     * Class door constructor
     * @param x The x position of the door
     * @param y The y position of the door
     * @param height The height of the door
     **/
    public Door(double x, double y,double height){
        this.x = x;
        this.y = y;
        this.height = height;
    }

    /**
     * Draw the door
     *
     * @param gc The GraphicsContext object
     **/
    public void draw(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.fillRect(x,y,(height / 2),height);
    }
}