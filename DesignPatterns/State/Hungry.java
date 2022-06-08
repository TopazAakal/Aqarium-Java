package DesignPatterns.State;
import SeaCreatures.*;
import GUI.*;


/**
 * A class for DataPatterns.State.Hungry state
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Hungry implements HungerState {

    /**
     * go to eat the worm if exist
     *
     * @param swimmi SeaCreatures.Swimmable
     */
    @Override
    public void doAction(Swimmable swimmi) {
        // direction according to x-axis
        if (AquaPanel.isFood()) {
            if (swimmi.getX_front() < AquaFrame.getAquaWidth() / 2)
                swimmi.setX_dir(1);
            else
                swimmi.setX_dir(-1);

            // direction according to y-axis
            if (swimmi.getY_front() > AquaFrame.getAquaHeight() / 2)
                swimmi.setY_dir(-1);
            else
                swimmi.setY_dir(1);

            // if the fish is inline with the worm
            if ((swimmi.getX_front() >= (AquaFrame.getAquaWidth() / 2 - 5) && swimmi.getX_front() <= (AquaFrame.getAquaWidth() / 2 + 5)) || (swimmi.getY_front() >= (AquaFrame.getAquaHeight() / 2 - 5) && swimmi.getY_front() <= (AquaFrame.getAquaHeight() / 2 + 5))) {
                if (swimmi.getX_front() >= (AquaFrame.getAquaWidth() / 2 - 5) && swimmi.getX_front() <= (AquaFrame.getAquaWidth() / 2 + 5)) // on the x-axis move only in y-axis
                    swimmi.setY_front(swimmi.getY_front() + (swimmi.getVerSpeed() * swimmi.getY_dir()));

                if (swimmi.getY_front() >= (AquaFrame.getAquaHeight() / 2 - 5) && swimmi.getY_front() <= (AquaFrame.getAquaHeight() / 2 + 5)) { // on y-axis move only in x-axis
                    swimmi.setX_front(swimmi.getX_front() + (swimmi.getHorSpeed() * swimmi.getX_dir()));
                }
                // fish is in the 5px perimeter of the worm
                if ((swimmi.getX_front() >= (AquaFrame.getAquaWidth() / 2 - 5) && swimmi.getX_front() <= (AquaFrame.getAquaWidth() / 2 + 5)) && (swimmi.getY_front() >= (AquaFrame.getAquaHeight() / 2 - 5) && swimmi.getY_front() <= (AquaFrame.getAquaHeight() / 2 + 5))) {
                    AquaPanel.setFood(false);
                    swimmi.eatInc();
                }
            } else { // move to the center in diagonal
                swimmi.setY_front(swimmi.getY_front() + swimmi.getVerSpeed() * swimmi.getY_dir());
                swimmi.setX_front(swimmi.getX_front() + swimmi.getHorSpeed() * swimmi.getX_dir());
            }
        } else {
            swimmi.setY_front(swimmi.getY_front() + swimmi.getVerSpeed() * swimmi.getY_dir());
            swimmi.setX_front(swimmi.getX_front() + swimmi.getHorSpeed() * swimmi.getX_dir());
        }
    }
}
