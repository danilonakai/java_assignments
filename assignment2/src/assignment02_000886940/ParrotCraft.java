package assignment02_000000000;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Implementation of the view ParrotCraft
 * This view use the model Parrot
 *
 * @author Danilo Nakai
 */
public class ParrotCraft {
    /**
     * Quit Loop Boolean
     **/
    public static Boolean quitLoop = false;

    /**
     * A method to test the object
     *
     * @param args unused
     **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the ParrotCraft World: \n I hope you enjoy the game.\n"); // Initialize the game

        System.out.println("How many Parrots do you want to create?"); // Ask user to create the parrots
        double numberOfParrots = validateDoubleInput(input, "numberOfParrots", 0);

        ArrayList parrotsList = createParrotsList(numberOfParrots); // Create a list with all parrots

        while (!quitLoop) { // Keep playing if the user doesn't quit the game
            System.out.println(getParrotsToString(parrotsList)); // Provide the full report for the user

            System.out.println("1. Feed    2. Command    3. Play    4. Hit    5. Quit");

            System.out.println("Choose the action: "); // Ask the user to choose an action

            double selectedAction = validateDoubleInput(input, "selectAction", 5); // Validate the user's input

            if (quitGame(selectedAction)) {// If the action is "QUIT" finish the game here
                System.out.println("Thanks for playing.");
            } else { // If the game is not finished keep playing
                System.out.println("Which parrot? "); // Ask the user to choose a parrot to do the action
                double selectedParrot = validateDoubleInput(input, "selectedParrot", parrotsList.size());

                chooseAction(selectedAction, parrotsList, selectedParrot); // Process the action selected by the user
            }
        }
    }

    /**
     * Validate the user's inputs that returns double
     * @param input The user's input
     * @param validationType The validation method
     * @param max The max value accepted
     **/

    public static double validateDoubleInput(Scanner input, String validationType, int max) {
        int result = 0;
        String inputValue = input.nextLine();

        switch (validationType) { // Filter the type of validation
            case "numberOfParrots" -> {
                while (!isNumeric(inputValue)) {
                    System.out.println("A number is required..."); // Ask user to provide a number
                    inputValue = input.nextLine();
                }
                result = Integer.parseInt(inputValue);
            }
            case "selectAction" -> {
                while (!(isNumeric(inputValue) && (Integer.parseInt(inputValue) >= 1 && Integer.parseInt(inputValue) <= max))) {
                    System.out.println("Type a valid number(1~5)..."); // Ask user to provide a valid number
                    inputValue = input.nextLine();
                }
                result = Integer.parseInt(inputValue);
            }
            case "selectedParrot" -> {
                while (!(isNumeric(inputValue) && (Integer.parseInt(inputValue) >= 1 && Integer.parseInt(inputValue) <= max))) {
                    System.out.println("Type a valid number(1~" + max + ")..."); // Ask user to provide a valid number
                    inputValue = input.nextLine();
                }
                result = Integer.parseInt(inputValue);
            }
            case "crackerCrumbs" -> {
                while (!(isNumeric(inputValue) && Integer.parseInt(inputValue) > 0)) {
                    System.out.println("Type a valid double number..."); // Ask user to provide a valid number
                    inputValue = input.nextLine();
                }
                result = Integer.parseInt(inputValue);
            }
        }
        return result; // When user provides a valid number the method returns the number
    }

    /**
     * Validate the user's inputs that returns string
     * @param input The user's input
     * @param validationType The validation method
     **/
    public static String validateStringInput(Scanner input, String validationType) {
        String result = "";
        String inputValue = input.nextLine();

        switch (validationType) { // Filter the type of validation
            case "name" -> {
                while (Objects.equals(inputValue, "")) {
                    System.out.println("Type some name..."); // Ask user to provide a non-blank value
                    inputValue = input.nextLine();
                }
                result = inputValue;
            }
            case "command" -> {
                while (!(inputValue.equalsIgnoreCase("fly") || inputValue.equalsIgnoreCase("stay"))) {
                    System.out.println("Type 'fly' or 'stay'..."); // Ask user to type "fly" or "stay"
                    inputValue = input.nextLine();
                }
                result = inputValue;
            }
        }
        return result; // When user provides a valid string the method returns the string
    }

    /**
     * Check if the string value is numeric or not
     * @param string The string to check
     **/
    public static boolean isNumeric(String string) {
        boolean numeric = true;

        try { // Try to parse the string
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            numeric = false; // If it gets an error return false
        }

        return numeric;
    }

    /**
     * Generate a list of parrots provided by the user
     * @param numberOfParrots The number of items of the list
     **/
    private static ArrayList createParrotsList(double numberOfParrots) {
        ArrayList<Parrot> parrotsList = new ArrayList<>(); // Create the list

        for (int i = 1; i <= numberOfParrots; i++) {
            Scanner input = new Scanner(System.in);

            Parrot parrot = new Parrot(); // Instance the parrot object

            System.out.println("What's the name of the parrot " + i + "? "); // Ask user to choose a name for the parrot

            String parrotName = validateStringInput(input, "name"); // Validate the input
            parrot.setName(parrotName); // Set the parrot's name

            parrotsList.add(parrot); // Add the new parrot to the list
        }

        return parrotsList; // Return the list
    }

    /**
     * Generate the string that return the full report of all parrots
     * @param parrotsList The list of parrots created by the user
     **/
    private static String getParrotsToString(ArrayList parrotsList) {
        String result = "";

        for (int i = 0; i < parrotsList.size(); i++) { // Create a loop by the amount of parrots
            Parrot newParrot = (Parrot) parrotsList.get(i);
            String parrotString = (i + 1) + ". " +
                    Parrot.isTamedToString(newParrot) + " " +
                    Parrot.isAliveToString(newParrot) + " Parrot " +
                    newParrot.getName() + ": " +
                    newParrot.getCrackerCrumbs() + " crumbs, " +
                    newParrot.getHealth() + " heart, " +
                    Parrot.isFlyingToString(newParrot) + "\n";
            result += parrotString; // Add to the final string the description of the parrot
        }

        return result; // Return the complete string
    }

    /**
     * Quit the game if the user select the "QUIT" action
     * @param selectedAction The action selected by the user
     **/
    private static Boolean quitGame(double selectedAction) {
        boolean quit = false;

        if (selectedAction == 5) { // Check the user's action
            quitLoop = true; // Quit the game
            quit = true;
        }

        return quit; // Return true to indicate that the game is quited
    }

    /**
     * Process the user's selected action
     * @param selectedAction The action selected by the user
     * @param parrotsList The list of parrots created by the user
     * @param selectedParrot The parrot selected by the user to do the action
     **/
    private static void chooseAction(double selectedAction, ArrayList parrotsList, double selectedParrot) {
        Scanner input = new Scanner(System.in);
        Parrot parrot = (Parrot) parrotsList.get((int) (selectedParrot - 1));

        switch ((int) selectedAction) { // Filter the actions
            case 1 -> { // Feed
                System.out.println("How much?"); // Ask for the amount of cracker crumbs
                Double crackerCrumbs = validateDoubleInput(input, "crackerCrumbs", 0);
                Parrot.feedParrot(parrot, crackerCrumbs); // Feed the parrot
                if (Parrot.isSick(parrot)) { // Check if the parrot got sick
                    System.out.println("The " + parrot.getName() + " is SICK.\n");
                }
                if (!parrot.getAlive()) { // Check if the parrot is still alive
                    System.out.println("The " + parrot.getName() + " is DEAD.\n");
                }
            }
            case 2 -> { // Command
                System.out.println("Fly or Stay?"); // Ask user to specify the command
                String command = validateStringInput(input, "command");
                if (parrot.getAlive()) { // Check if the parrot is still alive
                    if (parrot.getTamed()) { // Check if the parrot is tamed
                        Parrot.commandParrot(parrot, command); // Command the parrot
                        System.out.println("You are commanding " + parrot.getName() + ".\n");
                    } else { // Inform the user that the parrot is untamed
                        System.out.println("You cannot command an untamed parrot.\n");
                    }
                } else { // Inform the user that the parrot is dead
                    System.out.println("You cannot command a DEAD parrot.\n");
                }
            }
            case 3 -> { // Play
                System.out.println("Who is it gonna play with? Ps:Type the number"); // Ask the user which parrot it will play with
                Parrot partner = (Parrot) parrotsList.get((int) (validateDoubleInput(input, "selectedParrot", parrotsList.size()) - 1));

                if (parrot != partner) { // Check if both are not the same
                    if (parrot.getAlive() && partner.getAlive()) { // Check if both are alive
                        if (parrot.getTamed() && partner.getTamed()) { // Check if both are tamed
                            Parrot.playWith(parrot, partner); // Make both play

                            System.out.println("They enjoyed so much that not they are both Untamed.\n");
                        } else { // Inform the user that untamed parrot cannot play
                            System.out.println("Untamed parrot cannot play.\n");
                        }
                    } else {// Inform the user that dead parrot cannot play
                        System.out.println("Dead parrot cannot play.\n");
                    }
                } else { // Inform the user that it cannot play with itself
                    System.out.println("It cannot play with itself.\n");
                }

            }
            case 4 -> { // Hit
                System.out.println("Ouch!\n");
                Parrot.hitParrot(parrot); // Hit the parrot
                if (!parrot.getAlive()) { // Check if it is still alive
                    System.out.println("The " + parrot.getName() + " is DEAD.\n");
                }
            }
        }
    }
}
