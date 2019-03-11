package patterns.factory;

import patterns.model.Animal;
import patterns.model.IAction;

public class AnimalFactory implements ICreatureFactory {

    @Override
    public IAction createDefaultCreature(String name) {
        return Animal.builder().name(name).build();
    }
}
