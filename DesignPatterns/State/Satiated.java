package DesignPatterns.State;

import SeaCreatures.Swimmable;

/**
 * A class for DataPatterns.State.Satiated state
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Satiated implements HungerState {
    /** swim normally even if there is food
     *  count movements and notify if hungry
     * @param swimmi SeaCreatures.Swimmable
     */
    @Override
    public void doAction(Swimmable swimmi) {
        if (swimmi.getCountMovements() == swimmi.getFreq()) {
            swimmi.setStateHunger(new Hungry());
            swimmi.support.firePropertyChange(swimmi.getColor() + " " + swimmi.getAnimalName() + " is hungry", null, null);
        }
        swimmi.setY_front(swimmi.getY_front() + swimmi.getVerSpeed() * swimmi.getY_dir());
        swimmi.setX_front(swimmi.getX_front() + swimmi.getHorSpeed() * swimmi.getX_dir());
    }
}
