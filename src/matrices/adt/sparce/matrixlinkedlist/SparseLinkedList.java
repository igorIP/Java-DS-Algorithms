package matrices.adt.sparce.matrixlinkedlist;

import java.util.Scanner;

public class SparseLinkedList {
    private int numOfSparseRows;
    private int numOfSparseColumns;
    private int numNonZeroElements;
    private Node[] sparseRows;

    public SparseLinkedList(int numOfSparseRows, int numOfSparseColumns, int numNonZeroElements) {
        this.numOfSparseRows = numOfSparseRows;
        this.numOfSparseColumns = numOfSparseColumns;
        this.numNonZeroElements = numNonZeroElements;
        this.sparseRows = new Node[numOfSparseRows];
    }

    public void createNonZeroElement() {
        int rowNum, columnNum, elValue;
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < numNonZeroElements; i++) {

            System.out.println("Enter element row number: ");
            rowNum = scan.nextInt();
            System.out.println("Enter element column  number: ");
            columnNum = scan.nextInt();
            System.out.println("Enter  element value: ");
            elValue = scan.nextInt();

            Node temp = new Node();

            if (sparseRows[rowNum] == null) {
                sparseRows[rowNum] = temp;
                temp.last = temp;
            } else {
                sparseRows[rowNum].last.next = temp;
                sparseRows[rowNum].last = temp;
            }
            temp.row = rowNum;
            temp.column = columnNum;
            temp.value = elValue;
        }
    }

    public void display() {
        Node temp = new Node();
        for (int i = 0; i < numOfSparseRows; i++) {
            temp = sparseRows[i];
            for (int j = 0; j < numOfSparseColumns; j++) {
                if (temp == null || j != temp.column) {
                    System.out.print("0 ");
                } else {
                    System.out.print(temp.value + " ");
                }
            }
            System.out.println();
        }
    }
}
