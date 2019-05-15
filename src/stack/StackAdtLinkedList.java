package stack;

import java.util.ArrayList;

public class StackAdtLinkedList<T> {

    private Node top;
    //Important; Insertion in stack created with linked list,
    //  is always from head because otherwise we have to traverse the list to add node;

    public StackAdtLinkedList() {
        this.top = null;
    }

    public void push(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        T value = null;
        if (top != null) {
            Node node = top;
            top = top.next;
            node.next = null;
            value = node.data;
            return value;
        }
        return value;
    }

    public T peek(int position) {
        T pos = null;
        Node node = top;
        if (top != null) {
            for (int i = 1; i < position; i++) {
                node = node.next;
                if (node == null) return pos;
            }
            return node.data;
        }
        return pos;
    }

    public T stackPop() {
        if (top != null) return top.data;
        return null;
    }

    public void display() {
        System.out.println("Start");
        Node node = top;
        T temp;
        if (top != null) {
            while (node != null) {
                temp = node.data;
                System.out.println(temp);
                node = node.next;
            }
        }
        System.out.println("End");
    }

    public boolean isEmpty() {
        return top == null;
    }

    //method for parentheses matching
    public boolean isBalanced(ArrayList<Character> charArrayList) {
        int ch;
        for (Character arrayItem : charArrayList) {
            if (arrayItem == '(' || arrayItem == '{' || arrayItem == '[') push((T) arrayItem);

            else if (arrayItem == ')' || arrayItem == '}' || arrayItem == ']') {
                if (top == null) return false;
            } else {
                ch = (char) stackPop();
                if (ch + 1 == (int) arrayItem) pop();
                else if (ch + 2 == (int) arrayItem) pop();
            }
        }
        return top == null;
    }

    private class Node {
        private T data;
        private Node next;
    }
}
