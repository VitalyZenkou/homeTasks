package collections.second.garageApp.model;

public class Bus extends Vehicle {

    private final int seatsNumber;

    public Bus(String mark, Model model, String color, int productionYear, Engine engine, int seatsNumber) {
        super(mark, model, color, productionYear, engine);
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;

        Bus bus = (Bus) o;

        return getSeatsNumber() == bus.getSeatsNumber();
    }

    @Override
    public int hashCode() {
        return getSeatsNumber();
    }
}
