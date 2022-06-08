package SeaCreatures;

import DesignPatterns.AbstractFactory.SeaCreature;

import java.awt.*;

/**
 * A class for saving SeaCreatures.Immobile object and perform actions
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public abstract class Immobile implements SeaCreature {
    String name;

    /**
     * Instantiates a new SeaCreatures.Immobile.
     *
     * @param name the name
     */
    public Immobile(String name) {
        this.name = name;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public abstract Color getColor();

    /**
     * Gets size.
     *
     * @return the size
     */
    public abstract int getSize();

    /**
     * Gets x front.
     *
     * @return the x front
     */
    public abstract int getX_front();

    /**
     * Gets y front.
     *
     * @return the y front
     */
    public abstract int getY_front();

    /**
     * Sets color.
     *
     * @param color the color
     * @return the color
     */
    abstract public boolean setColor(Color color);

    /**
     * Sets size.
     *
     * @param size the size
     * @return the size
     */
    abstract public boolean setSize(int size);

    /**
     * Sets x front.
     *
     * @param x_front the x front
     */
    abstract public void setX_front(int x_front);

    /**
     * Sets y front.
     *
     * @param y_front the y front
     */
    abstract public void setY_front(int y_front);

    /**
     * Get info string [ ].
     *
     * @return the string [ ]
     */
    public String[] getInfo() {
        return new String[]{name, "(" + String.valueOf(getColor().getRed()) + "," + String.valueOf(getColor().getGreen()) + "," + String.valueOf(getColor().getBlue()) + ")", String.valueOf(getSize()), String.valueOf(getX_front()), String.valueOf(getY_front())};
    }
}