import java.util.*;
public class My2D {
    public int numofRows;
    public int numofColums;
    public int [][] myArray;

    //constructor supporting ragged arrays.
    public My2D(int numofRows,int numofColums){
        this.numofRows =numofRows;
        this.numofColums =numofColums;
        myArray =new int[numofColums][numofColums];

    }
    //this method is used to and elements in the matrix
    public void addElements(){
        Scanner console = new Scanner(System.in);
            for (int indexofRow =0;indexofRow<numofRows;indexofRow++){
                for (int indexofColum=0;indexofColum<numofColums;indexofColum++){
                    System.out.print("Enter The Element["+indexofRow+"]["+indexofColum+"]:");
                    myArray[indexofRow][indexofColum] =console.nextInt();
                }
            }

    }
    // display the martix (show all the rows and colums in the matrix
    public void matrixDisplay(){
            for (int indexofRow=0;indexofRow<numofRows;indexofRow++){
                for (int indexofColum=0;indexofColum<numofColums;indexofColum++){
                    System.out.print(myArray[indexofRow][indexofColum]);
                    System.out.print(" ");

                }
                System.out.println();
            }
    }

    //this function is used to delete one Row in the matrix
    public void deleteRow(int indexofRow){
        int[][] newArray=new int[numofRows-1][numofColums];
        for (int i=0;i<indexofRow;i++){
            for (int j=0;j<numofColums;j++){
                newArray[i][j]=myArray[i][j];
            }
        }

        for (int i =indexofRow+1;i<numofRows;i++){
            for (int j=0;j<numofColums;j++){
                newArray[i-1][j]=myArray[i][j];
            }
        }
        myArray=newArray;
        numofRows--;

    }
    //this function is used to delete one colum in the matrix
    public void deleteColum(int indexofColum){
            int[] [] newArray=new int[numofRows][numofColums-1];
            for (int i =0;i<numofRows;i++){
                for (int j =0;j<indexofColum;j++){
                        newArray[i][j]=myArray[i][j];
            }
        }
            for (int i=0;i<numofRows;i++){
                 for (int j=indexofColum+1;j<numofColums;j++){
                          newArray[i][j-1]=myArray[i][j];
            }
        }
        myArray=newArray;
        numofColums--;

    }
    //the function is used to delete one element in the matrix by replacing it by 0
    public void deleteItem(int indexofRow,int indexofColum){
        myArray[indexofRow][indexofColum]=0;


    }
    //fill in array with zeros to reach to the required size
    public void marixPadding(int newSizeofRows,int newSizeofColums){
            int[][] newArray=new int[newSizeofRows][newSizeofColums];
            for (int i=0;i<numofRows;i++){
                for (int j=0;j<numofColums;j++){
                    newArray[i][j]=myArray[i][j];
                }
            }
         myArray=newArray;
         numofRows=newSizeofRows;
         numofColums=newSizeofColums;

    }
    /*this function is used to get the maximum number between two numbers to know what is the size
    of the result matrix
    */
    public int max(int num1,int num2){
        if (num1>=num2)
            return num1;
        else
            return num2;

    }

    /*this function is use to return the addition of two martix by create a new type of data called My2D
    we send a parametar of class My2D*/

    public My2D matricesAddition(My2D othermarix){

        My2D addition=new My2D(max(numofRows,othermarix.numofRows),max(numofColums,othermarix.numofColums));

        marixPadding(addition.numofRows,addition.numofColums);

        othermarix.marixPadding(addition.numofRows,addition.numofColums);

        for (int indexofRows=0;indexofRows<numofRows;indexofRows++){

            for (int indexofColums=0;indexofColums<numofColums;indexofColums++){

                addition.myArray[indexofRows][indexofColums]=myArray[indexofRows][indexofColums]+othermarix.myArray[indexofRows][indexofColums];

            }
        }
        return addition;


    }
    /*this method is use to compare between two two matrix if they are identical the functun will retern 1
    else,it will retrun 0*/

    public int matricesComparison(My2D otherMatrix){
        boolean flag=false;
        if (numofRows==otherMatrix.numofRows&&numofColums==otherMatrix.numofColums){
            for (int indexofRow=0;indexofRow<numofRows;indexofRow++){
                for (int indexofColum=0;indexofColum<numofColums;indexofColum++){
                    if (myArray[indexofRow][indexofColum]!=otherMatrix.myArray[indexofRow][indexofColum]){
                        flag= true;
                        break;
                    }

                }
            }
            if (flag==false){
                return 1;
            } else{
                return 0;
            }

        }else{
            return 0;
        }
    }


    //function to transpose the matrix
    public void matrixTranspose(){
        if (numofRows==numofColums){
            int [][]newArray=new int[numofRows][numofColums];
            for (int indexofRow=0;indexofRow<numofRows;indexofRow++){
                for (int indexofColum=0;indexofColum<numofColums;indexofColum++){
                    newArray[indexofRow][indexofColum]=myArray[indexofColum][indexofRow];
                }
            }
            myArray=newArray;
        }else{
//            int[][]newArray=new int[numofRows][numofColums];
            My2D newArray=new My2D(numofColums,numofRows);
            for (int indexofRow=0;indexofRow<newArray.numofRows;indexofRow++){
                for (int indexofColum=0;indexofColum<newArray.numofColums;indexofColum++){
                    newArray.myArray[indexofRow][indexofColum]=myArray[indexofColum][indexofRow];

                }

            }
            myArray=newArray.myArray;
            numofRows= newArray.numofRows;
            numofColums= newArray.numofColums;
        }
    }



}
