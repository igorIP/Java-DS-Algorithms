package tree;

import java.util.Scanner;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    public void create() {
        Node newNode;
        Node p;
        int x;

        Queue inputQueue = new Queue();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter root value" + "\n");
        x = scan.nextInt();
        root = new Node();
        root.data = x;
        root.leftChild = root.rightChild = null;
        inputQueue.enQueue(root);

        while (!inputQueue.isEmpty()) {
            p = inputQueue.deQueue();
            System.out.println("Enter left child for: " + p.data + "\n");
            x = scan.nextInt();
            if (x != -1) {
                newNode = new Node();
                newNode.data = x;
                newNode.leftChild = newNode.rightChild = null;
                p.leftChild = newNode;
                inputQueue.enQueue(newNode);
            }

            System.out.println("Enter right child for: " + p.data + "\n");
            x = scan.nextInt();
            if (x != -1) {
                newNode = new Node();
                newNode.data = x;
                newNode.leftChild = newNode.rightChild = null;
                p.rightChild = newNode;
                inputQueue.enQueue(newNode);
            }
        }
    }

    //Tree traversal: pre-order, in-order, iterative
    public void preorder() {
        preorder(root);
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    public void postorder() {
        postorder(root);
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.println(node.data);
        }
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(Node node) {
        if (node != null) {
            postorder(node.leftChild);
            System.out.println(node.data);
            postorder(node.rightChild);
        }
    }

    public void levelorder() {
        levelorder(root);
    }

    public void levelorder(Node root) {
        Queue queue = new Queue();
        System.out.println(root.data);
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            root = queue.deQueue();
            if (root.leftChild != null) {
                queue.enQueue(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.enQueue(root.rightChild);
            }
        }
    }

    //for refactoring
//    public int height(Node root) {
//        int x = 0;
//        int y = 0;
//        if (root == null) return 0;
//        x = height(root.leftChild);
//        y = height(root.rightChild);
//        if (x > y) return x + 1;
//        else return y + 1;
//    }

}
