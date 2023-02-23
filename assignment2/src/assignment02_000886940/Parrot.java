package assignment02_000000000;

/**
 * Implementation of the ParrotCraft Model Class
 * The view ParrotCraft can use this model
 *
 * @author Danilo Nakai
 */
public class Parrot {
    /**
     * Name
     **/
    private String name = "Julius";
    /**
     * Health
     **/
    private Integer health = 3;
    /**
     * CrackerCrumbs
     **/
    private Double crackerCrumbs = 0.1;
    /**
     * Tamed
     **/
    private Boolean tamed = false;
    /**
     * Alive
     **/
    private Boolean alive = true;
    /**
     * Flying
     **/
    private Boolean flying = true;

    /**
     * Get the parrot name
     **/
    public String getName() {
        return name;
    }

    /**
     * Set the parrot name
     * @param name The parrot name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the parrot amount of hearts(health)
     **/
    public Integer getHealth() {
        return health;
    }

    /**
     * Set the parrot amount of hearts(health)
     * @param health The amount of hearts(health)
     **/
    public void setHealth(Integer health) {
        this.health = health;
    }

    /**
     * Get the amount of cracker crumbs in the parrot's stomach
     **/
    public Double getCrackerCrumbs() {
        return crackerCrumbs;
    }

    /**
     * Set the amount of cracker crumbs in the parrot's stomach
     * @param crackerCrumbs The amount of cracker crumbs in the parrot's stomach
     **/
    public void setCrackerCrumbs(Double crackerCrumbs) {
        this.crackerCrumbs = crackerCrumbs;
    }

    /**
     * Get the boolean value of the parrot's tamed status
     **/
    public Boolean getTamed() {
        return tamed;
    }

    /**
     * Set the boolean value of the parrot's tamed status
     * @param tamed The boolean value of the parrot's tamed status
     **/
    public void setTamed(Boolean tamed) {
        this.tamed = tamed;
    }

    /**
     * Get the boolean value of the parrot's alive status
     **/
    public Boolean getAlive() {
        return alive;
    }

    /**
     * Set the boolean value of the parrot's alive status
     * @param alive The boolean value of the parrot's alive status
     **/
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    /**
     * Get the boolean value of the parrot's flying status
     **/
    public Boolean getFlying() {
        return flying;
    }

    /**
     * Set the boolean value of the parrot's flying status
     * @param flying The boolean value of the parrot's flying status
     **/
    public void setFlying(Boolean flying) {
        this.flying = flying;
    }

    /**
     * Feed the parrot
     * @param parrot The parrot object
     * @param crackerCrumbs The weight to add
     **/
    public static void feedParrot(Parrot parrot, Double crackerCrumbs) {
        Integer currentHealth = parrot.getHealth(); // Define the current health status
        int newHealth = 3; // Initialize the new health status using 3 as default
        Double currentCrackerCrumbs = parrot.getCrackerCrumbs(); // Define the current amount of cracker crumbs in the parrot's stomach
        Double newCrackerCrumbs = currentCrackerCrumbs + crackerCrumbs; // Define the new amount of cracker crumbs in the parrot's stomach
        int randomNumber = (int) (Math.random() * 100); // Generate a random number to check if the parrot will be tamed

        if (parrot.getAlive()) { // Check if the parrot is still alive
            if (currentHealth < 2) { // Check if the parrot's health is less than 2 to increase
                newHealth = currentHealth + 1;
                parrot.setHealth(newHealth); // Increase the health by 1
            }

            parrot.setCrackerCrumbs(newCrackerCrumbs); // Set the new amount of cracker crumbs in the parrot's stomach

            if ((crackerCrumbs * 20) > randomNumber) { // Calculate the chance of the parrot get tamed
                parrot.setTamed(true); // Tame the parrot
            }

            if (isSick(parrot)) { // Check if the parrot got sick
                Integer sickHealth = newHealth - 2;
                parrot.setHealth(sickHealth); // Decrease the parrot's health by 2

                if (parrot.getHealth() == 0) { // Check if the parrot is still alive
                    parrot.setAlive(false); // Set the parrot's alive status to dead
                    parrot.setTamed(false); // Set the parrot's tamed status to untamed
                    parrot.setFlying(true); // Set the parrot's flying status to flying
                }
            }
        }
    }

    /**
     * Command the parrot to Fly or Stay
     * @param parrot The parrot object
     * @param command The weight to add
     **/
    public static void commandParrot(Parrot parrot, String command) {
        if (command.equalsIgnoreCase("fly")) { // Validate the command
            parrot.setFlying(true); // Set the parrot's flying status to flying
        } else if (command.equalsIgnoreCase("stay")) { // Validate the command
            parrot.setFlying(false); // Set the parrot's flying status to sitting
        }
    }

    /**
     * Hit the parrot
     * @param parrot The parrot object
     **/
    public static void hitParrot(Parrot parrot) {
        Integer currentHealth = parrot.getHealth(); // Define the current health status

        if (parrot.getAlive()) { // Check if the parrot is still alive
            Integer newHealth = currentHealth - 1;
            parrot.setHealth(newHealth); // Decrease the parrot's health by 1
        }

        if (parrot.getHealth() == 0) { // Check if the parrot is dead
            parrot.setAlive(false); // Set the parrot's alive status to dead
        }

        parrot.setTamed(false); // Set the parrot's tamed status to untamed
        parrot.setFlying(true); // Set the parrot's flying status to flying
    }

    /**
     * Make two parrots play
     * @param parrot The parrot object
     * @param partner The partner parrot object
     **/
    public static void playWith(Parrot parrot, Parrot partner) {
        parrot.setTamed(false); // Set the parrot's tamed status to untamed
        parrot.setFlying(true); // Set the parrot's flying status to flying
        partner.setTamed(false); // Set the partner parrot's tamed status to untamed
        partner.setFlying(true); // Set the partner parrot's flying status to flying
    }

    /**
     * Discover if the parrot is sick
     * @param parrot The parrot object
     **/
    public static Boolean isSick(Parrot parrot) {
        return parrot.getCrackerCrumbs() >= 2.5;
    }

    /**
     * Convert to a specific string the parrot's alive status
     * @param target The parrot object
     **/
    public static String isAliveToString(Parrot target) {
        String status = "ALIVE";

        if (!target.getAlive()) {
            status = "DEAD";
        }
        return status;
    }

    /**
     * Convert to a specific string the parrot's flying status
     * @param target The parrot object
     **/
    public static String isFlyingToString(Parrot target) {
        String status = "Flying";

        if (!target.getFlying()) {
            status = "Sitting";
        }
        return status;
    }

    /**
     * Convert to a specific string the parrot's tamed status
     * @param target The parrot object
     **/
    public static String isTamedToString(Parrot target) {
        String status = "Tamed";

        if (!target.getTamed()) {
            status = "Untamed";
        }
        return status;
    }
}