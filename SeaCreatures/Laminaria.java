package SeaCreatures;

import java.awt.*;

/**
 * A class for save SeaCreatures.Laminaria object and perform actions
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Laminaria extends Immobile {
    private Color color = new Color(0, 153, 0);
    private int size, x_front, y_front;

    /**
     * Instantiates a new SeaCreatures.Laminaria.
     *
     * @param size the size
     * @param x    the x
     * @param y    the y
     */
    public Laminaria(int size, int x, int y) {
        super("SeaCreatures.Laminaria");
        this.size = size;

        this.x_front = x;
        this.y_front = y;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getX_front() {
        return x_front;
    }

    public int getY_front() {
        return y_front;
    }

    public boolean setColor(Color color) {
        this.color = color;
        return true;
    }

    public boolean setSize(int size) {
        this.size = size;
        return true;
    }

    public void setX_front(int x_front) {
        this.x_front = x_front;
    }

    public void setY_front(int y_front) {
        this.y_front = y_front;
    }

    @Override
    public void drawCreature(Graphics g) {
        g.setColor(color);

        g.fillArc(x_front - size / 20, y_front - size, size / 10, size * 4 / 5, 0, 360);
        g.fillArc(x_front - size * 3 / 20, y_front - size * 13 / 15, size / 10, size * 2 / 3, 0, 360);
        g.fillArc(x_front + size / 20, y_front - size * 13 / 15, size / 10, size * 2 / 3, 0, 360);

        g.drawLine(x_front, y_front, x_front, y_front - size / 5);
        g.drawLine(x_front, y_front, x_front - size / 10, y_front - size / 5);
        g.drawLine(x_front, y_front, x_front + size / 10, y_front - size / 5);

    }
}
