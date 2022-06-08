package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import DesignPatterns.Prototype.SwimmableCache;
import DesignPatterns.Singleton.Worm;
import GUI.Decorator.JPanelDecorator;
import GUI.Factory.AddAnimalDialog;
import GUI.Factory.AddPlantDialog;
import GUI.Memento.JPanelMemento;
import GUI.Prototype.duplicateAnimalDialog;

/**
 * A class for creating the main frame
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */

public class AquaFrame extends JFrame implements ActionListener {
    JPanel buttons, infoPanel;
    JButton addAnimal, addPlant, sleep, wakeUp, reset, food, info, exit, duplicate, decorator;
    AquaPanel aqua;
    JTable infoTable;
    JMenu menuFile, menuBackground, menuHelp;
    JMenuItem menuItemExit, menuItemImage, menuItemBlue, menuItemNone, menuItemHelp, menuItemMemento;
    private Image image;
    private static Worm worm;
    final static String IMAGE_PATH = "src\\GUI\\Media\\aqua.jpg";
    private boolean flag = true;
    static int aquaWidth, aquaHeight;

    /**
     * Instantiates a new Aqua frame.
     */
    public AquaFrame() {

        buttons = new JPanel(); //Panel that will contain all the buttons
        buttons.setLayout(new GridLayout(1, 10)); //Setting the boundaries of the panel

        //CREATE BUTTONS
        addAnimal = new JButton("Add Animal");
        addPlant = new JButton("Add Plant");
        sleep = new JButton("Sleep");
        wakeUp = new JButton("Wake up");
        reset = new JButton("Reset");
        food = new JButton("Food");
        info = new JButton("Info");
        exit = new JButton("Exit");
        duplicate = new JButton("Duplicate Animal");
        decorator = new JButton("Decorator");

        //Adding the buttons to the buttons panel
        buttons.add(addAnimal);
        buttons.add(addPlant);
        buttons.add(duplicate);
        buttons.add(decorator);
        buttons.add(sleep);
        buttons.add(wakeUp);
        buttons.add(reset);
        buttons.add(food);
        buttons.add(info);
        buttons.add(exit);

        aqua = new AquaPanel(); //Panel that will contain the aquarium
        infoPanel = new JPanel(new BorderLayout(0, 0)); //Panel that will contain the info table

        getContentPane().add(buttons, BorderLayout.SOUTH);
        getContentPane().add(aqua, BorderLayout.CENTER);


        //the file button
        menuFile = new JMenu("File");
        menuBackground = new JMenu("Background");
        menuHelp = new JMenu("Help");

        //the exit button
        menuItemMemento = new JMenuItem("Memento");
        menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemMemento);
        menuFile.add(menuItemExit);

        //the background button
        menuItemImage = new JMenuItem("Image");
        menuItemBlue = new JMenuItem("Blue");
        menuItemNone = new JMenuItem("None");
        menuBackground.add(menuItemImage);
        menuBackground.add(menuItemBlue);
        menuBackground.add(menuItemNone);

        //the help button
        menuItemHelp = new JMenuItem("Help");
        menuHelp.add(menuItemHelp);

        //the menu buttons
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuFile);
        menuBar.add(menuBackground);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        //add action listeners to all objects in the menu
        menuItemExit.addActionListener(this);
        menuItemMemento.addActionListener(this);
        menuItemImage.addActionListener(this);
        menuItemBlue.addActionListener(this);
        menuItemNone.addActionListener(this);
        menuItemHelp.addActionListener(this);

        //add action listeners to all objects in the buttons panel
        addAnimal.addActionListener(this);
        addPlant.addActionListener(this);
        duplicate.addActionListener(this);
        sleep.addActionListener(this);
        wakeUp.addActionListener(this);
        reset.addActionListener(this);
        food.addActionListener(this);
        info.addActionListener(this);
        exit.addActionListener(this);
        decorator.addActionListener(this);

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwimmableCache.loadCache();
        AquaFrame aquaFrame = new AquaFrame();
        aquaFrame.setTitle("My Aquarium");
        aquaFrame.setSize(1295, 600);
        aquaFrame.setResizable(false);
        aquaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aquaFrame.setVisible(true);
    }

    /**
     * method to load the image for the background
     */
    private void loadImage() {
        try {
            image = ImageIO.read(new File(IMAGE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets aqua width.
     *
     * @return the aqua width
     */
    public static int getAquaWidth() {
        return aquaWidth;
    }

    /**
     * Sets aqua width.
     *
     * @param aquaWidth the aqua width
     */
    public static void setAquaWidth(int aquaWidth) {
        AquaFrame.aquaWidth = aquaWidth;
    }

    /**
     * Gets aqua height.
     *
     * @return the aqua height
     */
    public static int getAquaHeight() {
        return aquaHeight;
    }

    /**
     * Sets aqua height.
     *
     * @param aquaHeight the aqua height
     */
    public static void setAquaHeight(int aquaHeight) {
        AquaFrame.aquaHeight = aquaHeight;
    }

    /**
     * A methods that's responsible for activating the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //if the user clicks on the exit button
        if (e.getSource() == menuItemExit) {
            System.exit(0);
        }

        //if the user clicks on the Memento item
        else if (e.getSource() == menuItemMemento) {
            JPanelMemento mem = new JPanelMemento(aqua);
            JFrame memento = new JFrame();
            memento.setTitle("Memento");
            memento.setSize(1000, 700);
            memento.getContentPane().add(mem);
            memento.setVisible(true);
        }

        //if the user clicks on the blue button
        else if (e.getSource() == menuItemBlue) {
            aqua.setImage(null);
            aqua.setBackground(Color.blue);
        }

        //if the user clicks on the none button
        else if (e.getSource() == menuItemNone) {
            aqua.setImage(null);
            aqua.setBackground(Color.white);
        }

        //if the user clicks on the image button
        else if (e.getSource() == menuItemImage) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    loadImage();
                    aqua.setImage(image);
                }
            });
            t.start();


        }

        //if the user clicks on the help button
        else if (e.getSource() == menuItemHelp) {
            JOptionPane.showMessageDialog(aqua, "Home Work 2 \n GUI @ Threads", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

        //if the user clicks on the "add animal" button
        else if (e.getSource() == addAnimal) {
            if (aqua.getCount("Animal") < 5) {
                AddAnimalDialog a = new AddAnimalDialog(aqua);
            } else {
                addAnimal.setEnabled(false);
                JOptionPane.showMessageDialog(aqua, "You reached the maximum capacity (5 animals)", "Message", JOptionPane.WARNING_MESSAGE);
            }

            setAquaHeight(aqua.getHeight());
            setAquaWidth(aqua.getWidth());
        }

        //if the user clicks on the "add Plant" button
        else if (e.getSource() == addPlant) {
            if (aqua.getCount("Plant") < 5) {
                AddPlantDialog p = new AddPlantDialog(aqua);
            } else {
                addPlant.setEnabled(false);
                JOptionPane.showMessageDialog(aqua, "You reached the maximum capacity (5 plants)", "Message", JOptionPane.WARNING_MESSAGE);
            }
            setAquaHeight(aqua.getHeight());
            setAquaWidth(aqua.getWidth());
        }

        //if the user clicks on the "sleep" button
        else if (e.getSource() == duplicate) {
            if (aqua.getCount("Animal") < 5) {
                duplicateAnimalDialog d = new duplicateAnimalDialog(aqua);
            } else {
                duplicate.setEnabled(false);
                JOptionPane.showMessageDialog(aqua, "You reached the maximum capacity (5 animals)", "Message", JOptionPane.WARNING_MESSAGE);
            }
            setAquaHeight(aqua.getHeight());
            setAquaWidth(aqua.getWidth());
        }

        //if the user clicks on the "decorator" button
        else if (e.getSource() == decorator) {
            JPanelDecorator decor = new JPanelDecorator(aqua);
            JFrame decorator = new JFrame();
            decorator.setTitle("Change Color");
            decorator.setSize(1000, 400);
            decorator.getContentPane().add(decor);
            decorator.setVisible(true);
        }

        //if the user clicks on the "sleep" button
        else if (e.getSource() == sleep) {
            aqua.goToSleep();
        }

        //if the user clicks on the "wakeUp" button
        else if (e.getSource() == wakeUp) {
            aqua.wakeUp();
        }

        //if the user clicks on the "reset" button
        else if (e.getSource() == reset) {
            aqua.removeFromAnimals();
            aqua.removeFromPlants();
            JPanelMemento.getCareTaker().clearAnimals();
            JPanelMemento.getCareTaker().clearPlants();
            addAnimal.setEnabled(true);
            AquaPanel.setFood(false);
            duplicate.setEnabled(true);
            addPlant.setEnabled(true);
        }

        //if the user clicks on the "food" button
        else if (e.getSource() == food) {
            worm = Worm.getInstance(aqua);
            worm.setFood();
            if (aqua.getHashSize() > 0)
                aqua.setBar();

            setAquaHeight(aqua.getHeight());
            setAquaWidth(aqua.getWidth());
        }

        //if the user clicks on the "info" button
        else if (e.getSource() == info) {
            setAquaHeight(aqua.getHeight());
            setAquaWidth(aqua.getWidth());

            if (flag) {
                int size = aqua.getHashSize();
                int counter = 0;
                //crete a data array that will contain all information about the animals
                String[][] data = new String[size + 1][6];

                //Entering the information about the animals into the data array
                for (int i = 0; i < size; i++) {
                    data[i] = aqua.getAnimalInfo(i);
                    counter += Integer.parseInt(data[i][5]);
                }
                data[size][0] = "Total";
                data[size][5] = String.valueOf(counter);
                String[] columns = {"Animal", "Color", "Size", "Hor.speed", "Ver.speed", "Eat counter"};

                //Create the table
                infoTable = new JTable(data, columns);
                infoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                int index = 0;

                //Define the width of the columns
                while (index < 6) {
                    TableColumn a = infoTable.getColumnModel().getColumn(index);
                    a.setPreferredWidth(213);
                    index++;
                }

                //Adding the table to the info panel
                infoPanel.add(new JScrollPane(infoTable));
                getContentPane().add(infoPanel);
                aqua.setVisible(false);
                infoPanel.setVisible(true);
                flag = false;

            } else {
                //with each double click we want to delete the table
                infoPanel.removeAll();
                aqua.setVisible(true);
                infoPanel.setVisible(false);
                flag = true;
            }
        }

        //if the user clicks on the "exit" button
        else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
