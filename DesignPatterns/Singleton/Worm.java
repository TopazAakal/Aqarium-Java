package DesignPatterns.Singleton;

import GUI.AquaPanel;

/**
 * A class singleton worm
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Worm {
    private static Worm instance=null;
    private AquaPanel panel = null;

    /**
     * Instantiates a new DataPatterns.Singleton.Worm.
     *
     * @param p the GUI.AquaPanel
     */
    private Worm(AquaPanel p){
        panel=p;
    }

    /**
     * Get instance worm.
     *
     * @param p the GUI.AquaPanel
     * @return the worm
     */
    public static Worm getInstance(AquaPanel p){
        if(instance==null)
            instance=new Worm(p);
        return instance;
    }

    /**
     * Set instance.
     *
     * @param worm the worm
     */
    public static void setInstance(Worm worm){
        instance=worm;
    }

    /**
     * Sets food.
     */
    public void setFood() {
        if (instance != null) {
            AquaPanel.setFood(true);
        }
    }

}
