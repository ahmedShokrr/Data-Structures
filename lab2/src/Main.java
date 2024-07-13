public class Main {
    public static void main (String args[]){
        SingleLinkedList a1= new SingleLinkedList();
        a1.add(15);
        a1.add(20);
        a1.add(55);
        a1.display();
        System.out.println("----------");


        a1.add(55555,1);
        a1.display();


        a1.add(-1);
        System.out.println("The minimum value is: " +a1.min());
        System.out.println("The maximum valus is: " +a1.max());

        System.out.println(a1.getcount());


        System.out.println("----------");
        a1.delete(15);
        System.out.println("----------");
        a1.display();

        boolean x=binarySearchLinkedList(a1.head, 55);





    }
    public static boolean binarySearchLinkedList(Node left, int element) {
        Node start = left;
        Node last = null;


        do {
            Node middleNode = getMiddle(start, last);
            if (middleNode == null) return false;
            if (middleNode.data == element) {
                return true;
            } else if (element > middleNode.data) {
                start = middleNode.next;
            } else if (element < middleNode.data) {
                last = middleNode;
            }
        } while (last == null || last != start);

        return false;


    }

    public static Node getMiddle(Node start, Node last) {
        if (start == null) return null;

        Node slow = start;
        Node fast = start.next;
        while (fast != last) {
            fast = fast.next;
            if (fast != last) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;

    }


    }


