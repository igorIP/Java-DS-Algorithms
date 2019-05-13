package stack;

import java.util.Arrays;

public class StackAdt {
    //ADT Stack using Array as DataWarehouse
    private int size;
    private int top;
    private int[] dataArray;//Space for Storing Elements

    public StackAdt(int size) {
        this.size = size;
        this.top = -1;
        this.dataArray = new int[size];
    }

    //Operations
    public void push(int data) {
        if (this.isFull()) return;
        dataArray[++top] = data;
    }

    public int pop() {
        if (top == -1) return -1;
        int temp = dataArray[top];
        dataArray[top--] = 0;
        return temp;
    }

    //position 0 is first element in the stack BUT last element int the array and vs.
    //formula for finding index of element in the array using the given position and the top is:
    //index = top - position + 1
    public int peek(int position) {
        if (top - position + 1 < 0) {
            int index = top - position + 1;
            return dataArray[index];
        }
        return -1;
    }

    public int stackTop() {
        return dataArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void display() {
        System.out.println(Arrays.toString(dataArray) + " -->Top is: " + top);
    }
}
