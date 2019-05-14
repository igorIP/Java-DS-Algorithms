package stack;

public class App {
    public static void main(String[] args) {
        StackAdt myStack1 = new StackAdt(10);
        myStack1.display();
        System.out.println(myStack1.isEmpty());
        System.out.println(myStack1.isFull());
        System.out.println(myStack1.peek(0));

        myStack1.push(11);
        myStack1.display();
        System.out.println(myStack1.isEmpty());
        System.out.println(myStack1.isFull());
        System.out.println(myStack1.peek(0));
        System.out.println(myStack1.peek(1));

        myStack1.push(22);
        myStack1.push(33);
        myStack1.display();
        System.out.println(myStack1.peek(1));

        myStack1.push(33);
        myStack1.push(44);
        myStack1.push(55);
        myStack1.push(66);
        myStack1.push(77);
        myStack1.push(88);
        myStack1.push(99);
        myStack1.push(33);
        myStack1.display();
        System.out.println(myStack1.isFull());
        System.out.println(myStack1.peek(10));

        System.out.println(myStack1.stackTop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.stackTop());
        myStack1.display();

        //Stack using Linked List
        System.out.println("\n" + "Stack using Linked List" + "\n");
        StackAdtLinkedList myStackList = new StackAdtLinkedList();
        System.out.println(myStackList.isEmpty());
        myStackList.push(11);
        myStackList.push(22);
        myStackList.push(33);
        myStackList.display();
        System.out.println(myStackList.pop());
        myStackList.display();
        System.out.println(myStackList.peek(3));
        System.out.println(myStackList.stackPop());
    }
}
