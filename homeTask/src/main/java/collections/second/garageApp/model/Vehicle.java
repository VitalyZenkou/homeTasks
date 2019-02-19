package collections.second.garageApp.model;

public abstract class Vehicle {

    private final String mark;
    private final Model model;
    private final String color;
    private final int productionYear;
    private final Engine engine;

    public Vehicle(String mark, Model model, String color, int productionYear, Engine engine) {
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
        this.engine = engine;
    }

    public String getMark() {
        return mark;
    }

    public Model getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (getProductionYear() != vehicle.getProductionYear()) return false;
        if (!getMark().equals(vehicle.getMark())) return false;
        if (getModel() != vehicle.getModel()) return false;
        if (!getColor().equals(vehicle.getColor())) return false;
        return getEngine().equals(vehicle.getEngine());
    }

    @Override
    public int hashCode() {
        int result = getMark().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getProductionYear();
        result = 31 * result + getEngine().hashCode();
        return result;
    }
}
