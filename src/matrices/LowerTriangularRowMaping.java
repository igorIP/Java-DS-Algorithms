package matrices;

public class LowerTriangularRowMaping {
    private int[] arr;
    private int n;

    public LowerTriangularRowMaping() {
        this.n = 2;
        this.arr = new int[(2 * (2 + 1)) / 2];
    }

    public LowerTriangularRowMaping(int n) {
        this.n = n;
        this.arr = new int[(n * (n + 1)) / 2];
    }

    public void setValue(int i, int j, int value) {
        if (i >= j) {
            int index = i * (i - 1) / 2 + j - 1;
            arr[index] = value;
        }
    }

    public int getVlaue(int i, int j) {
        if (i >= j) return arr[(i * (i - 1)) / 2 + (j - 1)];
        return 0;
    }

    public void display() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j) System.out.print(arr[(i * (i - 1)) / 2 + (j - 1)] + " ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
