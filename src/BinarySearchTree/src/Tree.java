public class Tree {
    private Node root;

    public void root(Node root) {
        this.root = root;
    }

    public boolean search(Node parent, int key) {
        if (parent == null) {
            return false;
        } else {
            if (parent.getKey() == key) {
                return true;
            }
            if (parent.getKey() > key) {
                return search(parent.getLeft(), key);
            } else {
                return search(parent.getRight(), key);
            }
        }
    }

    public boolean add(int key) {
        Node node = new Node(key);

        if (search(root, key)) {
            return false;
        }
        if (root == null){
            root = node;
            return true;
        }
        insert(root, node);
        return true ;
    }

    public boolean insert(Node parent, Node node){
        if (parent.getKey() > node.getKey()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            }else{
                insert(parent.getLeft(), node);
            }
        }else{
            if (parent.getRight() == null) {
                parent.setRight(node);
            }else{
                insert(parent.getRight(), node);
            }
        }
        return true;
        
    }
    public boolean remove(int key){
        if(!search(root, key)){
            return false;
        }
        
        return true;
    }
   
    public void display(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getKey());
            display(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            display(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
    
    public void display() {
        display(root, "", true);
    }
    


    public Node getRoot(){
        return root;
    }
}


