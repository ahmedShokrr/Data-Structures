import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]){
            MyCDLL l1=new MyCDLL();

            l1.insert(5,0);
            l1.insert(55,1);
            l1.insert(88,2);

            System.out.println("Display Funtion ....");

            l1.displayList();
            System.out.println("Delete Funtion ....");

            l1.delete(88);
            l1.displayList();
            System.out.println("Search Funtion ....");

            System.out.println(l1.Search(5));

            System.out.println("Compare Two Lists Funtion ....");


            MyCDLL l2=new MyCDLL();
            l2.insert(5,0);
            l2.insert(55,1);
            //take care we delete data:88 at index 2 (line 10)
            System.out.println(l1.compareTwoLists(l2));

            System.out.println("Appending Funticon ....");
            MyCDLL l3=new MyCDLL();
            MyCDLL l4=new MyCDLL();
            MyCDLL result=new MyCDLL();
            l3.insert(53,0);
            l4.insert(54,0);
            result=l3.Append(l4);
            result.displayList();
            System.out.println("Thanks for using my program:)");








    }
}
