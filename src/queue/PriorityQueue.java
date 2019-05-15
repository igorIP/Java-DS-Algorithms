package queue;

public class PriorityQueue {
    Node first;
    Node last;

    public PriorityQueue() {
        this.first = null;
        this.last = null;
    }

    public void enQueue(int data) {
        Node node = first;
        Node previous = null;
        int min = data;
        Node newNode = new Node();
        newNode.data = data;
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            if (first == last) {
                if (node.data >= data) {
                    node.next = newNode;
                    last = newNode;
                } else {
                    first = newNode;
                    newNode.next = node;
                }
            } else {
                if (data > first.data) {
                    first = newNode;
                    newNode.next = node;
                    return;
                } else if (data < last.data) {
                    last.next = newNode;
                    last = newNode;
                    return;
                }
                while (node != null) {
                    if (data > node.data) {
                        newNode.next = node;
                        previous.next = newNode;
                    }
                    previous = node;
                    node = node.next;
                }
            }
        }
    }

    public void display() {
        if (first != null) {
            Node node = first;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public class Node {
        int data;
        Node next;
    }
}
