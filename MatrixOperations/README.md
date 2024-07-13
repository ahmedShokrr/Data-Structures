# MatrixOperations

## Overview

This project is part of the CSE111 Data Structures course at Al Alamein International University. It implements various operations on 2D matrices, such as addition, deletion of rows and columns, element deletion, padding, comparison, and transposition.

## Features

- **Matrix Operations**:
  - Add elements to the matrix.
  - Display the matrix.
  - Delete specific elements, rows, or columns.
  - Pad the matrix to a larger size with zeros.
  - Add two matrices.
  - Compare two matrices.
  - Transpose the matrix.

## Requirements

- Java Development Kit (JDK) 8 or later
- Eclipse IDE or any other Java IDE



## Usage

1. **Open the project in your IDE**:
    - Open Eclipse or your preferred IDE.
    - Import the project.

2. **Run the program**:
    - Locate the `Main.java` file in your IDE.
    - Run the `Main.java` file to execute the program.

3. **Interact with the program**:
    - Follow the prompts to add elements, delete items, delete rows/columns, pad the matrix, add matrices, compare matrices, and transpose matrices.

## Code Structure

- `Main.java`: Contains the main method to demonstrate the functionality of the matrix operations.
- `My2DMatrix.java`: Implements the matrix operations.
  - **Methods**:
    - `add()`: Adds elements to the matrix.
    - `display()`: Displays the matrix.
    - `deleteRow(int indexOfRow)`: Deletes a specific row from the matrix.
    - `deleteCol(int indexOfCol)`: Deletes a specific column from the matrix.
    - `deleteItem(int indexOfRow, int indexOfCol)`: Deletes a specific element from the matrix.
    - `padding(int newRowSize, int newColSize)`: Pads the matrix to a new size with zeros.
    - `addation(My2DMatrix otherMatrix)`: Adds two matrices.
    - `compare(My2DMatrix otherMatrix)`: Compares two matrices.
    - `transpose()`: Transposes the matrix.


## License

This project is licensed under the MIT License.


