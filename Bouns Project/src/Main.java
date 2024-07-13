// Name: Ahmed Mostafa Bassouny Shokr              ID: 20100547
// Name: Yousef Tarek ALi Abdelaziz                ID: 20200102
// Name: Youssef Mohamed Gamaleldin Samy Badreldin ID: 20100294
// Name: Nour Walid Mohamed Abdelhalim Mohamed     ID: 20100250


import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        AVLTree govTree = new AVLTree();
        read_gov_data_from_file("C:\\Users\\Ahmed Shokr\\IdeaProjects\\Bouns Project\\src\\governorates_data.txt", govTree);

        AVLTree cropTree = new AVLTree();
        read_crop_data_from_file("C:\\Users\\Ahmed Shokr\\IdeaProjects\\Bouns Project\\src\\crops_data.txt", cropTree);

        System.out.println("----------------------------------- Menu ------------------------------------");
        menu(govTree, cropTree);

    }


    public static void menu(AVLTree govTree, AVLTree cropTree) {
        Scanner console = new Scanner(System.in);
        System.out.println("1) Search For Crop Data.");
        System.out.println("2) Search For Governorate Data.");
        System.out.println("3) Print All Data.");
        System.out.println("4) Exit.");
        System.out.print("Option: ");
        String option = console.next();
        System.out.println("-----------------------------------------------------------------------------");


        if(option.equals("1")) {
            System.out.print("Enter the name of the crop: ");
            cropTree.search(console.next());
            System.out.println("-----------------------------------------------------------------------------");
            menu(govTree, cropTree);
        } else if(option.equals("2")) {
            System.out.print("Enter the governorate name: ");
            govTree.search(console.next());
            System.out.println("-----------------------------------------------------------------------------");
            menu(govTree, cropTree);
        } else if(option.equals("3")) {
            System.out.println("Governorate Data:- ");
            govTree.breadth_first_traverse();
            System.out.println("Crop Data:- ");
            cropTree.breadth_first_traverse();
            System.out.println("-----------------------------------------------------------------------------");
            menu(govTree,cropTree);
        } else if(option.equals("4")) {
            System.out.println("----------------------------------- Finish ----------------------------------");
            System.out.println("-----------------------------------------------------------------------------");
        } else {
            menu(govTree, cropTree);
        }
    }

    public static void read_gov_data_from_file(String fileName, AVLTree tree) {
        try {
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNext()) {
                String line = reader.nextLine();
                String[] information = line.split(" ");
                PriorityQueue test = new PriorityQueue();
                for(int i = 1; i < information.length-1; i+=2) {
                    test.enqueue(new Pair(information[i], information[i+1]));
                }
                tree.insert(information[0], test);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }

    public static void read_crop_data_from_file(String fileName, AVLTree tree) {
        try {
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNext()) {
                String[] line = reader.nextLine().split(" ");
                PriorityQueue test = new PriorityQueue();

                for(int i = 1; i < line.length-1; i+=2) {
                    test.enqueue(new Pair(line[i], line[i+1]));
                }
                tree.insert(line[0], test);
            }
            reader.close();
        } catch(FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }
}
