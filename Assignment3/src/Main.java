/**
 *
 *
 * Name:Ahmed Mostafa Bassouny SHOKR                ID:20100547
 * Name:Youssef Mohamed gamaleldin samy badreldin   ID:20100294
 *
 *
 */

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        MyArray a1=new MyArray();
        menu(a1);


    }
    public static void menu(MyArray a1) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------- MENU --------------------");
        System.out.println();
        System.out.println("1) Sort The Array Using Insertion Sort. ");
        System.out.println("2) Sort The Array Using Merge Sort.");
        System.out.println("3) Search For a Value Using BinarySearch.");
        System.out.println("4) Search For a Value Using AVL Search.");
        System.out.println("5) Exit.");
        System.out.println();
        System.out.print("Enter Your Choice : ");
        String choice = input.next();


        if (choice.equals("1")) {
            System.out.println("-------------------- Insertion Sort --------------------");
            System.out.println();
            a1.insertionSort();
            System.out.println();
            menu(a1);
        } else if (choice.equals("2")) {
            System.out.println("-------------------- Merge Sort --------------------");
            System.out.println();
            a1.MergeSort();
            System.out.println();
            menu(a1);
        }else if(choice.equals("3")) {
            System.out.println("-------------------- BinarySearch --------------------");
            System.out.println();
            a1.BinarySearch();
            System.out.println();
            menu(a1);
        }else if(choice.equals("4")){
            System.out.println("-------------------- AVL Tree Search --------------------");
            System.out.println();
            a1.AVLTreemenu();
            System.out.println();
            menu(a1);
        } else if (choice.equalsIgnoreCase("exit") || choice.equals("5")) {
            System.out.println("Thanks for using our program");
        } else {
            System.out.println("InValid Choice. ");
            menu(a1);
        }
    }
    }

