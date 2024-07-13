// Name: Ahmed Mostafa Bassouny Shokr              ID: 20100547
// Name: Yousef Tarek ALi Abdelaziz                ID: 20200102
// Name: Youssef Mohamed Gamaleldin Samy Badreldin ID: 20100294
// Name: Nour Walid Mohamed Abdelhalim Mohamed     ID: 20100250


public class PriorityQueue{
     PriorityQueueNode front;
     PriorityQueueNode rear;
     private int size;

     public PriorityQueue() {
         front = rear = null;
         size = 0;
     }

    public void enqueue(Pair item) {
        PriorityQueueNode newItem = new PriorityQueueNode(item);
        if(isEmpty()) {
            front = rear = newItem;
        } else if(Integer.parseInt(newItem.data.statistics) >= Integer.parseInt(front.data.statistics)){
            newItem.next = front;
            front = newItem;
        } else if(Integer.parseInt(newItem.data.statistics) <= Integer.parseInt(rear.data.statistics)) {
            rear.next = newItem;
            rear = newItem;
        } else {
            PriorityQueueNode current = front;
            PriorityQueueNode  afterCurrent = front.next;
            while(afterCurrent != null) {
                if(Integer.parseInt(current.data.statistics) >= Integer.parseInt(item.statistics ) &&
                        Integer.parseInt(item.statistics) >= Integer.parseInt(afterCurrent.data.statistics)) {
                    break;
                }
                current = afterCurrent;
                afterCurrent = afterCurrent.next;
            }
            current.next = newItem;
            newItem.next = afterCurrent;
        }
        size++;
    }

    public Pair dequeue() {
        if(!isEmpty()) {
            PriorityQueueNode  temp = front;
            front = front.next;
            temp.next = null;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void display() {
        PriorityQueueNode  current = front;
        while(current != null) {
            System.out.println(current.toString() + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Pair peek() {
        return front.data;
    }

    public int getSize() {
        return size;
    }
}
