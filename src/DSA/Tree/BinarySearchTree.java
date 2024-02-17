package DSA.Tree;


import java.util.LinkedList;
import java.util.Queue;

class BinarySearchNode {
    Integer data;
    BinarySearchNode leftChild;
    BinarySearchNode rightChild;

    public BinarySearchNode(int data) {
        this.data = data;
    }
}

public class BinarySearchTree {

    BinarySearchNode root;

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    public BinarySearchNode insertHelper(BinarySearchNode root, int value) {

        if (root == null) {
            root = new BinarySearchNode(value);
            return root;
        } else if (value < root.data) {
            root.leftChild = insertHelper(root.leftChild, value);
        } else {
            root.rightChild = insertHelper(root.rightChild, value);
        }

        return root;
    }

    public boolean isContain(int key) {
        return isContainHelper(root, key);
    }

    private boolean isContainHelper(BinarySearchNode root, int key) {

        if (root == null) {
            return false;
        } else if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return isContainHelper(root.leftChild, key);
        } else {
            return isContainHelper(root.rightChild, key);
        }

    }

    public void remove(int key) {

        if (isContain(key)) {
            removeHelper(root, key);
        } else {
            System.out.println(key + " is not in the tree");
        }
    }

    private BinarySearchNode removeHelper(BinarySearchNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.leftChild = removeHelper(root.leftChild, key);
        } else if (key > root.data) {
            root.rightChild = removeHelper(root.rightChild, key);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            root.data = findMinValue(root.rightChild);
            root.rightChild = removeHelper(root.rightChild, root.data);
        }

        return root;
    }


    private int findMinValue(BinarySearchNode node) {
        int minValue = node.data;
        while (node.leftChild != null) {
            minValue = node.leftChild.data;
            node = node.leftChild;
        }
        return minValue;
    }

    public void levelOrderTraversal(){
        if(root == null) return;

        Queue<BinarySearchNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){

            BinarySearchNode currentNode = queue.poll();

            System.out.print(" "+currentNode.data);

            if(currentNode.rightChild != null) queue.add(currentNode.rightChild);

            if(currentNode.leftChild != null) queue.add(currentNode.leftChild);
        }
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(BinarySearchNode root) {
        if (root == null) return;

        displayHelper(root.leftChild);
        System.out.print(" " + root.data);
        displayHelper(root.rightChild);
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(9);
        binarySearchTree.insert(1);

        binarySearchTree.remove(1);

        System.out.println(binarySearchTree.isContain(0));

        binarySearchTree.levelOrderTraversal();
        System.out.println();
        binarySearchTree.display();
    }
}