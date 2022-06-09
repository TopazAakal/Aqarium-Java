package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

import DesignPatterns.AbstractFactory.AddSeaCreature;
import DesignPatterns.AbstractFactory.SeaCreature;
import SeaCreatures.*;

/**
 * A class for creating the panel of the aquarium
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class AquaPanel extends JPanel implements PropertyChangeListener {
    private HashSet<Swimmable> animals = new HashSet<Swimmable>();
    private HashSet<Immobile> plants = new HashSet<Immobile>();
    final static String IMAGE_PATH = "aqua.jpeg";
    private Image image;
    private int count = 0, countPlants = 0;
    private static boolean food = false;

    /**
     * Instantiates a new Aqua panel.
     */
    public AquaPanel() {
        setBackground(Color.gray);
        image = null;
    }

    /**
     * Get animals hash set.
     *
     * @return the hash set
     */
    public HashSet<SeaCreatures.Swimmable> getAnimals(){
        return animals;
    }

    /**
     * Get plants hash set.
     *
     * @return the hash set
     */
    public HashSet<SeaCreatures.Immobile> getPlants(){
        return plants;
    }

    /**
     * if there is food in the aquarium
     *
     * @return if there is food in the aquarium
     */
    public static boolean isFood() {
        return food;
    }

    /**
     * update the "food" flag
     *
     * @param food boolean
     */
    public static void setFood(boolean food) {
        AquaPanel.food = food;
    }

    /**
     * @return how many animals are in the aquarium
     */
    public int getCount(String type) {
        if (type.equals("Animal"))
            return count;
        else if (type.equals("Plant"))
            return countPlants;
        else
            return 0;
    }

    /**
     * creates and send the barrier to all animals in tank
     */
    public void setBar() {
        CyclicBarrier bar = new CyclicBarrier(getHashSize());
        for (Swimmable swim : animals) {
            swim.setBarrier(bar);
        }
    }

    /**
     * get the information to update the info table
     *
     * @param index int
     * @return Animal Info
     */
    public String[] getAnimalInfo(int index) {
        String[] info = new String[6];
        Swimmable[] animalsArray = new Swimmable[getHashSize()];

        int i = 0;
        for (Swimmable swim : animals) {
            animalsArray[i++] = swim;
        }

        info[0] = animalsArray[index].getAnimalName();
        info[1] = animalsArray[index].getColor();
        info[2] = String.valueOf(animalsArray[index].getSize());
        info[3] = String.valueOf(animalsArray[index].getHorSpeed());
        info[4] = String.valueOf(animalsArray[index].getVerSpeed());
        info[5] = String.valueOf(animalsArray[index].getEatCount());

        return info;
    }

    /**
     * Gets hashSet size.
     *
     * @return the hashSet size
     */
    public int getHashSize() {
        return animals.size();
    }

    /**
     * Gets hashSet size.
     *
     * @return the hashSet size
     */
    public int getHashSizePlants() {
        return plants.size();
    }

    /**
     * Add fish to  animals (HashSet).
     *
     * @param size  the size
     * @param x     the x
     * @param y     the y
     * @param hor   the hor
     * @param ver   the ver
     * @param color the color
     */
    public void addFishToAnimals(int size, int x, int y, int hor, int ver, int color, int freq) {

        AddSeaCreature creature = new AddSeaCreature("Animal", "Fish", new int[]{size, x, y, hor, ver, color, freq});
        SeaCreature f = creature.getSeaCreature();
        animals.add((Swimmable) f);
        ((Swimmable) f).addPropertyChangeListener(this);
        count++;
        Thread t = new Thread((Swimmable) f);
        t.start();
    }

    /**
     * Add fish to animals.
     *
     * @param fish the fish
     */
    public void addFishToAnimals(Swimmable fish) {
        animals.add(fish);
        count++;
        (fish).addPropertyChangeListener(this);
        Thread t = new Thread(fish);
        t.start();
    }

    /**
     * Add jellyfish to animals (HashSet).
     *
     * @param size  the size
     * @param x     the x
     * @param y     the y
     * @param hor   the hor
     * @param ver   the ver
     * @param color the color
     */
    public void addJellyFishToAnimals(int size, int x, int y, int hor, int ver, int color, int freq) {
        AddSeaCreature creature = new AddSeaCreature("Animal", "JellyFish", new int[]{size, x, y, hor, ver, color, freq});
        SeaCreature j = creature.getSeaCreature();
        animals.add((Swimmable) j);
        count++;
        ((Swimmable) j).addPropertyChangeListener(this);
        new Thread((Swimmable) j).start();
    }

    /**
     * Add jelly fish to animals.
     *
     * @param jellyfish the jellyfish
     */
    public void addJellyFishToAnimals(Swimmable jellyfish) {
        animals.add(jellyfish);
        count++;
        (jellyfish).addPropertyChangeListener(this);
        Thread t = new Thread(jellyfish);
        t.start();
    }

    /**
     * Add laminaria to plants.
     *
     * @param size the size
     * @param x    the x
     * @param y    the y
     */
    public void addLaminariaToPlants(int size, int x, int y) {
        AddSeaCreature creature = new AddSeaCreature("Plant", "Laminaria", new int[]{size, x, y});
        SeaCreature l = creature.getSeaCreature();
        plants.add((Immobile) l);
        countPlants++;
    }

    /**
     * Add zostera to plants.
     *
     * @param size the size
     * @param x    the x
     * @param y    the y
     */
    public void addZosteraToPlants(int size, int x, int y) {
        AddSeaCreature creature = new AddSeaCreature("Plant", "Zostera", new int[]{size, x, y});
        SeaCreature z = creature.getSeaCreature();
        plants.add((Immobile) z);
        countPlants++;
    }

    /**
     * the method clear the HashSet and kill the animals Threads.
     */
    public void removeFromAnimals() {
        for (Swimmable animal : animals) {
            animal.setTimer(false); // to end the threads
        }
        animals.clear();
        count = 0;
        repaint();
    }

    /**
     * Remove from plants.
     */
    public void removeFromPlants() {
        plants.clear();
        countPlants = 0;
        repaint();
    }

    /**
     * tells all animals in fish tank to sleep
     */
    public void goToSleep() {
        if (!animals.isEmpty()) {
            for (Swimmable swim : animals) {
                swim.setSuspend();
            }
        }
    }

    /**
     * tells all animals in fish tank to wake up
     */
    public void wakeUp() {
        if (!animals.isEmpty()) {
            for (Swimmable swim : animals) {
                swim.setResume();
            }
        }
    }

    /**
     * Sets the background image
     *
     * @param img Image
     */
    public void setImage(Image img) {
        this.image = img;
        repaint();
    }

    /**
     * main painting method invoke all drwaing necessary
     *
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Dimension dm = getSize();

        if (image != null)
            g.drawImage(image, 0, 0, dm.width, dm.height, this); // change the background

        if (!animals.isEmpty()) { // draw the new animal
            for (Swimmable swim : animals) {
                swim.drawCreature(g);
            }
        }

        if (!plants.isEmpty()) {
            for (Immobile imm : plants) {
                imm.drawCreature(g);
            }
        }

        if (food) { // draw the worm
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(3));
            g2.drawArc(getWidth() / 2, getHeight() / 2 - 5, 10, 10, 30, 210);
            g2.drawArc(getWidth() / 2, getHeight() / 2 + 5, 10, 10, 180, 270);
            g2.setStroke(new BasicStroke(1));
        }
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JDialog dialog = new JDialog();
        dialog.setSize(200,100);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(evt.getPropertyName());
        JButton OKBtn = new JButton("Ok");
        OKBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                dialog.setVisible(false);
            }
        });
        JPanel okPanel = new JPanel();
        okPanel.add(OKBtn);
        mainPanel.add(label);
        dialog.add(okPanel,BorderLayout.SOUTH);
        dialog.add(mainPanel,BorderLayout.CENTER);
        dialog.setLocationRelativeTo(this);
        dialog.setBackground(Color.white);
        dialog.setVisible(true);
    }
}
