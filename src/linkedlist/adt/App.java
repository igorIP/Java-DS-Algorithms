package linkedlist.adt;

public class App {
    public static void main(String[] args) {

        int[] myArr = {11, 22, 33, 44, 55,};
        LinkedListAdt myList = new LinkedListAdt();
        myList.create(myArr);
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
        LinkedListAdt mySortedList = new LinkedListAdt();
        int[] arr = {11, 22, 33, 55};
        mySortedList.create(arr);
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

        System.out.println("reverseListLinksRecursion");
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
        myList.reverseListLinksRecursion(myList.last.next, myList.head);
        myList.display();
        System.out.println(myList.printFirstElement());
        System.out.println(myList.printLastElement());
    }
}

