package patterns.model;

public class Animal implements IAction {

    private final String name;
    private final String ownerName;

    private Animal(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
    }

    public static AnimalBuilder builder() {
        return new AnimalBuilder();
    }

    @Override
    public void action() {
        System.out.println("Do some animal things!");
    }

    public static class AnimalBuilder {

        private String name;
        private String ownerName;

        public AnimalBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Animal build() {
            return new Animal(name, ownerName);
        }
    }
}
