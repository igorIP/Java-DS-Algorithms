package sorting;


import java.util.Arrays;

public class App {

    public static void swap(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int[] bubbleSort(int[] array, int n) {
        int flag;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            flag = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) return array;
        }
        return array;
    }

    public static int[] insertionSort(int[] arr, int n) {
        int j, x, temp;
        for (int i = 1; i < n; i++) {
            j = i - 1;
            x = arr[i];
            while (j > -1 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = x;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr, int n) {
        int i, j, k;
        for (i = 0; i < n - 1; i++) {
            for (j = k = i; j < n; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            swap(arr, i, k);
        }
        return arr;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        do {
            do {
                i++;
            } while (arr[i] <= pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) swap(arr, i, j);
        } while (i < j);

        swap(arr, low, j);
        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int j;
        if (low < high) {
            j = partition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);
        }
    }


    //merge two lists represented by two arrays, using axillary array
    static int[] arrC = new int[20];

    public static void merge(int[] arrA, int[] arrB, int m, int n) {
        int i, j, k;
        i = j = k = 0;

        while (i < m && j < n) {
            if (arrA[i] < arrB[j]) {
                arrC[k++] = arrA[i++];
            } else {
                arrC[k++] = arrB[j++];
            }
        }

        for (; i < m; i++) {
            arrC[k++] = arrA[i];
        }
        for (; j < n; j++) {
            arrC[k++] = arrB[j];
        }
    }

    //merge two lists represented in one array using axillary array
    public static void merge(int[] arrA, int low, int mid, int high) {
        int i, j, k;
        i = k = low;
        j = mid + 1;
        int[] arrB = new int[high + 1];

        while (i <= mid && j <= high) {
            if (arrA[i] < arrA[j]) {
                arrB[k++] = arrA[i++];
            } else {
                arrB[k++] = arrA[j++];
            }
        }

        for (; i <= mid; i++) {
            arrB[k++] = arrA[i];
        }
        for (; j <= high; j++) {
            arrB[k++] = arrA[j];
        }

        for (i = low; i <= high; i++) {
            arrA[i] = arrB[i];
        }
    }


    //merge-sort two list represented in one array, Iterative-2-way merge sort
    public static void mergeSortIterative(int[] arr, int n) {
        int p, i, low, mid;
        int high = 0;
        for (p = 2; p <= n; p = p * 2) {
            for (i = 0; i + p - 1 < n; i = i + p) {
                low = i;
                high = i + p - 1;
                mid = (low + high) / 2;
                merge(arr, low, mid, high);
            }
        }
        if (p / 2 < n) {
            merge(arr, 0, p / 2, high - 1);
        }
    }

    //2-way merge sort, Recursively
    public static void mergeSortRecursion(int[] arr, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSortRecursion(arr, low, mid);
            mergeSortRecursion(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void countSort(int[] arr, int n) {
        int max = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int[] arrB = new int[max + 1];
        for (int i = 0; i < n; i++) {
            arrB[arr[i]] += 1;
        }

        for (int i = 0; i <= max; i++) {
            if (arrB[i] != 0) {
                while (arrB[i] > 0) {
                    arr[k++] = i;
                    arrB[i]--;
                }
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = {2, 5, 7, 33, 122};
        int[] arrB = {1, 55, 22, 44, 222};
        //System.out.println(Arrays.toString(bubbleSort(arr, arr.length)));
        //System.out.println(Arrays.toString(insertionSort(arr, arr.length)));
        //System.out.println(Arrays.toString(selectionSort(arr, arr.length)));
        //int[] arr = {8, 5, 7, 3, 2, Integer.MAX_VALUE};
        //quickSort(arr, 0, 5);
        //System.out.println(Arrays.toString(arr));
        //merge(arr, arrB, 5, 5);
        //System.out.println(Arrays.toString(arrC));
        //merge(arrB,0,2,4);
        //System.out.println(Arrays.toString(arrB));
        //mergeSortIterative(arrB, 4);
        //System.out.println(Arrays.toString(arrB));
        //mergeSortRecursion(arrB, 0, 4);
        //System.out.println(Arrays.toString(arrB));
        countSort(arrB,4);
        System.out.println(Arrays.toString(arrB));

    }


}
