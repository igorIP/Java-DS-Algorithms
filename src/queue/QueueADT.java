package queue;

public class QueueADT {

    private Node first;
    private Node last;

    public QueueADT() {
        this.first = null;
        this.last = null;
    }

    public void enQueue(int data) {
        Node newNode = new Node();
        if (first == null) {
            newNode.data = data;
            first = newNode;
            last = newNode;
        } else {
            newNode.data = data;
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
    }

    public int deQueue() {
        Node node = first;
        int x = -1;
        if (first != null) {
            if (first.next == null) {
                first = null;
                return node.data;
            }
            first = first.next;
            first.previous = null;
            node.next = null;
            return node.data;
        }
        return x;
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

    public boolean isEmpty() {
        return first == null;
    }

    public Node first() {
        return first;
    }

    public Node last() {
        return last;
    }

    private class Node {
        Node next;
        Node previous;
        int data;

        public Node() {
            this.next = null;
            this.previous = null;
        }
    }
}
