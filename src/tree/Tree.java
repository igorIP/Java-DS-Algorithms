package tree;

import java.util.Scanner;

public class Tree {

    public Node root;
    //private Queue treeLinkedList;

    public Tree() {
        this.root = null;
        //this.treeLinkedList = new Queue();
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
    public void preorder(Node node) {
        if (node != null) {
            System.out.println("left");
            System.out.println(node.data);
            preorder(node.leftChild);
            System.out.println("right");
            preorder(node.rightChild);
        }
    }

    public void display() {
    }

}
