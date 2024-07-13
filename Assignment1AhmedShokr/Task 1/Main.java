public class Main {
    public static void main(String args[]){


//           ************* here we check (AddElements, matrixDisplay, deleteItem, deleteRow, deleteColums) ****************
                      My2D a1=new My2D(3,3);
                    a1.addElements();
                    a1.matrixDisplay();
                    System.out.println("-----------");
                    a1.deleteItem(2,2);
                    a1.matrixDisplay();
                    System.out.println("-----------");
                    a1.deleteRow(1);
                    a1.matrixDisplay();
                    System.out.println("-----------");
                    a1.deleteColum(1);
                    a1.matrixDisplay();



//           ************** Here we Check the padding function ******************
                      My2D a2=new My2D(2,2);

                    a2.addElements();
                    a2.matrixDisplay();
                    System.out.println("-----------");
                    a2.marixPadding(3,3);
                    a2.matrixDisplay();
                    System.out.println("-----------");



//           ************** Here we Check the addition function,comparison function and transpose function ***************

                      a1.addElements();
                      a1.matrixDisplay();
                      System.out.println("-----------");
                      a2.addElements();
                      a2.matrixDisplay();
                      System.out.println("-----------");
                      My2D addition = a1.matricesAddition(a2);
                      addition.matrixDisplay();
                      System.out.println("-----------");
                      System.out.println(a1.matricesComparison(a2));
                      System.out.println("-----------");
                      a1.matrixTranspose();
                      a1.matrixDisplay();
                      System.out.println("-----------");
                      System.out.println("Thanks for using my program:)");









    }
}
