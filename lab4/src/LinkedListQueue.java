//Ahmed mostafa Bassouny Shokr ID:20100547
public class LinkedListQueue {

    class Node{
        int data;
        Node next;
    }
    Node head;
    public LinkedListQueue(){
        this.head=null;

    }
    //function to add node with a value  in the LinkedListQueue
    public void Enqueue(int value){
        if (head==null){
            System.out.println("The Queue is empty");
            head=new Node();
            head.data=value;
            head.next=null;
        }else {
            Node temp=head;
            while (temp.next!=null){
                temp.next=null;
            }
            temp.next=new Node();
            temp.next.data=value;
            temp.next.next=null;

        }
    }
    //check if the LinkedListQueue is empty or not
    public boolean isEmpty(){
        if(head==null){
            return true;
        }else {
            return false;

        }
    }
    //function to remove a first node we add in the LinkedListQueue
    public int Dequeue(){
        if (isEmpty()){
            System.out.println("The Queue is empty");
            return -1;
        }else{
            int value=head.data;
            head=head.next;
            return value;
        }
    }
    //function to display all the value in the linkedListQueue
    public void display(){
    if (isEmpty()){
        System.out.println("The Queue is empty");

    }else{
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();



    }
    }
    }
