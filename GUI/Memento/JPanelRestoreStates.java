package GUI.Memento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import DesignPatterns.Memento.MementoAnimal;
import DesignPatterns.Memento.MementoPlant;
import SeaCreatures.*;

/**
 * A class for JPanel Restore States
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class JPanelRestoreStates extends JPanel {

    /**
     * Instantiates a new JPanel restore states.
     */
    public JPanelRestoreStates() {
        List<MementoAnimal> animalData = JPanelMemento.careTaker.getMementoAnimalList();
        List<MementoPlant> plantData = JPanelMemento.careTaker.getMementoPlantList();

        for (MementoAnimal animal : animalData) {
            this.add(createObjPane(animal));
        }
        for (MementoPlant plant : plantData) {
            this.add(createObjPane(plant));
        }
    }

    /**
     * Create obj pane JPanel.
     *
     * @param animal the animal
     * @return the JPanel
     */
    public JPanel createObjPane(MementoAnimal animal) {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());

        DefaultTableModel model = new DefaultTableModel(new String[]{"Animal", "Color(RGB)", "Size", "Hor.speed", "Ver.speed", "x-axis", "y-axis"}, 0);
        model.addRow(animal.getAnimalData());

        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(800, 40));
        JButton restoreBtn = new JButton("Restore");
        restoreBtn.setFont(new Font("David", Font.PLAIN, 16));
        restoreBtn.setBackground(new Color(138, 40, 92));
        restoreBtn.setSize(50, 30);
        restoreBtn.setForeground(Color.white);

        restoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Swimmable ani = animal.getAnimalObj();
                String[] data = animal.getAnimalData();
                ani.setColor(parseRGB(data[1]));
                ani.setSize(Integer.parseInt(data[2]));
                ani.setHorSpeed(Integer.parseInt(data[3]));
                ani.setVerSpeed(Integer.parseInt(data[4]));
                ani.setX_front(Integer.parseInt(data[5]));
                ani.setY_front(Integer.parseInt(data[6]));

                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        pane.add(scroll);
        pane.add(restoreBtn);
        return pane;
    }

    /**
     * Create obj pane JPanel.
     *
     * @param plant the animal
     * @return the JPanel
     */
    public JPanel createObjPane(MementoPlant plant) {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());

        DefaultTableModel model = new DefaultTableModel(new String[]{"plant", "Color(RGB)", "Size", "x-axis", "y-axis"}, 0);
        model.addRow(plant.getPlantData());

        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(800, 40));
        JButton restoreBtn = new JButton("Restore");
        restoreBtn.setFont(new Font("David", Font.PLAIN, 16));
        restoreBtn.setBackground(new Color(138, 40, 92));
        restoreBtn.setSize(50, 30);
        restoreBtn.setForeground(Color.white);

        restoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Immobile planti = plant.getPlanti();
                String[] data = plant.getPlantData();
                planti.setColor(parseRGB(data[1]));
                planti.setSize(Integer.parseInt(data[2]));
                planti.setX_front(Integer.parseInt(data[3]));
                planti.setY_front(Integer.parseInt(data[4]));

                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        pane.add(scroll);
        pane.add(restoreBtn);
        return pane;
    }

    /** a method to convert string to RGB
     *
     * @param col String
     * @return Color
     */
    private Color parseRGB(String col) {
        String text = col;
        String[] colors = text.substring(1, text.length() - 1).split(",");
        Color color = new Color(
                Integer.parseInt(colors[0].trim()),
                Integer.parseInt(colors[1].trim()),
                Integer.parseInt(colors[2].trim())
        );
        return color;
    }
}

