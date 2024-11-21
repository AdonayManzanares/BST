//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Perform in-order traversal
        bst.inOrderTraversal();

        // Perform pre-order traversal
        bst.preOrderTraversal();

        // Perform post-order traversal
        bst.postOrderTraversal();

        // Check if this value exist in our tree
        System.out.print("Search for 60: ");
        System.out.println(bst.search(60));

        // Check if this value exist in our tree
        System.out.print("Search for 90: ");
        System.out.println(bst.search(90));

        // Delete a value in our tree
        System.out.println("Removeing... 20");
        bst.delete(20);

        // Display BST after deletion
        bst.inOrderTraversal();
        bst.preOrderTraversal();
        bst.postOrderTraversal();

    }
}