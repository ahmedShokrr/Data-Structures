import java.util.*;
public class Queue implements Queueinterface {
    public Node front;
    public Node rear;
    public int size;


    //constructor

    public Queue() {
        this.front = null;
    }


    //function to add node(contain Data) in the Queue

    public void enqueue(Node data) {
        if (front == null) {
            front = rear = data;
        } else {
            rear.next = data;
            rear = data;
        }
        size++;
    }


    //fuction to check if the Queue is empty or not

    public boolean isEmpty() {
        if (front == null) {
            return true;
        } else
            return false;
    }


    //function to remove node(contain Data) from the Queue

    public Node dequeue() {
        if (rear == null) {
            return null;
        } else {
            Node temp = front;
            front = front.next;
            temp.next = null;
            size--;
            return temp;

        }

    }
}