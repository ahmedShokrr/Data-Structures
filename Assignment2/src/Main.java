//Ahmed Mostafa bassouny Shokr   ID:20100547

import java.util.*;

public class Main {
    public static void main(String[] args){


            //Random funtion to get numbers Randomly to fill the BST
            Random R1 = new Random();

            BST T1 = new BST();
            T1.insert(70);
            T1.insert(60);
            //Fill The the BST of 15 Numbers from 1 to 100
            for(int i = 0; i < 15; i++) {
                T1.insert(R1.nextInt(100));
            }

            //(_______________________________________________________________________________)
            BST T2 = new BST();
            T2.insert(43);

            //Fill The the BST of 15 Numbers from 1 to 100
            for(int i = 0; i < 15; i++) {
                    T2.insert(R1.nextInt(100));
            }

            //(_______________________________________________________________________________)
            BST T3 = new BST();
            T3.insert(80);
            T3.insert(60);
            //Fill The the BST of 15 Numbers from 1 to 100
            for(int i = 0; i < 15; i++) {
                    T3.insert(R1.nextInt(100));
            }

            //(_______________________________________________________________________________)
            BST T4 = new BST();
            T4.insert(100);
            //Fill The the BST of 15 Numbers from 1 to 100
            for(int i = 0; i < 15; i++) {
                    T4.insert(R1.nextInt(100));
            }


            //Fill The Priority Queue With The BSTS(Trees)
            MyPQBST myqueue = new MyPQBST(4);
            myqueue.EnqueueBST(T2);
            myqueue.EnqueueBST(T2);
            myqueue.EnqueueBST(T3);
            myqueue.EnqueueBST(T4);

            System.out.println("Search Function: ");
            System.out.print("The Number 60 is Found in ");
            myqueue.search(60);

            System.out.println("Display Function: ");
            myqueue.QueueDisplay();

            System.out.println("Dequeue Function: ");
            myqueue.DequeueBST();
            myqueue.DequeueBST();

            System.out.println();

            System.out.println("Displaying After Dequeue: ");
            myqueue.QueueDisplay();
            System.out.println("Thanks For Using My Program:)");




    }
}
