package DesignPatterns.Prototype;

import java.util.Hashtable;

import SeaCreatures.*;

/**
 * A class for SeaCreatures.Swimmable Cache part of prototype pattern
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class SwimmableCache {
    private static Hashtable<String, Swimmable> swimmableMap = new Hashtable<String, Swimmable>();

    /**
     * Get swimmable swimmable.
     *
     * @param swimmableID the swimmable id
     * @return the swimmable
     */
    public static Swimmable getSwimmable(String swimmableID){
        Swimmable swim=swimmableMap.get(swimmableID);
        return (SeaCreatures.Swimmable) swim.clone();
    }

    /**
     * Load cache.
     */
    public static void loadCache() {
        Fish fish = new Fish(70, 300, 50, 5, 5, 1,10);
        swimmableMap.put("fish", fish);

        Jellyfish jellyfish = new Jellyfish(70,300,50,5,5,1,10);
        swimmableMap.put("jellyfish", jellyfish);
    }
}
