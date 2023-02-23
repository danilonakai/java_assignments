package assignment3_000000000;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of the window of the house
 *
 * @author Danilo Nakai
 */
public class Window {
    /**
     * x position of the window
     **/
    private double x;

    /**
     * y position of the window
     **/
    private double y;

    /**
     * Diameter of the window
     **/
    private double diameter;

    /**
     * Class window constructor
     *
     * @param x        The x position of the window
     * @param y        The y position of the window
     * @param diameter The diameter of the window
     **/
    public Window(double x, double y, double diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    /**
     * Draw the window
     *
     * @param gc The GraphicsContext object
     **/
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(x, y, diameter, diameter);
    }
}