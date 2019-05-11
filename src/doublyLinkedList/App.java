package doublyLinkedList;

public class App {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44};
        DoublyLinkedListAdt myList = new DoublyLinkedListAdt();
        myList.create(arr);
        myList.display();
        System.out.println(myList.length());
        myList.insert(0, 1);
        myList.display();
        myList.insert(1, 2);
        myList.display();
        myList.insert(6, 6);
        myList.display();
        myList.delete(2);
        myList.display();
        myList.delete(6);
        myList.display();
    }
}
