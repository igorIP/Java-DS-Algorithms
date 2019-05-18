package graph;


import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static void main(String[] args) {

        int g[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0}};


        System.out.println("BFS");
        BFS(g, 1, 7);
        System.out.println("===");
        BFS(g, 5, 7);
        System.out.println("===");
        BFS(g, 6, 7);

        System.out.println("DFS");
        //DFS(g, 1, 7);
        System.out.println("===");
        DFS(g, 5, 7);
        System.out.println("===");
        //DFS(g, 6, 7);
    }

    public static void BFS(int[][] G, int start, int n) {
        int i = start;
        int d;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = {0, 0, 0, 0, 0, 0, 0};

        System.out.println(start);
        visited[i] = 1;
        q.add(i);

        while (!q.isEmpty()) {
            d = q.remove();
            for (int v = 1; v < n; v++) {
                //for-loop is: if there is and edge and if is not visited
                if (G[d][v] == 1 && visited[v] == 0) {
                    System.out.println(v);
                    visited[v] = 1;
                    q.add(v);
                }
            }
        }
    }

    static int[] visited = {0, 0, 0, 0, 0, 0, 0};

    public static void DFS(int[][] g, int start, int n) {
        if (visited[start] == 0) {
            System.out.println(start);
            visited[start] = 1;
            for (int v = 1; v < n; v++) {
                if (g[start][v] == 1 && visited[v] == 0) {
                    DFS(g, v, n);
                }
            }
        }
    }
}

