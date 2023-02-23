package assignment3_000000000;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Two villages class
 * This class is used to display the Two village system using canvas
 *
 * @author Danilo Nakai
 */
public class TwoVillages extends Application {
    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group(); // Root passed to scene
        Scene scene = new Scene(root, Color.DARKSLATEBLUE); // Scene with darklateblue background
        Canvas canvas = new Canvas(1200, 800); // Canvas to display the villages
        stage.setTitle("The Villages");
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        Village village1 = new Village("Hogwarts", 50, 50, Color.RED); // Creating the first village
        village1.draw(gc); // Drawing the first village

        Village village2 = new Village("Hobbiton", 50, 600, Color.BLUE); // Creating the second village
        village2.draw(gc); // Drawing the second village

        House kingsHouse = new House(950, 350); // Creating the King's house
        kingsHouse.draw(gc); // Drawing the King's house


        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
