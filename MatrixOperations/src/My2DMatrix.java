import java.util.Scanner;
public class My2DMatrix {
    public int numOfRows;
    public int numOfCols;
    public int[][] arr;

    public My2DMatrix(int numOfRows, int numOfCols) {
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        arr = new int[numOfRows][numOfCols];
    }

    public void add() {
        Scanner console = new Scanner(System.in);
        for(int i = 0; i < numOfRows; i++) {
            for(int j = 0; j < numOfCols; j++) {
                System.out.print("Enter value[" + i + "][" + j + "]: ");
                arr[i][j] = console.nextInt();
            }
        }
    }

    public void display() {
        for(int i = 0; i < numOfRows; i++) {
            for(int j = 0; j < numOfCols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void deleteRow(int indexOfRow) {
        int[][] newArray = new int[numOfRows-1][numOfCols];
        for(int i = 0; i < indexOfRow; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                newArray[i][j] = arr[i][j];
            }
        }
        for(int i = indexOfRow + 1; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                newArray[i - 1][j] = arr[i][j];
            }
        }
        arr = newArray;
        numOfRows--;
    }

    public void deleteCol(int indexOfCol) {
        int[][] newArray = new int[numOfRows][numOfCols];

        for(int i = 0; i < numOfRows; i++) {
            for(int j = 0; j < indexOfCol; j++) {
                newArray[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < numOfRows; i++) {
            for(int j = indexOfCol+1; j < numOfCols; j++) {
                newArray[i][j-1] = arr[i][j];
            }
        }
        arr = newArray;
        numOfCols--;
    }

    public void deleteItem(int indexOfRow, int indexOfCol) {
        arr[indexOfRow][indexOfCol] = 0;
    }

    public void padding(int newRowSize, int newColSize) {
        int[][] newArray = new int[newRowSize][newColSize];
        for(int i = 0; i < numOfRows; i++) {
            for(int j =0; j < numOfCols; j++) {
                newArray[i][j] = arr[i][j];
            }
        }

        arr = newArray;
        numOfCols = newColSize;
        numOfRows = newRowSize;
    }

    public My2DMatrix addation(My2DMatrix otherMatrix) {
        My2DMatrix result = new My2DMatrix(max(numOfRows, otherMatrix.numOfRows), max(numOfCols, otherMatrix.numOfCols));
        padding(result.numOfRows, result.numOfCols);
        otherMatrix.padding(result.numOfRows, result.numOfCols);

        for(int i = 0; i < result.numOfRows; i++) {
            for(int j = 0; j < result.numOfCols; j++){
                result.arr[i][j] = arr[i][j] + otherMatrix.arr[i][j];
            }
        }

        return result;
    }

    public int max(int n1, int n2) {
        if(n1 > n2)
            return n1;
        else if(n2 > n1)
            return n2;
        else
            return n1;
    }

    public int compare(My2DMatrix otherMatrix) {
        boolean flag = false;
        if(numOfRows == otherMatrix.numOfRows && numOfCols == otherMatrix.numOfCols) {
            for(int i = 0; i < numOfRows; i++) {
                for(int j = 0; j < numOfCols; j++) {
                    if(otherMatrix.arr[i][j] != arr[i][j]) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag == false) {
                return 1;
            } else {
                return 0;
            }
        } else {
           return 0;
        }
    }

    public void transpose() {
        if(numOfCols == numOfRows) {
            My2DMatrix newmatrix = new My2DMatrix(numOfCols, numOfRows);
            for (int row = 0; row < numOfRows; row++) {
                for (int col = 0; col < numOfCols; col++) {
                    newmatrix.arr[row][col] = arr[col][row];
                }
            }
            arr = newmatrix.arr;
        } else {
            My2DMatrix newMatrix = new My2DMatrix(numOfCols, numOfRows);
            for(int row = 0; row < newMatrix.numOfRows; row++) {
                for(int col = 0; col < newMatrix.numOfCols; col++) {
                    newMatrix.arr[row][col] = arr[col][row];
                }
            }
            arr = newMatrix.arr;
            numOfCols = newMatrix.numOfCols;
            numOfRows = newMatrix.numOfRows;
        }
    }
}
