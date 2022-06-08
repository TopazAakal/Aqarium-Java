package DesignPatterns.AbstractFactory;

import SeaCreatures.*;

/**
 * The Plant Factory.
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class PlantFactory implements AbstractSeaFactory {

    /**
     * Instantiates a new Plant factory.
     */
    public PlantFactory(){}

    @Override
    public SeaCreature produceSeaCreature(String plant,int[] args) {
        SeaCreature seaCreature=null;
        if(plant.equalsIgnoreCase("Laminaria")){
            seaCreature=new Laminaria(args[0],args[1],args[2]);
        }
        else if(plant.equalsIgnoreCase("Zostera")){
            seaCreature=new Zostera(args[0],args[1],args[2]);
        }
        return seaCreature;
    }
}
