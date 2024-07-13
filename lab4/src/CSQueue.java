
public class CSQueue{
    public int[] queue;
    public int capacity;
    public int front;
    public int rear;



    public CSQueue(int capacity){
        this.capacity=capacity;
        queue= new int[this.capacity];
        front=0;
        rear=0;

    }
    public void enQueue(int element){
        if (isFull()){
            System.out.println("Queue is full");

        }else{
            queue[rear]=element;
            rear=(rear+1)%capacity;
        }
    }

    public int enQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
            int element=queue[front];
            queue[front]=0;
            front=(front+1)%capacity;
            return element;
        }

    }
    public boolean isEmpty(){
        if (front==rear){
            return true;
        }else{
            return false;
        }
    }
    public boolean isFull(){
        if ((rear-front==capacity-1)||(rear-front==-1)){
            return true;
        }else {
            return false;
        }
    }
    public void display(){
        for (int i=front;i<=rear;i++){
            queue[i]=front;
        }
    }

}
