package hashing;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Chaining myTable = new Chaining(10);
        myTable.display();
        myTable.insert(12);
        myTable.insert(222);
        myTable.insert(55);
        myTable.insert(55);
        myTable.insert(25);
        myTable.insert(65);
        myTable.display();
        System.out.println(Arrays.toString(myTable.searchList(12)));
        System.out.println(Arrays.toString(myTable.searchList(55)));
    }
}
