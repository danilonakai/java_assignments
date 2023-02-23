package assignment3_000000000;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

import static java.lang.Math.round;

/**
 * Implementation of the village
 *
 * @author Danilo Nakai
 */
public class Village {
    /**
     * x position of the village
     **/
    private double x;

    /**
     * y position of the village
     **/
    private double y;

    /**
     * Size of the village
     **/
    private double size;

    /**
     * Color of the village
     **/
    private Color color;

    /**
     * Name of the village
     **/
    private String name;

    /**
     * Class village constructor
     *
     * @param name  The name of the village
     * @param x     The x position of the village
     * @param y     The y position of the village
     * @param color The color of the village
     **/
    public Village(String name, double x, double y, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Draw the village
     *
     * @param gc The GraphicsContext object
     **/
    public void draw(GraphicsContext gc) {
        Random rand = new Random();

        double bigHouseSize = round(rand.nextDouble(100.0 - 80.0) + 80.0);
        double secondHouseSize = round(rand.nextDouble(70.0 - 20.0) + 20.0);
        double thirdHouseSize = round(rand.nextDouble(70.0 - 20.0) + 20.0);
        double housesArea = bigHouseSize + secondHouseSize + thirdHouseSize;
        double space = round(rand.nextDouble(30.0 - 10.0) + 10.0);

        this.size = housesArea + space;

        House house = new House(x, y, bigHouseSize, color);
        House house2 = new House((x + space + house.getSize()), (y + (bigHouseSize - secondHouseSize)), secondHouseSize, color);

        space = round(rand.nextDouble(30.0 - 10.0) + 10.0);

        this.size += space;

        double totalSpace = size - housesArea;

        House house3 = new House((x + totalSpace + house.getSize() + house2.getSize()), (y + (bigHouseSize - thirdHouseSize)), thirdHouseSize, color);

        double villageSize = (size * 20) / 100;

        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(x, y, (house.getSize() + house2.getSize() + house3.getSize() + totalSpace), bigHouseSize);

        String description = name + " (Size " + villageSize + "m, population " + (house.getOccupants() + house2.getOccupants() + house3.getOccupants()) + ")";
        gc.setFill(Color.BLACK);
        gc.fillText(description, x, (y + bigHouseSize + 20));

        house.draw(gc);
        house2.draw(gc);
        house3.draw(gc);
    }
}