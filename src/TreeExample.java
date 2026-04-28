public class TreeExample {
    public static void run() {
        System.out.println("\n-- Binary Search Tree Example --");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) bst.insert(v);
        System.out.println("In-order traversal (sorted): " + bst.inorder());
        System.out.println("Contains 60? " + bst.contains(60));
        System.out.println("Contains 25? " + bst.contains(25));
    }
}

