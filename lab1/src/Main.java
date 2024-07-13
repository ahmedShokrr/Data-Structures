//Name:Ahmed Mostafa Shokr


//ID:20100547



public class Main {
        public static void main(String[] args){
            MyArray array1=new MyArray();//we create an object from the MyArray's class

            array1.setLength(10); //this method is used to set a value to the length

            array1.getValues(); //this method is used to make the size of array about the number of elements

            array1.delete(0); //this method is used to delete any element in the array
            array1.search(0);   //this method is used to search for any element in the array


            int result=array1.search(40);
            if (result==-1){
                System.out.println("not found!");
            }else{
                System.out.println("the value at index : "+result);

            }

            array1.display(); //this method is used to print the array(all elements in it)
            array1.Maximum(); //this method is used to find the maximum element in the array
            array1.Minimum(); //this method is used to find the minimum element in the array
            array1.insert(8888,2);
            array1.display();







    }
}
