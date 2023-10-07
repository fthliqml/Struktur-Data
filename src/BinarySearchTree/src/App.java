public class App {
    public static void main(String[] args) throws Exception {

        Tree tree = new Tree();

        // Add elements to the tree
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        // Display the sorted nodes
        System.out.println("Sorted Nodes:");
        tree.display();
    }
}
