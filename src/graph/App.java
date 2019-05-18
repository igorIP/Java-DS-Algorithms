package graph;

import matrices.sparce.matrixlinkedlist.*;

public class App {
    public static void main(String[] args) {
        SparseLinkedList adjacencyMatrix = new SparseLinkedList(5, 5, 4);
        adjacencyMatrix.createNonZeroElement();
        adjacencyMatrix.display();
    }
}
