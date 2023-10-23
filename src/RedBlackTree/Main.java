package RedBlackTree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

       
        
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        tree.add(19);
        
        tree.remove(12);
        
        System.out.println(" ");
        
        
        
        tree.display();

        
        
    }
}
