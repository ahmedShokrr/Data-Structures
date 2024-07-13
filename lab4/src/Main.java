import java.util.*;
public class Main {
    public static void main(String args[]){
        ArrayQueue a1=new ArrayQueue(5);
        a1.Enqueue(5);
        a1.Enqueue(6);
        a1.display();
        System.out.println("----------");
        a1.Dequeue();
        a1.Dequeue();
        a1.display();
        System.out.println("----------");
        a1.Dequeue();
        a1.Enqueue(90);
        a1.display();
        System.out.println("----------");
        a1.Enqueue(25);
        a1.Enqueue(6);
        a1.display();
        System.out.println("----------");
        a1.Dequeue();
        a1.display();
        System.out.println("Thanks for using my program:)");

    }
}
