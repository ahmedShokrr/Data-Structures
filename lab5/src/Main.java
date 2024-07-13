
public class Main {
    public static void main(String[] args){


        BST t1=new BST();
        t1.insert(60);
        t1.insert(130);
        t1.insert(120);
        t1.insert(40);
        t1.insert(35);
        t1.insert(60);
        t1.insert(250);
        t1.insert(10);
        t1.insert(80);
        t1.insert(145);
        t1.insert(50);
        t1.insert(125);
        t1.inorder();
        System.out.println("___________");
        t1.preorder();
        System.out.println("___________");
        t1.postorder();
        System.out.println("___________");
        t1.delete(60);
        t1.inorder();
        System.out.println("___________");
        System.out.println(t1.search(47));
        System.out.println("___________");
//        System.out.println("The maximum value is:"+t1.getmax());
//        System.out.println("___________");
        System.out.println("The minimum value is:"+t1.getmin());
//        System.out.println("___________");
//        System.out.println("Thanks for using my program");







    }
}

