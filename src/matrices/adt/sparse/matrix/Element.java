package matrices.adt.sparse.matrix;

import java.util.Scanner;

public class Element {
    //position of the element in matrix
    int rowPosition;
    int columnPosition;
    int value;//value of the element

    public void create(Sparse structure) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimensions: ");
        structure.row = sc.nextInt();
        structure.column = sc.nextInt();
        System.out.println("Enter number of non-zero elements: ");
        structure.numNonZero = sc.nextInt();
        structure.El = new Element[structure.numNonZero];

        System.out.println("Enter all non-zero elements");
        for (int i = 0; i < structure.numNonZero; i++) {
            structure.El[i].rowPosition = sc.nextInt();
            structure.El[i].columnPosition = sc.nextInt();
            structure.El[i].value = sc.nextInt();
        }
    }

    public void AddTwoSparseMatrices(Sparse structure1, Sparse structure2){

    }

    public void display(){

    }
}
