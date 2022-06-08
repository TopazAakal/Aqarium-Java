package SeaCreatures;

import DesignPatterns.AbstractFactory.SeaCreature;
import DesignPatterns.Decorator.MarineAnimal;
import DesignPatterns.Decorator.MarineAnimalDecorator;
import DesignPatterns.State.HungerState;
import DesignPatterns.State.Satiated;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.CyclicBarrier;

/**
 * A class for saving swimmable objects and perform actions
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public abstract class Swimmable extends Thread implements SeaCreature, Cloneable, MarineAnimal {
    protected int horSpeed, verSpeed, col;
    protected Color color;
    public PropertyChangeSupport support;
    HungerState state = new Satiated();

    ///////////////////////////////////////////////////////////////////////////////////
    // **************************** constructors **************************** //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * Instantiates a new SeaCreatures.Swimmable.
     */
    public Swimmable() {
        horSpeed = 0;
        verSpeed = 0;
        support = new PropertyChangeSupport(this);

    }

    /**
     * Instantiates a new SeaCreatures.Swimmable.
     *
     * @param hor the hor
     * @param ver the ver
     */
    public Swimmable(int hor, int ver) {
        horSpeed = hor;
        verSpeed = ver;
        support = new PropertyChangeSupport(this);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // **************************** Getters And Setters **************************** //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * Gets hor speed.
     *
     * @return the hor speed
     */
    public int getHorSpeed() {
        return horSpeed;
    }

    /**
     * Gets ver speed.
     *
     * @return the ver speed
     */
    public int getVerSpeed() {
        return verSpeed;
    }

    /**
     * Sets hor speed.
     *
     * @param hor the hor
     */
    public void setHorSpeed(int hor) {
        horSpeed = hor;
    }

    /**
     * Sets ver speed.
     *
     * @param ver the ver
     */
    public void setVerSpeed(int ver) {
        verSpeed = ver;
    }

//ABSTRACT METHODS
    abstract public String getAnimalName();
    abstract public int getFreq();
    abstract public void setFreq(int freq);
    abstract public String getColor();
    abstract public void setCol(int col);
    abstract public int getSize();
    abstract public void setSize(int size);
    abstract public int getX_front();
    abstract public void setX_front(int x_front);
    abstract public int getX_dir();
    abstract public void setX_dir(int x_dir);
    abstract public int getY_front();
    abstract public void setY_front(int x_front);
    abstract public int getY_dir();
    abstract public void setY_dir(int y_dir);
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public void setTimer(Boolean timer);
    abstract public int getEatCount();
    abstract public int getCountMovements();
    abstract public void setCountMovements(int countMovements);
    abstract public void drawCreature(Graphics g);
    abstract public void eatInc();
    abstract public void run();

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
        this.col = 10;
    }

    /**
     * Gets color rgb.
     *
     * @return the color rgb
     */
    public Color getColorRGB() {
        return color;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return clone;
    }

    /**
     * Get info string [ ].
     *
     * @return the string [ ]
     */
    public String[] getInfo() {
        return new String[]{getAnimalName(), "(" + String.valueOf(getColorRGB().getRed()) + "," + String.valueOf(getColorRGB().getGreen()) + "," + String.valueOf(getColorRGB().getBlue()) + ")", String.valueOf(getSize()), String.valueOf(getHorSpeed()), String.valueOf(getVerSpeed()), String.valueOf(getX_front()), String.valueOf(getY_front())};
    }

    /**
     * Add property change listener.
     *
     * @param pcl the pcl
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /**
     * Remove property change listener.
     *
     * @param pcl the pcl
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public void PaintFish() {
        this.setColor(MarineAnimalDecorator.getCol());
    }

    /**
     * Gets state hunger.
     *
     * @return the state hunger
     */
    public HungerState getStateHunger() {
        return state;
    }

    /**
     * Sets state hunger.
     *
     * @param state the state
     */
    public void setStateHunger(HungerState state) {
        this.state = state;
    }


}
