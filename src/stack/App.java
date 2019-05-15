package stack;

import java.util.ArrayList;

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

        System.out.println("\n" + "Stack using Linked List" + "\n");
        System.out.println("\n" + "Strings" + "\n");
        StackAdtLinkedList<String> StringStackList = new StackAdtLinkedList<>();
        System.out.println(myStackList.isEmpty());
        StringStackList.push("!");
        StringStackList.push("whats up ");
        StringStackList.push("Hey");
        StringStackList.display();
        System.out.println(StringStackList.pop());
        StringStackList.display();
        System.out.println(StringStackList.peek(3));
        System.out.println(StringStackList.stackPop());

        System.out.println("Parenthesis matching");
        StackAdtLinkedList<Character> myStackChar = new StackAdtLinkedList<>();
        ArrayList<Character> myArrayList1 = new ArrayList<>();
        myArrayList1.add('}');

        myArrayList1.add('(');
        myArrayList1.add('(');
        myArrayList1.add('a');
        myArrayList1.add('+');
        myArrayList1.add('b');
        myArrayList1.add(')');
        myArrayList1.add('*');
        myArrayList1.add('(');
        myArrayList1.add('c');
        myArrayList1.add('-');
        myArrayList1.add('d');
        myArrayList1.add(')');
        myArrayList1.add(')');
        System.out.println(myStackChar.isBalanced(myArrayList1));
        //myStackChar.display();
    }
}
