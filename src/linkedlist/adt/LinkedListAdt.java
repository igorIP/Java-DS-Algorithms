package linkedlist.adt;

public class LinkedListAdt {
    public Node head;
    public Node last;

    public void create(int[] array) {
        head = last = new Node();

        last.data = array[0];
        last.next = null;

        for (int i = 1; i < array.length; i++) {
            Node newNode = new Node();
            last.next = newNode;
            newNode.data = array[i];
            last = newNode;
        }
    }

    public void createAlwaysAddLast(int data) {
        if (head == null) {
            head = last = new Node();
            head.data = data;
        } else {
            last.next = new Node();
            last = last.next;
            last.data = data;
        }
    }

    public void display() {
        System.out.println("===Start");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("===End");
    }

    public boolean searchElement(int key) {
        Node node = head;
        while (node != null) {
            if (key == node.data) return true;
            node = node.next;
        }
        return false;
    }

    public boolean searchElementMoveToHead(int key) {
        Node node = head;
        Node previous = new Node();

        while (node != null) {
            if (key == node.data) {
                if (node == last) last = previous;
                previous.next = node.next;
                node.next = head;
                head = node;
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

    public void insertAfterLastNode(int value) {
        Node temp = new Node();
        temp.data = value;
        last.next = temp;
        last = temp;
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

    public void insertInSortedList(int data) {
        Node newNode = new Node();
        Node node = head;
        Node temp = new Node();

        if (data < head.data) {
            newNode.next = head;
            head = newNode;
            newNode.data = data;
        } else {
            while (node != null && node.data < data) {
                temp = node;
                node = node.next;
            }
            newNode.next = node;
            temp.next = newNode;
            newNode.data = data;

            if (data > last.data) {
                last = newNode;
            }
        }

    }

    public int printFirstElement() {
        System.out.println("=_=");
        return head.data;
    }

    public int printLastElement() {
        System.out.println("=_=");
        return last.data;
    }

    public int linkedListLength() {
        Node node = head;
        int sum = 0;
        while (node != null) {
            node = node.next;
            sum += 1;
        }
        return sum;
    }

    public int sumLinkedListElements() {
        Node node = head;
        int sum = 0;
        while (node != null) {
            sum += node.data;
            node = node.next;
        }
        return sum;
    }

    public int maxElement() {
        Node node = head;
        int max = 0;
        while (node != null) {
            if (max < node.data) max = node.data;
            node = node.next;
        }
        return max;
    }
}
