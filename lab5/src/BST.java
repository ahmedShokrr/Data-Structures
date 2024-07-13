
public class BST {

    //represent a node of the BST
    class Node{
        int key;
        Node left,right;
        public Node(int key){
            this.key=key;
            this.right=null;
            this.left=null;
        }
    }

    //BST root node
    Node root;


    //constractor Empty BST
    public BST(){
        root=null;
    }


    //insert a node in BST

    public void insert(int key){
        root=insert_Recursive(root,key);
    }


    //recuesive insert function

    Node insert_Recursive(Node root,int key){
        //check if the tree is empty
        if (root==null){
            root =new Node(key);
            return root;
        }
        //traverse the tree
        if (key<root.key)   //insert in the left subtree
            root.left=insert_Recursive(root.left,key);
        else if (key>root.key) //insert in the right subtree
            root.right=insert_Recursive(root.right,key);
        return root;

    }


    //get the minimum value in the tree

    public int getmin(){
        return minValue(root);
    }


    //Minimum value in the BST

    public int minValue(Node root){
        //initially minimum value == root
        int minValue = root.key;
        //find the minimum by While loop
        while (root.left!=null){
            minValue=root.left.key;
            root=root.left;
        }
        return minValue;
    }


    //get the maxumim value

    public int getmax(){
        return maxValue(root);
    }
    public int maxValue(Node root){
        //initially Maxium value == root
        int maxValue=root.key;
        //find the maxumim value ==root
        while (root.right!=null){
            maxValue=root.right.key;
            root=root.right;
        }
        return maxValue;

    }


    //search for key

    public boolean search(int key){
        root=searchRecursive(root,key);
        if (root!=null)
            // exist
            return true;
        else
            //not exist
            return false;
    }


    //recursive search funtion

    Node searchRecursive (Node root,int key){

        //Base cases: root is null or key is present at root
        if (root==null||root.key==key)
            return root;

        //if value is greater than the root's jey
        if (root.key>key)
            return searchRecursive(root.left,key);
        else
            //value is less than the root's key
            return searchRecursive(root.right,key);
    }


    //function for inorder trsversal of BST

    public void inorder(){
        inorderRecursive(root);
        System.out.println();
    }


    //recursively traverse the BST

    public void inorderRecursive(Node root){
        if (root!=null){
            inorderRecursive(root.left);
            System.out.print(root.key+" ");
            inorderRecursive(root.right);
        }

    }


    //function for postorder trsversal of BST

    public void postorder(){
        postorderRecursive(root);
        System.out.println();
    }


    //recursively traverse the BST

    public void postorderRecursive(Node root){
        if (root!=null){
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.key+" ");
        }
    }


    //function for pretorder trsversal of BST

    public void preorder(){
        preorderRecursive(root);
        System.out.println();
    }


    //recursively traverse the BST

    public void preorderRecursive(Node root){
        if (root!=null){
            System.out.print(root.key+" ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }


    public void delete(int key){
        root=deleteRecursive(root,key);
    }

    //Recursive delete function
    Node deleteRecursive(Node root,int key) {
        //tree is empty
        if (root == null)
            return root;

        //traverse the tree
        if (key < root.key) //traverse left subtree
            root.left = deleteRecursive(root.left, key);
        else if (key > root.key)   //traverse right substree
            root.right = deleteRecursive(root.right, key);
        else {
            //node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            //node has two children
            //get inorder successor(min value in the right subtree)
            root.key = minValue(root.right);

            //Delete the inorder Successor
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }





}
