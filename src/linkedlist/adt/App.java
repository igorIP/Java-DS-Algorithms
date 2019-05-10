package linkedlist.adt;

public class App {
    public static void main(String[] args) {

        int[] myArr = {11, 22, 33, 44, 55};
        LinkedListAdt myList = new LinkedListAdt(myArr);
        //myList.create(myArr);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
        System.out.println(myList.linkedListLength());
        System.out.println(myList.sumLinkedListElements());
        System.out.println(myList.maxElement());
        System.out.println(myList.searchElement(44));
        System.out.println(myList.searchElementMoveToHead(55));
        myList.display();
        myList.display();
        myList.insertAfterIndex(3, 111);
        myList.display();
        myList.insertAfterLastNode(222);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
        LinkedListAdt myEmptyList = new LinkedListAdt();
        myEmptyList.createAlwaysAddLast(11);
        myEmptyList.createAlwaysAddLast(22);
        myEmptyList.createAlwaysAddLast(33);
        myEmptyList.display();
        System.out.println(myEmptyList.printFirstElement());
        System.out.println(myEmptyList.printLastElement());
        int[] arr = {11, 22, 33, 55};
        LinkedListAdt mySortedList = new LinkedListAdt(arr);
        //mySortedList.create(arr);
        mySortedList.display();
        System.out.println(mySortedList.printFirstElement());
        System.out.println(mySortedList.printLastElement());
        mySortedList.insertInSortedList(4);
        mySortedList.display();
        System.out.println(mySortedList.printFirstElement());
        System.out.println(mySortedList.printLastElement());

        myList.display();
        myList.deleteElement(6);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());

        myList.display();
        myList.deleteElementIteration(0);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());

        myList.display();
        System.out.println(myList.isSorted());
        mySortedList.display();
        System.out.println(mySortedList.isSorted());

        mySortedList.display();
        mySortedList.insertInSortedList(22);
        mySortedList.insertInSortedList(55);
        mySortedList.display();
        mySortedList.deleteDuplicatesInSortedList();
        mySortedList.display();

        myList.display();
        myList.reverseListElements(myList);
        myList.display();
        myList.reverseListElements(myList);

        System.out.println("reverseListLinksSlidingPointers");
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
        myList.reverseListLinksSlidingPointers();
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
        myList.reverseListLinksSlidingPointers();

        System.out.println("reverseListLinksRecursion");
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
        //myList.reverseListLinksRecursion(myList.last.next, myList.head);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());

        System.out.println("appendTwoLists");
        myList.deleteElement(2);
        LinkedListAdt myList1 = new LinkedListAdt();
        myList1.createAlwaysAddLast(12);
        myList1.createAlwaysAddLast(25);
        myList1.createAlwaysAddLast(55);
        myList1.display();
        //myList1.appendTwoLists(myList, myList1);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());


        System.out.println("Merge two lists");
        myList.display();
        myList1.display();
        myList.mergeTwoSortedLists(myList, myList1);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());

        System.out.println("Has Loop");
        myList.insertInSortedList(46);
        myList.display();
        System.out.println(myList.isLoop());

        System.out.println("Circular Singly Linked List");
        int[] myArr1 = {11, 22, 33};
        CircularSinglyLinkedListAdt myCircularList = new CircularSinglyLinkedListAdt(myArr1);
        myCircularList.display();
        //myCircularList.displayRecursion(myCircularList.head);

        System.out.println("Insert");
        System.out.println(myCircularList.length());
        myCircularList.insert(111, 3);
        myCircularList.display();

        System.out.println("Delete Element");
        myCircularList.display();
        myCircularList.deleteElement(2);
        myCircularList.display();

    }
}

