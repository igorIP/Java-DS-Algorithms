package queue;

public class App {
    public static void main(String[] args) {
        //Queue can be implemented with array and inked list
        QueueADT myQueue = new QueueADT();
        myQueue.enQueue(11);
        myQueue.enQueue(22);
        myQueue.enQueue(33);
        myQueue.display();
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        myQueue.display();

        PriorityQueue myPrioQue=new PriorityQueue();
        myPrioQue.enQueue(11);
        myPrioQue.enQueue(1);
        myPrioQue.enQueue(13);
        myPrioQue.enQueue(44);
        myPrioQue.display();
    }
}
