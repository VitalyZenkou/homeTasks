package homeTaskGeneric.third;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table<K, V> {

    private final List<Entry<K, V>> entries;

    public Table() {
        entries = new ArrayList<>();
    }

    public Table(List<Entry<K, V>> entries) {
        this.entries = entries;
    }

    @SuppressWarnings("unchecked")
    public List<V> getValue(K key) {
        List<V> values = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getKey().equals(key)) {
                values.add((V) entry.getValue());
            }
        }
        return values;
    }

    @SuppressWarnings("unchecked")
    public boolean addValue(K key, V value) {
        for (Entry entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return true;
            }
        }
        return false;
    }

    public boolean remove(K key) {
        Iterator<Entry<K, V>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Entry entry = entryIterator.next();
            if (entry.getKey().equals(key)) {
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void add(Entry entry) {
        entries.add(entry);
    }

    public List<Entry<K, V>> getEntries() {
        return entries;
    }
}
