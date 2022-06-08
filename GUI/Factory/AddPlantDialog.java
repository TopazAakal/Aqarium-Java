package GUI.Factory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import GUI.AquaPanel;
import SeaCreatures.*;

/**
 * A class for creating the dialog window for the "add plant" button
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */

public class AddPlantDialog extends JDialog implements ActionListener {
    private JRadioButton Laminaria, Zostera;
    private int size = 100;
    private ButtonGroup group;
    private String plant = "Laminaria";
    AquaPanel panel;
    JButton addPlantBtn;
    private JSlider sizeSlider;
    private static int x = 10;

    /**
     * Instantiates a new Add animal dialog.
     *
     * @param pane the pane
     */
    public AddPlantDialog(AquaPanel pane) {
        JDialog dialog = new JDialog(); //create a new dialog window
        dialog.setTitle("Add Plant"); //set the title of the dialog
        dialog.setSize(250, 350); //set the size of the dialog
        dialog.setLocationRelativeTo(pane);

        panel = pane;

        //DIALOG PANEL SETTINGS
        JPanel dialogPanel = new JPanel();

        //GENERAL PANEL SETTINGS
        JPanel GeneralPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        GeneralPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GeneralPanel.setPreferredSize(new Dimension(250, 250));

        //TYPE PANEL SETTINGS
        JPanel typePanel = new JPanel();
        typePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Type:"),
                BorderFactory.createEmptyBorder(20, 0, 0, 0)));

        //SIZE PANEL SETTINGS
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Size:"),
                BorderFactory.createEmptyBorder(10, 5, 0, 5)));

        //BUTTONS PANEL SETTINGS
        JPanel btnPannel = new JPanel();
        btnPannel.setPreferredSize(new Dimension(80, 40));

        GeneralPanel.add(typePanel);
        GeneralPanel.add(sizePanel);


        Laminaria = new JRadioButton("Laminaria");
        Laminaria.setSelected(true);
        Laminaria.setActionCommand("Laminaria");
        Zostera = new JRadioButton("Zostera");
        Zostera.setActionCommand("Zostera");
        group = new ButtonGroup();
        group.add(Laminaria);
        group.add(Zostera);
        Laminaria.addActionListener(this);
        Zostera.addActionListener(this);

        //Add them to the panel
        typePanel.add(Laminaria);
        typePanel.add(Zostera);


        //Create a slider to the size panel
        sizeSlider = new JSlider(100, 400);
        sizeSlider.setOrientation(JSlider.HORIZONTAL);
        sizeSlider.setMinorTickSpacing(0);
        sizeSlider.setMajorTickSpacing(70);
        sizeSlider.setValue(70);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        JLabel label = new JLabel();

        sizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                label.setText(String.format("selected : %d", sizeSlider.getValue()));
                size = sizeSlider.getValue();
            }
        });

        sizePanel.add(label);
        sizePanel.add(sizeSlider);

        addPlantBtn = new JButton("Add");
        addPlantBtn.setPreferredSize(new Dimension(80, 30));
        addPlantBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                x = rnd.nextInt(980);
                if (plant.equals("Laminaria"))
                    panel.addLaminariaToPlants(size, x, 510);
                else if (plant.equals("Zostera"))
                    panel.addZosteraToPlants(size, x, 510);

                dialog.dispose(); // Or whatever else
                dialog.setVisible(false);
            }
        });

        btnPannel.add(addPlantBtn);
        dialogPanel.add(GeneralPanel, BorderLayout.NORTH);
        dialogPanel.add(btnPannel, BorderLayout.SOUTH);

        //Adding the general panel to the dialogs
        dialog.add(dialogPanel);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if the user clicks on one of the types
        if (e.getSource().equals(Laminaria)) {
            plant = e.getActionCommand();
        } else if (e.getSource().equals(Zostera)) {
            plant = e.getActionCommand();
        }
    }
}
