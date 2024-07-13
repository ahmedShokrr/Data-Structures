import java.util.Scanner;

public class MyArray {
    private int n;
    private int []MyArray;

    /**
     * No args constractor
     */
    public MyArray() {

    }

    /**
     * function to Sort the Array Using Insertion Sort
     *
     */

    public void insertionSort(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        insertionSortAlgorithm(arr);

        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /**
     * function to Sort the Array Using MergeSort
     *
     */
    public void MergeSort(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        MegreSortAlgorithms(arr, 0, n - 1);
        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

    }

    /**
     * Recursive function of MegreSortAlgorthim
     * @param arr
     * @param lower
     * @param upper
     */
    private void MegreSortAlgorithms(int arr[], int lower, int upper){
        if (lower >= upper)
            return;
        int m = (lower + upper) / 2;
        MegreSortAlgorithms(arr, lower, m);
        MegreSortAlgorithms(arr, m + 1, upper);
        merge(arr, lower, upper);
    }

    /**
     * merge Algorthim
     * @param arr
     * @param lower
     * @param upper
     */
    private void merge(int arr[], int lower, int upper){
        int m = (lower + upper) / 2;
        int a[] = new int[m - lower + 1];
        int b[] = new int[upper - m];
        int i, k = 0, k1 = 0, k2 = 0;
        for (i = lower; i <= m; i++, k++)
            a[k] = arr[i];
        k = 0;
        for (; i <= upper; i++, k++)
            b[k] = arr[i];
        for (i = lower; i <= upper && k1 < m - lower + 1 && k2 < upper - m; i++) {
            if (a[k1] < b[k2]) {
                arr[i] = a[k1];
                k1++;
            } else {
                arr[i] = b[k2];
                k2++;
            }
        }
        for (; k1 < m - lower + 1; k1++)
            arr[i++] = a[k1];
        for (; k2 < upper - m; k2++)
            arr[i++] = b[k2];
    }

    /**
     * Recursive function of insertionSortAlgorthim
     * @param arr
     */
    private void insertionSortAlgorithm(int[]arr){
        int len = arr.length, tmp, j;
        for (int i = 1; i < len; i++) {
            tmp = arr[i];
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > tmp)
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = tmp;
        }
    }

    /**
     * function to store the array and give the params to the BinarySearchAlgorithm function
     */
    public void BinarySearch(){
        Scanner console=new Scanner(System.in);

        System.out.print("Enter an Intger: ");
        int key=console.nextInt();
        System.out.println();

        int arr[]={2, 3, 4, 10, 40};

        int r= arr.length;

        int result=BinarySearchAlgorithm(arr,0, r-1,key);

        if (result==-1) {
            System.out.println("The Number: " + key + " Was Not Found!!");
            System.out.println();
        }else {
            System.out.println("The Number: " + arr[result] + " Was Found At Index:(" + result + ")");
            System.out.println();
            System.out.print("And This is The Array : [ ");
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("]");
        }
    }

    /**
     * function to cheak if the number that we want to search for it , is found or not
     * @param arr
     * @param l
     * @param h
     * @param element
     * @return
     */
    private int BinarySearchAlgorithm(int arr[], int l, int h, int element){

            while (l<=h){

                int m=(l+h)/2;

                if (arr[m]==element) {

                    return m;

                }else if(arr[m]>element){

                    h=m-1;

                }else {

                    l=m+1;
                }
            }
            return -1;

        }

    /**
     * AVL Tree Implementation
      */
    class AVLTree
    {
        /**
         *         NODE structure
          */

        class Node
        {
            int value;
            int height;
            Node left;
            Node right;

            public Node(int value)
            {
                this.value = value;
                this.height = 1;
                this.left = null;
                this.right = null;
            }
        }


        /**
         * returns the height of the node
         * @param key
         * @return
         */
        private int Height(Node key)
        {
            if (key == null)
                return 0;

            else
                return key.height;
        }


        /**
         * Balance computes the balance factor of the node
         * @param key
         * @return
         */
        private int Balance(Node key)
        {
            if (key == null)
                return 0;

            else
                return ( Height(key.right) - Height(key.left) );
        }


        /**
         * updateHeight updates the height of the node
         * @param key
         */
        private void updateHeight(Node key)
        {
            int l = Height(key.left);
            int r = Height(key.right);

            key.height = Math.max(l , r) + 1;
        }

        /**
         * fucntion to get left rotation
         * @param x
         * @return
         */
        private Node rotateLeft(Node x)
        {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.right = T2;

            updateHeight(x);
            updateHeight(y);

            return y;
        }

        /**
         * fucntion to get right rotation
         * @param y
         * @return
         */
        private Node rotateRight(Node y)
        {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.left = T2;

            updateHeight(y);
            updateHeight(x);

            return x;
        }

        /**
         * balanceTree balances the tree using rotations after an insertion or deletion
          * @param root
         * @return
         */
        private Node balanceTree(Node root)
        {
            updateHeight(root);

            int balance = Balance(root);

            if (balance > 1) //R
            {
                if (Balance(root.right) < 0)//RL
                {
                    root.right = rotateRight(root.right);
                    return rotateLeft(root);
                }

                else //RR
                    return rotateLeft(root);
            }

            if (balance < -1)//L
            {
                if (Balance(root.left) > 0)//LR
                {
                    root.left = rotateLeft(root.left);
                    return rotateRight(root);
                }
                else//LL
                    return rotateRight(root);
            }

            return root;
        }

        Node Root;

        /**
         * function to insert new node with its data
         * @param root
         * @param key
         * @return
         */
        private Node AVLinsert(Node root, int key)
        {
            // Performs normal BST insertion
            if (root == null)
                return new Node(key);

            else if (key < root.value)
                root.left = AVLinsert(root.left, key);

            else
                root.right = AVLinsert(root.right, key);

            // Balances the tree after BST Insertion
            return balanceTree(root);
        }

        /**
         *    Successor returns the next largest node
         * @param root
         * @return
         */
        private Node Successor(Node root)
        {
            if (root.left != null)
                return Successor(root.left);

            else
                return root;
        }

        /**
         * function to remove  node
         * @param root
         * @param key
         * @return
         */
        private Node Remove(Node root, int key)
        {
            // Performs standard BST Deletion
            if (root == null)
                return root;

            else if (key < root.value)
                root.left = Remove(root.left, key);

            else if (key > root.value)
                root.right = Remove(root.right, key);

            else
            {
                if (root.right == null)
                    root = root.left;

                else if (root.left == null)
                    root = root.right;

                else
                {
                    Node temp = Successor(root.right);
                    root.value = temp.value;
                    root.right = Remove(root.right, root.value);
                }
            }

            if (root == null)
                return root;

            else
                // Balances the tree after deletion
                return balanceTree(root);
        }

        /**
         * findNode is used to search for a particular value given the root
         * @param root
         * @param key
         * @return
         */
        private Node findNode(Node root, int key)
        {
            if (root == null || key==root.value)
                return root;

            if (key < root.value)
                return findNode(root.left, key);

            else
                return findNode(root.right, key);
        }

        /**
         * Utility function for insertion of node
         * @param key
         */
        private void add(int key)
        {
            if (findNode(Root , key) == null)
            {
                Root = AVLinsert(Root , key);
                System.out.println("Insertion successful");
            }

            else
                System.out.println("\nKey with the entered value already exists in the tree");
        }

        public int search(int key)
        {
            if(findNode(Root, key) == null)
                return 0;
            else
                return 1;
        }

        /**
         * Utility function for deletion of node
         * @param key
         */
        private void delete(int key)
        {
            if (findNode(Root , key) != null)
            {
                Root = Remove(Root , key);
                System.out.println("\nDeletion successful ");
            }

            else
                System.out.println("\nNo node with entered value found in tree");
        }

        /**
         * function to print by InOrder style
         * @param root
         */
        private void InOrder(Node root)
        {
            if(root == null)
            {
                System.out.println("\nNo nodes in the tree");
                return;
            }

            if(root.left != null)
                InOrder(root.left);
            System.out.print(root.value + " ");
            if(root.right != null)
                InOrder(root.right);

        }

        /**
         * function to print by preorder style
         * @param root
         */
        private void PreOrder(Node root)
        {
            if(root == null)
            {
                System.out.println("No nodes in the tree");
                return;
            }

            System.out.print(root.value + " ");
            if(root.left != null)
                PreOrder(root.left);
            if(root.right != null)
                PreOrder(root.right);

        }

        /**
         * function to print by postorder style
         * @param key
         */
        private void PostOrder(Node key)
        {
            if(key == null)
            {
                System.out.println("No nodes in the tree");
                return;
            }


            if(key.left != null)
                PostOrder(key.left);
            if(key.right != null)
                PostOrder(key.right);
            System.out.print(key.value + " ");

        }

    }

    /**
     * the menu function of the AVL tree
     */
    public void AVLTreemenu(){

            Scanner scan = new Scanner(System.in);
            AVLTree tree = new AVLTree();
            while(true)
            {
                System.out.println("\n\n1) Insert\n2) Delete\n3) Search\n4) Inorder traversal\n5) Preorder traversal\n6) Postorder traversal\n7) Exit");
                int choice = scan.nextInt();
                if(choice == 7) {
                    System.out.println("Exit");
                    break;
                }
                switch(choice) {
                    case 1:
                    {
                        System.out.println("Enter the elements to add and enter -999 to stop:");
                        while(scan.hasNext()) {
                            int temp = scan.nextInt();
                            if(temp == -999)
                                break;
                            tree.add(temp);
                        }
                        System.out.println("\nInOrder Traversal :");
                        tree.InOrder(tree.Root);
                        System.out.println("\nPreOrder Traversal :");
                        tree.PreOrder(tree.Root);
                        System.out.println("\nPostOrder Traversal :");
                        tree.PostOrder(tree.Root);
                        break;
                    }

                    case 2:
                    {
                        System.out.println("Enter the element to be deleted:");
                        int temp = scan.nextInt();
                        tree.delete(temp);
                        System.out.println("\nInOrder Traversal :");
                        tree.InOrder(tree.Root);
                        System.out.println("\nPreOrder Traversal :");
                        tree.PreOrder(tree.Root);
                        break;
                    }

                    case 3:
                    {
                        System.out.println("Enter the element to be searched:");
                        int temp = scan.nextInt();
                        int c = tree.search(temp);
                        if(c==0)
                            System.out.println("\nKey not found");
                        else
                            System.out.println(temp + " Is Found");
                    }

                    case 4:
                    {
                        System.out.println("\nInOrder Traversal :");
                        tree.InOrder(tree.Root);
                        break;
                    }

                    case 5:
                    {
                        System.out.println("\nPreOrder Traversal :");
                        tree.PreOrder(tree.Root);
                        break;
                    }
                    case 6:
                    {
                        System.out.println("\nPostOrder Traversal :");
                        tree.PostOrder(tree.Root);
                        break;
                    }

                }
            }
        }
    }





