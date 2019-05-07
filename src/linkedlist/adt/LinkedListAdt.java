package linkedlist.adt;

public class LinkedListAdt {
    public Node head;
    public Node last;

    public void create(int[] array) {
        head = new Node();
        last = new Node();

        head.data = array[0];
        head.next = null;
        last = head;

        for (int i = 1; i < array.length; i++) {
            Node temp = new Node();
            last.next = temp;
            last = temp;
            temp.next = null;
            temp.data = array[i];
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("============");
    }

    public boolean searchElement(Node node, int key) {
        while (node != null) {
            if (key == node.data) return true;
            node = node.next;
        }
        return false;
    }

    public boolean searchElementMoveToHead(Node node, int key) {
        Node previous = new Node();
        Node temp;

        while (node != null) {
            if (key == node.data) {
                previous.next = node.next;

                temp = head;
                head = node;
                head.next = temp;
                return true;
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    public void insertBeforeFirstNode(int value) {
        Node temp;
        temp = head;
        head = new Node();
        head.data = value;
        head.next = temp;
    }

    public void insertAfterIndex(int index, int value) {
        Node newNode = new Node();
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.data = value;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int printFirstElement() {
        return head.data;
    }

    public int printLastElement() {
        return last.data;
    }

    public int linkedListLength(Node node) {
        int sum = 1;
        while (node != null) {
            node = node.next;
            sum += 1;
        }
        return sum;
    }

    public int sumLinkedListElements(Node node) {
        int sum = 0;
        while (node != null) {
            sum += node.data;
            node = node.next;
        }
        return sum;
    }

    public int maxElement(Node node) {
        int max = 0;
        while (node != null) {
            if (max < node.data) max = node.data;
            node = node.next;
        }
        return max;
    }
}
