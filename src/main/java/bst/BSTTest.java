package bst;

public class BSTTest {
    public static void main(String[] args) {

        BST<Integer, String> tree = new BST<>();

        tree.put(5, "A");
        tree.put(3, "B");
        tree.put(7, "C");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() +
                    " and value is " + elem.getValue());
        }

        System.out.println("Size: " + tree.size());
    }
}