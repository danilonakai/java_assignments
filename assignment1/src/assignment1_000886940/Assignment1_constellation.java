package assignment1_000000000;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import javax.swing.*;

import static javafx.application.Application.launch;

/**
 * Use this template to create drawings in FX. Change the name of the class and
 * put your own name as author below. Change the size of the canvas and the
 * window title where marked and add your drawing code where marked.
 *
 * @author Danilo Nakai
 */
public class Assignment1_constellation extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        int CANVAS_WIDTH = 1200;
        int CANVAS_HEIGHT = 800;
        int DIFFERENCE_TO_CENTER_OF_STAR = 4;

        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT); // Set canvas Size in Pixels
        stage.setTitle("Assignment1"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE


        // *** GETTING THE COORDINATES AND DRAWING THE CONSTELLATION
        String stars = JOptionPane.showInputDialog("Let's create a Constellation. Enter the number of stars.");
        String cord;
        int cord_x = 0;
        int cord_y = 0;
        int prev_cord_x = 0;
        int prev_cord_y = 0;
        int first_cord_x = 0;
        int first_cord_y = 0;


        for (int i = 1; i <= Integer.parseInt(stars); i++) {
            gc.setStroke(Color.WHITE);
            gc.setFill(Color.WHITE);

            cord = JOptionPane.showInputDialog("Please enter the star " + i + " coordinate in x,y format. (ie 5,4)");

            cord_x = Integer.parseInt(cord.split(",")[0]);
            cord_y = Integer.parseInt(cord.split(",")[1]);

            while ((cord_x < 0 || cord_x > CANVAS_WIDTH) || (cord_y < 0 || cord_y > CANVAS_HEIGHT)) {
                cord = JOptionPane.showInputDialog("NOT a valid cordinate.\n x must be max 1200 and y must be max 800.");
                cord_x = Integer.parseInt(cord.split(",")[0]);
                cord_y = Integer.parseInt(cord.split(",")[1]);
            }

            if (i == 1) {
                first_cord_x = Integer.parseInt(cord.split(",")[0]);
                first_cord_y = Integer.parseInt(cord.split(",")[1]);
            } else if (i > 1 && i < Integer.parseInt(stars)) {
                gc.strokeLine(prev_cord_x + DIFFERENCE_TO_CENTER_OF_STAR, prev_cord_y + DIFFERENCE_TO_CENTER_OF_STAR, cord_x + DIFFERENCE_TO_CENTER_OF_STAR, cord_y + DIFFERENCE_TO_CENTER_OF_STAR);
            }
            if (i == Integer.parseInt(stars)) {
                gc.strokeLine(prev_cord_x + DIFFERENCE_TO_CENTER_OF_STAR, prev_cord_y + DIFFERENCE_TO_CENTER_OF_STAR, cord_x + DIFFERENCE_TO_CENTER_OF_STAR, cord_y + DIFFERENCE_TO_CENTER_OF_STAR);
                gc.strokeLine(cord_x + DIFFERENCE_TO_CENTER_OF_STAR, cord_y + DIFFERENCE_TO_CENTER_OF_STAR, first_cord_x + DIFFERENCE_TO_CENTER_OF_STAR, first_cord_y + DIFFERENCE_TO_CENTER_OF_STAR);
            }

            prev_cord_x = Integer.parseInt(cord.split(",")[0]);
            prev_cord_y = Integer.parseInt(cord.split(",")[1]);

            gc.fillRect(cord_x, cord_y, 8, 8);
        }


        // *** DRAWING A RANDOM SKY
        int i = 0;
        while (i < 500) {
            int x = (int) (Math.random() * 1201);
            int y = (int) (Math.random() * 801);
            int w = 2;
            int h = 2;

            if (i > 200 && i < 401) {
                w = 4;
                h = 4;
            } else if (i > 400) {
                w = 6;
                h = 6;
            }

            gc.fillOval(x, y, w, h);

            i++;
        }

        // *** PRINTING CREDITS AND CONSTELLATION NAME
        gc.setFill(Color.RED);
        gc.setFont(new Font("Serif", 20));
        gc.fillText("App created by Danilo Nakai", 10, 760);
        String name = JOptionPane.showInputDialog("Give a name to your Constellation:");
        gc.fillText(name, 10, 785);


        // YOUR CODE STOPS HERE
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
