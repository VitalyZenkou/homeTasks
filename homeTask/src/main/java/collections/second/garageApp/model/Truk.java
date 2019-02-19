package collections.second.garageApp.model;

public class Truk extends Vehicle {

    private final int loadCapacity;

    public Truk(String mark, Model model, String color, int productionYear, Engine engine, int loadCapacity) {
        super(mark, model, color, productionYear, engine);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Truk truk = (Truk) o;

        return getLoadCapacity() == truk.getLoadCapacity();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getLoadCapacity();
        return result;
    }
}
