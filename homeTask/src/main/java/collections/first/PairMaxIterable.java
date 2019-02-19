package collections.first;

import homeTaskGeneric.firstSecond.Pair;

import java.util.Iterator;
import java.util.List;

public class PairMaxIterable implements Iterable<Integer> {

    private final List<Pair> pairs;

    public PairMaxIterable(List<Pair> pairs) {
        this.pairs = pairs;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PairMaxIterator(pairs);
    }
}
