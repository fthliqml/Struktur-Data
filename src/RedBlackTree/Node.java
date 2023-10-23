package RedBlackTree;

public class Node {
    private int key;
    private Node right;
    private  Node left;
    private Node parent;
    private boolean red;
    
    

    public Node (int key){
        this.key = key;
    }

    public void setRight(Node right){
        this.right = right;
    }
    public void setLeft(Node left){
        this.left = left;
    }

    public Node getRight(){
        return right;
    }
    public Node getLeft(){
        return left;
    }
    public int getKey(){
        return key;
    }
    public void setKey(int key){
        this.key = key;
    }
    public boolean isRed(){
        return red;
    }

    public void setRed(boolean red){
        this.red = red;
    }

    public Node getParent(){
        return parent;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
}
