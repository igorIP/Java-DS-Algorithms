package matrices.adt;

public class DiagonalMatrix {

    private int[] arr;
    private int n;//diagonal matrix, here n is n*n elements

    public DiagonalMatrix() {
        this.n = 2;
        this.arr = new int[2];
    }

    public DiagonalMatrix(int n) {
        this.n = n;
        this.arr = new int[n];
    }

    public void setValue(int i, int j, int value) {
        if (i == j) {
            arr[i - 1] = value;
        }
    }

    public int getValue(int i, int j) {
        if (i == j) return arr[i - 1];
        else return 0;
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) System.out.printf(arr[i] + " ");
                else System.out.printf("0 ");
            }
            System.out.print("\n");
        }
    }
}
