package GUI.Prototype;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AquaPanel;
import SeaCreatures.*;

/**
 * A class for update Animal after duplicating
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class updateAnimalDiaglos extends JDialog implements ActionListener {
    private String[] names = {"Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink"};
    private JComboBox<String> cmbcolor;
    private JSlider sizeSlider, verSpeed, horSpeed;
    private int size = 70, horSpeedSelected = 5, verSpeedSelected = 5, clr = 2;
    private Swimmable animal;
    JButton updateAnimalBtn;
    AquaPanel panel;

    /**
     * Instantiates a new duplicate animal dialog.
     *
     * @param pane the pane
     */
    public updateAnimalDiaglos(AquaPanel pane, Swimmable swimmi) {
        animal = swimmi;
        JDialog dialog = new JDialog(); //create a new dialog window
        dialog.setTitle("Update Animal"); //set the title of the dialog
        dialog.setSize(275, 700); //set the size of the dialog
        dialog.setLocationRelativeTo(pane);

        panel = pane;

        //DIALOG PANEL SETTINGS
        JPanel dialogPanel = new JPanel();

        //GENERAL PANEL SETTINGS
        JPanel GeneralPanel = new JPanel(new GridLayout(4, 1, 0, 0));
        GeneralPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
        GeneralPanel.setPreferredSize(new Dimension(250, 600));

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

        //BUTTONS PANEL SETTINGS
        JPanel btnPannel = new JPanel();
        btnPannel.setPreferredSize(new Dimension(150, 150));

        //Adding all the panels to the general panel
        GeneralPanel.add(sizePanel);
        GeneralPanel.add(verPanel);
        GeneralPanel.add(horPanel);
        GeneralPanel.add(colorPanel);

        //Create a comboBox to the color panel
        cmbcolor = new JComboBox<String>(names);
        cmbcolor.setPreferredSize(new Dimension(200, 30));
        cmbcolor.setSelectedIndex(0);
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
        ;
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
        updateAnimalBtn = new JButton("Update");
        updateAnimalBtn.setPreferredSize(new Dimension(80, 30));
        updateAnimalBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                animal.setSize(size);
                animal.setHorSpeed(horSpeedSelected);
                animal.setVerSpeed(verSpeedSelected);
                animal.setCol(clr);
                dialog.dispose();
                dialog.setVisible(false);
            }
        });


        btnPannel.add(updateAnimalBtn);
        dialogPanel.add(GeneralPanel, BorderLayout.NORTH);
        dialogPanel.add(btnPannel, BorderLayout.SOUTH);

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

    }

}
