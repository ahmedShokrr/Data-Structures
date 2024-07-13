# WebsiteIndexer

## Overview

This project is part of the CSE111 Data Structures course at Al Alamein International University. It implements an indexing system for popular websites and their IP addresses using an AVL Tree. The project demonstrates the practical use of the binary search tree ADT and AVL Tree for efficient data storage and retrieval.

## Features

- **Index Websites**:
  - Process a file with URLs and IP addresses.
  - Create an AVL tree index based on the website names.
  - Handle multiple IP addresses for a single website.

- **Functionalities**:
  - Display the full index of websites.
  - Search for a URL and retrieve all associated IP addresses.
  - Search for an IP address and find the associated URL.



## Usage

1. **Open the project in your IDE**:
    - Open Eclipse or your preferred IDE.
    - Import the project.

2. **Run the program**:
    - Locate the `Main.java` file in your IDE.
    - Run the `Main.java` file to execute the program.

3. **Interact with the program**:
    - Provide the input file name as a command line argument.
    - Follow the menu options to display the index, search for URLs, or search for IP addresses.

## Code Structure

- `Main.java`: Contains the main method to initiate the program and handle user interactions.
- `AVLTree.java`: Implements the AVL Tree data structure.
  - **Methods**:
    - `insert(String page, String ipAddress)`: Inserts or updates a node in the tree.
    - `display()`: Displays the AVL tree in alphabetical order.
    - `searchURL(String page)`: Searches for a URL and returns associated IP addresses.
    - `searchIP(String ipAddress)`: Searches for an IP address and returns the associated URL.
- `Node.java`: Represents a node in the AVL tree.
- `Utils.java`: Contains utility functions for reading the input file and processing data.

## Contribution

Contributions are welcome! Please feel free to submit a pull request or open an issue if you have any suggestions or improvements.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

For any questions or inquiries, please contact [your.email@example.com](mailto:your.email@example.com).
