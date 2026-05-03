package hashtable;

import java.util.Random;

public class HashTableTest {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(101);
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            String name = "name" + rand.nextInt(1000);

            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, i);
        }

        System.out.println("Total size: " + table.size());
        table.printBuckets();
    }
}