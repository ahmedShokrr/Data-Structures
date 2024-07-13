// Name: Ahmed Mostafa Bassouny Shokr              ID: 20100547
// Name: Yousef Tarek ALi Abdelaziz                ID: 20200102
// Name: Youssef Mohamed Gamaleldin Samy Badreldin ID: 20100294
// Name: Nour Walid Mohamed Abdelhalim Mohamed     ID: 20100250

import java.util.*;

class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public void insert(String websiteName, PriorityQueue queue) {
        AVLNode newNode = new AVLNode(websiteName);
        PriorityQueueNode current = queue.front;
        for(int i = 0; i < queue.getSize(); i++) {
            newNode.addPairToQueueData(current.data);
            current = current.next;
        }
        root = insert_recursive(root, newNode);
        balancePath(websiteName);
    }

    private AVLNode insert_recursive(AVLNode currentRoot,  AVLNode newNode) {
        if (currentRoot == null)
            return newNode;
        if(compare(currentRoot.getData(), newNode.getData()) == 1) {
            currentRoot.left = insert_recursive(currentRoot.left, newNode);
        } else if(compare(currentRoot.getData(), newNode.getData()) == -1) {
            currentRoot.right = insert_recursive(currentRoot.right, newNode);
        }
        return currentRoot;
    }

    private void updateHeight(AVLNode currentNode) {
        if(currentNode.right == null && currentNode.left == null) {
            currentNode.height = 0;
        } else if(currentNode.left == null) {
            currentNode.height = 1 + currentNode.right.height;
        } else if(currentNode.right == null) {
            currentNode.height = 1 + currentNode.left.height;
        } else {
            currentNode.height = 1 + Math.max(currentNode.right.height, currentNode.left.height);
        }
    }

    private void balancePath(String data) {
        try {
            ArrayList<AVLNode> path = new ArrayList<>();
            for (int i = path.size() - 1; i >= 0; i--) {
                AVLNode currentNode = path.get(i);
                updateHeight(currentNode);
                AVLNode parentOfA = (currentNode == root) ? null : path.get(i - 1);
                if (balanceFactor(currentNode) == -2) {
                    if (balanceFactor(currentNode.left) <= 0) {
                        balanceLL(currentNode, parentOfA); // Perform LL rotation
                    } else {
                        balanceLR(currentNode, parentOfA); // Perform LR rotation
                    }
                }
                if(balanceFactor(currentNode)== 2){
                    if (balanceFactor(currentNode.right) >= 0) {
                        balanceRR(currentNode, parentOfA); // Perform RR rotation
                    } else {
                        balanceRL(currentNode, parentOfA); // Perform RL rotation
                    }
                }
            }
        } catch(NullPointerException ex) {
            ex.getStackTrace();
        }
    }

    private void balanceRL(AVLNode currentNode, AVLNode parentOfCurrentNode) {
        AVLNode temp1 = currentNode.right; // currentRoot is right-heavy
        AVLNode temp2 = temp1.left; // temp1 is left-heavy
        if (currentNode == root) {
            root = temp2;
        }
        else {
            if (parentOfCurrentNode.left == currentNode) {
                parentOfCurrentNode.left = temp2;
            }
            else {
                parentOfCurrentNode.right = temp2;
            }
        }
        currentNode.right = temp2.left; // Make T2 the right subtree of currentRoot
        temp1.left = temp2.right; // Make T3 the left subtree of temp1
        temp2.left = currentNode;
        temp2.right = temp1;
        // Adjust heights
        updateHeight(currentNode);
        updateHeight(temp1);
        updateHeight(temp2);
    }

    private void balanceLR(AVLNode currentNode, AVLNode parentOfCurrentNode) {
        AVLNode temp1 = currentNode.left; // currentNode is left-heavy
        AVLNode temp2 = temp1.right; // temp1 is right-heavy
        if (currentNode == root) {
            root = temp2;
        }
        else {
            if (parentOfCurrentNode.left == currentNode) {
                parentOfCurrentNode.left = temp2;
            }
            else {
                parentOfCurrentNode.right = temp2;
            }
        }
        currentNode.left = temp2.right; // Make T3 the left subtree of currentNode
        temp1.right = temp2.left; // Make T2 the right subtree of temp1
        temp2.left = temp1;
        temp2.right = currentNode;
        updateHeight(currentNode); // Adjust heights
        updateHeight(temp1);
        updateHeight(temp2);
    }

    private void balanceRR(AVLNode currentNode, AVLNode parentOfCurrentNode) {
        AVLNode temp1 = currentNode.right; // currentNode is right-heavy and temp1 is right-heavy
        if (currentNode == root) {
            root = temp1;
        } else {
            if (parentOfCurrentNode.left == currentNode) {
                parentOfCurrentNode.left = temp1;
            }
            else {
                parentOfCurrentNode.right = temp1;
            }
        }
        currentNode.right = temp1.left; // Make T2 the right subtree of currentNode
        temp1.left = currentNode;
        updateHeight(currentNode);
        updateHeight(temp1);
    }

    private void balanceLL(AVLNode currentNode, AVLNode parentOfCurrentNode) {
        AVLNode temp1 = currentNode.left; // currentNode is left-heavy and temp1 is left-heavy
        if (currentNode == root) {
            root = temp1;
        } else {
            if (parentOfCurrentNode.left == currentNode) {
                parentOfCurrentNode.left = temp1;
            }
            else {
                parentOfCurrentNode.right = temp1;
            }
        }
        currentNode.left = temp1.right; // Make T2 the left subtree of currentNode
        temp1.right = currentNode; // Make A the left child of parentOfCurrentNode
        updateHeight(currentNode);
        updateHeight(temp1);
    }

    private int balanceFactor(AVLNode node) {
        if (node.right == null) // node has no right subtree
            return -node.height;
        else if (node.left == null) // node has no left subtree
            return +node.height;
        else
            return (node.right.height - node.left.height);
    }

    private int compare(String str1, String str2) {
        int asciOfWebsiteName1 = asciOfWebsite(str1);
        int asciOfWebsiteName2 = asciOfWebsite(str2);
        if (asciOfWebsiteName1 > asciOfWebsiteName2)
            return 1;
        else if (asciOfWebsiteName1 < asciOfWebsiteName2)
            return -1;
        else
            return 0;
    }

    private int asciOfWebsite(String str) {
        int asci = 0;
        for(int i = 0; i < str.length(); i++)
            asci += (int) str.charAt(i);
        return asci;
    }

    private int getHeight(AVLNode root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }

    public void breadth_first_traverse() {
        int h = getHeight(root);
        int i;
        for (i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    private  void printCurrentLevel(AVLNode root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.getData() + "   ");
            root.getQueueData().display();
        }else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public void search(String data){
        AVLNode rootReference = root;
        rootReference = search_recursive(rootReference, data);
        if(rootReference != null) {
            rootReference.getQueueData().display();
        } else {
            System.out.println(data + " is not found in the database.");
        }
    }

    private AVLNode search_recursive(AVLNode currentRoot, String item){
        if(currentRoot == null || currentRoot.getData().equalsIgnoreCase(item))
            return currentRoot;
        if(compare(currentRoot.getData(), item) == 1){
            return search_recursive(currentRoot.left, item);
        } else if(compare(currentRoot.getData(), item) == -1){
            return search_recursive(currentRoot.right, item);
        }
        return null;
    }
}

