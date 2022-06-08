package SeaCreatures;

import DesignPatterns.Decorator.MarineAnimal;
import DesignPatterns.State.Satiated;
import GUI.*;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * A class for save SeaCreatures.Fish object and perform actions
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Fish extends Swimmable implements MarineAnimal {
    private Boolean timer = true, suspended = false;
    private CyclicBarrier barrier = null;
    private final int EAT_DISTANCE = 4;
    private int size, freq, countMovements = 0, eatCount, x_front, y_front, x_dir, y_dir;

    ///////////////////////////////////////////////////////////////////////////////////
    // **************************** constructors **************************** //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * Instantiates a new SeaCreatures.Fish.
     *
     * @param size     the size
     * @param x_front  the x front
     * @param y_front  the y front
     * @param horSpeed the hor speed
     * @param verSpeed the ver speed
     * @param col      the col
     * @param freq     the freq
     */
    public Fish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col, int freq) {
        super(horSpeed, verSpeed);
        this.size = size;
        this.x_front = x_front;
        this.y_front = y_front;
        this.col = col;
        this.eatCount = 0;
        this.x_dir = 1;
        this.y_dir = 1;
        this.freq = freq;
        setCol(col);
    }

    /**
     * Instantiates a new SeaCreatures.Fish.
     */
    public Fish() {
        this(0, 0, 0, 0, 0, 1, 10);
    }

    /**
     * Instantiates a new SeaCreatures.Fish.
     *
     * @param other the other
     */
    public Fish(Fish other) {
        this();
        if (other != null) {
            this.horSpeed = other.horSpeed;
            this.verSpeed = other.verSpeed;
            this.size = other.size;
            this.col = other.col;
            this.eatCount = other.eatCount;
            this.x_front = other.x_front;
            this.y_front = other.y_front;
            this.x_dir = other.x_dir;
            this.y_dir = other.y_dir;
            this.freq = other.freq;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // **************************** Getters And Setters **************************** //
    ///////////////////////////////////////////////////////////////////////////////////

    /** Get frequency
     *
     * @return hunger frequency
     */
    public int getFreq() {
        return freq;
    }

    /** Set frequency
     *
     * @param  freq int
     */
    public void setFreq(int freq) {
        this.freq = freq;
    }

    /**
     * Gets eat distance.
     *
     * @return the eat distance
     */
    public final int getEAT_DISTANCE() {
        return EAT_DISTANCE;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets col.
     *
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets col.
     *
     * @param col the col
     */
    public void setCol(int col) {
        this.col = col;
        switch (col) {
            case 1:
                this.color = Color.black;
                break;
            case 2:
                this.color = Color.red;
                break;
            case 3:
                this.color = Color.blue;
                break;
            case 4:
                this.color = Color.green;
                break;
            case 5:
                this.color = Color.cyan;
                break;
            case 6:
                this.color = Color.orange;
                break;
            case 7:
                this.color = Color.yellow;
                break;
            case 8:
                this.color = Color.magenta;
                break;
            case 9:
                this.color = Color.pink;
                break;
        }

    }

    /**
     * @return how much does the ate
     */
    @Override
    public int getEatCount() {
        return eatCount;
    }

    /**
     * Sets eat count.
     *
     * @param eatCount the eat count
     */
    public void setEatCount(int eatCount) {
        this.eatCount = eatCount;
    }

    /**
     * Gets x front.
     *
     * @return the x front
     */
    public int getX_front() {
        return x_front;
    }

    /**
     * Sets x front.
     *
     * @param x_front the x front
     */
    public void setX_front(int x_front) {
        this.x_front = x_front;
    }

    /**
     * Gets y front.
     *
     * @return the y front
     */
    public int getY_front() {
        return y_front;
    }

    /**
     * Sets y front.
     *
     * @param y_front the y front
     */
    public void setY_front(int y_front) {
        this.y_front = y_front;

    }

    /**
     * Gets x dir.
     *
     * @return the x dir
     */
    public int getX_dir() {
        return x_dir;
    }

    /**
     * Sets x dir.
     *
     * @param x_dir the x dir
     */
    public void setX_dir(int x_dir) {
        this.x_dir = x_dir;

    }

    /**
     * Gets y dir.
     *
     * @return the y dir
     */
    public int getY_dir() {
        return y_dir;
    }

    /**
     * Sets y dir.
     *
     * @param y_dir the y dir
     */
    public void setY_dir(int y_dir) {
        this.y_dir = y_dir;
    }

    /**
     * get the string representation of the color
     *
     * @return color name
     */
    @Override
    public String getColor() {
        switch (this.getCol()) {
            case 1:
                return "Black";
            case 2:
                return "Red";
            case 3:
                return "Blue";
            case 4:
                return "Green";
            case 5:
                return "Cyan";
            case 6:
                return "Orange";
            case 7:
                return "Yellow";
            case 8:
                return "Magenta";
            case 9:
                return "Pink";
            default:
                return "(" + String.valueOf(getColorRGB().getRed()) + "," + String.valueOf(getColorRGB().getGreen()) + "," + String.valueOf(getColorRGB().getBlue()) + ")";
        }
    }

    /**
     * returns the name of the animal
     */
    public String getAnimalName() {
        return "SeaCreatures.Fish";
    }

    /** how many movements
     *
     * @return how many movements
     */
    public int getCountMovements() {
        return countMovements;
    }

    /** setCountMovements
     *
     * @param countMovements int
     */
    public void setCountMovements(int countMovements) {
        this.countMovements = countMovements;
    }

    /**
     * method to notify the thread
     */
    @Override
    synchronized public void setResume() {
        suspended = false;
        notify();
    }

    /**
     * update the barrier field
     *
     * @param b (CyclicBarrier)
     */
    @Override
    public void setBarrier(CyclicBarrier b) {
        this.barrier = b;
    }

    /**
     * timer is the flag for the thread run method if true thread is alive else thread is dead
     *
     * @param timer Boolean
     */
    public void setTimer(Boolean timer) {
        this.timer = timer;
    }

    /**
     * if true th thread will be suspended
     */
    @Override
    public void setSuspend() {
        suspended = true;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // **************************** auxiliary methods **************************** //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * Change fish. changing the fish size and reset count
     */
    public void changeFish() {
        setSize(this.getSize() + 1);
        setEatCount(0);
    }

    /**
     * Change fish color.
     */
    public void changeColor(int c) {
        setCol(c);
    }

    /**
     * eating action
     */
    @Override
    public void eatInc() {
        countMovements = 0;
        setStateHunger(new Satiated());
        if (eatCount < EAT_DISTANCE)
            eatCount++;
        else
            changeFish();
    }

    @Override
    public String toString() {
        return "SeaCreatures.Fish{" +
                "EAT_DISTANCE=" + EAT_DISTANCE +
                ", size=" + size +
                ", col=" + col +
                ", eatCount=" + eatCount +
                ", x_front=" + x_front +
                ", y_front=" + y_front +
                ", x_dir=" + x_dir +
                ", y_dir=" + y_dir +
                '}';
    }

    @Override
    public Object clone() {
        return new Fish(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fish)) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return getEAT_DISTANCE() == fish.getEAT_DISTANCE() && getSize() == fish.getSize() && getCol() == fish.getCol() && getEatCount() == fish.getEatCount() && getX_front() == fish.getX_front() && getY_front() == fish.getY_front() && getX_dir() == fish.getX_dir() && getY_dir() == fish.getY_dir();
    }

    /**
     * a method to invoke draw animal
     *
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        drawCreature(g);
    }

    /**
     * method for drawing the fish on the screen
     *
     * @param g Graphics
     */
    @Override
    public void drawCreature(Graphics g) {
        g.setColor(color);
        if (x_dir == 1) // fish swims to right side
        {
            // Body of fish
            g.fillOval(x_front - size, y_front - size / 4, size, size / 2);

            // Tail of fish
            int[] x_t = {x_front - size - size / 4, x_front - size - size / 4, x_front - size};
            int[] y_t = {y_front - size / 4, y_front + size / 4, y_front};
            Polygon t = new Polygon(x_t, y_t, 3);
            g.fillPolygon(t);

            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue()));
            g2.fillOval(x_front - size / 5, y_front - size / 10, size / 10, size / 10);

            // Mouth of fish
            if (size > 70)
                g2.setStroke(new BasicStroke(3));
            else if (size > 30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front - size / 10, y_front + size / 10);
            g2.setStroke(new BasicStroke(1));
        } else // fish swims to left side
        {
            // Body of fish
            g.fillOval(x_front, y_front - size / 4, size, size / 2);

            // Tail of fish
            int[] x_t = {x_front + size + size / 4, x_front + size + size / 4, x_front + size};
            int[] y_t = {y_front - size / 4, y_front + size / 4, y_front};
            Polygon t = new Polygon(x_t, y_t, 3);
            g.fillPolygon(t);

            // Eye of fish
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue()));
            g2.fillOval(x_front + size / 10, y_front - size / 10, size / 10, size / 10);

            // Mouth of fish
            if (size > 70)
                g2.setStroke(new BasicStroke(3));
            else if (size > 30)
                g2.setStroke(new BasicStroke(2));
            else
                g2.setStroke(new BasicStroke(1));
            g2.drawLine(x_front, y_front, x_front + size / 10, y_front + size / 10);
            g2.setStroke(new BasicStroke(1));
        }
    }

    /**
     * the way the fish moves
     */
    public void swim() {
        // the panel border
        if (this.getX_front() >= AquaFrame.getAquaWidth() - 10 || this.getX_front() <= 10) {
            this.setX_dir(this.getX_dir() * -1);
            this.setCountMovements(this.getCountMovements() + 1);
        }

        if (this.getY_front() >= AquaFrame.getAquaHeight() - 10 || this.getY_front() <= 10)
            this.setY_dir(this.getY_dir() * -1);

        if (AquaPanel.isFood()) {
            // the barrier all thread waiting till everyone knows there is food
            if (barrier != null) {
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
        if (state != null)
            state.doAction(this);

    }

    /**
     * method to manage the thread
     */
    @Override
    public void run() {
        while (timer) {
            synchronized (this) {
                while (suspended) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Sleep ERROR!");
            }

            swim();
        }
    }
}