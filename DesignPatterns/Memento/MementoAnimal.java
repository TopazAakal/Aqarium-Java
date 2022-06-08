package DesignPatterns.Memento;
import SeaCreatures.*;
/**
 * A class for Memento animal.
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class MementoAnimal {
    String[] animalData;
    Swimmable animal;

    /**
     * Instantiates a new Memento animal.
     *
     * @param state  the state
     * @param animal the animal
     */
    public MementoAnimal(String[] state, Swimmable animal){
        this.animalData = state;
        this.animal = animal;
    }

    /**
     * Get animal data string [ ].
     *
     * @return the string [ ]
     */
    public String[] getAnimalData(){
        return animalData;
    }

    /**
     * Gets animal obj.
     *
     * @return the animal obj
     */
    public Swimmable getAnimalObj() {
        return animal;
    }
}
