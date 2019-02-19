package collections.second.garageApp.model;

public class Engine {

    private final double volume;
    private final String mark;

    public Engine(double volume, String mark) {
        this.volume = volume;
        this.mark = mark;
    }

    public double getVolume() {
        return volume;
    }

    public String getMark() {
        return mark;
    }
}
