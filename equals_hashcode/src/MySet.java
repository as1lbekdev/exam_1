public class MySet<K> {
    private static final Object obj = new Object();

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, Object>[] bucket = new Entry[16];
    private int size;

//    O(1)
    public void add(K k) {
        Entry<K, Object> newEntry = new Entry<>(k, obj);
        int hashIndex = hash(k);
        Entry<K, Object> entry = bucket[hashIndex];
        if (entry == null) {
            bucket[hashIndex] = newEntry;
            size ++;
            return;
        }

        while(entry.next != null) {
            if (entry.key.equals(k)) {
                return;
            }
            entry = entry.next;
        }
        if (entry.key.equals(k)) {
            entry.value = obj;
            return;
        }
        entry.next = newEntry;
        size ++;
    }

//    O(1)
    public boolean contains(K k) {
        int hashIndex = hash(k);
        Entry<K, Object> entry = bucket[hashIndex];
        while(entry != null) {
            if (entry.key.equals(k)) {
                return true;
            }
            entry = entry.next;
        }

        return false;
    }

//    O(1)
    private int hash(K k) {
        return Math.abs(k.hashCode() % 16);
    }

//    O(n)
    public void print() {
        System.out.print("[");
        for (Entry<K, Object> entry: bucket) {
            while (entry != null) {
                System.out.print(entry.key + ", ");
                entry = entry.next;
            }
        }
        System.out.println("]");
    }

//    O(1)
    public int size() {
        return size;
    }
}
