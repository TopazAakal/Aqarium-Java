package SeaCreatures;

import java.awt.*;
/**
 * A class for save SeaCreatures.Zostera object and perform actions
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class Zostera extends Immobile {
    private Color color = new Color(0, 102, 0);
    private int size, x_front, y_front;

    /**
     * Instantiates a new SeaCreatures.Zostera.
     *
     * @param size the size
     * @param x    the x
     * @param y    the y
     */
    public Zostera(int size, int x, int y) {
        super("SeaCreatures.Zostera");
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(color);
        g.drawLine(x_front, y_front, x_front, y_front - size);
        g.drawLine(x_front - 2, y_front, x_front - 10, y_front - size * 9 / 10);
        g.drawLine(x_front + 2, y_front, x_front + 10, y_front - size * 9 / 10);
        g.drawLine(x_front - 4, y_front, x_front - 20, y_front - size * 4 / 5);
        g.drawLine(x_front + 4, y_front, x_front + 20, y_front - size * 4 / 5);
        g.drawLine(x_front - 6, y_front, x_front - 30, y_front - size * 7 / 10);
        g.drawLine(x_front + 6, y_front, x_front + 30, y_front - size * 7 / 10);
        g.drawLine(x_front - 8, y_front, x_front - 40, y_front - size * 4 / 7);
        g.drawLine(x_front + 8, y_front, x_front + 40, y_front - size * 4 / 7);

        g2.setStroke(new BasicStroke(1));
    }
}
