import java.util.*;
public class MyCDLL {
    public doubleNode head;
    public doubleNode tail;
    public int size;


    //represent a node of CDLL
    class doubleNode {
        int data;
        doubleNode next;
        doubleNode previous;

        public doubleNode(int data) {
            this.data = data;
            next = null;
            previous = null;
        }
    }

    /*represent the head and tail of CDLL (but we if we do that we should remove constractor and
     line(3, 4) and make the initial value of size=0)*/

    /*
    public doubleNode head=null;
    public doubleNode tail=null;*/


    //constractor
    public MyCDLL() {
        head = null;
        tail = null;
        size = 0;

    }


    //this function is used to return the size of list
    public int getSize() {
        return size;

    }

    //this fuction is used print all data in the list
    public void displayList() {
        doubleNode current = head;
        if (head == null || size == 0) {
            System.out.println("List is Empty");
        } else {
            while (current.next != head) {
                System.out.print(current.data +" ");
                current = current.next;
            }
            System.out.print(current.data);
            System.out.println();
        }

    }

    //this method is used to add node in a specific position
    public void insert(int data, int index) {
        doubleNode newNode = new doubleNode(data);
        doubleNode current = head;
        if (index == 0) {
            addNodeatFirst(data);
            //return;
        } else if (index == size) {
            addNodeatEnd(data);
            //return;
        } else {
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.previous = newNode;
            newNode.previous = current;
            current.next = newNode;

        }
        size++;

    }

    //this method is used to delete a node in the list
    public void delete(int value) {
        doubleNode current = head;
        boolean flag = false;
        if(head == null || size == 0) {
            System.out.println("The List is Empty");
        } else if(head.data == value) {
            deleteNodeatFirst();
            flag = true;
        } else if(tail.data == value) {
            deleteNodeatEnd();
            flag = true;
        } else {
            while(current.next != head && current.data != value) {
                current = current.next;
            }
        }

        if(flag == false) {
            if(current == head) {
                System.out.println("The Value is't Found");
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
            }
        }

    }

    //function use to search for a node by their data (data in this node)
    public int Search(int value) {
        doubleNode current = head;
        if (size == 0) {
            System.out.println("The list is empty");
        } else {
            for(int i = 0; i < size; i++){
                if(current.data == value) {
                    return 1;
                } else {
                    current = current.next;
                }
            }
        }
        return 0;
    }

    /*this function is use to compare two lists and if they are identical,we will return 1
    else return 0*/

    public boolean compareTwoLists(MyCDLL list2) {
        boolean flag = false;
        doubleNode current = head;
        doubleNode current2 = list2.head;
        if (size == list2.getSize()){
            for(int i= 0; i < size; i++){
                for(int j = 0; j < list2.getSize();j++){
                    if(current.data == current2.data && i!=size+1){
                        i++;
                        flag = true;
                        current = current.next;
                        current2 = current2.next;
                    }else if(i == size+1) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;

    }
    //funtion to add one list at the end of another list
    public MyCDLL Append(MyCDLL list){
        MyCDLL newList = new MyCDLL();
        newList.size = size + list.getSize();
        newList.head = head;
        tail.next = list.head;
        list.head.previous = tail;
        list.tail.next = newList.head;
        newList.head.previous= list.tail;
        return newList;

    }
    //funtion to add new node at the first of the list
    public void addNodeatFirst(int value) {
        doubleNode newNode = new doubleNode(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.previous = tail;
        } else {
            newNode.next = head;
            newNode.previous = head.previous;
            head.previous = newNode;
            head = newNode;
            tail.next = head;
        }
        size++;
    }
    //funtion to add new node at the end of the list
    public void addNodeatEnd(int value) {
        doubleNode newNode = new doubleNode(value);
        if (size == 0) {
            tail = head = newNode;
            newNode.next = head;
            newNode.previous = tail;
        } else {
            newNode.previous = tail;
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
            head.previous = newNode;
        }
        size++;
    }
    //funtion to delete node at the first of the list
    public void deleteNodeatFirst() {
        if(head == null || size == 0) {
            System.out.println("List is Empty");
        } else {
            doubleNode temp = head;
            head = head.next;
            head.previous = tail;
            tail.next = head;
            temp.next = null;
            temp.previous = null;
            size--;
        }
    }

    //funtion to delete node at the End of the list
    public void deleteNodeatEnd() {
        if(head == null || size == 0) {
            System.out.println("List is Empty");
        } else {
            doubleNode temp = tail;
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
            temp.next = null;
            temp.previous = null;
            size--;
        }
    }


}









