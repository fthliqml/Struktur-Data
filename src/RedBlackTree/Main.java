package RedBlackTree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

       
        
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        

        // tree.remove(10);
        System.out.println(" ");
        // System.out.println(" ");
        tree.isRed(10);
        tree.isRed(11);
        tree.isRed(12);
        tree.isRed(13);
        tree.isRed(14);
        
        tree.display();

        // System.out.println("In Order Traversal : ");
        // tree.inorderTraversal(tree.getRoot());
        // System.out.println(" ");
        // System.out.println("Pre-Order Traversal : ");
        // tree.preorderTraversal(tree.getRoot());
        // System.out.println(" ");
        // System.out.println("Post-Order Traversal : ");
        // tree.postorderTraversal(tree.getRoot());

        
    }
}
