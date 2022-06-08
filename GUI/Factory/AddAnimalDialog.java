package GUI.Factory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AquaPanel;


/**
 * A class for creating the dialog window for the "add animal" button
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */

public class AddAnimalDialog extends JDialog implements ActionListener {
    private String[] names = {"Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink"};
    private JComboBox<String> cmbcolor;
    private JRadioButton fish, jellyFish;
    private JSlider sizeSlider, verSpeed, horSpeed, freq;
    private int size = 70, horSpeedSelected = 5, verSpeedSelected = 5, clr = 2, freqSelected=10;
    private String animal = "Fish";
    private ButtonGroup group;
    JButton addAnimalbtn;
    AquaPanel panel;

    /**
     * Instantiates a new Add animal dialog.
     *
     * @param pane the pane
     */
    public AddAnimalDialog(AquaPanel pane) {
        JDialog dialog = new JDialog(); //create a new dialog window
        dialog.setTitle("Add Animal"); //set the title of the dialog
        dialog.setSize(275, 700); //set the size of the dialog
        dialog.setLocationRelativeTo(pane);
        panel = pane;

        //DIALOG PANEL SETTINGS
        JPanel dialogPanel=new JPanel();

        //GENERAL PANEL SETTINGS
        JPanel GeneralPanel = new JPanel(new GridLayout(6, 1, 0, 0));
        GeneralPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        GeneralPanel.setPreferredSize(new Dimension(250, 600));

        //TYPE PANEL SETTINGS
        JPanel typePanel = new JPanel();
        typePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Type:"),
                BorderFactory.createEmptyBorder(25, 0, 0, 0)));

        //SIZE PANEL SETTINGS
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Size:"),
                BorderFactory.createEmptyBorder(10, 5, 0, 5)));

        //VER PANEL SETTINGS
        JPanel verPanel = new JPanel();
        verPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Ver Speed:"),
                BorderFactory.createEmptyBorder(15, 5, 5, 5)));

        //HOR PANEL SETTINGS
        JPanel horPanel = new JPanel();
        horPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Hor Speed:"),
                BorderFactory.createEmptyBorder(15, 5, 5, 5)));

        //COLOR PANEL SETTINGS
        JPanel colorPanel = new JPanel();
        colorPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Color:"),
                BorderFactory.createEmptyBorder(20, 0, 0, 0)));

        JPanel freqPanel = new JPanel();
        freqPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Frequency:"),
                BorderFactory.createEmptyBorder(15, 5, 5, 5)));


        //BUTTONS PANEL SETTINGS
        JPanel btnPannel = new JPanel();
        btnPannel.setPreferredSize(new Dimension(150,40));


        //Adding all the panels to the general panel
        GeneralPanel.add(typePanel);
        GeneralPanel.add(sizePanel);
        GeneralPanel.add(verPanel);
        GeneralPanel.add(horPanel);
        GeneralPanel.add(freqPanel);
        GeneralPanel.add(colorPanel);


        //Create buttons to the type panel
        fish = new JRadioButton("Fish");
        fish.setSelected(true);
        fish.setActionCommand("Fish");
        jellyFish = new JRadioButton("JellyFish");
        jellyFish.setActionCommand("JellyFish");
        group = new ButtonGroup();
        group.add(fish);
        group.add(jellyFish);
        fish.addActionListener(this);
        jellyFish.addActionListener(this);

        //Add them to the panel
        typePanel.add(fish);
        typePanel.add(jellyFish);

        //Create a comboBox to the color panel
        cmbcolor = new JComboBox<String>(names);
        cmbcolor.setPreferredSize(new Dimension(200, 30));
        cmbcolor.setSelectedIndex(1);
        cmbcolor.addActionListener(this);

        //Add him to the panel
        colorPanel.add(cmbcolor, BorderLayout.CENTER);

        //Create a slider to the hor speed panel
        horSpeed = new JSlider(1, 10);
        horSpeed.setOrientation(JSlider.HORIZONTAL);
        horSpeed.setMinorTickSpacing(1);
        horSpeed.setMajorTickSpacing(1);
        horSpeed.setPaintTicks(true);
        horSpeed.setPaintLabels(true);
        horSpeed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                horSpeedSelected = horSpeed.getValue();
            }
        });
        horPanel.add(horSpeed);
        horSpeedSelected = horSpeed.getValue();

        //Create a slider to the ver speed panel
        verSpeed = new JSlider(1, 10);
        verSpeed.setOrientation(JSlider.HORIZONTAL);
        verSpeed.setMinorTickSpacing(1);
        verSpeed.setMajorTickSpacing(1);
        verSpeed.setPaintTicks(true);
        verSpeed.setPaintLabels(true);

        verSpeed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                verSpeedSelected = verSpeed.getValue();
            }
        });
        verPanel.add(verSpeed);

        //Create a slider to the freq speed panel
        freq = new JSlider(1, 10);
        freq.setOrientation(JSlider.HORIZONTAL);
        freq.setMinorTickSpacing(1);
        freq.setMajorTickSpacing(1);
        freq.setPaintTicks(true);
        freq.setPaintLabels(true);

        freq.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                freqSelected = freq.getValue();
            }
        });
        freqPanel.add(freq);

        //Create a slider to the size panel
        sizeSlider = new JSlider(20, 320);
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


        //Create buttons to the btnPanel
        addAnimalbtn = new JButton("Add");
        addAnimalbtn.setPreferredSize(new Dimension(80,30));
        addAnimalbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (animal.equals("Fish"))
                    panel.addFishToAnimals(size, 300, 50, horSpeedSelected, verSpeedSelected, clr, freqSelected);
                else if (animal.equals("JellyFish"))
                    panel.addJellyFishToAnimals(size, 300, 50, horSpeedSelected, verSpeedSelected, clr,freqSelected);

                dialog.dispose(); // Or whatever else
                dialog.setVisible(false);
            }
        });

        btnPannel.add(addAnimalbtn);
        dialogPanel.add(GeneralPanel,BorderLayout.NORTH);
        dialogPanel.add(btnPannel,BorderLayout.SOUTH);

        //Adding the general panel to the dialogs
        dialog.add(dialogPanel);
        dialog.setVisible(true);
    }

    /**
     * A methods that's responsible for activating the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //if the user clicks on the color box
        if (e.getSource().equals(cmbcolor)) {
            String clr_name = cmbcolor.getItemAt(cmbcolor.getSelectedIndex());
            switch (clr_name) {
                case "Black":
                    clr = 1;
                    break;
                case "Red":
                    clr = 2;
                    break;
                case "Blue":
                    clr = 3;
                    break;
                case "Green":
                    clr = 4;
                    break;
                case "Cyan":
                    clr = 5;
                    break;
                case "Orange":
                    clr = 6;
                    break;
                case "Yellow":
                    clr = 7;
                    break;
                case "Magenta":
                    clr = 8;
                    break;
                case "Pink":
                    clr = 9;
                    break;
            }
        }

        //if the user clicks on one of the types
        if (e.getSource().equals(fish)) {
            animal = e.getActionCommand();
        } else if (e.getSource().equals(jellyFish)) {
            animal = e.getActionCommand();
        }
    }
}



