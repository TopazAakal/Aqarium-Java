package DesignPatterns.AbstractFactory;

/**
 * A class for invoking the right factory
 *
 * @author Topaz aakal, 318644549
 * @author Afik danan, 208900175
 */

public class AddSeaCreature {
    SeaCreature animal;

    /**
     * Instantiates a new Add sea creature.
     *
     * @param nameFac    the name fac
     * @param nameAnimal the name animal
     * @param args       the args
     */
    public AddSeaCreature(String nameFac,String nameAnimal,int[] args){
        AbstractSeaFactory factory=createFactory(nameFac);
        if(factory!=null)
            animal=factory.produceSeaCreature(nameAnimal,args);
    }

    /**
     * Create factory abstract sea factory.
     *
     * @param type the type
     * @return the abstract sea factory
     */
    public static AbstractSeaFactory createFactory(String type){
        if("Animal".equals(type))
            return new AnimalFactory();
        else if("Plant".equals(type))
            return new PlantFactory();
        else
            return null;
    }

    /**
     * Get sea creature.
     *
     * @return the sea creature
     */
    public SeaCreature getSeaCreature(){
        return animal;
    }
}
