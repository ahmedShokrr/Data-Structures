
//Name:Ahmed Mostafa Shokr


//ID:20100547


import java.util.*;
public class MyArray implements MyArrayinterface {

        private static int[] array;
        private static int length;
        private static int counter = 0;


        //constructor
        public MyArray() {
//        this.length=10;
//        array=new int[length];
        }

        public MyArray(int length) {
            array = new int[length];
            this.length = length;


        }

        //this method is used to set a value to the length
        public void setLength(int length) {
            this.length = length;
            array = new int[length];


        }

        //this method is used to get the value of the length
        public int getLength() {
            return length;


        }

        //this method is used to make the size of array about the number of elements
        public  void getValues() {
            Scanner console = new Scanner(System.in);
            System.out.println("Enter the number of values you want to insert : ");
            int numofelements = console.nextInt();
            int counter2 = counter;
//        counter+=numofelements;
            for (int i = 0 + counter2; i < numofelements + counter2; i++) {
                System.out.println("array[" + i + "] :");
                array[i] = console.nextInt();
                counter++;


            }

        }

        //this method is used to add elements in any index in the array
         public void insert(int number, int position) {
            for (int index = counter - 1; index >= position; index--) {
                array[index + 1] = array[index];
            }
            array[position] = number;

            counter++;


        }

        //this method is used to delete any element in the array
        public void delete(int position) {
            for (int index = position; index < counter - 1; index++) {
                array[index] = array[index + 1];

            }
//        array[counter]=0;
            counter--;


        }

        //this method is used to print the array(all elements in it)
        public void display() {
            System.out.print("{" + array[0]);
            for (int index = 1; index < counter; index++) {
                System.out.print(", " + array[index]);
            }
            System.out.print("}");
            System.out.println();


        }

        //this method is used to search for any element in the array
        public int search(int value) {
            for (int index = 0; index < length; index++) {
                if (array[index] == value) {
                    // System.out.println("the value at index " + index);
                    return index;


                }

            }

            return -1;


        }

        //this method is used to find the maximum element in the array
        public  void Maximum() {
            int max = Integer.MIN_VALUE;
            for (int index = 0; index < counter; index++) {
                if (array[index] > max) {
                    max = array[index];

                }
            }
            System.out.println("the maximum is: " + max);


        }

        //this method is used to find the minimum element in the array
        public  void Minimum() {
            int min = Integer.MAX_VALUE;
            for (int index = 0; index < counter; index++) {
                if (array[index] < min) {
                    min = array[index];

                }
            }
            System.out.println("the minimum is: " + min);
        }

    }
