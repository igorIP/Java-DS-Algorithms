package matrices.adt.sparse.matrix;

import java.util.Scanner;

public class Element {
    //position of the element in matrix
    public int rowPosition;
    public int columnPosition;
    public int value;//value of the element

    public void create(Sparse sparse) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimensions: ");
        sparse.rows = sc.nextInt();
        sparse.columns = sc.nextInt();
        System.out.println("Enter number of non-zero elements: ");
        sparse.numNonZeroElements = sc.nextInt();
        sparse.el = new Element[sparse.numNonZeroElements];

        System.out.println("Enter all non-zero elements");
        for (int i = 0; i < sparse.numNonZeroElements; i++) {
            sparse.el[i].rowPosition = sc.nextInt();
            sparse.el[i].columnPosition = sc.nextInt();
            sparse.el[i].value = sc.nextInt();
        }
    }
}
