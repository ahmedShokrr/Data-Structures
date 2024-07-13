public class ArrayQueue {
    public int[] myArray;
    public int length;
    public int front;
    public int rear;

    //Queue construction
    public ArrayQueue(int length){
        myArray=new int[length+1];
        this.length=0;
        rear=0;
        front=0;

    }
    //function to add number in the queue
    public void Enqueue(int value){
        System.out.println("Enqueue Value:"+value);
        myArray[rear]=value;
        rear=rear+1;
        length=length+1;

    }
    //function to remove the first number was added in the queue
    public int Dequeue(){
        if (isEmpty()){
            System.out.println("The Queue is Empty");
            return-1;
        }else {
            int temp=myArray[front];
            front=front+1;
            length--;
        }
        return length;

    }
    //check if the queue is empty or not

    public boolean isEmpty(){
        if (length==0)
            return true;
        else
            return false;
    }
    //funtion to display all the element in the queue
    public void display(){
        if (isEmpty()){
            System.out.println("The Queue is Empty");
        }else{
            for (int i= front;i<=rear;i++){
                System.out.print(myArray[i]+" ");
            }
            System.out.println();
        }

    }

}
