package GUI.Decorator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import DesignPatterns.Decorator.MarineAnimalDecorator;
import GUI.AquaPanel;
import SeaCreatures.*;

/**
 * A class for JPanel Decorator
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class JPanelDecorator extends JPanel {
    HashSet<Swimmable> animals;
    AquaPanel aqua;
    MarineAnimalDecorator Marine;

    /**
     * Instantiates a new JPanel decorator.
     *
     * @param aqua the aqua
     */
    public JPanelDecorator(AquaPanel aqua) {
        this.aqua = aqua;
        animals = aqua.getAnimals();
        for (Swimmable swimmi : animals) {
            this.add(createObjPane(swimmi));
        }
    }

    /**
     * Create obj pane JPanel.
     *
     * @param animal the animal
     * @return the JPanel
     */
    public JPanel createObjPane(Swimmable animal) {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        DefaultTableModel model = new DefaultTableModel(new String[]{"Animal", "Color(RGB)", "Size", "Hor.speed", "Ver.speed"}, 0);
        model.addRow(animal.getInfo());
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(800, 40));
        JButton ChangeColorBtn = new JButton("Change Color");
        ChangeColorBtn.setFont(new Font("David", Font.PLAIN, 16));
        ChangeColorBtn.setBackground(new Color(108, 96, 134));
        ChangeColorBtn.setSize(50, 30);
        ChangeColorBtn.setForeground(Color.white);

        ChangeColorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(aqua, "Change Animal Color", Color.WHITE);
                if (newColor != null)
                    Marine = new MarineAnimalDecorator(animal);
                MarineAnimalDecorator.setCol(newColor);
                Marine.PaintFish();

                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();

            }
        });

        pane.add(scroll);
        pane.add(ChangeColorBtn);

        return pane;
    }
}
