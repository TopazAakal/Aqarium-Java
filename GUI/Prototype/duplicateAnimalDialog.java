package GUI.Prototype;

import DesignPatterns.Prototype.SwimmableCache;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AquaPanel;
import SeaCreatures.*;

/**
 * A class for prototype pattern
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class duplicateAnimalDialog extends JDialog implements ActionListener {

    private JRadioButton fish, jellyFish;
    private String animal = "fish";
    private Swimmable swimmi;
    private ButtonGroup group;
    JButton duplicateAnimalbtn;
    JCheckBox updateCbox;
    AquaPanel panel;

    /**
     * Instantiates a new duplicate animal dialog.
     *
     * @param pane the pane
     */
    public duplicateAnimalDialog(AquaPanel pane) {
        JDialog dialog = new JDialog(); //create a new dialog window
        dialog.setTitle("Duplicate Animal"); //set the title of the dialog
        dialog.setSize(250, 200); //set the size of the dialog
        dialog.setLocationRelativeTo(pane);

        panel = pane;

        //GENERAL PANEL SETTINGS
        JPanel GeneralPanel = new JPanel(new GridLayout(5, 1, 0, 0));
        GeneralPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        GeneralPanel.setPreferredSize(new Dimension(250, 600));

        //TYPE PANEL SETTINGS
        JPanel typePanel = new JPanel();
        typePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Type:"),
                BorderFactory.createEmptyBorder(25, 0, 0, 0)));

        //Create buttons to the type panel
        fish = new JRadioButton("Fish");
        fish.setSelected(true);
        fish.setActionCommand("fish");
        jellyFish = new JRadioButton("JellyFish");
        jellyFish.setActionCommand("jellyfish");
        group = new ButtonGroup();
        group.add(fish);
        group.add(jellyFish);
        fish.addActionListener(this);
        jellyFish.addActionListener(this);

        //Add them to the panel
        typePanel.add(fish);
        typePanel.add(jellyFish);


        duplicateAnimalbtn = new JButton("Duplicate");
        duplicateAnimalbtn.setPreferredSize(new Dimension(120, 30));
        duplicateAnimalbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (animal.equals("fish")) {
                    swimmi = SwimmableCache.getSwimmable(animal);
                    panel.addFishToAnimals(swimmi);
                } else if (animal.equals("jellyfish")) {
                    swimmi = SwimmableCache.getSwimmable(animal);
                    panel.addJellyFishToAnimals(swimmi);
                }


                if (updateCbox.isSelected()) {
                    new updateAnimalDiaglos(panel, swimmi);
                }

                dialog.dispose();
                dialog.setVisible(false);
            }

        });


        updateCbox = new JCheckBox("update properties?");
        typePanel.add(updateCbox);
        typePanel.add(duplicateAnimalbtn);


        //Adding to the dialogs
        dialog.add(typePanel);
        dialog.setVisible(true);

    }

    /**
     * A methods that's responsible for activating the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //if the user clicks on one of the types
        if (e.getSource().equals(fish)) {
            animal = e.getActionCommand();
        } else if (e.getSource().equals(jellyFish)) {
            animal = e.getActionCommand();
        }
    }
}
