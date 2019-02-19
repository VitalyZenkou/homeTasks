package collections.first;

import homeTaskGeneric.firstSecond.Pair;

import java.util.Iterator;
import java.util.List;

public class PairMaxIterator implements Iterator<Integer> {

    private static int counter = 0;
    private final List<Pair> pairs;

    public PairMaxIterator(List<Pair> pairs) {
        this.pairs = pairs;
    }

    @Override
    public boolean hasNext() {
        return pairs.size() > counter;
    }

    @Override
    public Integer next() {
        return (Integer) pairs.get(counter++).getMax();
    }
}
