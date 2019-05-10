package array;

import java.util.List;

public class ArrayADT {
    private int[] arr;
    private int size;
    private int length;

    //Constructors
    public ArrayADT(int size) {
        this.size = size;
        this.length = 0;
        this.arr = new int[this.size];
    }

    //Methods

    //Binary Search with Loop
    public int binarySearchLoop(int key) {
        int first = 0;
        int last = length - 1;
        int mid = length / 2;
        //only on sorted array
        //first , mid = half(floor), last;
        //is mid the key
        //is mid < or > from the key
        //if key is bigger, then we go right, the new first is mid+1, new mid is (mid+last)/2, and last is the same until the end of the GOING searching right
        //if key is smaller then we go left,  the new last is mid-1, new mid is (first + mid)/2, and first is the same until the end of GOING searching left

        while (first <= last) {
            if (key == arr[mid]) return mid;

            else if (key < arr[mid]) {
                last = mid - 1;
                mid = (first + mid) / 2;
            } else {
                first = mid + 1;
                mid = (first + last) / 2;
            }
        }
        return -1;
    }

    //Binary Search with Recursion
    public int binarySearchRecursion(int key, int first, int last) {
        if (first <= last) {
            int mid = (first + last) / 2;
            if (key == arr[mid]) return mid;
            else if (key < arr[mid]) return binarySearchRecursion(key, first, mid - 1);
            else return binarySearchRecursion(key, mid + 1, last);
        }
        return -1;
    }

    public void display() {
        System.out.printf("\nElements are\n");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    public void sort() {
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                //important: j = i + 1 because when i increments, after that all items on the left of i are sorted so-
                //I need to check for smaller item starting from i+1 to the right.
                //if I start with j = 1 that means compare again every j with i-sorted.
                //this is because  we have loop in loop!!
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return  true;
    }

    public void appendAdd(int value) {
        if (length < size) {
            arr[length] = value;
            length++;
        }
    }

    public int search(int x) {
        for (int i = 0; i < length; i++) {
            if (x == arr[i]) return i;
        }
        return -1;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int delete(int index) {
        int temp = arr[index];
        if (index >= 0 && index < length) {
            for (int i = index; i < length - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
        length--;
        return temp;
    }

    public void insert(int index, int value) {
        if (index >= 0 && index <= length) {
            for (int i = length - 1; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = value;
            length++;
        }
    }

    public void reverse() {
        int i = 0;
        int k = length - 1;
        int temp;
        while (i < k) {
            temp = arr[i];
            arr[i++] = arr[k];
            arr[k--] = temp;
        }
        //System.arraycopy(temp, 0, arr, 0, length);
    }

    public void shiftLeft() {
        for (int i = 0; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[length - 1] = 0;
    }

    public void rotateLeft() {
        int temp = arr[0];
        for (int i = 0; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[length - 1] = temp;
    }

    public int max() {
        int max = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public int min() {
        int min = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }
}
