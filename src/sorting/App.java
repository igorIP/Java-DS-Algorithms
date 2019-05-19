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

    public static void main(String[] args) {

        int[] arr = {8, 5, 7, 3, 2};
        //System.out.println(Arrays.toString(bubbleSort(arr, arr.length)));
        //System.out.println(Arrays.toString(insertionSort(arr, arr.length)));
        System.out.println(Arrays.toString(selectionSort(arr, arr.length)));

    }


}
