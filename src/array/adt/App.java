package array.adt;

public class App {

    public static void main(String[] args) {

        ArrayADT myArray = new ArrayADT(10);
        ArrayADT myArray2 = new ArrayADT(5);
        myArray.Insert(0, 222);
        myArray.Insert(1, 133);
        myArray.Insert(2, 44);
        myArray.Insert(3, 555);
        myArray.Insert(4, 66);
        myArray.Display();
        myArray.Display();

    }
}
