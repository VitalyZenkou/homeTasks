package homeTaskGeneric.firstSecond;

public class Pair<E extends Comparable<E>> {

    private final E firstElement;
    private final E secondElement;

    public Pair(E firstElement, E secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public E getFirstElement() {
        return firstElement;
    }

    public E getSecondElement() {
        return secondElement;
    }

    @SuppressWarnings("unchecked")
    public E getMax() {
        return firstElement.compareTo(secondElement) > 0 ? firstElement : secondElement;
    }

    @SuppressWarnings("unchecked")
    public E getMin() {
        return firstElement.compareTo(secondElement) < 0 ? firstElement : secondElement;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstElement=" + firstElement +
                ", secondElement=" + secondElement +
                '}';
    }
}
