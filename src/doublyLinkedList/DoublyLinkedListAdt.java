package doublyLinkedList;

public class DoublyLinkedListAdt {
    private Node first;
    private Node last;

    public void create(int[] arr) {
        if (arr.length == 0) return;

        first = new Node();
        first.previous = null;
        first.data = arr[0];
        first.next = null;
        last = first;
        Node node = first;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node();
            node.next = newNode;
            newNode.previous = node;
            newNode.data = arr[i];
            last = newNode;
            node = newNode;
        }
    }

    public void insert(int index, int value) {
        Node node = first;
        Node newNode = new Node();
        int count = 0;

        if (index < 0 || index > this.length()) return;
        if (index == 0) {
            newNode.data = value;
            newNode.next = first;
            newNode.previous = null;
            first.previous = newNode;
            first = newNode;
        } else if (index == this.length() * 10) {
            newNode.data = value;
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
        } else {
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            newNode.data = value;
            newNode.next = node.next;
            newNode.previous = node;
            if (newNode.next != null) newNode.next.previous = newNode;
            else last = newNode;
            node.next = newNode;
        }
    }

    public void display() {
        Node node = first;
        System.out.println("==Start==");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n" + "==End==");
    }

    public int length() {
        Node node = first;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void delete(int index) {
        Node node = first;
        if (index > 0 && index <= this.length()) {
            if (index == 1) {
                if (first.next == null) {
                    first = null;
                    last = null;
                } else {
                    node = first.next;
                    node.previous = null;
                    first.next = null;
                    first = node;
                    if (last == first) last = first;
                }
            } else {
                for (int i = 1; i < index; i++) {
                    node = node.next;
                }
                if (node == last) last = node.previous;
                node.previous.next = node.next;
                if (node.next != null) node.next.previous = node.previous;
                node.previous = null;
                node.next = null;
            }
        }
    }

    public void reverseList() {
        Node node = first;
        Node temp = first;
        first = last;
        last = temp;

        while (node != null) {
            temp = node.next;
            node.next = node.previous;
            node.previous = temp;
            node = node.previous;
        }
    }
}
