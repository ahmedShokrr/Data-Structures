//Ahmed Mostafa bassouny Shokr   ID:20100547
public class BST implements BSTInterface {

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

    private Node insert_Recursive(Node root,int key){
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



    //search for key
    public boolean search(int key){
        Node currentRoot = root;
        currentRoot =searchRecursive(currentRoot,key);
        if (currentRoot != null)
            // exist
            return true;
        else
            //not exist
            return false;
    }


    //recursive search funtion

    private Node searchRecursive (Node currentRoot,int key){

        //Base cases: root is null or key is present at root
        if (currentRoot==null||currentRoot.key==key)
            return currentRoot;

        //if value is greater than the root's jey
        if (currentRoot.key>key)
            return searchRecursive(currentRoot.left,key);
        else
            //value is less than the root's key
            return searchRecursive(currentRoot.right,key);
    }

    //function for postorder trsversal of BST

    public void postorder(){
        postorderRecursive(root);
        System.out.println();
    }


    //recursively traverse the BST

    private void postorderRecursive(Node root){
        if (root!=null){
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.key+" ");
        }
    }

    //Breadth first Function To Print the BST dequeued in breadth first style

    public void breadth_first() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }



    private void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }



    private int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }



}
