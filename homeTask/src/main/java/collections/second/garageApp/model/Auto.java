package collections.second.garageApp.model;

public class Auto extends Vehicle {

    private final int trunkValue;
    private final int price;

    public Auto(String mark, Model model, String color, int productionYear, Engine engine, int trunkValue, int price) {
        super(mark, model, color, productionYear, engine);
        this.trunkValue = trunkValue;
        this.price = price;
    }

    public int getTrunkValue() {
        return trunkValue;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Auto auto = (Auto) o;

        if (getTrunkValue() != auto.getTrunkValue()) return false;
        return getPrice() == auto.getPrice();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getTrunkValue();
        result = 31 * result + getPrice();
        return result;
    }
}
