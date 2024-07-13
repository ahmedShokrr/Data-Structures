    public class LinkedListStack {

    class Node {
        int data;
        Node next;


    }

    Node top;
    public LinkedListStack(int j){

        this.top=null;
    }

    public void push(int x){
        Node node = new Node();
        if(node ==null){
            System.out.println("Stack overFlow");
        }
        System.out.println("Inserting "+ x);
        node.data = x;
        node.next = top;
        top = node;

    }

    public boolean isEmpty() {
        return top == null;

    }

    public int peek(){
        if(!isEmpty()){
            return top.data;
        }
        else{
            System.out.println("the stack is empty");
            return -1;
        }


    }

    public void pop(){
        if(top == null){
            System.out.println("Stack underflow");
        }
        System.out.println("Removing "+peek());
        top =(top).next;
    }

    public void display(){
        if(top==null){
            System.out.println("Stack underflow");
        }
        else{
            Node temp = top;
            while (temp!=null){
                System.out.println(temp.data+ " ");
                temp = temp.next;
            }
            System.out.println();
        }
     }

 }
