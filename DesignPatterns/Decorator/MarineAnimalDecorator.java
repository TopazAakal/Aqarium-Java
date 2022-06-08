package DesignPatterns.Decorator;

import SeaCreatures.*;
import java.awt.*;
/**
 * A class for DataPatterns.Decorator.MarineAnimalDecorator part of the prototype pattern
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class MarineAnimalDecorator implements MarineAnimal {
    MarineAnimal marine;
    static Color col;
    Swimmable animal;

    /**
     * Instantiates a new Marine animal decorator.
     *
     * @param ani the ani
     */
    public MarineAnimalDecorator(Swimmable ani) {
        this.animal = ani;
    }

    /**
     * Gets col.
     *
     * @return the col
     */
    public static Color getCol() {
        return col;
    }

    /**
     * Sets col.
     *
     * @param colo the colo
     */
    public static void setCol(Color colo) {
        col = colo;
    }

    @Override
    public void PaintFish() {
       animal.PaintFish();
    }


}
