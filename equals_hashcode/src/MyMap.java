class MyHashMap<K, V> {
     private static class Entry<K, V> {
         private K key;
         private V value;
         private Entry<K, V> next;

         private Entry(K key, V value) {
               this.key = key;
               this.value = value;
          }
     }

     private int size = 16;
     private Entry<K, V>[] buckets = new Entry[size];


     public V put(K key, V value) {
          int index = getIndex(key);
          Entry<K, V> newentry = buckets[index];

          while (newentry != null) {
               if (newentry.key.equals(key)) {
                    V val = newentry.value;
                    newentry.value = value;
                    return val;
               }
               newentry = newentry.next;
          }

          Entry<K, V> entry = new Entry<>(key, value);
          entry.next = buckets[index];
          buckets[index] = entry;
          return null;
     }

     public V get(K key) {
          int index = getIndex(key);
          Entry<K, V> entry = buckets[index];

          while (entry != null) {
               if (entry.key.equals(key)) {
                    return entry.value;
               }
               entry = entry.next;
          }
          return null;
     }



     public int size() {
          int c = 0;
          for (Entry<K, V> bucket : buckets) {
               Entry<K, V> entry = bucket;
               while (entry != null) {
                    c++;
                    entry = entry.next;
               }
          }
          return c;
     }

     private int getIndex(K key) {
          return Math.abs(key.hashCode()) % size;
     }

}
