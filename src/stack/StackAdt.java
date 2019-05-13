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
        if (this.isEmpty()) return -1;
        int temp = dataArray[top];
        dataArray[top--] = 0;
        return temp;
    }

    public int peek(int index) {
        if (!(this.isEmpty()) && index < size && index > -1) return dataArray[index];
        return -1;
    }

    public int stackTop() {
        return top;
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
