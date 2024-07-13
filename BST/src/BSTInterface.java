public interface BSTInterface {
    public void insert(int data);
    public void inorder_traversal();
    public void preorder_traversal();
    public void postorder_traversal();
    public int getMaxValue();
    public int getMinValue();
    public boolean search(int value);
    public int getDataOfRoot();
    public void delete(int value);
}
