package patterns;

import patterns.factory.AnimalFactory;
import patterns.factory.ICreatureFactory;
import patterns.factory.UserFactory;
import patterns.model.IAction;

import java.util.Arrays;
import java.util.List;

public class PatternApp {

    public static void main(String[] args) {
        ICreatureFactory animalFactory = new AnimalFactory();
        ICreatureFactory userFactory = new UserFactory();
        List<IAction> creatures = Arrays.asList(userFactory.createDefaultCreature("Vasia"),
                animalFactory.createDefaultCreature("Snowflake"),
                userFactory.createDefaultCreature("Petia"),
                animalFactory.createDefaultCreature("Sharik"));

        creatures.forEach(IAction::action);
    }
}
