package assignment3_000000000;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of the house of the village
 *
 * @author Danilo Nakai
 */
public class House {
    /**
     * x position of the house
     **/
    private double x;

    /**
     * y position of the house
     **/
    private double y;

    /**
     * Size of the house
     **/
    private double size = 200;

    /**
     * Number of occupants of the house
     **/
    private int occupants = 1;

    /**
     * Color of the house
     **/
    private Color color = Color.ORANGE;

    /**
     * Class house constructor
     *
     * @param x     The x position of the house
     * @param y     The y position of the house
     * @param size  The size of the house
     * @param color The color of the house
     **/
    public House(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

        setOccupants((int) (Math.random() * 10));
    }

    /**
     * Class house constructor
     *
     * @param x The x position of the house
     * @param y The y position of the house
     **/
    public House(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draw the house
     *
     * @param gc The GraphicsContext object
     **/
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, size, size);

        Door door = new Door((x + (size / 2)), (y + (size / 2)), (size / 2));
        door.draw(gc);
        Window window = new Window((x + (size / 8)), (y + (size / 8)), (size / 4));
        window.draw(gc);
    }

    /**
     * Get the number of occupants of the house
     **/
    public int getOccupants() {
        return occupants;
    }

    /**
     * Set the number of occupants of the house
     *
     * @param n The number of occupants
     **/
    public void setOccupants(int n) {
        this.occupants = n;
    }

    /**
     * Get the size of the house
     **/
    public double getSize() {
        return size;
    }
}