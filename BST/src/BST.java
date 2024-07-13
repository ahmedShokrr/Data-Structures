public class BST implements BSTInterface {
    private BSTNode root;

    /**
     *
     * no-args constructor. set the default value of root to null
     */
    public BST() {
        root = null;
    }

    /**
     * insert function - Insert a value at the BST using recursion method.
     * @param data
     */
    public void insert(int data) {
        root = insert_recursive(root, data);
    }


    /**
     * insert_recursive function
     * @param currentRoot
     * @param data
     * @return
     */
    private BSTNode insert_recursive(BSTNode currentRoot, int data) {
        BSTNode newNode = new BSTNode(data);
        if(currentRoot == null) {
            currentRoot = newNode;
            return currentRoot;
        }

        if(currentRoot.data > data) {
            currentRoot.left = insert_recursive(currentRoot.left, data);
        } else if(currentRoot.data < data) {
            currentRoot.right = insert_recursive(currentRoot.right, data);
        }
        return currentRoot;
    }

    /**
     * inorder_traversal function (Left -> Root -> Right)
     */
    public void inorder_traversal() {
        inorder_traversal_recursive(root);
    }

    /**
     * inorder_traversal_recursive function
     * @param currentRoot
     */
    private void inorder_traversal_recursive(BSTNode currentRoot) {
        if(currentRoot != null) {
            inorder_traversal_recursive(currentRoot.left);
            System.out.print(currentRoot.data + " ");
            inorder_traversal_recursive(currentRoot.right);
        }
    }

    /**
     * preorder_traversal function - (Root -> Left -> Right)
     */
    public void preorder_traversal() {
        preorder_traversal_recursive(root);
    }

    /**
     * preorder_traversal_recursive function
     * @param currentRoot
     */
    private void preorder_traversal_recursive(BSTNode currentRoot) {
        if(currentRoot != null) {
            System.out.print(currentRoot.data + " ");
            preorder_traversal_recursive(currentRoot.left);
            preorder_traversal_recursive(currentRoot.right);
        }
    }

    /**
     * postorder_traversal function - (Left -> Right -> Root)
     */
    public void postorder_traversal() {
        postorder_traversal_recursive(root);
    }

    /**
     * postorder_traversal_recursive function
     * @param currentRoot
     */
    private void postorder_traversal_recursive(BSTNode currentRoot) {
        if(currentRoot != null) {
            postorder_traversal_recursive(currentRoot.left);
            postorder_traversal_recursive(currentRoot.right);
            System.out.print(currentRoot.data + " ");
        }
    }

    /**
     * getMaxValue function - return maximum value in the tree
     * @return maxValue
     */
    public int getMaxValue() {
        BSTNode currentRoot = root;
        return getMaxValue(currentRoot);
    }

    /**
     * getMaxValue function - return maximum value in specific tree (sub tree)
     * Note: we can use this function in delete function.
     * @param currentRoot
     * @return
     */
    private int getMaxValue(BSTNode currentRoot) {
        int maxValue = currentRoot.data;
        while(currentRoot.right != null) {
            maxValue = currentRoot.right.data;
            currentRoot = currentRoot.right;
        }
        return maxValue;
    }

    /**
     * getMinValue function - return minimum value in the tree
     * @return
     */
    public int getMinValue() {
        BSTNode currentRoot = root;
        return getMinValue(currentRoot);
    }

    /**
     * getMinValue function - return minimum value in specific tree (sub tree)
     * Note: we use this function in delete function.
     * @param currentRoot
     * @return
     */
    private int getMinValue(BSTNode currentRoot) {
        int minValue = root.data;
        while(currentRoot.left != null) {
            minValue = currentRoot.left.data;
            currentRoot = currentRoot.left;
        }
        return minValue;
    }

    /**
     *  search function - search for a value in the BST (return true if found , 0 otherwise)
     * @param value
     * @return boolean
     */
    public boolean search(int value) {
        BSTNode rootReference = root;
        rootReference = search_recursive(rootReference, value);
        if(rootReference != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * search_recursive function
     * @param currentRoot
     * @param value
     * @return null or BSTNode object
     */
    private BSTNode search_recursive(BSTNode currentRoot, int value) {
        if(currentRoot == null || currentRoot.data == value) {
            return currentRoot;
        } else if(currentRoot.data > value) {
            return search_recursive(currentRoot.left, value);
        } else {
            return search_recursive(currentRoot.right, value);
        }
    }

    /**
     * getDataOfRoot function - return the data of root to check it in every state
     * @return root.data
     */
    public int getDataOfRoot() {
        return root.data;
    }

    /**
     * delete function - delete a value from the BST by calling delete_recursive function
     * @param value
     */
    public void delete(int value) {
        root = delete_Recursive(root, value);
    }

    /**
     *  delete_recursive function - delete a value from the BST using recursion method (leave node, node with one child
     *  and node with two children)
     * @param currentRoot
     * @param value
     * @return
     */
    private BSTNode delete_Recursive(BSTNode currentRoot, int value)  {
        if (currentRoot == null)
            return currentRoot;
        if (value < currentRoot.data) {
            currentRoot.left = delete_Recursive(currentRoot.left, value);
        } else if (value > currentRoot.data) {
            currentRoot.right = delete_Recursive(currentRoot.right, value);
        } else {
            if (currentRoot.left == null)
                return currentRoot.right;
            else if (currentRoot.right == null)
                return currentRoot.left;
            currentRoot.data = getMinValue(currentRoot.right);
            currentRoot.right = delete_Recursive(currentRoot.right, currentRoot.data);
        }
        return currentRoot;
    }
}
