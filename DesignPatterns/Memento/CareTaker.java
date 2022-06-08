package DesignPatterns.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to save all the memento information
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class CareTaker {
    private List<MementoAnimal> mementoAnimalList = new ArrayList<MementoAnimal>();
    private List<MementoPlant> mementoPlantList = new ArrayList<MementoPlant>();

    /**
     * Add animal to mementoAnimalList
     *
     * @param state the state
     */
    public void add(MementoAnimal state) {
        mementoAnimalList.add(state);
    }

    /**
     * Add plant to mementoPlantList
     *
     * @param state the state
     */
    public void add(MementoPlant state) {
        mementoPlantList.add(state);
    }

    /**
     * Clear mementoAnimalList.
     */
    public void clearAnimals() {
        mementoAnimalList.clear();
    }

    /**
     * Clear mementoPlantList.
     */
    public void clearPlants() {
        mementoPlantList.clear();
    }

    /**
     * Gets memento animal list.
     *
     * @return the memento animal list
     */
    public List<MementoAnimal> getMementoAnimalList() {
        return mementoAnimalList;
    }

    /**
     * Gets memento plant list.
     *
     * @return the memento plant list
     */
    public List<MementoPlant> getMementoPlantList() {
        return mementoPlantList;
    }
}