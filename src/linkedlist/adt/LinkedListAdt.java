package linkedlist.adt;


public class LinkedListAdt {
    private Node head;
    private Node last;

    public LinkedListAdt() {
        this.head = null;
        this.last = null;
    }

    public LinkedListAdt(int[] array) {
        this.head = last = new Node();

        this.last.data = array[0];
        this.last.next = null;

        for (int i = 1; i < array.length; i++) {
            Node newNode = new Node();
            this.last.next = newNode;
            newNode.data = array[i];
            this.last = newNode;
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

    public void deleteElement(int index) {
        if (head == null) return;
        Node node = head;
        Node previous = new Node();

        if (index == 0) head = head.next;
        else if (head.next == null) head = null;
        else {
            int count = 0;
            while (node != null) {
                if (count == index) {
                    previous.next = node.next;
                    node.next = null;
                }
                count += 1;
                previous = node;
                if (last.equals(previous.next)) last = previous;
                node = node.next;
            }
        }
    }

    public void deleteElementIteration(int index) {
        Node node = head;
        Node previous = new Node();

        if (index == 0) head = head.next;
        else {
            for (int i = 0; i <= index - 1; i++) {
                previous = node;
                node = node.next;
            }
            if (last.equals(previous.next)) last = previous;
            previous.next = node.next;
            node.next = null;
        }
    }

    public void reverseListElements(LinkedListAdt list) {
        Node node = head;
        int length = linkedListLength();
        int[] array = new int[length];
        int i = 0;

//        for (int i = 0; i < length; i++) {
//            array[i] = node.data;
//            node = node.next;
//        }
//
//        node = head;
//        for (int i = length - 1; i >= 0; i--) {
//            node.data = array[i];
//            node = node.next;
//        }

        while (node != null) {
            array[i] = node.data;
            node = node.next;
            i++;
        }

        i--;
        node = head;

        while (node != null) {
            node.data = array[i];
            node = node.next;
            i--;
        }
    }

    public void reverseListLinksSlidingPointers() {
        Node node = head;
        Node previous = null;
        Node temp = null;
        last = head;

        while (node != null) {
            temp = previous;
            previous = node;
            node = node.next;

            previous.next = temp;
        }
        head = previous;
    }

    public void reverseListLinksRecursion(Node prev, Node current) {
        last = head;
        if (current != null) {
            reverseListLinksRecursion(current, current.next);
            current.next = prev;
        } else {
            head = prev;
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


    //Methods for Sorted LinkedList

    public boolean isSorted() {
        Node node = head;
        //with use of OBJ
//        while (node != null) {
//            if (node.data < node.next.data) {
//                if (node.next.next == null) {
//                    break;
//                }
//                node = node.next;
//            } else return false;
//        }
//        return true;

        //with use of primitive int, basically is like using the =previous pointer=
        int x = -1;
        while (node != null) {
            if (x > node.data) return false;
            x = node.data;
            node = node.next;
        }
        return true;
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

    public void deleteDuplicatesInSortedList() {
        Node node = head;
        Node previous = new Node();

        while (node != null) {
            if (previous.data == node.data) {
                previous.next = node.next;
                node.next = null;
                node = previous.next;
            } else {
                previous = node;
                node = node.next;
            }
        }
    }

    //Concatenating "meaning"-joining-append two linked lists

    public void appendTwoLists(LinkedListAdt list1, LinkedListAdt list2) {
        list1.last.next = list2.head;
        list1.last = list2.last;
        list2.head = null;
        list2.last = null;
    }

    public void mergeTwoSortedLists(LinkedListAdt list1, LinkedListAdt list2) {
        Node node1 = list1.head;
        Node node2 = list2.head;
        Node lastNode;
        Node node3Head;

        if (node1.data < node2.data) {
            node3Head = lastNode = node1;
            node1 = node1.next;
            lastNode.next = null;
        } else {
            node3Head = lastNode = node2;
            node2 = node2.next;
            lastNode.next = null;
        }
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                lastNode.next = node1;
                lastNode = node1;
                node1 = node1.next;
                lastNode.next = null;
            } else {
                lastNode.next = node2;
                lastNode = node2;
                node2 = node2.next;
                lastNode.next = null;
            }
        }

        if (node1 != null) {
            lastNode.next = node1;
            list1.last = node1;
        } else {
            lastNode.next = node2;
            list1.last = node2;
        }

        head = node3Head;
    }

    public boolean isLoop() {
        Node node, match;
        node = match = head;

//        while (match != null) {
//            match = match.next;
//            if (match == null) return false;
//            match = match.next;
//            node = node.next;
//            if (match == node) return true;
//        }
//        return false;

        do {
            node = node.next;
            match = match.next;
            match = match != null ? match.next : match;
        } while (match != null && match != node);
        if (node == match) return true;
        return false;
    }
}
