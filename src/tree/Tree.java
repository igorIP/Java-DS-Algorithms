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
    public void preorderIterative() {
        preorderIterative(root);
    }

    private void preorderIterative(Node node) {
        Stack<Node> stackNodes = new Stack<>();

        while (node != null || !stackNodes.empty()) {
            if (node != null) {
                System.out.println(node.data);
                stackNodes.push(node);
                node = node.leftChild;
            } else {
                node = stackNodes.pop();
                node = node.rightChild;
            }
        }
    }

    public void inorderIterative() {
        inorderIterative(root);
    }

    private void inorderIterative(Node node) {
        Stack<Node> stackNodes = new Stack<>();

        while (node != null || !stackNodes.empty()) {
            if (node != null) {
                stackNodes.push(node);
                node = node.leftChild;
            } else {
                node = stackNodes.pop();
                System.out.println(node.data);
                node = node.rightChild;
            }
        }
    }

    public void levelorderIterative() {
        levelorderIterative(root);
    }

    private void levelorderIterative(Node node) {
        Queue queue = new Queue();

        System.out.println(node.data);
        queue.enQueue(node);

        while (!queue.isEmpty()) {
            node = queue.deQueue();
            if (node.leftChild != null) {
                System.out.println(node.leftChild.data);
                queue.enQueue(node.leftChild);
            }
            if (node.rightChild != null) {
                System.out.println(node.rightChild.data);
                queue.enQueue(node.rightChild);
            }
        }
    }


    //Count nodes in tree
    public int count() {
        return count(root);
    }


    private int count(Node node) {
        int x, y;
        if (node != null) {
            x = count(node.leftChild);
            y = count(node.rightChild);
            return x + y + 1;
        }
        return 0;
    }

    //Count only nodes with degree two(only nodes who have 2 childes)

    public int countNodeWithdegreeTwo() {
        return countNodeWithdegreeTwo(root);
    }


    private int countNodeWithdegreeTwo(Node node) {
        int x, y;
        if (node != null) {
            x = countNodeWithdegreeTwo(node.leftChild);
            y = countNodeWithdegreeTwo(node.rightChild);
            if (node.leftChild != null && node.rightChild != null) {
                return x + y + 1;
            } else {
                return x + y;
            }
        }
        return 0;
    }

    //Sum of data in all nodes in tree

    public int sumData() {
        return sumData(root);
    }


    private int sumData(Node node) {
        int x, y;
        if (node != null) {
            x = sumData(node.leftChild);
            y = sumData(node.rightChild);
            return x + y + node.data;
        }
        return 0;
    }
}
