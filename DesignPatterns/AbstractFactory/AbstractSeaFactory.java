package DesignPatterns.AbstractFactory;

/**
 * An interface for sea creature factories.
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public interface AbstractSeaFactory {
    /**
     * Produce sea creature.
     *
     * @param animal the animal
     * @param args   the args
     * @return the sea creature
     */
    SeaCreature produceSeaCreature(String animal,int[] args);
}
