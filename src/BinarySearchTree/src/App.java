public class App {
    public static void main(String[] args) throws Exception {

        Tree tree = new Tree();

        
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(19);
        tree.add(10);
        tree.add(10);

        tree.remove(10);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("In Order Traversal : ");
        tree.inorderTraversal(tree.getRoot());  
        System.out.println(" ");      
        System.out.println("Pre-Order Traversal : ");
        tree.preorderTraversal(tree.getRoot());    
        System.out.println(" ");    
        System.out.println("Post-Order Traversal : ");
        tree.postorderTraversal(tree.getRoot());   
        
        
        
    }
}
