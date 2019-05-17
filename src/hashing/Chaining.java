package hashing;

import java.util.Arrays;

public class Chaining {

    private Node[] hashTable;
    private int size;

    public Chaining(int size) {
        this.size = size;
        this.hashTable = new Node[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = null;
        }
    }

    public int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        insertInSortedList(hashTable[index], key, index);
    }

    private void insertInSortedList(Node node, int data, int index) {
        Node temp = node;
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (node == null) {
            hashTable[index] = newNode;
        } else {
            while (node != null && node.data < data) {
                temp = node;
                node = node.next;
            }
            if (temp == node) {
                newNode.next = node;
                hashTable[index] = newNode;
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    public int[] searchList(int key) {
        Node node = hashTable[hash(key)];
        int i = 0;
        int[] keysArr = new int[size];
        while (node != null) {
            keysArr[i] = node.data;
            i++;
            node = node.next;
        }
        return keysArr;
    }

    public void display() {
        System.out.println(Arrays.toString(hashTable));
    }
}
