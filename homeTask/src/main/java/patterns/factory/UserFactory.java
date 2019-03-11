package patterns.factory;

import patterns.model.IAction;
import patterns.model.User;

public class UserFactory implements ICreatureFactory {

    @Override
    public IAction createDefaultCreature(String name) {
        return User.builder().name(name).build();
    }
}
