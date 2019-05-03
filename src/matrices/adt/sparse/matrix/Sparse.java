package matrices.adt.sparse.matrix;

import java.util.Scanner;

public class Sparse {
    //dimension is row*column
    public int rows;//number of rows
    public int columns;
    public int numNonZeroElements;//number of non-zero elements
    Element[] el;//el is pointer to an Object of type Element[] "meaning" (array with objects of type Element)

    public Sparse(int rows, int columns, int numNonZeroElements) {
        this.rows = rows;
        this.columns = columns;
        this.numNonZeroElements = numNonZeroElements;
        el = new Element[this.numNonZeroElements];
    }

    public void read() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the non-zero elements: " + "\n");
        for (int i = 0; i < numNonZeroElements; i++) {
            el[i].rowPosition = scan.nextInt();
            el[i].columnPosition = scan.nextInt();
            el[i].value = scan.nextInt();
        }
    }

    public void display() {
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (el[k].columnPosition == i && el[k].rowPosition == j) {
                    System.out.printf(el[k++].value + " ");
                } else {
                    System.out.printf("0 ");
                }
            }
            System.out.println("\n");
        }
    }

    public Sparse AdditionOperator(Sparse sparse) {
        int i, j, k;
        if (rows != sparse.rows || columns != sparse.columns) {
            return null;
        }
        Sparse sum = new Sparse(rows, columns, numNonZeroElements + sparse.numNonZeroElements);
        i = j = k = 0;
        while (i < numNonZeroElements || j < sparse.numNonZeroElements) {
            if (el[i].rowPosition < sparse.el[j].rowPosition) {
                sum.el[k++] = el[i++];
            } else if (el[i].rowPosition > sparse.el[j].rowPosition) {
                sum.el[k++] = el[j++];
            } else {
                if (el[i].columnPosition < sparse.el[j].columnPosition) {
                    sum.el[k++] = el[i++];
                } else if (el[i].columnPosition > sparse.el[j].columnPosition) {
                    sum.el[k++] = el[j++];
                } else {
                    sum.el[k] = el[i];
                    sum.el[k++].value = el[i++].value + sparse.el[j++].value;
                }
            }
        }
        for (; i < numNonZeroElements; i++) sum.el[k++] = el[i];
        for (; j < sparse.numNonZeroElements; j++) sum.el[k++] = sparse.el[j];
        sum.numNonZeroElements = k;

        return sum;
    }
}