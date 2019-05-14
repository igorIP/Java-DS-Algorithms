package stack;

public class StackAdtLinkedList {

    private Node top;
    //Important; Insertion in stack created with linked list,
    //  is always from head because otherwise we have to traverse the list to add node;

    public StackAdtLinkedList() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        int value = -1;
        if (top != null) {
            Node node = top;
            top = top.next;
            node.next = null;
            value = node.data;
            return value;
        }
        return value;
    }

    public int peek(int position) {
        int pos = -1;
        Node node = top;
        if (top != null) {
            for (int i = 1; i < position; i++) {
                node = node.next;
                if (node == null) return pos;
            }
            return node.data;
        }
        return pos;
    }

    public int stackPop() {
        if (top != null) return top.data;
        return -1;
    }

    public void display() {
        System.out.println("Start");
        Node node = top;
        if (top != null) {
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
        System.out.println("End");
    }

    public boolean isEmpty() {
        return top == null;
    }


    private class Node {
        private int data;
        private Node next;
    }
}
