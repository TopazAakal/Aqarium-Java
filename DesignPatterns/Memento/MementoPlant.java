package DesignPatterns.Memento;
import SeaCreatures.*;
/**
 * A class for Memento plant.
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class MementoPlant {
    String[] plantData;
    Immobile planti;

    /**
     * Instantiates a new Memento plant.
     *
     * @param state  the state
     * @param planti the planti
     */
    public MementoPlant(String[] state, Immobile planti){
        this.plantData = state;
        this.planti = planti;
    }

    /**
     * Get plant data string [ ].
     *
     * @return the string [ ]
     */
    public String[] getPlantData(){
        return plantData;
    }

    /**
     * Gets planti.
     *
     * @return the planti
     */
    public Immobile getPlanti() {
        return planti;
    }
}
