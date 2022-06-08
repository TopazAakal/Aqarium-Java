package GUI.Memento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import DesignPatterns.Memento.CareTaker;
import DesignPatterns.Memento.Originator;
import GUI.AquaPanel;
import SeaCreatures.*;

/**
 * A class for GUI.Memento.JPanelMemento
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class JPanelMemento extends JPanel {
    HashSet<SeaCreatures.Swimmable> animals;
    HashSet<SeaCreatures.Immobile> plants;
    AquaPanel aqua;
    Originator originator;
    static CareTaker careTaker = new CareTaker();

    /**
     * Instantiates a new J panel memento.
     *
     * @param aqua the aqua
     */
    public JPanelMemento(AquaPanel aqua) {

        this.aqua = aqua;
        animals = aqua.getAnimals();
        plants = aqua.getPlants();
        for (Swimmable swimmi : animals) {
            this.add(createObjPane(swimmi));
        }
        for (Immobile planti : plants) {
            this.add(createObjPane(planti));
        }
        JButton restoreBtn = new JButton("Restore Object State");
        restoreBtn.setFont(new Font("David", Font.PLAIN, 16));
        restoreBtn.setBackground(new Color(25, 52, 103));
        restoreBtn.setSize(50, 30);
        restoreBtn.setForeground(Color.white);

        restoreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanelRestoreStates rest = new JPanelRestoreStates();
                JFrame restore = new JFrame();
                restore.setTitle("Restore");
                restore.setSize(1000, 700);
                restore.getContentPane().add(rest);
                restore.setVisible(true);

                JComponent comp = (JComponent) e.getSource();
                Window win =SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });

        this.add(restoreBtn);
    }

    /**
     * Create obj pane JPpanel.
     *
     * @param animal the animal
     * @return the JPanel
     */
    public JPanel createObjPane(Swimmable animal) {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        DefaultTableModel model = new DefaultTableModel(new String[]{"Animal", "Color(RGB)", "Size", "Hor.speed", "Ver.speed", "x-axis", "y-axis" }, 0);
        model.addRow(animal.getInfo());
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(800, 40));
        JButton saveStateBtn = new JButton("Save State");
        saveStateBtn.setFont(new Font("David", Font.PLAIN, 16));
        saveStateBtn.setBackground(new Color(138, 40, 92));
        saveStateBtn.setSize(50, 30);
        saveStateBtn.setForeground(Color.white);

        saveStateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originator=new Originator();
                originator.setState(animal.getInfo(), animal);
                careTaker.add(originator.saveStateToMementoAnimal());

                JComponent comp = (JComponent) e.getSource();
                Window win =SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });

        pane.add(scroll);
        pane.add(saveStateBtn);

        return pane;
    }

    /**
     * Create obj pane JPanel.
     *
     * @param plant the plant
     * @return the JPanel
     */
    public JPanel createObjPane(Immobile plant) {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        DefaultTableModel model = new DefaultTableModel(new String[]{"plant", "Color(RGB)", "Size", "x-axis", "y-axis" }, 0);
        model.addRow(plant.getInfo());
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(800, 40));
        JButton saveStateBtn = new JButton("Save State");
        saveStateBtn.setFont(new Font("David", Font.PLAIN, 16));
        saveStateBtn.setBackground(new Color(138, 40, 92));
        saveStateBtn.setSize(50, 30);
        saveStateBtn.setForeground(Color.white);

        saveStateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originator=new Originator();
                originator.setState(plant.getInfo(), plant);
                careTaker.add(originator.saveStateToMementoPlant());
            }
        });

        pane.add(scroll);
        pane.add(saveStateBtn);

        return pane;
    }

    /**
     * Gets care taker.
     *
     * @return the care taker
     */
    public static CareTaker getCareTaker() {
        return careTaker;
    }
}

