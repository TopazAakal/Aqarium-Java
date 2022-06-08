package DesignPatterns.Memento;
import SeaCreatures.*;
/**
 * A class for DataPatterns.Memento.Originator -> Memento pattern
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Originator {

    private String[] state;
    private Swimmable swimmi;
    private Immobile planti;

    /**
     * Sets state.
     *
     * @param state  the state
     * @param swimmi the swimmi
     */
    public void setState(String[] state, Swimmable swimmi) {
        this.swimmi = swimmi;
        this.state = new String[state.length];
        for (int i = 0; i < state.length; i++)
            this.state[i] = state[i];
    }

    /**
     * Sets state.
     *
     * @param state  the state
     * @param planti the planti
     */
    public void setState(String[] state, Immobile planti) {
        this.planti = planti;
        this.state = new String[state.length];
        for (int i = 0; i < state.length; i++)
            this.state[i] = state[i];
    }

    /**
     * Get state string [ ].
     *
     * @return the string [ ]
     */
    public String[] getState() {
        return state;
    }

    /**
     * Gets swimmi.
     *
     * @return the swimmi
     */
    public Swimmable getSwimmi() {
        return swimmi;
    }

    /**
     * Gets planti.
     *
     * @return the planti
     */
    public Immobile getPlanti() {
        return planti;
    }

    /**
     * Save state to memento animal memento animal.
     *
     * @return the memento animal
     */
    public MementoAnimal saveStateToMementoAnimal() {
        return new MementoAnimal(state, swimmi);
    }

    /**
     * Save state to memento plant memento plant.
     *
     * @return the memento plant
     */
    public MementoPlant saveStateToMementoPlant() {
        return new MementoPlant(state, planti);
    }

    /**
     * Gets state from memento animal.
     *
     * @param Memento the memento
     */
    public void getStateFromMementoAnimal(MementoAnimal Memento) {
        state = Memento.getAnimalData();
        swimmi = Memento.getAnimalObj();
    }

    /**
     * Gets state from memento plant.
     *
     * @param Memento the memento
     */
    public void getStateFromMementoPlant(MementoPlant Memento) {
        state = Memento.getPlantData();
        planti = Memento.getPlanti();
    }
}
