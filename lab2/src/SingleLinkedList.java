public class SingleLinkedList{

     public Node head;
     public Node tail;
     private int size;


     /**
     * no-args constructor - set the default value of head and tail to null and size to zero
     */
     public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
     }

    /**
     * add function - create new node object and pass in the data then add this new node to the tail of the list.
     * @param data
     */

    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // newNode will be added after tail such that tail's next will point to the newNode
            tail.next = newNode;

            // newNode will become the new tail of the list
            tail = newNode;
        }
        size++;
    }

    /**
     * insertFirst function - create new node object and pass in the data then add this new node to the head.
     * @param data
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * insert function - create new node object and pass in the data then add this new node to the specific index.
     * @param data
     * @param index
     */
    public void add(int data, int index) {
        if(index == 0) {
            insertFirst(data);
        } else {
            Node newNode = new Node(data);
            Node beforeIndex = head;

            for (int i = 0; i < index - 1; i++) {
                beforeIndex = beforeIndex.next;
            }

            Node afterIndex = beforeIndex.next;
            beforeIndex.next = newNode;
            newNode.next = afterIndex;
            size++;
        }
    }



    /**
     * display function - iterate over the all nodes and print its data
     */


    public void display() {
        Node current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        while(current != null) {
            // prints each node by incrementing the pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * delete function - take the value that the user want to delete then delete it, if the value not found in the
     * linkedlist then the function will print "List is empty".
     * @param valueOfNode
     */
    public void delete(int valueOfNode) {
        Node current = head;
        Node beforeCurrent = null;
        boolean flag = false;

        if(head == null) {
            System.out.println("List is empty");
            return;
        } else  if(current.data == valueOfNode){
            head = current.next;
            current = null;
            flag = true;
            size--;
        } else {
            while (current.next != null && current.data != valueOfNode) {
                beforeCurrent = current;
                current = current.next;
            }
        }
        if(flag == false) {
            if (current == null) {
                System.out.println("Value not found");
            } else {
                beforeCurrent.next = current.next;
                if (beforeCurrent.next == null)
                    tail = beforeCurrent;
                size--;
            }
        }
    }

    /**
     * min function - return minimum value in the list
     * @return minValue
     */
    public int min() {
        int minValue = Integer.MAX_VALUE;
        Node current = head;

        for(int index = 0; index < size; index++) {
            if(current.data < minValue)
                minValue = current.data;
            current = current.next;
        }
        return minValue;
    }

    /**
     * max function - return maximum value in the list
     * @return maxValue
     */
    public int max() {
        int maxValue = Integer.MIN_VALUE;
        Node current = head;

        for(int index = 0; index < size; index++) {
            if(current.data > maxValue)
                maxValue = current.data;
            current = current.next;
        }
        return maxValue;
    }

    /**
     * getSize function - return size of the list (number of the node in the list)
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * get function - return value (data) of the node in specific index
     * @param index
     * @return value (data)
     */
    public int get(int index) {
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    /**
     * this method is used to get the number of nodes in the linked list
     */

    public int getcount() {
        if (head == null)
            return 0;
        Node current = head;
        int count = 0;
        while (current != null)
            count++;
        current = current.next;

        return count;


      }
  }




/*
 public class SingleLinkedList {


    //represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    //this method is use to add a new node to the linked list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }


    }
    //this method is used to add node in a specific position
    public void addNode(int data, int index) {
        Node newNode = new Node(data);
        Node node1 = head;
        for (int i = 1; i < index - 1; i++) {
            node1 = node1.next;
        }
        Node node2 = node1.next;
        node1.next = newNode;
        newNode.next = node2;

    }

    //this method is used to display all the node in the linked list
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();


    }

    //this method is used to get the minimum data in linked list
    public int getmin() {
        if (head == null)
            // list empty
            return 0;
        Node current = head;
        int min = current.data;

        while (current.next != null) {
            if (current.next.data < min)
                min = current.next.data;
            current = current.next;
        }
        return min;


    }

    //this method is used to get the maximum value in the list
    public int getmax() {
        if (head == null)
            // list empty
            return 0;
        Node current = head;
        int max = current.data;

        while (current.next != null) {
            if (current.next.data > max)
                max = current.next.data;
            current = current.next;
        }
        return max;



    }

    //this method is used to get the number of nodes in the linked list
    public int getcount() {
        if (head == null)
            return 0;
        Node current = head;
        int count = 0;
        while (current != null)
            count++;
        current = current.next;

        return count;


    }

    //this method is used to delete a node in the list
    public int delete(int value) {
        if (head == null) {
            return 0;
        }
        Node current = head;
        Node before_current = null;
        while (current != null && current.data != value) {
            before_current = current;
            current = current.next;
        }
        if (current == head) {
            head = current.next;
            return 1;
        } else if (current == null) {
            //value is not found
            return 2;
        } else {
            before_current.next = current.next;
            if (before_current.next == null) {
                tail = before_current;
                return 1;
            }
        }
        return 3;


    }

    //this method is used to get the node my its index
    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;


    }
 }
 */