//Ahmed Mostafa bassouny Shokr   ID:20100547
public class MyPQBST implements MyPQBSTInterface {
    private  BST[] MyPQArray;
    private int MaxSize;
    private int front;
    private int rear;  // numofelements

    //Constractor
    public MyPQBST(int MaxSize){
        MyPQArray = new BST[MaxSize+1];
        this.MaxSize=MaxSize;
        rear=0;
        front=0;
    }



    /*
    Function to insert the BST in the priority Queue
    The prioity is from maxiumun root to Minimum root
    priority is incrementally determined based on the BST’s root value.
     */

    public void EnqueueBST(BST value){
        if (rear==0){
            MyPQArray[rear]=value;
            rear++;
        }else {
             HandelEnqueu(value);
        }
    }

    //Handling Priority Queue
    private void HandelEnqueu(BST value){
        int i;
        for (i=rear-1;i>=0;i--){
            if (value.root.key>MyPQArray[i].root.key){
                MyPQArray[i+1]=MyPQArray[i];
            }else{
                break;
            }
        }
        MyPQArray[i+1]=value;
        rear++;
        MaxSize++;

    }



    /*
         Funtion To Print the BST dequeued in breadth first style
     */
    public void DequeueBST(){
        if (isEmpty()){
            System.out.println("The Queue is Empty");
        }else{
            BST temp = MyPQArray[front];
            front = front+1;
            MaxSize--;
            temp.breadth_first();
            System.out.println();
        }

    }


    //Check if the Queue is Empty or Not
    private boolean isEmpty(){

        if (MaxSize==0)
            return true;
        else
            return false;
    }



    //Display the Queue from front To End, where BSTs are Displayed in post-order Traverse Style
    public void QueueDisplay(){
        if (isEmpty()){
            System.out.println("The Queue is Empty");
        }else{
            for (int i= front;i<rear;i++){
                MyPQArray[i].postorder();
            }
            System.out.println();
        }
    }



    //Search all the queue and print the root of every tree that has the value
    public void search(int value) {
        for(int i = front; i < rear; i++) {
            if(MyPQArray[i].search(value) == true) {
                System.out.print(MyPQArray[i].root.key + " ");
            }

        }
        System.out.println();
    }

}
