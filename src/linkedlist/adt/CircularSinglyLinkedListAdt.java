package linkedlist.adt;

public class CircularSinglyLinkedListAdt {
    public Node head;
    private Node last;
    //private int flag = 0;


    public CircularSinglyLinkedListAdt(int[] array) {
        if (array.length == 0) return;
        this.head = new Node();
        this.head.data = array[0];
        this.head.next = head;
        this.last = head;

        for (int i = 1; i < array.length; i++) {
            Node node = new Node();
            node.next = last.next;//is like this because in circular I cant use =null in this case;
            node.data = array[i];
            last.next = node;
            last = node;
        }
    }

    public int length() {
        int count = 0;
        Node node = head;
        do {
            count++;
            node = node.next;
        } while (node != head);
        return count;
    }

    public void display() {
        System.out.println("===Start===");
        if (this.head == null) return;
        Node node = head;
        do {
            System.out.println(node.data);
            node = node.next;
        } while (node != head);
        System.out.println("===End===");
    }

//    public void displayRecursion(Node node) {
//        if (node != head || flag == 0) {
//            flag = 1;
//            System.out.println(node.data);
//            displayRecursion(node.next);
//        }
//        flag = 0;
//    }

    public void insert(int value, int index) {
        //Important: The Head is not changing when I insert before head: 11=head 22 33 44 111
        //Hint: Also I can make the head to point to the new node: 111=Head 11 22 33 44
        if (index < 0 || index > length()) {
            System.out.println("Enter valid index");
            return;
        }
        Node node = head;
        Node newNode = new Node();
        newNode.data = value;

        if (index == 0) {
            if (head == null) {
                head = newNode;
                head.next = head;
                last = head;
            } else {
                last.next = newNode;
                newNode.next = head;
                head = newNode;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            if (node == last) last = newNode;
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public void deleteElement(int index) {
        Node node = head;
        Node previous;
        int count = 1;
        if (index < 1 || index > length()) return;
        else if (index == 1) {
            if (head.next == null) {
                head = null;
                last = null;
            } else {
                last.next = head.next;
                head.next = null;
                head = last.next;
            }
        } else {
            do {
                count++;
                previous = node;
                node = node.next;
            } while (index != count);
            previous.next = node.next;
            node.next = null;
            if (index == length()) last = previous;
        }
    }
}
