package tree;


public class Queue {

    private Node first;
    private Node last;

    public Queue() {
        this.first = null;
        this.last = null;
    }

    public void enQueue(Node newNode) {
        //Node newNode = new Node();
        if (first == null) {
            //newNode.data = data;
            first = newNode;
            last = newNode;
        } else {
            //newNode.data = data;
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
    }

    public Node deQueue() {
        Node node = first;
        Node x = null;
        if (first != null) {
            if (first.next == null) {
                first = null;
                return node;
            }
            first = first.next;
            first.previous = null;
            node.next = null;
            return node;
        }
        return null;
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

}
