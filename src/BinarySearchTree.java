public class BinarySearchTree {
    private TreeNode root;

    //constructor
    public BinarySearchTree(){
        this.root = null;
    }

    // Insert a node into the BST
    public void insert(int data){
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data){
        if(root == null)
        {
            root = new TreeNode(data);
            return root;
        }
        if(data < root.getData())
        {
            root.setLeft(insertRec(root.getLeft(), data));
        }
        else if(data > root.getData())
        {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    // In-order traversal of the BST
    public  void inOrderTraversal(){
        System.out.print("In-order Traversal: ");
        inOrderRec(root);
        System.out.println();
    }
    private void inOrderRec(TreeNode root){
        if(root != null)
        {
            // LVR Left -> Visit -> Right
            inOrderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderRec(root.getRight());
        }
    }
    public void preOrderTraversal(){
        System.out.print("Pre-order Traversal: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(TreeNode root){
        if(root != null)
        {
            // VLR Visit -> Left -> Right
            System.out.print(root.getData() + " ");
            preOrderRec(root.getLeft());
            preOrderRec(root.getRight());
        }
    }

    public void postOrderTraversal(){
        System.out.print("Post-order Traversal: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(TreeNode root){
        if(root != null)
        {
            // LRV Left -> Right -> Visit
            postOrderRec(root.getLeft());
            postOrderRec(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    // Search for a value in the BST
    public boolean search(int data){
        return searchRec(root,data);
    }

    private boolean searchRec(TreeNode root, int data){
        if(root == null)
        {
            return false;
        }
        if(root.getData() == data)
        {
            return true;
        }
        return data < root.getData() ? searchRec(root.getLeft(), data): searchRec(root.getRight(), data);
    }

    public void delete(int data){
        root = deleteRec(root,data);
    }

    // Delete a node from the BST
    private TreeNode deleteRec(TreeNode root, int data){
        if(root == null)
        {
            return root;
        }
        if(data < root.getData())
        {
            root.setLeft(deleteRec(root.getLeft(), data));
        }
        else if(data > root.getData())
        {
            root.setRight(deleteRec(root.getRight(),data));
        }
        else
        {
            //Node with only one child or no child
            if(root.getLeft() == null)
            {
                return root.getRight();
            }
            else if(root.getRight() == null)
            {
                return root.getLeft();
            }
            // Node with two children: Get the inorder successor
            // (smallest in the right subtree)
            root.setData(findMin(root.getRight()));
            // Delete the inorder successor
            root.setRight(deleteRec(root.getRight(), root.getData()));
        }
        return root;
    }

    private int findMin(TreeNode root){
        int minValue = root.getData();
        while(root.getLeft() != null)
        {
            root = root.getLeft();
            minValue = root.getData();
        }
        return minValue;
    }
}