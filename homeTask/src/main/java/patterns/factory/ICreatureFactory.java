package patterns.factory;

import patterns.model.IAction;

public interface ICreatureFactory {

    IAction createDefaultCreature(String name);
}
