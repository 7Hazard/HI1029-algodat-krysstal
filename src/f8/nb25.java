package f8;

import java.util.LinkedList;

public class nb25 {
    public static void main(String[] args) {
        HashTableBucket<Object, Object> hashTableBucket = new HashTableBucket(10);

        hashTableBucket.put(1, "Q");
        hashTableBucket.put(2, "W");
        hashTableBucket.put(3, "R");
        hashTableBucket.put(4, "T");
        hashTableBucket.put(5, "T");
        hashTableBucket.put(6, "T");
        hashTableBucket.put(7, "T");
        hashTableBucket.put(8, "T");
        hashTableBucket.put(9, "T");
        hashTableBucket.put(10, "T");
        hashTableBucket.put(11, "T");

        System.out.println(hashTableBucket);
    }

    public static class HashTableBucket<K, V> {
        private static class Entry<K, V> {

            public K key;
            public V value;

            public Entry(K k, V v) {
                key = k;
                value = v;
            }

            @Override
            public String toString() {
                return key.toString() + ":" + value.toString();
            }
        }

        private LinkedList<Entry<K, V>>[] table;
        private int count = 0;

        @SuppressWarnings("unchecked")
        public HashTableBucket(int initialSize) {
            table = new LinkedList[initialSize];
        }

        public V get(K key) {
            int index = key.hashCode() % table.length;
            if (index < 0) {
                index += table.length;
            }
            if (table[index] == null) {
                return null;
            }
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        }

        public V put(K key, V value) {
            int max = (int) (table.length*0.75);
            if(count == max)
                reallocate(table.length*2);
            count++;
            return put(table, key, value);
        }

        private V put(LinkedList<Entry<K,V>>[] table, K key, V value) {
            int index = key.hashCode() % table.length;
            if (index < 0) index += table.length;
            if (table[index] == null) {
                table[index] = new LinkedList<>();
                table[index].add(new Entry<K, V>(key, value));
            } else {
                V oldValue;
                for (Entry<K, V> e : table[index]) {
                    if (e.key.equals(key)) {
                        oldValue = e.value;
                        e.value = value;
                        return oldValue;
                    }
                }
                table[index].add(0, new Entry<K, V>(key, value));
            }
            return null;
        }

        private void reallocate(int newSize) {
            var newtable = new LinkedList[newSize];
            for (var li : table)
            {
                if(li != null)
                {
                    for(var entry : li)
                        put(newtable, entry.key, entry.value);
                }
            }
            table = newtable;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (var element : table)
                if(element != null)
                    sb.append(element).append(", ");
            sb.append("]");
            return sb.toString();
        }
    }
}
