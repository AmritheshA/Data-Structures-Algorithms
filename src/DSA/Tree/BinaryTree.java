package DSA.Tree;


import java.util.LinkedList;
import java.util.Queue;

class BinaryNode {

    public Integer value;
    public BinaryNode leftNode;
    public BinaryNode rightNode;

    public BinaryNode(int value) {
        this.value = value;
    }

}

public class BinaryTree {

    BinaryNode root;

    public void insertElement(int value) {

        if (root == null) {
            root = new BinaryNode(value);
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.poll();

            if (currentNode.leftNode == null) {
                currentNode.leftNode = new BinaryNode(value);
                return;
            } else {
                queue.offer(currentNode.leftNode);
            }

            if (currentNode.rightNode == null) {
                currentNode.rightNode = new BinaryNode(value);
                return;
            } else {
                queue.offer(currentNode.rightNode);
            }
        }
    }

    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private BinaryNode deleteHelper(BinaryNode root, int value) {

        if (root == null) {
            return null;
        }

        if (root.value == value) {
            if (root.leftNode == null && root.rightNode == null) {
                return null;
            } else if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            }else{
                BinaryNode node = findLastNode(root.rightNode);
                root.value = node.value;
                root.rightNode = deleteHelper(root.rightNode,node.value);
                return root;
            }
        }
        root.leftNode = deleteHelper(root.leftNode,value);
        root.rightNode = deleteHelper(root.rightNode,value);
        return root;
    }

    private BinaryNode findLastNode(BinaryNode node) {
        while (node.rightNode != null) {
            node = node.rightNode;
        }
        return node;
    }

    public void inOrder() {

        BinaryNode current = root;
        inOrderHelper(current);
    }

    private void inOrderHelper(BinaryNode current) {

        if (current == null) return;

        inOrderHelper(current.leftNode);
        System.out.println(current.value);
        inOrderHelper(current.rightNode);

    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insertElement(10);
        binaryTree.insertElement(20);
        binaryTree.insertElement(30);
        binaryTree.insertElement(40);

        binaryTree.delete(40);

        binaryTree.inOrder();


    }
}
