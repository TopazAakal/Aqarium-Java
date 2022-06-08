package DesignPatterns.AbstractFactory;

import SeaCreatures.*;

/**
 * The Animal factory.
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */
public class AnimalFactory implements AbstractSeaFactory {

    /**
     * Instantiates a new Animal factory.
     */
    public AnimalFactory(){}

    @Override
    public SeaCreature produceSeaCreature(String animal,int[] args) {
        SeaCreature seaCreature=null;
        if(animal.equalsIgnoreCase("Fish")){
            seaCreature=new Fish(args[0],args[1],args[2],args[3],args[4],args[5], args[6]);
        }
        else if(animal.equalsIgnoreCase("JellyFish")){
            seaCreature=new Jellyfish(args[0],args[1],args[2],args[3],args[4],args[5],args[6]);
        }
        return seaCreature;
    }
}
