package linkedlist.adt;

public class CircularSinglyLinkedList {
    public Node head;
    private Node last;
    //private int flag = 0;


    public CircularSinglyLinkedList(int[] array) {
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
            } else {
                last.next = newNode;
                newNode.next = head;
                head = newNode;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
    }
}
