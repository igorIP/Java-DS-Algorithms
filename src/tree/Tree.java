package tree;

import java.util.Scanner;
import java.util.Stack;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    public void create() {
        Node newNode;
        Node node;
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
            node = inputQueue.deQueue();
            System.out.println("Enter left child for: " + node.data + "\n");
            x = scan.nextInt();
            if (x != -1) {
                newNode = new Node();
                newNode.data = x;
                newNode.leftChild = newNode.rightChild = null;
                node.leftChild = newNode;
                inputQueue.enQueue(newNode);
            }

            System.out.println("Enter right child for: " + node.data + "\n");
            x = scan.nextInt();
            if (x != -1) {
                newNode = new Node();
                newNode.data = x;
                newNode.leftChild = newNode.rightChild = null;
                node.rightChild = newNode;
                inputQueue.enQueue(newNode);
            }
        }
    }

    //Tree traversal: Recursion
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
            inorder(node.leftChild);
            System.out.println(node.data);
            inorder(node.rightChild);
        }
    }

    public void levelorder() {
        levelorder(root);
    }

    public void levelorder(Node node) {
        Queue queue = new Queue();
        System.out.println(node.data);
        queue.enQueue(node);
        while (!queue.isEmpty()) {
            node = queue.deQueue();
            if (node.leftChild != null) {
                System.out.println(node.data);
                queue.enQueue(node.leftChild);
            }
            if (node.rightChild != null) {
                System.out.println(node.data);
                queue.enQueue(node.rightChild);
            }
        }
    }

    //Tree traversal: Iterative
    public void preorderIterative(){
        preorderIterative(root);
    }

    public void preorderIterative(Node node) {
        Stack<Node> stackNodes = new Stack<>();
        System.out.println(node.data);
        stackNodes.push(node);

        while (!stackNodes.empty()) {
            if (node.leftChild != null) {
                node = node.leftChild;
                System.out.println(node.data);
                stackNodes.push(node);
            } else {
                node = stackNodes.pop();
                if (node.rightChild != null) {
                    node = node.rightChild;
                    System.out.println(node.data);
                    stackNodes.push(node);
                } else {
                    node = stackNodes.pop();
                    node = node.rightChild;
                    System.out.println(node.data);
                }
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
