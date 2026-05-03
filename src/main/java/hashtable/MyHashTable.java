package hashtable;

public class MyHashTable<K, V> {

    private static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.table = (HashNode<K, V>[]) new HashNode[capacity];
        this.size = 0;
    }

    public MyHashTable() {
        this(101);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);

        HashNode<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);

        HashNode<K, V> head = table[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    table[index] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void printBuckets() {
        for (int i = 0; i < capacity; i++) {
            int count = 0;
            HashNode<K, V> head = table[i];

            while (head != null) {
                count++;
                head = head.next;
            }

            System.out.println("Bucket " + i + ": " + count);
        }
    }
}