public class DoubleLinkedList {
    public DNode head;
    public DNode tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertFirst(int data) {
        DNode newNode = new DNode(data);
        if(head == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertLast(int data) {
        DNode newNode = new DNode(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void displayFromHeadToTail() {
        DNode current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayFromTailToHead() {
        DNode current = tail;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.println();
    }

    public void insert(int data, int index) {
        if (indexValidation(index)) {
            System.out.println("Index out of the bound.");
        } else if (index == 0) {
            insertFirst(data);
        } else if (index == size) {
            insertLast(data);
        } else {
            DNode newNode = new DNode(data);
            DNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // current pointer is point to the before index node
            }
            newNode.next = current.next;
            newNode.previous = current;
            current.next = newNode;
            current.next.next.previous = newNode;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    private boolean indexValidation(int index) {
        return (index < 0 || index > size);
    }

    public void deleteAtFirst() {
        if(head == null || size == 0) {
            System.out.println("List is Empty");
        } else {
            DNode temp = head;
            head = head.next;
            head.previous = null;
            temp.next = null;
            size--;
        }
    }

    public void deleteAtLast() {
        if(head == null || size == 0) {
            System.out.println("List is Empty");
        } else {
            DNode temp = tail;
            tail = tail.previous;
            tail.next = null;
            temp.previous = null;
            size--;
        }
    }

    public void delete(int data) {
        boolean flag = false;
        DNode current = head;
        if(head == null || size == 0) {
            System.out.println("List is Empty");
        } else if(head.data == data) {
            deleteAtFirst();
            flag = true;
        } else if(tail.data == data) {
            deleteAtLast();
            flag = true;
        } else {
            while (current != null && current.data != data) {
                current = current.next;
            }
        }
        if(flag == false) {
            if(current == null) {
                System.out.println("Value not found in List");
            } else {
                current.next.previous = current.previous;
                current.previous.next = current.next;
                size--;
            }
        }
    }

    public int get(int index) {
        DNode current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
