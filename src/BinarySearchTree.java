import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private static class Node<T> {
        T val; Node<T> left, right;
        Node(T v) { val = v; }
    }

    private Node<T> root;

    public void insert(T val) {
        root = insert(root, val);
    }

    private Node<T> insert(Node<T> node, T val) {
        if (node == null) return new Node<>(val);
        int cmp = val.compareTo(node.val);
        if (cmp < 0) node.left = insert(node.left, val);
        else if (cmp > 0) node.right = insert(node.right, val);
        return node;
    }

    public boolean contains(T val) { return contains(root, val); }

    private boolean contains(Node<T> node, T val) {
        if (node == null) return false;
        int cmp = val.compareTo(node.val);
        if (cmp == 0) return true;
        return cmp < 0 ? contains(node.left, val) : contains(node.right, val);
    }

    public List<T> inorder() {
        List<T> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node<T> node, List<T> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}

